package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class MilathiumAxe extends ItemAxe
{
	public MilathiumAxe(String name, ToolMaterial toolAxe)
	{
		super(toolAxe, 6.0F, -3.2F);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}