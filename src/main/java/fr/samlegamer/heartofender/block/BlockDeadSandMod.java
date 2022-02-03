package fr.samlegamer.heartofender.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDeadSandMod extends BlockSoulSand
{
    public BlockDeadSandMod(String name)
    {
        super();
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setSoundType(SoundType.SAND);
    }
}