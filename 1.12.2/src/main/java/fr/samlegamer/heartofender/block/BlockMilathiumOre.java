package fr.samlegamer.heartofender.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class BlockMilathiumOre extends BlockOre
{
	public BlockMilathiumOre(String name, int harvestLevel, Material getmaterial)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel("pickaxe", harvestLevel);
	}
}