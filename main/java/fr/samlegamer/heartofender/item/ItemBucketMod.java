package fr.samlegamer.heartofender.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class ItemBucketMod extends ItemBucket
{
	public ItemBucketMod(String name, Block containedBlockIn)
	{
		super(containedBlockIn);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}