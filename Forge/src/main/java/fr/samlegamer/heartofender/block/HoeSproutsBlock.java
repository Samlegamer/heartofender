package fr.samlegamer.heartofender.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.NetherSproutsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HoeSproutsBlock extends NetherSproutsBlock
{
	public HoeSproutsBlock(Properties p_54952_)
	{
		super(p_54952_);
	}

	protected boolean mayPlaceOn(BlockState p_54960_, BlockGetter p_54961_, BlockPos p_54962_)
	{
		return p_54960_.is(BlockTags.NYLIUM) || p_54960_.is(HoeBlocksRegistry.DEAD_SOUL_SOIL.get()) || super.mayPlaceOn(p_54960_, p_54961_, p_54962_);
	}
}