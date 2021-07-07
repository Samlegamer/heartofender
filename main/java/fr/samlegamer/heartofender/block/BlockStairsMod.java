package fr.samlegamer.heartofender.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairsMod extends BlockStairs
{
	public BlockStairsMod(String name, IBlockState modelState)
	{
		super(modelState);
		setUnlocalizedName(name);
		setRegistryName(name);
        this.setLightOpacity(255);
        this.useNeighborBrightness = true;
	}
}