package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TwistingVinesBlock;

public class HoeTwistingVinesBlock extends TwistingVinesBlock
{
	public HoeTwistingVinesBlock(Properties p_154864_)
	{
		super(p_154864_);
	}

	protected Block getBodyBlock()
	{
		return HoeBlocksRegistry.LEAFY_TWISTING_VINES_PLANT.get();
	}
}