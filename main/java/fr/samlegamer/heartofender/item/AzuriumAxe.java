package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemAxe;

public class AzuriumAxe extends ItemAxe
{
	public AzuriumAxe(String name, ToolMaterial toolAxe)
	{
		super(toolAxe, 6.0F, -3.2F);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}