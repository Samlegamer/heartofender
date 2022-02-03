package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.core.References;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBlueMagmaBlock extends EntitySlime
{
	public static final ResourceLocation LOOT = new ResourceLocation(References.MODID, "bluemagma/magmablue");
	
    public EntityBlueMagmaBlock(World worldIn)
    {
        super(worldIn);
        this.isImmuneToFire = true;
    }

    public static void registerFixesMagmaCube(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityBlueMagmaBlock.class);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023264D);
    }

    public boolean getCanSpawnHere()
    {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    public boolean isNotColliding()
    {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

    protected void setSlimeSize(int size, boolean resetHealth)
    {
        super.setSlimeSize(size, resetHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue((double)(size * 3));
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    public float getBrightness()
    {
        return 1.0F;
    }

    protected EnumParticleTypes getParticleType()
    {
        return EnumParticleTypes.FLAME;
    }

    protected EntitySlime createInstance()
    {
        return new EntityBlueMagmaBlock(this.world);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
    	return LOOT;
    }

    public boolean isBurning()
    {
        return false;
    }

    protected int getJumpDelay()
    {
        return super.getJumpDelay() * 4;
    }

    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.9F;
    }

    protected void jump()
    {
        this.motionY = (double)(0.42F + (float)this.getSlimeSize() * 0.1F);
        this.isAirBorne = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    }

    protected void handleJumpLava()
    {
        this.motionY = (double)(0.22F + (float)this.getSlimeSize() * 0.05F);
        this.isAirBorne = true;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected boolean canDamagePlayer()
    {
        return true;
    }

    protected int getAttackStrength()
    {
        return super.getAttackStrength() + 2;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_HURT : SoundEvents.ENTITY_MAGMACUBE_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_DEATH : SoundEvents.ENTITY_MAGMACUBE_DEATH;
    }

    protected SoundEvent getSquishSound()
    {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_SQUISH : SoundEvents.ENTITY_MAGMACUBE_SQUISH;
    }

    protected SoundEvent getJumpSound()
    {
        return SoundEvents.ENTITY_MAGMACUBE_JUMP;
    }
}