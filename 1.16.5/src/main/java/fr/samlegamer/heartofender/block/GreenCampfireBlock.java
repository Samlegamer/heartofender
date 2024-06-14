package fr.samlegamer.heartofender.block;

import java.util.Optional;
import java.util.Random;

import fr.samlegamer.heartofender.inits.ModParticles;
import fr.samlegamer.heartofender.tile.GreenCampfireTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CampfireCookingRecipe;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GreenCampfireBlock extends CampfireBlock
{
	   private final boolean spawnParticles;
	   
	   public GreenCampfireBlock(boolean p_i241174_1_, int p_i241174_2_, Properties p_i241174_3_) {
		super(p_i241174_1_, p_i241174_2_, p_i241174_3_);
	      this.spawnParticles = p_i241174_1_;
	      this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(true)).setValue(SIGNAL_FIRE, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH));
	}

	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_)
	   {
	      if (p_180655_1_.getValue(LIT)) {
	         if (p_180655_4_.nextInt(10) == 0) {
	            p_180655_2_.playLocalSound((double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + p_180655_4_.nextFloat(), p_180655_4_.nextFloat() * 0.7F + 0.6F, false);
	         }

	         if (this.spawnParticles && p_180655_4_.nextInt(5) == 0) {
	            for(int i = 0; i < p_180655_4_.nextInt(1) + 1; ++i) {
	               p_180655_2_.addParticle(ModParticles.GREEN_LAVA.get(), (double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, (double)(p_180655_4_.nextFloat() / 2.0F), 5.0E-5D, (double)(p_180655_4_.nextFloat() / 2.0F));
	            }
	         }

	      }
	   }
	   
	   public static boolean isLitCampfire(BlockState p_226915_0_) {
		      return p_226915_0_.hasProperty(LIT) && p_226915_0_.is(BlockTags.CAMPFIRES) && p_226915_0_.getValue(LIT);
		   }
	   
	   public TileEntity newBlockEntity(IBlockReader p_196283_1_)
	   {
		   return new GreenCampfireTileEntity();
	   }
	   
	   public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
		      TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
		      if (tileentity instanceof GreenCampfireTileEntity) {
		    	  GreenCampfireTileEntity campfiretileentity = (GreenCampfireTileEntity)tileentity;
		         ItemStack itemstack = p_225533_4_.getItemInHand(p_225533_5_);
		         Optional<CampfireCookingRecipe> optional = campfiretileentity.getCookableRecipe(itemstack);
		         if (optional.isPresent()) {
		            if (!p_225533_2_.isClientSide && campfiretileentity.placeFood(p_225533_4_.abilities.instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
		               p_225533_4_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
		               return ActionResultType.SUCCESS;
		            }

		            return ActionResultType.CONSUME;
		         }
		      }

		      return ActionResultType.PASS;
		   }
	   
	   public static void dowse(IWorld p_235475_0_, BlockPos p_235475_1_, BlockState p_235475_2_) {
		      if (p_235475_0_.isClientSide()) {
		         for(int i = 0; i < 20; ++i) {
		            makeParticles((World)p_235475_0_, p_235475_1_, p_235475_2_.getValue(SIGNAL_FIRE), true);
		         }
		      }

		      TileEntity tileentity = p_235475_0_.getBlockEntity(p_235475_1_);
		      if (tileentity instanceof GreenCampfireTileEntity) {
		         ((GreenCampfireTileEntity)tileentity).dowse();
		      }

		   }
	   
	   public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
		      if (!p_196243_1_.is(p_196243_4_.getBlock())) {
		         TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
		         if (tileentity instanceof GreenCampfireTileEntity) {
		            InventoryHelper.dropContents(p_196243_2_, p_196243_3_, ((GreenCampfireTileEntity)tileentity).getItems());
		         }

		         super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
		      }
		   }


}