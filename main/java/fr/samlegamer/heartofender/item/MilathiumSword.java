package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class MilathiumSword extends ItemSword
{
	public MilathiumSword(String name, ToolMaterial toolMat)
	{
		super(toolMat);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}