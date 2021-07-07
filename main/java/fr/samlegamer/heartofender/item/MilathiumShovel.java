package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class MilathiumShovel extends ItemSpade
{
	public MilathiumShovel(String name, ToolMaterial toolSpade)
	{
		super(toolSpade);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}