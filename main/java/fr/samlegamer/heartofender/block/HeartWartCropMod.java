package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class HeartWartCropMod extends BushBlock
{
	   public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	   public static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};

	   public HeartWartCropMod(Material materialIn, SoundType sound, MaterialColor mc) {
	      super(AbstractBlock.Properties.of(materialIn, mc).sound(sound).instabreak().noCollission().randomTicks());
	      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	   }

	   @Override
	   public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
	      return SHAPE_BY_AGE[p_220053_1_.getValue(AGE)];
	   }

	   @Override
	   public boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
	      return p_200014_1_.is(ModBlocks.DEAD_SAND.get());
	   }

	   @Override
	   public boolean isRandomlyTicking(BlockState p_149653_1_) {
	      return p_149653_1_.getValue(AGE) < 3;
	   }

	   @Override
	   public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
	      int i = p_225542_1_.getValue(AGE);
	      if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_225542_2_, p_225542_3_, p_225542_1_, p_225542_4_.nextInt(10) == 0)) {
	         p_225542_1_ = p_225542_1_.setValue(AGE, Integer.valueOf(i + 1));
	         p_225542_2_.setBlock(p_225542_3_, p_225542_1_, 2);
	         net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_225542_2_, p_225542_3_, p_225542_1_);
	      }

	   }

	   @Override
	   public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
	      return new ItemStack(ModBlocks.HEART_ENDER_WART_BLOCK.get());
	   }

	   @Override
	   public void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
	      p_206840_1_.add(AGE);
	   }
	}