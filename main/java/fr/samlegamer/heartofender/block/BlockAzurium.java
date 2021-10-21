package fr.samlegamer.heartofender.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAzurium extends Block
{
	public BlockAzurium(String name, Material materialIn)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
        this.setSoundType(SoundType.METAL);
	}
}