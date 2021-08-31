package fr.samlegamer.heartofender.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModBlock extends Block
{
	
    public ModBlock(Material materialIn, String toolUsed, int toolStrength, float hardness, float resistance, SoundType sound) {
        super(
    		AbstractBlock.Properties
    			.of(materialIn)
    			.sound(sound)
    			.strength(hardness, resistance)
    			.harvestTool(ToolType.get(toolUsed))
    			.harvestLevel(toolStrength)
    			.requiresCorrectToolForDrops()
    			
		);
    }
}