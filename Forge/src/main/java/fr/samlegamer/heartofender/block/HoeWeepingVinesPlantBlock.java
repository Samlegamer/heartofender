package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WeepingVinesPlantBlock;

public class HoeWeepingVinesPlantBlock extends WeepingVinesPlantBlock
{
	public HoeWeepingVinesPlantBlock(Properties p_154975_)
	{
		super(p_154975_);
	}

	protected GrowingPlantHeadBlock getHeadBlock()
	{
		return (GrowingPlantHeadBlock)HoeBlocksRegistry.LILAC_WEEPING_VINES.get();
	}
}