package fr.samlegamer.heartofender.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;

public class HeartBlaze extends Blaze
{
	   public HeartBlaze(EntityType<HeartBlaze> typeentity, Level level)
	   {
	      super(typeentity, level);
	      this.setPathfindingMalus(PathType.WATER, -1.0F);
	      this.setPathfindingMalus(PathType.LAVA, 8.0F);
	      this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0F);
	      this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0F);
	      this.xpReward = 20;
	   }
	    
	    @Override
	    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_)
	    {
	    	return false;
	    }
		
	   public static AttributeSupplier.Builder createAttributes()
	   {
		      return Monster.createMonsterAttributes()
		      .add(Attributes.MAX_HEALTH, 35.0D)
		      .add(Attributes.ARMOR, 20.0D)
		      .add(Attributes.ATTACK_DAMAGE, 17.0D)
		      .add(Attributes.MOVEMENT_SPEED, (double)0.24000000917232513D)
		      .add(Attributes.FOLLOW_RANGE, 48.0D);
	   }

}