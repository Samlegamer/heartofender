package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class MilathiumPickaxe extends ItemPickaxe
{
	public MilathiumPickaxe(String name, ToolMaterial toolPickaxe)
	{
		super(toolPickaxe);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}