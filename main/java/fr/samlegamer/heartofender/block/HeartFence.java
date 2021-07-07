package fr.samlegamer.heartofender.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class HeartFence extends BlockFence
{
	public HeartFence(String name, float hardness, float resistance)
	{
		super(Material.ROCK, Material.ROCK.getMaterialMapColor());
		setUnlocalizedName(name);
		setRegistryName(name);
		setResistance(resistance);
		setHardness(hardness);
		this.useNeighborBrightness = true;
	}
}