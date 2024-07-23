package fr.samlegamer.heartofender.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;

public class HoeForestVegetationFeature extends Feature<NetherForestVegetationConfig>
{
	   public HoeForestVegetationFeature(Codec<NetherForestVegetationConfig> p_66361_)
	   {
		   super(p_66361_);
	   }

		   public boolean place(FeaturePlaceContext<NetherForestVegetationConfig> p_160068_) {
		      WorldGenLevel worldgenlevel = p_160068_.level();
		      BlockPos blockpos = p_160068_.origin();
		      BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
		      NetherForestVegetationConfig netherforestvegetationconfig = p_160068_.config();
		      RandomSource random = p_160068_.random();
		      if (!blockstate.is(BlockTags.NYLIUM)) {
		         return false;
		      } else {
		         int i = blockpos.getY();
		         if (i >= worldgenlevel.getMinBuildHeight() + 1 && i + 1 < worldgenlevel.getMaxBuildHeight()) {
		            int j = 0;

		            for(int k = 0; k < netherforestvegetationconfig.spreadWidth * netherforestvegetationconfig.spreadWidth; ++k) {
		               BlockPos blockpos1 = blockpos.offset(random.nextInt(netherforestvegetationconfig.spreadWidth) - random.nextInt(netherforestvegetationconfig.spreadWidth), random.nextInt(netherforestvegetationconfig.spreadHeight) - random.nextInt(netherforestvegetationconfig.spreadHeight), random.nextInt(netherforestvegetationconfig.spreadWidth) - random.nextInt(netherforestvegetationconfig.spreadWidth));
		               BlockState blockstate1 = netherforestvegetationconfig.stateProvider.getState(random, blockpos1);
		               if (worldgenlevel.isEmptyBlock(blockpos1) && blockpos1.getY() > worldgenlevel.getMinBuildHeight() && blockstate1.canSurvive(worldgenlevel, blockpos1)) {
		                  worldgenlevel.setBlock(blockpos1, blockstate1, 2);
		                  ++j;
		               }
		            }

		            return j > 0;
		         } else {
		            return false;
		         }
		      }
		   }
}