package fr.samlegamer.heartofender.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;

public class EnderKidEntity extends MonsterEntity
{
	public EnderKidEntity(EntityType<? extends EnderKidEntity> p_i50210_1_, World p_i50210_2_)
	   {
	      super(p_i50210_1_, p_i50210_2_);
	      this.maxUpStep = 1.0F;
	      this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
	   } 
}