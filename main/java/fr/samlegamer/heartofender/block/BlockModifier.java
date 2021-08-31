package fr.samlegamer.heartofender.block;

import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModifier extends Block
{
	public BlockModifier(Material materialIn)
	{
		super(materialIn);
	}

	public boolean isFireSource(World world, BlockPos pos, EnumFacing side)
    {
        if (side != EnumFacing.UP)
            return false;
        if (this == BlocksMod.dark_end_stone || this == Blocks.MAGMA)
            return true;
        if ((world.provider instanceof net.minecraft.world.WorldProviderEnd) && this == Blocks.BEDROCK)
            return true;
        return false;
    }
}