package fr.samlegamer.heartofender.inits;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class ModFluids
{
	
	public static void init() {}

    public static final IOptionalNamedTag<Fluid> GREEN_LAVA = tag("green_lava");

    private static IOptionalNamedTag<Fluid> tag(String name)
    {
        return FluidTags.createOptional(new ResourceLocation("forge", name));
    }

	/*
    public static final DeferredRegister<Fluid> FLUIDS_REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, HeartofEnder.MODID);

	public static final RegistryObject<Fluid> GREEN_LAVA = createFluidGeneric("lava_green", () -> new GenericFluids(Fluids.MILK, new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_still"), new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_flow")));

    
    public static RegistryObject<Fluid> createFluidGeneric(String name, Supplier<? extends Fluid> supplier)
    {
        RegistryObject<Fluid> fluids = FLUIDS_REGISTRY.register(name, supplier);
        return fluids;
    } */
}