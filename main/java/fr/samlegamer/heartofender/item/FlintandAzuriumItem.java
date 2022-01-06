package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.AbstractGreenFireBlock;
import fr.samlegamer.heartofender.block.GreenCampfireBlock;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlintandAzuriumItem extends Item
{
	   public FlintandAzuriumItem(Item.Properties p_i48493_1_)
	   {
		      super(p_i48493_1_);
	   }

		@Override
		   public ActionResultType useOn(ItemUseContext p_195939_1_)
		   {
		      PlayerEntity playerentity = p_195939_1_.getPlayer();
		      World world = p_195939_1_.getLevel();
		      BlockPos blockpos = p_195939_1_.getClickedPos();
		      BlockState blockstate = world.getBlockState(blockpos);
		      
		      if (GreenCampfireBlock.canLight(blockstate))
		      {
		         world.playSound(playerentity, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
		         world.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
		         if (playerentity != null) {
		            p_195939_1_.getItemInHand().hurtAndBreak(1, playerentity, (p_219999_1_) -> {
		               p_219999_1_.broadcastBreakEvent(p_195939_1_.getHand());
		            });
		         }

		         return ActionResultType.sidedSuccess(world.isClientSide());
		      }
		      else if(playerentity != null)
		      {
		         BlockPos blockpos1 = blockpos.relative(p_195939_1_.getClickedFace());
		         if (AbstractGreenFireBlock.canBePlacedAt(world, blockpos1, p_195939_1_.getHorizontalDirection())) {
		            world.playSound(playerentity, blockpos1, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
		            BlockState blockstate1 = AbstractGreenFireBlock.getState(world, blockpos1);
		            world.setBlock(blockpos1, blockstate1, 11);
		            ItemStack itemstack = p_195939_1_.getItemInHand();
		            if (playerentity instanceof ServerPlayerEntity) {
		               CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
		               itemstack.hurtAndBreak(1, playerentity, (p_219998_1_) -> {
		                  p_219998_1_.broadcastBreakEvent(p_195939_1_.getHand());
		               });
		       }
		            return ActionResultType.sidedSuccess(world.isClientSide());
		         }
		      }

	             return ActionResultType.FAIL;
		   }
}