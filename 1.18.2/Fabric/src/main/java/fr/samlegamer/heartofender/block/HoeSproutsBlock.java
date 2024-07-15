package fr.samlegamer.heartofender.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SproutsBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class HoeSproutsBlock extends SproutsBlock  {

	public HoeSproutsBlock(Settings settings)
	{
		super(settings);
	}

	@Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(HoeBlocks.DEAD_SOUL_SOIL) || super.canPlantOnTop(floor, world, pos);
    }
}