package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.AbstractGreenFireBlock;
import fr.samlegamer.heartofender.block.PortalDimBlock;
import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModDimension;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Hand;

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
		      
		      if (CampfireBlock.canLight(blockstate))
		      {
		         world.playSound(playerentity, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
		         world.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
		         if (playerentity != null) {
		            p_195939_1_.getItemInHand().hurtAndBreak(1, playerentity, (p_219999_1_) -> {
		               p_219999_1_.broadcastBreakEvent(p_195939_1_.getHand());
		            });
		         }

		         return ActionResultType.sidedSuccess(world.isClientSide());
		      } else if(p_195939_1_.getPlayer() != null)
		        {
		            if(p_195939_1_.getPlayer().level.dimension() == ModDimension.HEART_OF_ENDER || p_195939_1_.getPlayer().level.dimension() == World.OVERWORLD)
		            {
		                for(Direction direction : Direction.Plane.VERTICAL)
		                {
		                    BlockPos framePos = p_195939_1_.getClickedPos().relative(direction);
		                    if(((PortalDimBlock) ModBlocks.HEART_OF_ENDER_PORTAL.get()).trySpawnPortal(p_195939_1_.getLevel(), framePos)) {
		                    	p_195939_1_.getLevel().playSound(p_195939_1_.getPlayer(), framePos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
		    		            p_195939_1_.getItemInHand().hurtAndBreak(1, playerentity, (p_219999_1_) -> {
		    			               p_219999_1_.broadcastBreakEvent(p_195939_1_.getHand());
		    		            });
		    			         return ActionResultType.sidedSuccess(world.isClientSide());
		                       // return ActionResultType.CONSUME;
		                    }
		                }
		            }
	   		         return ActionResultType.sidedSuccess(world.isClientSide());
		        } else
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
	   	
	   	public ActionResultType onItemUseInPortal(PlayerEntity player, World worldIn, BlockPos pos, Hand hand, Direction facing, float hitX, float hitY, float hitZ) {
	 		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
	 		int side = facing.ordinal();
	 		
	 		switch(side) {
	 		case 0:
	 		default:
	 			y--;
	 			break;
	 		case 1:
	 			y++;
	 			break;
	 		case 2:
	 			z--;
	 			break;
	 		case 3:
	 			z++;
	 			break;
	 		case 4:
	 			x--;
	 			break;
	 		case 5:
	 			x++;
	 			break;
	 		}
	 		
	 		if(!player.mayUseItemAt(new BlockPos(x, y, z), facing, player.getItemInHand(hand))) {
	 			return ActionResultType.FAIL;
	 		}
	 		
	 		BlockState location = worldIn.getBlockState(new BlockPos(x, y, z));
	 		if(location == Blocks.AIR.defaultBlockState()) {
	 			((PortalDimBlock) ModBlocks.HEART_OF_ENDER_PORTAL.get()).trySpawnPortal(worldIn, new BlockPos(x, y, z));
	 		}
	 		player.getItemInHand(hand).setDamageValue(1);
	 		return ActionResultType.SUCCESS;
	 	}
}