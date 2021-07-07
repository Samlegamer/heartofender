package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSpade;

public class AzuriumSpade extends ItemSpade
{
	public AzuriumSpade(String name, ToolMaterial toolSpade)
	{
		super(toolSpade);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}