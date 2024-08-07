package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.material.Material;
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
	   private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};

	   public HeartWartCropMod(AbstractBlock.Properties p_i48361_1_) {
	      super(p_i48361_1_);
	      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	   }

	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
	      return SHAPE_BY_AGE[p_220053_1_.getValue(AGE)];
	   }

	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader p_200014_2_, BlockPos pos)
	{
		if(state.is(ModBlocks.DEAD_SOUL_SAND.get()))
		{
			return true;
		}
		else if(state.getMaterial() == Material.DIRT);
		return false;
	}

	   public boolean isRandomlyTicking(BlockState p_149653_1_) {
	      return p_149653_1_.getValue(AGE) < 3;
	   }

	   public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
	      int i = p_225542_1_.getValue(AGE);
	      if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_225542_2_, p_225542_3_, p_225542_1_, p_225542_4_.nextInt(10) == 0)) {
	         p_225542_1_ = p_225542_1_.setValue(AGE, Integer.valueOf(i + 1));
	         p_225542_2_.setBlock(p_225542_3_, p_225542_1_, 2);
	         net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_225542_2_, p_225542_3_, p_225542_1_);
	      }

	   }
	   
	   public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
	      return new ItemStack(ModItems.HEART_ENDER_WART_ITEM.get());
	   }
	   
	   protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
	      p_206840_1_.add(AGE);
	   }
	}