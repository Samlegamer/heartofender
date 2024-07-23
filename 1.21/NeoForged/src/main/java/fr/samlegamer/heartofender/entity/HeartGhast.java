package fr.samlegamer.heartofender.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;

public class HeartGhast extends Ghast
{
	   private int explosionPower = 3;

	   public HeartGhast(EntityType<HeartGhast> typeentity, Level level)
	   {
	      super(typeentity, level);
	      this.xpReward = 20;
	   }

	   public int getExplosionPower() {
	      return this.explosionPower;
	   }

	   protected boolean shouldDespawnInPeaceful()
	   {
	      return true;
	   }

	   public static AttributeSupplier.Builder createAttributes() {
	      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 35.0D).add(Attributes.FOLLOW_RANGE, 100.0D);
	   }
}