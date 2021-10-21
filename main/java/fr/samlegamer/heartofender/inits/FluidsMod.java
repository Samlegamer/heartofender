package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.fluids.FluidGeneric;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidsMod
{
	public static final Fluid GREEN_LAVA_FLUID = new FluidGeneric("green_lava_fluid", new ResourceLocation(References.MODID, "blocks/green_lava_still"), new ResourceLocation(References.MODID, "blocks/green_lava_flow"));

	public static void registerFluids()
	{
		registerFluid(GREEN_LAVA_FLUID);
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}