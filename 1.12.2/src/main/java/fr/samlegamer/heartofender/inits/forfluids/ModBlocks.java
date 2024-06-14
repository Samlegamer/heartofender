package fr.samlegamer.heartofender.inits.forfluids;

import java.util.ArrayList;
import java.util.List;
import fr.samlegamer.heartofender.block.BlockFluidMod;
import fr.samlegamer.heartofender.inits.FluidsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block GREEN_LAVA_BLOCK = new BlockFluidMod("green_lava_fluid", FluidsMod.GREEN_LAVA_FLUID , Material.LAVA).setLightLevel(1.0F);
}