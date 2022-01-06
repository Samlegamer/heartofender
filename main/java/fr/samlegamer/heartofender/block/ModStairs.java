package fr.samlegamer.heartofender.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraftforge.common.ToolType;

public class ModStairs extends StairsBlock
{
	public ModStairs(BlockState modelState, int breack, int resist)
    {
        super(modelState, AbstractBlock.Properties.of(modelState.getMaterial()).harvestTool(ToolType.PICKAXE).strength(breack, resist));
    }
}