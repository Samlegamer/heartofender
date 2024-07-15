package fr.samlegamer.heartofender.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import fr.samlegamer.heartofender.block.HoeBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class PurpleGlowstoneBlobFeature extends Feature<DefaultFeatureConfig>
{
    public PurpleGlowstoneBlobFeature(Codec<DefaultFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        }
        BlockState blockState = structureWorldAccess.getBlockState(blockPos.up());
        if (!(blockState.isOf(HoeBlocks.DARK_END_STONE) || blockState.isOf(Blocks.BASALT) || blockState.isOf(Blocks.BLACKSTONE))) {
            return false;
        }
        structureWorldAccess.setBlockState(blockPos, HoeBlocks.PURPLE_GLOWSTONE.getDefaultState(), Block.NOTIFY_LISTENERS);
        for (int i = 0; i < 1500; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
            if (!structureWorldAccess.getBlockState(blockPos2).isAir()) continue;
            int j = 0;
            for (Direction direction : Direction.values()) {
                if (structureWorldAccess.getBlockState(blockPos2.offset(direction)).isOf(HoeBlocks.PURPLE_GLOWSTONE)) {
                    ++j;
                }
                if (j > 1) break;
            }
            if (j == 1) continue;
            structureWorldAccess.setBlockState(blockPos2, HoeBlocks.PURPLE_GLOWSTONE.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
        return true;
    }
}
