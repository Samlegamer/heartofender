package fr.samlegamer.heartofender.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class HoeTwistingVinesPlantBlock extends AbstractPlantBlock
{
    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    public HoeTwistingVinesPlantBlock(AbstractBlock.Settings settings)
    {
        super(settings, Direction.UP, SHAPE, false);
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)HoeBlocks.LEAFY_TWISTING_VINES;
    }
}