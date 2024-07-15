package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.features.HoeFeatures;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class NyliumBlockHoe extends Block implements Fertilizable
{
    public NyliumBlockHoe(AbstractBlock.Settings settings)
    {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
        return i < world.getMaxLightLevel();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!NyliumBlockHoe.stayAlive(state, world, pos)) {
            world.setBlockState(pos, HoeBlocks.DARK_END_STONE.getDefaultState());
        }
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        if (blockState.isOf(HoeBlocks.LILAC_NYLIUM)) {
            HoeFeatures.Dimension.LILAC_FOREST_VEGETATION_BONEMEAL.generate(world, chunkGenerator, random, blockPos);
        } else if (blockState.isOf(HoeBlocks.LEAFY_NYLIUM)) {
        	HoeFeatures.Dimension.LEAFY_FOREST_VEGETATION_BONEMEAL.generate(world, chunkGenerator, random, blockPos);
        	HoeFeatures.Dimension.HOE_SPROUTS_BONEMEAL.generate(world, chunkGenerator, random, blockPos);
            if (random.nextInt(8) == 0) {
            	HoeFeatures.Dimension.HOE_TWISTING_VINES_BONEMEAL.generate(world, chunkGenerator, random, blockPos);
            }
        }
    }
}

