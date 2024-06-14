package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeepingVinesBlock;

public class HoeWeepingVinesBlock extends WeepingVinesBlock
{
	public HoeWeepingVinesBlock(Properties p_154966_)
	{
		super(p_154966_);
	}

	protected Block getBodyBlock()
	{
		return HoeBlocksRegistry.LILAC_WEEPING_VINES_PLANT.get();
	}
}