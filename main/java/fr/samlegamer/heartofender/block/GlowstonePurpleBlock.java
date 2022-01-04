package fr.samlegamer.heartofender.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

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
    }
}