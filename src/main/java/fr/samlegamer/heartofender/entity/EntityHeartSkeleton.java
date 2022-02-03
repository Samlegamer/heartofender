package fr.samlegamer.heartofender.entity;

import javax.annotation.Nullable;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.inits.ItemsMod;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityHeartSkeleton extends AbstractSkeleton
{
	public static final ResourceLocation LOOT = new ResourceLocation(References.MODID, "heartskeleton/heartskeleton");

    public EntityHeartSkeleton(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7F, 2.4F);
        this.isImmuneToFire = true;
    }

    public static void registerFixesWitherSkeleton(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityHeartSkeleton.class);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

    }
    
    @Override
    protected ResourceLocation getLootTable()
    {
        return LOOT;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_WITHER_SKELETON_STEP;
    }
    
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemsMod.azurium_axe));
    }

    
    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
    }
    
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.setCombatTask();
        return ientitylivingdata;
    }

    public float getEyeHeight()
    {
        return 2.1F;
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        if (!super.attackEntityAsMob(entityIn))
        {
            return false;
        }
        else
        {
            if (entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 100, 2));
            }

            return true;
        }
    }

    protected EntityArrow getArrow(float p_190726_1_)
    {
        EntityArrow entityarrow = super.getArrow(p_190726_1_);
        entityarrow.setFire(100);
        return entityarrow;
    }
}