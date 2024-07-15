package fr.samlegamer.heartofender.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineLogic;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class HoeWeepingVinesBlock extends AbstractPlantStemBlock
{
	    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);

	    public HoeWeepingVinesBlock(AbstractBlock.Settings settings)
	    {
	        super(settings, Direction.DOWN, SHAPE, false, 0.1);
	    }

	    @Override
	    protected int getGrowthLength(Random random) {
	        return VineLogic.getGrowthLength(random);
	    }

	    @Override
	    protected Block getPlant() {
	        return HoeBlocks.LILAC_WEEPING_VINES_PLANT;
	    }

	    @Override
	    protected boolean chooseStemState(BlockState state) {
	        return VineLogic.isValidForWeepingStem(state);
	    }
}