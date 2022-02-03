package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSpade;

public class ShovelGeneric extends ItemSpade
{
	public ShovelGeneric(String name, ToolMaterial material)
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
}