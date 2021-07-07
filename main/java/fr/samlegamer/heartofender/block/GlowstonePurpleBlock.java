package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.ModItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

public class GlowstonePurpleBlock extends Block
{
    public GlowstonePurpleBlock(Material materialIn, float hardness, float resistance, SoundType sound)
    {
        super(
    		AbstractBlock.Properties
    			.of(materialIn)
    			.lightLevel((state) -> { return 20; })
    			.sound(sound)
    			.strength(hardness, resistance)
    			
		); 
        
		//this.setLightLevel(3.0F);
		//this.setLightOpacity(3);
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }

    public Item getItemDropped(BlockState state, Random rand, int fortune)
    {
        return ModItems.PURPLE_GLOWSTONE_DUST.get();
    }

    /*
    public MapColor getMapColor(BlockState state, BlockAccess worldIn, BlockPos pos)
    {
        return MapColor.PURPLE;
    } */
}