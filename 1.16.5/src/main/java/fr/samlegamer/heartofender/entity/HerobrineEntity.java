package fr.samlegamer.heartofender.entity;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.inits.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class HerobrineEntity extends MonsterEntity
{
	   private final ServerBossInfo bossEvent = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
	   protected static final DataParameter<Byte> DATA_FLAGS_ID = EntityDataManager.defineId(HerobrineEntity.class, DataSerializers.BYTE);
	   private static final DataParameter<Integer> DATA_ID_INV = EntityDataManager.defineId(HerobrineEntity.class, DataSerializers.INT);

	   private MobEntity owner;
	   @Nullable
	   private BlockPos boundOrigin;
	   private boolean hasLimitedLife = false;
	   private int limitedLifeTicks;
	   
	   public HerobrineEntity(World worldIn)
	   {
		   this(ModEntities.HEROBRINE, worldIn);
	   }
	   
	   @SuppressWarnings("rawtypes")
	public HerobrineEntity(EntityType typeentity, World world) {
		      super(typeentity, world);
		      this.maxUpStep = 1.0F;
		      this.moveControl = new HerobrineEntity.MoveHelperController(this);
		      this.xpReward = HoeConfig.HerobrineExp;
		   }
	   
	    public HerobrineEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn)
	    {
	        this(ModEntities.HEROBRINE, worldIn);
	    }

	    public static AttributeModifierMap.MutableAttribute createAttributes()
	    {
		      return MonsterEntity.createMonsterAttributes()
		    		  .add(Attributes.MAX_HEALTH, HoeConfig.HerobrineMaxHealth)
		    		  .add(Attributes.MOVEMENT_SPEED, HoeConfig.HerobrineMovementSpeed)
		    		  .add(Attributes.ATTACK_DAMAGE, HoeConfig.HerobrineAttackDamage)
		    		  .add(Attributes.FOLLOW_RANGE, 64.0D);
		}
	    
	   public void setInvulnerableTicks(int p_82215_1_) {
		      this.entityData.set(DATA_ID_INV, p_82215_1_);
		   }

		   public void setCustomName(@Nullable ITextComponent p_200203_1_) {
		      super.setCustomName(p_200203_1_);
		      this.bossEvent.setName(this.getDisplayName());
		   }
	   
	   public void move(MoverType p_213315_1_, Vector3d p_213315_2_) {
	      super.move(p_213315_1_, p_213315_2_);
	      this.checkInsideBlocks();
	   }

	   public void tick() {
	      this.noPhysics = true;
	      super.tick();
	      this.noPhysics = false;
	      this.setNoGravity(true);
	      if (this.hasLimitedLife && --this.limitedLifeTicks <= 0) {
	         this.limitedLifeTicks = 20;
	         this.hurt(DamageSource.STARVE, 1.0F);
	      }
	   }

	   protected void registerGoals() {
	      super.registerGoals();
	      this.goalSelector.addGoal(0, new SwimGoal(this));
	      this.goalSelector.addGoal(4, new HerobrineEntity.ChargeAttackGoal());
	      this.goalSelector.addGoal(8, new HerobrineEntity.MoveRandomGoal());
	      this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
	      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, AbstractRaiderEntity.class)).setAlertOthers());
	      this.targetSelector.addGoal(2, new HerobrineEntity.CopyOwnerTargetGoal(this));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	   }
	   
	   private boolean teleportTowards(Entity p_70816_1_) {
		      Vector3d vector3d = new Vector3d(this.getX() - p_70816_1_.getX(), this.getY(0.5D) - p_70816_1_.getEyeY(), this.getZ() - p_70816_1_.getZ());
		      vector3d = vector3d.normalize();
		      double d0 = 16.0D;
		      double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.x * 16.0D;
		      double d2 = this.getY() + (double)(this.random.nextInt(16) - 8) - vector3d.y * 16.0D;
		      double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.z * 16.0D;
		      return this.teleport(d1, d2, d3);
		   }

		   private boolean teleport(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
		      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(p_70825_1_, p_70825_3_, p_70825_5_);

		      while(blockpos$mutable.getY() > 0 && !this.level.getBlockState(blockpos$mutable).getMaterial().blocksMotion()) {
		         blockpos$mutable.move(Direction.DOWN);
		      }

		      BlockState blockstate = this.level.getBlockState(blockpos$mutable);
		      boolean flag = blockstate.getMaterial().blocksMotion();
		      boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
		      if (flag && !flag1) {
		         net.minecraftforge.event.entity.living.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, p_70825_1_, p_70825_3_, p_70825_5_);
		         if (event.isCanceled()) return false;
		         boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
		         if (flag2 && !this.isSilent()) {
		            this.level.playSound((PlayerEntity)null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
		            this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
		         }

		         return flag2;
		      } else {
		         return false;
		      }
		   }	   
	   protected boolean teleport() {
		      if (!this.level.isClientSide() && this.isAlive()) {
		         double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
		         double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
		         double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
		         return this.teleport(d0, d1, d2);
		      } else {
		         return false;
		      }
		   }
	   
	   static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		      private final HerobrineEntity enderman;
		      private PlayerEntity pendingTarget;
		      private int aggroTime;
		      private int teleportTime;

		      public FindPlayerGoal(HerobrineEntity p_i241912_1_, @Nullable Predicate<LivingEntity> p_i241912_2_) {
		         super(p_i241912_1_, PlayerEntity.class, 10, false, false, p_i241912_2_);
		         this.enderman = p_i241912_1_;
		         
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
			               if ((PlayerEntity)this.target != null) {
			                  if (this.target.distanceToSqr(this.enderman) < 16.0D) {
			                     this.enderman.teleport();
			                  }

			                  this.teleportTime = 0;
			               } else if (this.target.distanceToSqr(this.enderman) > 256.0D && this.teleportTime++ >= 30 && this.enderman.teleportTowards(this.target)) {
			                  this.teleportTime = 0;
			               }
			            }

			            super.tick();
			         }

			      }

		   }
	   
	   public void startSeenByPlayer(ServerPlayerEntity p_184178_1_) {
		      super.startSeenByPlayer(p_184178_1_);
		      this.bossEvent.addPlayer(p_184178_1_);
		   }

		   public void stopSeenByPlayer(ServerPlayerEntity p_184203_1_) {
		      super.stopSeenByPlayer(p_184203_1_);
		      this.bossEvent.removePlayer(p_184203_1_);
		   }

	   protected void customServerAiStep()
	   {
		   this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
	   }

	   protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_FLAGS_ID, (byte)0);
	   }

	   public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
	      super.readAdditionalSaveData(p_70037_1_);
	      if (p_70037_1_.contains("BoundX")) {
	         this.boundOrigin = new BlockPos(p_70037_1_.getInt("BoundX"), p_70037_1_.getInt("BoundY"), p_70037_1_.getInt("BoundZ"));
	      }

	      if (p_70037_1_.contains("LifeTicks")) {
	         this.setLimitedLife(p_70037_1_.getInt("LifeTicks"));
	      }

	      if (this.hasCustomName()) {
		         this.bossEvent.setName(this.getDisplayName());
		      }

	   }

	   public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
	      super.addAdditionalSaveData(p_213281_1_);
	      if (this.boundOrigin != null) {
	         p_213281_1_.putInt("BoundX", this.boundOrigin.getX());
	         p_213281_1_.putInt("BoundY", this.boundOrigin.getY());
	         p_213281_1_.putInt("BoundZ", this.boundOrigin.getZ());
	      }

	      if (this.hasLimitedLife) {
	         p_213281_1_.putInt("LifeTicks", this.limitedLifeTicks);
	      }

	   }

	   public MobEntity getOwner() {
	      return this.owner;
	   }

	   @Nullable
	   public BlockPos getBoundOrigin() {
	      return this.boundOrigin;
	   }

	   public void setBoundOrigin(@Nullable BlockPos p_190651_1_) {
	      this.boundOrigin = p_190651_1_;
	   }

	   private boolean getVexFlag(int p_190656_1_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      return (i & p_190656_1_) != 0;
	   }

	   private void setVexFlag(int p_190660_1_, boolean p_190660_2_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      if (p_190660_2_) {
	         i = i | p_190660_1_;
	      } else {
	         i = i & ~p_190660_1_;
	      }

	      this.entityData.set(DATA_FLAGS_ID, (byte)(i & 255));
	   }

	   public boolean isCharging() {
	      return this.getVexFlag(1);
	   }

	   public void setIsCharging(boolean p_190648_1_) {
	      this.setVexFlag(1, p_190648_1_);
	   }

	   public void setOwner(MobEntity p_190658_1_) {
	      this.owner = p_190658_1_;
	   }

	   public void setLimitedLife(int p_190653_1_) {
	      this.hasLimitedLife = true;
	      this.limitedLifeTicks = p_190653_1_;
	   }

	   protected SoundEvent getAmbientSound() {
	      return SoundEvents.VEX_AMBIENT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENDER_DRAGON_DEATH;
	   }

	   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
	      return SoundEvents.PLAYER_HURT;
	   }

	   public float getBrightness() {
	      return 1.0F;
	   }

	   @Nullable
	   public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
	      this.populateDefaultEquipmentSlots(p_213386_2_);
	      this.populateDefaultEquipmentEnchantments(p_213386_2_);
	      return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
	   }

	   protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_) {
	      this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
	      this.setDropChance(EquipmentSlotType.MAINHAND, 0.0F);
	   }

	   class ChargeAttackGoal extends Goal {
	      public ChargeAttackGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         if (HerobrineEntity.this.getTarget() != null && !HerobrineEntity.this.getMoveControl().hasWanted() && HerobrineEntity.this.random.nextInt(7) == 0) {
	            return HerobrineEntity.this.distanceToSqr(HerobrineEntity.this.getTarget()) > 4.0D;
	         } else {
	            return false;
	         }
	      }

	      public boolean canContinueToUse()
	      {
	         return HerobrineEntity.this.getMoveControl().hasWanted() && HerobrineEntity.this.isCharging() && HerobrineEntity.this.getTarget() != null && HerobrineEntity.this.getTarget().isAlive();
	      }
	      
	      public void start() {
	         LivingEntity livingentity = HerobrineEntity.this.getTarget();
	         Vector3d vector3d = livingentity.getEyePosition(1.0F);
	         HerobrineEntity.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	         HerobrineEntity.this.setIsCharging(true);
	         HerobrineEntity.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
	      }

	      public void stop() {
	         HerobrineEntity.this.setIsCharging(false);
	      }

	      public void tick() {
	         LivingEntity livingentity = HerobrineEntity.this.getTarget();
	         if (HerobrineEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	            HerobrineEntity.this.doHurtTarget(livingentity);
	            HerobrineEntity.this.setIsCharging(false);
	         } else {
	            double d0 = HerobrineEntity.this.distanceToSqr(livingentity);
	            if (d0 < 9.0D) {
	               Vector3d vector3d = livingentity.getEyePosition(1.0F);
	               HerobrineEntity.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
	            }
	         }

	      }
	   }

	   class CopyOwnerTargetGoal extends TargetGoal {
	      private final EntityPredicate copyOwnerTargeting = (new EntityPredicate()).allowUnseeable().ignoreInvisibilityTesting();

	      public CopyOwnerTargetGoal(CreatureEntity p_i47231_2_) {
	         super(p_i47231_2_, false);
	      }

	      public boolean canUse() {
	         return HerobrineEntity.this.owner != null && HerobrineEntity.this.owner.getTarget() != null && this.canAttack(HerobrineEntity.this.owner.getTarget(), this.copyOwnerTargeting);
	      }

	      public void start() {
	         HerobrineEntity.this.setTarget(HerobrineEntity.this.owner.getTarget());
	         super.start();
	      }
	   }

	   class MoveHelperController extends MovementController {
	      public MoveHelperController(HerobrineEntity p_i47230_2_) {
	         super(p_i47230_2_);
	      }

	      public void tick() {
	         if (this.operation == MovementController.Action.MOVE_TO) {
	            Vector3d vector3d = new Vector3d(this.wantedX - HerobrineEntity.this.getX(), this.wantedY - HerobrineEntity.this.getY(), this.wantedZ - HerobrineEntity.this.getZ());
	            double d0 = vector3d.length();
	            if (d0 < HerobrineEntity.this.getBoundingBox().getSize()) {
	               this.operation = MovementController.Action.WAIT;
	               HerobrineEntity.this.setDeltaMovement(HerobrineEntity.this.getDeltaMovement().scale(0.5D));
	            } else {
	               HerobrineEntity.this.setDeltaMovement(HerobrineEntity.this.getDeltaMovement().add(vector3d.scale(this.speedModifier * 0.05D / d0)));
	               if (HerobrineEntity.this.getTarget() == null) {
	                  Vector3d vector3d1 = HerobrineEntity.this.getDeltaMovement();
	                  HerobrineEntity.this.yRot = -((float)MathHelper.atan2(vector3d1.x, vector3d1.z)) * (180F / (float)Math.PI);
	                  HerobrineEntity.this.yBodyRot = HerobrineEntity.this.yRot;
	               } else {
	                  double d2 = HerobrineEntity.this.getTarget().getX() - HerobrineEntity.this.getX();
	                  double d1 = HerobrineEntity.this.getTarget().getZ() - HerobrineEntity.this.getZ();
	                  HerobrineEntity.this.yRot = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
	                  HerobrineEntity.this.yBodyRot = HerobrineEntity.this.yRot;
	               }
	            }

	         }
	      }
	   }

	   class MoveRandomGoal extends Goal {
	      public MoveRandomGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         return !HerobrineEntity.this.getMoveControl().hasWanted() && HerobrineEntity.this.random.nextInt(7) == 0;
	      }

	      public boolean canContinueToUse() {
	         return false;
	      }

	      public void tick() {
	         BlockPos blockpos = HerobrineEntity.this.getBoundOrigin();
	         if (blockpos == null) {
	            blockpos = HerobrineEntity.this.blockPosition();
	         }

	         for(int i = 0; i < 3; ++i) {
	            BlockPos blockpos1 = blockpos.offset(HerobrineEntity.this.random.nextInt(15) - 7, HerobrineEntity.this.random.nextInt(11) - 5, HerobrineEntity.this.random.nextInt(15) - 7);
	            if (HerobrineEntity.this.level.isEmptyBlock(blockpos1)) {
	               HerobrineEntity.this.moveControl.setWantedPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
	               if (HerobrineEntity.this.getTarget() == null) {
	                  HerobrineEntity.this.getLookControl().setLookAt((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	               }
	               break;
	            }
	         }

	      }
	   }
}