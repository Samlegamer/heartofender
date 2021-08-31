package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemPickaxe;

public class AzuriumPickaxe extends ItemPickaxe
{
	public AzuriumPickaxe(String name, ToolMaterial toolPickaxe)
	{
		super(toolPickaxe);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}