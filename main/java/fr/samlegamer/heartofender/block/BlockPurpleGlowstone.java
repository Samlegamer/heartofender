package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.ItemsMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockPurpleGlowstone extends Block
{
    public BlockPurpleGlowstone(String name, Material materialIn)
    {
        super(materialIn);
        setUnlocalizedName(name);
		setRegistryName(name);
        this.setSoundType(SoundType.GLASS);
		this.setLightLevel(3.0F);
		this.setLightOpacity(3);
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemsMod.purple_glowstone_dust;
    }

    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.PURPLE;
    }
}