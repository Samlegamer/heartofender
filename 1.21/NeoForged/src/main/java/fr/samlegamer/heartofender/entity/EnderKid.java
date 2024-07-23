package fr.samlegamer.heartofender.entity;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class EnderKid extends EnderMan implements NeutralMob
{
    private static final ResourceLocation SPEED_MODIFIER_ATTACKING_ID = ResourceLocation.withDefaultNamespace("attacking");
    private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(
        SPEED_MODIFIER_ATTACKING_ID, 0.15F, AttributeModifier.Operation.ADD_VALUE
    );
    private static final int DELAY_BETWEEN_CREEPY_STARE_SOUND = 400;
    private static final int MIN_DEAGGRESSION_TIME = 600;
    private static final EntityDataAccessor<Optional<BlockState>> DATA_CARRY_STATE = SynchedEntityData.defineId(
        EnderMan.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE
    );
    private static final EntityDataAccessor<Boolean> DATA_CREEPY = SynchedEntityData.defineId(EnderMan.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_STARED_AT = SynchedEntityData.defineId(EnderMan.class, EntityDataSerializers.BOOLEAN);
    private int lastStareSound = Integer.MIN_VALUE;
    private int targetChangeTime;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;


	   public EnderKid(EntityType<EnderKid> typeentity, Level world) {
	      super(typeentity, world);
	      this.xpReward = 6;
	      this.setPathfindingMalus(PathType.WATER, -1.0F);
	   }
	    	    
	    @Override
	    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
	    {
	    	return false;
	    }
	    
	   public static AttributeSupplier.Builder createAttributes()
	   {
			   return Monster.createMonsterAttributes()
			   .add(Attributes.MAX_HEALTH, 50.0D)
			   .add(Attributes.MOVEMENT_SPEED, (double)0.30000001192092898D)
			   .add(Attributes.ATTACK_DAMAGE, 8.0D)
			   .add(Attributes.FOLLOW_RANGE, 64.0D);
	   }
	   
	   protected void registerGoals()
	   {
		      this.goalSelector.addGoal(0, new FloatGoal(this));
		      this.goalSelector.addGoal(1, new EnderKid.EndermanFreezeWhenLookedAt(this));
		      this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		      this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
		      this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		      this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		      this.goalSelector.addGoal(10, new EnderKid.EndermanLeaveBlockGoal(this));
		      this.goalSelector.addGoal(11, new EnderKid.EndermanTakeBlockGoal(this));
		      this.targetSelector.addGoal(1, new EnderKid.EndermanLookForPlayerGoal(this, this::isAngryAt));
		      this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Endermite.class, true, false));
		      this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
		      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
		      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		      this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	   }
	   
	   boolean teleportTowards(Entity p_32501_) {
		      Vec3 vec3 = new Vec3(this.getX() - p_32501_.getX(), this.getY(0.5D) - p_32501_.getEyeY(), this.getZ() - p_32501_.getZ());
		      vec3 = vec3.normalize();
		      double d0 = 16.0D;
		      double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.x * 16.0D;
		      double d2 = this.getY() + (double)(this.random.nextInt(16) - 8) - vec3.y * 16.0D;
		      double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.z * 16.0D;
		      return this.teleport(d1, d2, d3);
		   }
	   
	    protected boolean teleport() {
	        if (!this.level().isClientSide() && this.isAlive()) {
	            double d0 = this.getX() + (this.random.nextDouble() - 0.5) * 64.0;
	            double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
	            double d2 = this.getZ() + (this.random.nextDouble() - 0.5) * 64.0;
	            return this.teleport(d0, d1, d2);
	        } else {
	            return false;
	        }
	    }
	    
	    private boolean teleport(double pX, double pY, double pZ) {
	        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(pX, pY, pZ);

	        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
	            blockpos$mutableblockpos.move(Direction.DOWN);
	        }

	        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
	        boolean flag = blockstate.blocksMotion();
	        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
	        if (flag && !flag1) {
	            net.neoforged.neoforge.event.entity.EntityTeleportEvent.EnderEntity event = net.neoforged.neoforge.event.EventHooks.onEnderTeleport(this, pX, pY, pZ);
	            if (event.isCanceled()) return false;
	            Vec3 vec3 = this.position();
	            boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
	            if (flag2) {
	                this.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
	                if (!this.isSilent()) {
	                    this.level().playSound(null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
	                    this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
	                }
	            }

	            return flag2;
	        } else {
	            return false;
	        }
	    }

	   
	   static class EndermanLookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
		      private final EnderKid enderman;
		      @Nullable
		      private Player pendingTarget;
		      private int aggroTime;
		      private int teleportTime;
		      private final TargetingConditions startAggroTargetConditions;
		      private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();

		      public EndermanLookForPlayerGoal(EnderKid p_32573_, @Nullable Predicate<LivingEntity> p_32574_) {
		         super(p_32573_, Player.class, 10, false, false, p_32574_);
		         this.enderman = p_32573_;
		         this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector((p_32578_) -> {
		            return p_32573_.isLookingAtMe((Player)p_32578_);
		         });
		      }

		      public boolean canUse() {
		         this.pendingTarget = this.enderman.level().getNearestPlayer(this.startAggroTargetConditions, this.enderman);
		         return this.pendingTarget != null;
		      }

		      public void start() {
		         this.aggroTime = this.adjustedTickDelay(5);
		         this.teleportTime = 0;
		         this.enderman.setBeingStaredAt();
		      }

		      public void stop() {
		         this.pendingTarget = null;
		         super.stop();
		      }

		      public boolean canContinueToUse() {
		         if (this.pendingTarget != null) {
		            if (!this.enderman.isLookingAtMe(this.pendingTarget)) {
		               return false;
		            } else {
		               this.enderman.lookAt(this.pendingTarget, 10.0F, 10.0F);
		               return true;
		            }
		         } else {
		            return this.target != null && this.continueAggroTargetConditions.test(this.enderman, this.target) ? true : super.canContinueToUse();
		         }
		      }

		      public void tick() {
		         if (this.enderman.getTarget() == null) {
		            super.setTarget((LivingEntity)null);
		         }

		         if (this.pendingTarget != null) {
		            if (--this.aggroTime <= 0) {
		               this.target = this.pendingTarget;
		               this.pendingTarget = null;
		               super.start();
		            }
		         } else {
		            if (this.target != null && !this.enderman.isPassenger()) {
		               if (this.enderman.isLookingAtMe((Player)this.target)) {
		                  if (this.target.distanceToSqr(this.enderman) < 16.0D) {
		                     this.enderman.teleport();
		                  }

		                  this.teleportTime = 0;
		               } else if (this.target.distanceToSqr(this.enderman) > 256.0D && this.teleportTime++ >= this.adjustedTickDelay(30) && this.enderman.teleportTowards(this.target)) {
		                  this.teleportTime = 0;
		               }
		            }

		            super.tick();
		         }

		      }
		   }
	   
	   static class EndermanTakeBlockGoal extends Goal {
		      private final EnderKid enderman;

		      public EndermanTakeBlockGoal(EnderKid p_32585_) {
		         this.enderman = p_32585_;
		      }

		      public boolean canUse() {
		         if (this.enderman.getCarriedBlock() != null) {
		            return false;
		         } else if (!net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.enderman.level(), this.enderman)) {
		            return false;
		         } else {
		            return this.enderman.getRandom().nextInt(reducedTickDelay(20)) == 0;
		         }
		      }

		      public void tick() {
		         RandomSource random = this.enderman.getRandom();
		         Level level = this.enderman.level();
		         int i = Mth.floor(this.enderman.getX() - 2.0D + random.nextDouble() * 4.0D);
		         int j = Mth.floor(this.enderman.getY() + random.nextDouble() * 3.0D);
		         int k = Mth.floor(this.enderman.getZ() - 2.0D + random.nextDouble() * 4.0D);
		         BlockPos blockpos = new BlockPos(i, j, k);
		         BlockState blockstate = level.getBlockState(blockpos);
		         Vec3 vec3 = new Vec3((double)this.enderman.getBlockX() + 0.5D, (double)j + 0.5D, (double)this.enderman.getBlockZ() + 0.5D);
		         Vec3 vec31 = new Vec3((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
		         BlockHitResult blockhitresult = level.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, this.enderman));
		         boolean flag = blockhitresult.getBlockPos().equals(blockpos);
		         if (blockstate.is(BlockTags.ENDERMAN_HOLDABLE) && flag) {
		            level.removeBlock(blockpos, false);
		            level.gameEvent(this.enderman, GameEvent.BLOCK_DESTROY, blockpos);
		            this.enderman.setCarriedBlock(blockstate.getBlock().defaultBlockState());
		         }

		      }
		   }
	   
	   static class EndermanLeaveBlockGoal extends Goal {
		      private final EnderKid enderman;

		      public EndermanLeaveBlockGoal(EnderKid p_32556_) {
		         this.enderman = p_32556_;
		      }

		      public boolean canUse() {
		         if (this.enderman.getCarriedBlock() == null) {
		            return false;
		         } else if (!net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.enderman.level(), this.enderman)) {
		            return false;
		         } else {
		            return this.enderman.getRandom().nextInt(reducedTickDelay(2000)) == 0;
		         }
		      }

		      @Override
		        public void tick() {
		            RandomSource randomsource = this.enderman.getRandom();
		            Level level = this.enderman.level();
		            int i = Mth.floor(this.enderman.getX() - 2.0 + randomsource.nextDouble() * 4.0);
		            int j = Mth.floor(this.enderman.getY() + randomsource.nextDouble() * 3.0);
		            int k = Mth.floor(this.enderman.getZ() - 2.0 + randomsource.nextDouble() * 4.0);
		            BlockPos blockpos = new BlockPos(i, j, k);
		            BlockState blockstate = level.getBlockState(blockpos);
		            Vec3 vec3 = new Vec3((double)this.enderman.getBlockX() + 0.5, (double)j + 0.5, (double)this.enderman.getBlockZ() + 0.5);
		            Vec3 vec31 = new Vec3((double)i + 0.5, (double)j + 0.5, (double)k + 0.5);
		            BlockHitResult blockhitresult = level.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, this.enderman));
		            boolean flag = blockhitresult.getBlockPos().equals(blockpos);
		            if (blockstate.is(BlockTags.ENDERMAN_HOLDABLE) && flag) {
		                level.removeBlock(blockpos, false);
		                level.gameEvent(GameEvent.BLOCK_DESTROY, blockpos, GameEvent.Context.of(this.enderman, blockstate));
		                this.enderman.setCarriedBlock(blockstate.getBlock().defaultBlockState());
		            }
		      }
		   }

	   boolean isLookingAtMe(Player p_32535_) {
		      ItemStack itemstack = p_32535_.getInventory().armor.get(3);
		      if (itemstack.isEnderMask(p_32535_, this)) {
		         return false;
		      } else {
		         Vec3 vec3 = p_32535_.getViewVector(1.0F).normalize();
		         Vec3 vec31 = new Vec3(this.getX() - p_32535_.getX(), this.getEyeY() - p_32535_.getEyeY(), this.getZ() - p_32535_.getZ());
		         double d0 = vec31.length();
		         vec31 = vec31.normalize();
		         double d1 = vec3.dot(vec31);
		         return d1 > 1.0D - 0.025D / d0 ? p_32535_.hasLineOfSight(this) : false;
		      }
		   }
	   
	   static class EndermanFreezeWhenLookedAt extends Goal {
		      private final EnderKid enderman;
		      @Nullable
		      private LivingEntity target;

		      public EndermanFreezeWhenLookedAt(EnderKid p_32550_) {
		         this.enderman = p_32550_;
		         this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		      }

		      public boolean canUse() {
		         this.target = this.enderman.getTarget();
		         if (!(this.target instanceof Player)) {
		            return false;
		         } else {
		            double d0 = this.target.distanceToSqr(this.enderman);
		            return d0 > 256.0D ? false : this.enderman.isLookingAtMe((Player)this.target);
		         }
		      }

		      public void start() {
		         this.enderman.getNavigation().stop();
		      }

		      public void tick() {
		         this.enderman.getLookControl().setLookAt(this.target.getX(), this.target.getEyeY(), this.target.getZ());
		      }
		   }
	   
	   protected SoundEvent getAmbientSound() {
	      return this.isCreepy() ? SoundEvents.ENDERMAN_SCREAM : SoundEvents.ENDERMAN_AMBIENT;
	   }

	   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
	      return SoundEvents.ENDERMAN_HURT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENDERMAN_DEATH;
	   }
}