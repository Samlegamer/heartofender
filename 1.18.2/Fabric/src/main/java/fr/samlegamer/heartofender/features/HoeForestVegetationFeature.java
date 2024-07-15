package fr.samlegamer.heartofender.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class HoeForestVegetationFeature extends Feature<NetherForestVegetationFeatureConfig>
{
    public HoeForestVegetationFeature(Codec<NetherForestVegetationFeatureConfig> codec)
    {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<NetherForestVegetationFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = structureWorldAccess.getBlockState(blockPos.down());
        NetherForestVegetationFeatureConfig netherForestVegetationFeatureConfig = context.getConfig();
        Random random = context.getRandom();
        if (!blockState.isIn(BlockTags.NYLIUM)) {
            return false;
        }
        int i = blockPos.getY();
        if (i < structureWorldAccess.getBottomY() + 1 || i + 1 >= structureWorldAccess.getTopY()) {
            return false;
        }
        int j = 0;
        for (int k = 0; k < netherForestVegetationFeatureConfig.spreadWidth * netherForestVegetationFeatureConfig.spreadWidth; ++k) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(netherForestVegetationFeatureConfig.spreadWidth) - random.nextInt(netherForestVegetationFeatureConfig.spreadWidth), random.nextInt(netherForestVegetationFeatureConfig.spreadHeight) - random.nextInt(netherForestVegetationFeatureConfig.spreadHeight), random.nextInt(netherForestVegetationFeatureConfig.spreadWidth) - random.nextInt(netherForestVegetationFeatureConfig.spreadWidth));
            BlockState blockState2 = netherForestVegetationFeatureConfig.stateProvider.getBlockState(random, blockPos2);
            if (!structureWorldAccess.isAir(blockPos2) || blockPos2.getY() <= structureWorldAccess.getBottomY() || !blockState2.canPlaceAt(structureWorldAccess, blockPos2)) continue;
            structureWorldAccess.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
            ++j;
        }
        return j > 0;
    }
}