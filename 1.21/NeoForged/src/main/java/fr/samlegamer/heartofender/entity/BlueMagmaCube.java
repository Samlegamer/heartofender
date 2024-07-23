package fr.samlegamer.heartofender.entity;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class BlueMagmaCube extends MagmaCube
{
	public BlueMagmaCube(EntityType<BlueMagmaCube> typeentity, Level world)
	   {
		   super(typeentity, world);
		      this.xpReward = 8;
	   }
	   
	   public static AttributeSupplier.Builder createAttributes()
	   {
	      return Monster.createMonsterAttributes()
	      .add(Attributes.MOVEMENT_SPEED, (double)0.4D)
	      .add(Attributes.MAX_HEALTH, 40.0D)
	      .add(Attributes.ATTACK_DAMAGE, 12.0D);
	   }

		   protected ParticleOptions getParticleType()
		   {
			   return ParticleTypes.SOUL_FIRE_FLAME;
		   }
}