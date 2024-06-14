package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.AbstractGreenFireBlock;
import fr.samlegamer.heartofender.block.GreenCampfireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GreenFireChargeItem extends Item
{
	   public GreenFireChargeItem(Item.Properties p_i48499_1_) {
		      super(p_i48499_1_);
		   }

		   public ActionResultType useOn(ItemUseContext p_195939_1_)
		   {
		      World world = p_195939_1_.getLevel();
		      BlockPos blockpos = p_195939_1_.getClickedPos();
		      BlockState blockstate = world.getBlockState(blockpos);
		      boolean flag = false;
		      if (GreenCampfireBlock.canLight(blockstate)) {
		         this.playSound(world, blockpos);
		         world.setBlockAndUpdate(blockpos, blockstate.setValue(GreenCampfireBlock.LIT, Boolean.valueOf(true)));
		         flag = true;
		      } else {
		         blockpos = blockpos.relative(p_195939_1_.getClickedFace());
		         if (AbstractGreenFireBlock.canBePlacedAt(world, blockpos, p_195939_1_.getHorizontalDirection())) {
		            this.playSound(world, blockpos);
		            world.setBlockAndUpdate(blockpos, AbstractGreenFireBlock.getState(world, blockpos));
		            flag = true;
		         }
		      }

		      if (flag) {
		         p_195939_1_.getItemInHand().shrink(1);
		         return ActionResultType.sidedSuccess(world.isClientSide);
		      } else {
		         return ActionResultType.FAIL;
		      }
		   }

		   private void playSound(World p_219995_1_, BlockPos p_219995_2_) {
		      p_219995_1_.playSound((PlayerEntity)null, p_219995_2_, SoundEvents.FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
		   }
		}