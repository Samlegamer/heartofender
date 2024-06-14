package fr.samlegamer.heartofender.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMetalGeneric extends Block
{
	public BlockMetalGeneric(String name, Material materialIn)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
        this.setSoundType(SoundType.METAL);
	}
}