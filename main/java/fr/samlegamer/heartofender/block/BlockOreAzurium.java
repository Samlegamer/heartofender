package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.ItemsMod;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreAzurium extends BlockOre
{
	private static boolean multipleQuantity = false;
	private static int miniDrop;
	private static int maxDrop;
	
	public BlockOreAzurium(String name, int harvestLevel)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
	}
	
	public BlockOreAzurium(String name, int harvestLevel, int minDrop, int maxDrop)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
		this.multipleQuantity = true;
		this.miniDrop = minDrop;
		this.maxDrop = maxDrop;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
        if (this == BlocksMod.azurium_ore)
        {
            return ItemsMod.azurium_nuggets;
        }
		else
		{
			return Item.getItemFromBlock(this);
		}
	}
	
	public int quantityDropped(Random rand)
	{
		return this.multipleQuantity ? this.miniDrop + rand.nextInt(this.maxDrop - this.miniDrop) : 1;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			if(this == BlocksMod.azurium_ore)
			{
				return MathHelper.getInt(rand, 1, 3);
			}
		}
		
		return 0;
	}
}
