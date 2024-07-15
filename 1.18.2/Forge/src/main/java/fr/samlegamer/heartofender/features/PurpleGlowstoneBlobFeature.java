package fr.samlegamer.heartofender.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class PurpleGlowstoneBlobFeature extends Feature<NoneFeatureConfiguration>
{
	   public PurpleGlowstoneBlobFeature(Codec<NoneFeatureConfiguration> p_65865_)
	   {
		   super(p_65865_);
	   }

		   public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159861_) {
		      WorldGenLevel worldgenlevel = p_159861_.level();
		      BlockPos blockpos = p_159861_.origin();
		      Random random = p_159861_.random();
		      if (!worldgenlevel.isEmptyBlock(blockpos)) {
		         return false;
		      } else {
		         BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
		         if (!blockstate.is(HoeBlocksRegistry.DARK_END_STONE.get()) && !blockstate.is(HoeBlocksRegistry.DARK_END_STONE.get()) && !blockstate.is(HoeBlocksRegistry.DARK_END_STONE.get())) {
		            return false;
		         } else {
		            worldgenlevel.setBlock(blockpos, HoeBlocksRegistry.PURPLE_GLOWSTONE.get().defaultBlockState(), 2);

		            for(int i = 0; i < 1500; ++i) {
		               BlockPos blockpos1 = blockpos.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
		               if (worldgenlevel.getBlockState(blockpos1).isAir()) {
		                  int j = 0;

		                  for(Direction direction : Direction.values()) {
		                     if (worldgenlevel.getBlockState(blockpos1.relative(direction)).is(HoeBlocksRegistry.PURPLE_GLOWSTONE.get())) {
		                        ++j;
		                     }

		                     if (j > 1) {
		                        break;
		                     }
		                  }

		                  if (j == 1) {
		                     worldgenlevel.setBlock(blockpos1, HoeBlocksRegistry.PURPLE_GLOWSTONE.get().defaultBlockState(), 2);
		                  }
		               }
		            }

		            return true;
		         }
		      }
		   }
		}