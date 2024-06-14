package fr.samlegamer.heartofender.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.network.PlayMessages;

public class HeartBlaze extends Blaze
{
	   @SuppressWarnings({ "rawtypes" })
	   public HeartBlaze(EntityType typeentity, Level level)
	   {
	      super(typeentity, level);
	      this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	      this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
	      this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
	      this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
	      this.xpReward = 20;
	   }
	   
	    public HeartBlaze(PlayMessages.SpawnEntity spawnEntity, Level worldIn)
	    {
	        this(HoeEntityRegistry.HEART_BLAZE, worldIn);
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