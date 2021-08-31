package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSword;

public class AzuriumSword extends ItemSword
{
	public AzuriumSword(String name, ToolMaterial toolMat)
	{
		super(toolMat);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}