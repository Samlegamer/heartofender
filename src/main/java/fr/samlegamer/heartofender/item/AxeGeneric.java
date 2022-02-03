package fr.samlegamer.heartofender.item;

import net.minecraft.item.ItemAxe;

public class AxeGeneric extends ItemAxe
{
	public AxeGeneric(String name, ToolMaterial material)
	{
		super(ToolMaterial.DIAMOND);
        this.toolMaterial = material;
        this.attackDamage = material.getAttackDamage() + 5;
        this.attackSpeed = -3;
		setRegistryName(name);
		setUnlocalizedName(name);
	}
}