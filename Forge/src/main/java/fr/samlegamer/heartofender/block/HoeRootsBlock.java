package fr.samlegamer.heartofender.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HoeRootsBlock extends RootsBlock
{
	public HoeRootsBlock(Properties p_55912_)
	{
		super(p_55912_);
	}

	protected boolean mayPlaceOn(BlockState p_55920_, BlockGetter p_55921_, BlockPos p_55922_)
	{
		return p_55920_.is(BlockTags.NYLIUM) || p_55920_.is(HoeBlocksRegistry.DEAD_SOUL_SOIL.get()) || super.mayPlaceOn(p_55920_, p_55921_, p_55922_);
	}
}