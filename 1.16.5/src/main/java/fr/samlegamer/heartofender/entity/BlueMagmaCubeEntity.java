package fr.samlegamer.heartofender.entity;

import java.util.Random;

import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.inits.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.loot.LootTables;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class BlueMagmaCubeEntity extends SlimeEntity
{
	   @SuppressWarnings({ "rawtypes" })
	   public BlueMagmaCubeEntity(EntityType typeentity, World world)
	   {
		   super(typeentity, world);
		      this.xpReward = HoeConfig.BlueMagmaCubeExp;
	   }
	   
	   public BlueMagmaCubeEntity(FMLPlayMessages.SpawnEntity spawnEntity, World worldIn)
	    {
	        this(ModEntities.BLUE_MAGMA_CUBE, worldIn);
	    }
	   
		   public static AttributeModifierMap.MutableAttribute createAttributes()
		   {
		      return MonsterEntity.createMonsterAttributes()
		      .add(Attributes.MOVEMENT_SPEED, (double)HoeConfig.BlueMagmaCubeMovementSpeed)
		      .add(Attributes.MAX_HEALTH, HoeConfig.BlueMagmaCubeMaxHealth)
		      .add(Attributes.ATTACK_DAMAGE, HoeConfig.BlueMagmaCubeAttackDamage);
		   }

		   public static boolean checkMagmaCubeSpawnRules(EntityType<BlueMagmaCubeEntity> p_223367_0_, IWorld p_223367_1_, SpawnReason p_223367_2_, BlockPos p_223367_3_, Random p_223367_4_) {
		      return p_223367_1_.getDifficulty() != Difficulty.PEACEFUL;
		   }

		   public boolean checkSpawnObstruction(IWorldReader p_205019_1_) {
		      return p_205019_1_.isUnobstructed(this) && !p_205019_1_.containsAnyLiquid(this.getBoundingBox());
		   }

		   protected void setSize(int p_70799_1_, boolean p_70799_2_) {
		      super.setSize(p_70799_1_, p_70799_2_);
		      this.getAttribute(Attributes.ARMOR).setBaseValue((double)(p_70799_1_ * 3));
		   }

		   public float getBrightness() {
		      return 1.0F;
		   }

		   protected IParticleData getParticleType() {
		      return ParticleTypes.SOUL_FIRE_FLAME;
		   }

		   protected ResourceLocation getDefaultLootTable()
		   {
		      return this.isTiny() ? LootTables.EMPTY : this.getType().getDefaultLootTable();
		   }

		   public boolean isOnFire() {
		      return false;
		   }

		   protected int getJumpDelay() {
		      return super.getJumpDelay() * 4;
		   }

		   protected void decreaseSquish() {
		      this.targetSquish *= 0.9F;
		   }

		   protected void jumpFromGround() {
		      Vector3d vector3d = this.getDeltaMovement();
		      this.setDeltaMovement(vector3d.x, (double)(this.getJumpPower() + (float)this.getSize() * 0.1F), vector3d.z);
		      this.hasImpulse = true;
		      net.minecraftforge.common.ForgeHooks.onLivingJump(this);
		   }

		   protected void jumpInLiquid(ITag<Fluid> p_180466_1_) {
		      if (p_180466_1_ == FluidTags.LAVA) {
		         Vector3d vector3d = this.getDeltaMovement();
		         this.setDeltaMovement(vector3d.x, (double)(0.22F + (float)this.getSize() * 0.05F), vector3d.z);
		         this.hasImpulse = true;
		      } else {
		         super.jumpInLiquid(p_180466_1_);
		      }

		   }

		   public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
		      return false;
		   }

		   protected boolean isDealsDamage() {
		      return this.isEffectiveAi();
		   }

		   protected float getAttackDamage() {
		      return super.getAttackDamage() + 2.0F;
		   }

		   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
		      return this.isTiny() ? SoundEvents.MAGMA_CUBE_HURT_SMALL : SoundEvents.MAGMA_CUBE_HURT;
		   }

		   protected SoundEvent getDeathSound() {
		      return this.isTiny() ? SoundEvents.MAGMA_CUBE_DEATH_SMALL : SoundEvents.MAGMA_CUBE_DEATH;
		   }

		   protected SoundEvent getSquishSound() {
		      return this.isTiny() ? SoundEvents.MAGMA_CUBE_SQUISH_SMALL : SoundEvents.MAGMA_CUBE_SQUISH;
		   }

		   protected SoundEvent getJumpSound() {
		      return SoundEvents.MAGMA_CUBE_JUMP;
		   }
}