package fr.samlegamer.heartofender.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

public class Herobrine extends Monster
{
	   public final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
	   private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(Herobrine.class, EntityDataSerializers.INT);
	   public static final float FLAP_DEGREES_PER_TICK = 45.836624F;
	   public static final int TICKS_PER_FLAP = Mth.ceil(3.9269907F);
	   protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Herobrine.class, EntityDataSerializers.BYTE);
	   private static final int FLAG_IS_CHARGING = 1;
	   @Nullable
	   Mob owner;
	   @Nullable
	   private BlockPos boundOrigin;
	   private boolean hasLimitedLife = false;
	   private int limitedLifeTicks;

	   @SuppressWarnings({ "rawtypes" })
	   public Herobrine(EntityType typeentity, Level world)
	   {
	      super(typeentity, world);
	      this.maxUpStep = 1.0F;
	      this.moveControl = new Herobrine.VexMoveControl(this);
	      this.xpReward = 2000;
	   }
	   
	   public Herobrine(Level world)
	   {
		   super(HoeEntityRegistry.HEROBRINE, world);
	   }
	    public Herobrine(PlayMessages.SpawnEntity spawnEntity, Level worldIn)
	    {
	        this(HoeEntityRegistry.HEROBRINE, worldIn);
	    }

	    public void setInvulnerableTicks(int p_82215_1_) {
		      this.entityData.set(DATA_ID_INV, p_82215_1_);
		   }
	    
		   public void startSeenByPlayer(ServerPlayer p_184178_1_) {
			      super.startSeenByPlayer(p_184178_1_);
			      this.bossEvent.addPlayer(p_184178_1_);
			   }

			   public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
			      super.stopSeenByPlayer(p_184203_1_);
			      this.bossEvent.removePlayer(p_184203_1_);
			   }

			   
			   
		   protected void customServerAiStep()
		   {
			   this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
		   }

	   public boolean isFlapping() {
	      return this.tickCount % TICKS_PER_FLAP == 0;
	   }

		   public void setCustomName(@Nullable Component p_31476_) {
		      super.setCustomName(p_31476_);
		      this.bossEvent.setName(this.getDisplayName());
		   }

	   public void move(MoverType p_33997_, Vec3 p_33998_) {
	      super.move(p_33997_, p_33998_);
	      this.checkInsideBlocks();
	   }
	   
	   @Override
	   public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
	   {
		   return false;
	   }

	   public void tick()
	   {
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
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(4, new Herobrine.VexChargeAttackGoal());
	      this.goalSelector.addGoal(8, new Herobrine.VexRandomMoveGoal());
	      this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
	      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
	      this.targetSelector.addGoal(2, new Herobrine.VexCopyOwnerTargetGoal(this));
	      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
	   }

	   public static AttributeSupplier.Builder createAttributes() {
	      return Monster.createMonsterAttributes()
	    		  .add(Attributes.MAX_HEALTH, 1000.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, 0.50000001192092898D)
	    		  .add(Attributes.ATTACK_DAMAGE, 26.0D)
	    		  .add(Attributes.FOLLOW_RANGE, 64.0D);
	   }

	   protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_FLAGS_ID, (byte)0);
	      this.entityData.define(DATA_ID_INV, 0);
	   }

	   public void readAdditionalSaveData(CompoundTag p_34008_) {
	      super.readAdditionalSaveData(p_34008_);
	      if (p_34008_.contains("BoundX")) {
	         this.boundOrigin = new BlockPos(p_34008_.getInt("BoundX"), p_34008_.getInt("BoundY"), p_34008_.getInt("BoundZ"));
	      }

	      if (p_34008_.contains("LifeTicks")) {
	         this.setLimitedLife(p_34008_.getInt("LifeTicks"));
	      }
	      
	      if (this.hasCustomName()) {
	          this.bossEvent.setName(this.getDisplayName());
	       }
	   }
	   
	@Override
	public boolean randomTeleport(double p_20985_, double p_20986_, double p_20987_, boolean p_20988_)
	{
		   return super.randomTeleport(p_20985_, p_20986_, p_20987_, p_20988_);
	}

	   public void addAdditionalSaveData(CompoundTag p_34015_) {
	      super.addAdditionalSaveData(p_34015_);
	      if (this.boundOrigin != null) {
	         p_34015_.putInt("BoundX", this.boundOrigin.getX());
	         p_34015_.putInt("BoundY", this.boundOrigin.getY());
	         p_34015_.putInt("BoundZ", this.boundOrigin.getZ());
	      }

	      if (this.hasLimitedLife) {
	         p_34015_.putInt("LifeTicks", this.limitedLifeTicks);
	      }

	   }
	   
	   @Nullable
	   public Mob getOwner() {
	      return this.owner;
	   }

	   @Nullable
	   public BlockPos getBoundOrigin() {
	      return this.boundOrigin;
	   }

	   public void setBoundOrigin(@Nullable BlockPos p_34034_) {
	      this.boundOrigin = p_34034_;
	   }

	   private boolean getVexFlag(int p_34011_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      return (i & p_34011_) != 0;
	   }

	   private void setVexFlag(int p_33990_, boolean p_33991_) {
	      int i = this.entityData.get(DATA_FLAGS_ID);
	      if (p_33991_) {
	         i |= p_33990_;
	      } else {
	         i &= ~p_33990_;
	      }

	      this.entityData.set(DATA_FLAGS_ID, (byte)(i & 255));
	   }

	   public boolean isCharging() {
	      return this.getVexFlag(1);
	   }

	   public void setIsCharging(boolean p_34043_) {
	      this.setVexFlag(1, p_34043_);
	   }

	   public void setOwner(Mob p_33995_) {
	      this.owner = p_33995_;
	   }

	   public void setLimitedLife(int p_33988_) {
	      this.hasLimitedLife = true;
	      this.limitedLifeTicks = p_33988_;
	   }

	   protected SoundEvent getAmbientSound() {
	      return SoundEvents.VEX_AMBIENT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENDER_DRAGON_DEATH;
	   }

	   protected SoundEvent getHurtSound(DamageSource p_34023_) {
	      return SoundEvents.PLAYER_HURT;
	   }

	   public float getBrightness() {
	      return 1.0F;
	   }

	   @Nullable
	   public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34002_, DifficultyInstance p_34003_, MobSpawnType p_34004_, @Nullable SpawnGroupData p_34005_, @Nullable CompoundTag p_34006_) {
	      this.populateDefaultEquipmentSlots(p_34003_);
	      this.populateDefaultEquipmentEnchantments(p_34003_);
	      return super.finalizeSpawn(p_34002_, p_34003_, p_34004_, p_34005_, p_34006_);
	   }

	   protected void populateDefaultEquipmentSlots(DifficultyInstance p_33993_) {
	      this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
	      this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
	   }

	   class VexChargeAttackGoal extends Goal {
	      public VexChargeAttackGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         if (Herobrine.this.getTarget() != null && !Herobrine.this.getMoveControl().hasWanted() && Herobrine.this.random.nextInt(reducedTickDelay(7)) == 0) {
	            return Herobrine.this.distanceToSqr(Herobrine.this.getTarget()) > 4.0D;
	         } else {
	            return false;
	         }
	      }

	      public boolean canContinueToUse() {
	         return Herobrine.this.getMoveControl().hasWanted() && Herobrine.this.isCharging() && Herobrine.this.getTarget() != null && Herobrine.this.getTarget().isAlive();
	      }

	      public void start() {
	         LivingEntity livingentity = Herobrine.this.getTarget();
	         if (livingentity != null) {
	            Vec3 vec3 = livingentity.getEyePosition();
	            Herobrine.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
	         }

	         Herobrine.this.setIsCharging(true);
	         Herobrine.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
	      }

	      public void stop() {
	    	  Herobrine.this.setIsCharging(false);
	      }

	      public boolean requiresUpdateEveryTick() {
	         return true;
	      }

	      public void tick() {
	         LivingEntity livingentity = Herobrine.this.getTarget();
	         if (livingentity != null) {
	            if (Herobrine.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
	            	Herobrine.this.doHurtTarget(livingentity);
	            	Herobrine.this.setIsCharging(false);
	            } else {
	               double d0 = Herobrine.this.distanceToSqr(livingentity);
	               if (d0 < 9.0D) {
	                  Vec3 vec3 = livingentity.getEyePosition();
	                  Herobrine.this.moveControl.setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
	               }
	            }

	         }
	      }
	   }

	   class VexCopyOwnerTargetGoal extends TargetGoal {
	      private final TargetingConditions copyOwnerTargeting = TargetingConditions.forNonCombat().ignoreLineOfSight().ignoreInvisibilityTesting();

	      public VexCopyOwnerTargetGoal(PathfinderMob p_34056_) {
	         super(p_34056_, false);
	      }

	      public boolean canUse() {
	         return Herobrine.this.owner != null && Herobrine.this.owner.getTarget() != null && this.canAttack(Herobrine.this.owner.getTarget(), this.copyOwnerTargeting);
	      }

	      public void start() {
	    	  Herobrine.this.setTarget(Herobrine.this.owner.getTarget());
	         super.start();
	      }
	   }
	   	   
	   class VexMoveControl extends MoveControl {
	      public VexMoveControl(Herobrine p_34062_) {
	         super(p_34062_);
	      }

	      public void tick() {
	         if (this.operation == MoveControl.Operation.MOVE_TO) {
	            Vec3 vec3 = new Vec3(this.wantedX - Herobrine.this.getX(), this.wantedY - Herobrine.this.getY(), this.wantedZ - Herobrine.this.getZ());
	            double d0 = vec3.length();
	            if (d0 < Herobrine.this.getBoundingBox().getSize()) {
	               this.operation = MoveControl.Operation.WAIT;
	               Herobrine.this.setDeltaMovement(Herobrine.this.getDeltaMovement().scale(0.5D));
	            } else {
	            	Herobrine.this.setDeltaMovement(Herobrine.this.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05D / d0)));
	               if (Herobrine.this.getTarget() == null) {
	                  Vec3 vec31 = Herobrine.this.getDeltaMovement();
	                  Herobrine.this.setYRot(-((float)Mth.atan2(vec31.x, vec31.z)) * (180F / (float)Math.PI));
	                  Herobrine.this.yBodyRot = Herobrine.this.getYRot();
	               } else {
	                  double d2 = Herobrine.this.getTarget().getX() - Herobrine.this.getX();
	                  double d1 = Herobrine.this.getTarget().getZ() - Herobrine.this.getZ();
	                  Herobrine.this.setYRot(-((float)Mth.atan2(d2, d1)) * (180F / (float)Math.PI));
	                  Herobrine.this.yBodyRot = Herobrine.this.getYRot();
	               }
	            }

	         }
	      }
	   }

	   class VexRandomMoveGoal extends Goal {
	      public VexRandomMoveGoal() {
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	      }

	      public boolean canUse() {
	         return !Herobrine.this.getMoveControl().hasWanted() && Herobrine.this.random.nextInt(reducedTickDelay(7)) == 0;
	      }

	      public boolean canContinueToUse() {
	         return false;
	      }

	      public void tick() {
	         BlockPos blockpos = Herobrine.this.getBoundOrigin();
	         if (blockpos == null) {
	            blockpos = Herobrine.this.blockPosition();
	         }

	         for(int i = 0; i < 3; ++i) {
	            BlockPos blockpos1 = blockpos.offset(Herobrine.this.random.nextInt(15) - 7, Herobrine.this.random.nextInt(11) - 5, Herobrine.this.random.nextInt(15) - 7);
	            if (Herobrine.this.level.isEmptyBlock(blockpos1)) {
	            	Herobrine.this.moveControl.setWantedPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
	               if (Herobrine.this.getTarget() == null) {
	            	   Herobrine.this.getLookControl().setLookAt((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	               }
	               break;
	            }
	         }

	      }
	   }
	}