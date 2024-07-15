package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.cfg.HoeConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class HeartBlazeEntity extends BlazeEntity
{
	public HeartBlazeEntity(EntityType<? extends BlazeEntity> entityType, World world)
	{
		super(entityType, world);
        this.experiencePoints = HoeConfig.HeartBlazeExp;
	}

    public static DefaultAttributeContainer.Builder createBlazeAttributes() {
        return HostileEntity.createHostileAttributes()
  		      .add(EntityAttributes.GENERIC_MAX_HEALTH, HoeConfig.HeartBlazeMaxHealth)
  		      .add(EntityAttributes.GENERIC_ARMOR, HoeConfig.HeartBlazeArmor)
  		      .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, HoeConfig.HeartBlazeAttackDamage)
  		      .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)HoeConfig.HeartBlazeMovementSpeed);
    }
}