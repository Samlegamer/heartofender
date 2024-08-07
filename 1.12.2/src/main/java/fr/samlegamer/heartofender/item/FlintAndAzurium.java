package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlintAndAzurium extends Item
{
	 	public FlintAndAzurium(String name)
	 	{
	 		this.setMaxStackSize(1);
	        this.setMaxDamage(64);
	 		setUnlocalizedName(name);
	 		setRegistryName(name);
	 	}
	 	
	 	 public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    	{
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (worldIn.isAirBlock(pos))
            {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, BlocksMod.green_fire.getDefaultState(), 11);
            }

            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
            }

            itemstack.damageItem(1, player);
            return EnumActionResult.SUCCESS;
        }
    }
	 	 
	 	public EnumActionResult onItemUseInPortal(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	 		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
	 		int side = facing.getIndex();
	 		
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
	 		
	 		if(!player.canPlayerEdit(new BlockPos(x, y, z), facing, player.getHeldItem(hand))) {
	 			return EnumActionResult.FAIL;
	 		}
	 		
	 		IBlockState location = worldIn.getBlockState(new BlockPos(x, y, z));
	 		if(location == Blocks.AIR.getDefaultState()) {
	 			(BlocksMod.portal_dim).trySpawnPortal(worldIn, new BlockPos(x, y, z));
	 		}
	 		player.getHeldItem(hand).damageItem(1, player);
	 		return EnumActionResult.SUCCESS;
	 	}
}