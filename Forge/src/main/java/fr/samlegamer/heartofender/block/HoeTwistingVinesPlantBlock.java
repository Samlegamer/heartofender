package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.TwistingVinesPlantBlock;

public class HoeTwistingVinesPlantBlock extends TwistingVinesPlantBlock
{
	public HoeTwistingVinesPlantBlock(Properties p_154873_)
	{
		super(p_154873_);
	}

	protected GrowingPlantHeadBlock getHeadBlock()
	{
		return (GrowingPlantHeadBlock)HoeBlocksRegistry.LEAFY_TWISTING_VINES.get();
	}
}