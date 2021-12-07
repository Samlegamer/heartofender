package fr.samlegamer.heartofender.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class PurpleGlowstoneBlobFeature extends Feature<NoFeatureConfig>
{
	   public PurpleGlowstoneBlobFeature(Codec<NoFeatureConfig> p_i231956_1_) {
		      super(p_i231956_1_);
		   }

		   public boolean place(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos p_241855_4_, NoFeatureConfig p_241855_5_) {
		      if (!p_241855_1_.isEmptyBlock(p_241855_4_)) {
		         return false;
		      } else {
		         BlockState blockstate = p_241855_1_.getBlockState(p_241855_4_.above());
		         if (!blockstate.is(ModBlocks.DARK_END_STONE.get()) && !blockstate.is(ModBlocks.DARK_END_STONE.get()) && !blockstate.is(ModBlocks.DARK_END_STONE.get())) {
		            return false;
		         } else {
		            p_241855_1_.setBlock(p_241855_4_, ModBlocks.PURPLE_GLOWSTONE.get().defaultBlockState(), 2);

		            for(int i = 0; i < 1500; ++i) {
		               BlockPos blockpos = p_241855_4_.offset(p_241855_3_.nextInt(8) - p_241855_3_.nextInt(8), -p_241855_3_.nextInt(12), p_241855_3_.nextInt(8) - p_241855_3_.nextInt(8));
		               if (p_241855_1_.getBlockState(blockpos).isAir(p_241855_1_, blockpos)) {
		                  int j = 0;

		                  for(Direction direction : Direction.values()) {
		                     if (p_241855_1_.getBlockState(blockpos.relative(direction)).is(ModBlocks.PURPLE_GLOWSTONE.get())) {
		                        ++j;
		                     }

		                     if (j > 1) {
		                        break;
		                     }
		                  }

		                  if (j == 1) {
		                     p_241855_1_.setBlock(blockpos, ModBlocks.PURPLE_GLOWSTONE.get().defaultBlockState(), 2);
		                  }
		               }
		            }

		            return true;
		         }
		      }
		   }
		}
