package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemPickaxe;

public class PickaxeGeneric extends ItemPickaxe
{
	public PickaxeGeneric(String name, ToolMaterial material)
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
}