package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.inits.ItemsMod;
import net.minecraft.item.Item;

public class ItemMod extends Item
{
	public ItemMod(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}