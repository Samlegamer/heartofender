package fr.samlegamer.heartofender.fluid;

import fr.samlegamer.heartofender.HeartofEnder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HoeFluids
{
    public static final FlowableFluid FLOWING_GREEN_LAVA = new GreenLavaFluid.Flowing();
    public static final FlowableFluid GREEN_LAVA =new GreenLavaFluid.Still();
    public static final Block GREEN_LAVA_BLOCK = new HoeFluidBlock(GREEN_LAVA, AbstractBlock.Settings.of(Material.LAVA).noCollision().ticksRandomly().strength(100.0f).luminance(state -> 15).dropsNothing());

    public static void registryFluids()
    {
    	Registry.register(Registry.FLUID, new Identifier(HeartofEnder.MODID, "green_lava_flow"), FLOWING_GREEN_LAVA);
    	Registry.register(Registry.FLUID, new Identifier(HeartofEnder.MODID, "green_lava"), GREEN_LAVA);
    	Registry.register(Registry.BLOCK, new Identifier(HeartofEnder.MODID, "green_lava_block"), GREEN_LAVA_BLOCK);

    }
}