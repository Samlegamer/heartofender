package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSword;

public class SwordGeneric extends ItemSword
{
	public SwordGeneric(String name, ToolMaterial material)
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
}