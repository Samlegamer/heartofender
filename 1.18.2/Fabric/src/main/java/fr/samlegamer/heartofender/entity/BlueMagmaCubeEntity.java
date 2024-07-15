package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.cfg.HoeConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class BlueMagmaCubeEntity extends MagmaCubeEntity
{
	public BlueMagmaCubeEntity(EntityType<? extends MagmaCubeEntity> entityType, World world)
	{
		super(entityType, world);
		this.experiencePoints = HoeConfig.BlueMagmaCubeExp;
	}

	@Override
    protected ParticleEffect getParticles() {
        return ParticleTypes.SOUL_FIRE_FLAME;
    }

    public static DefaultAttributeContainer.Builder createMagmaCubeAttributes() {
        return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)HoeConfig.BlueMagmaCubeMovementSpeed)
	      .add(EntityAttributes.GENERIC_MAX_HEALTH, HoeConfig.BlueMagmaCubeMaxHealth)
	      .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, HoeConfig.BlueMagmaCubeAttackDamage);
    }
}