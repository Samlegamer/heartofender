package fr.samlegamer.heartofender.fluids;

import net.minecraft.fluid.FluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class GenericFluids extends ForgeFlowingFluid
{
	public GenericFluids(Properties properties, ResourceLocation still, ResourceLocation flow)
	{
		super(properties);
	}

	@Override
	public boolean isSource(FluidState p_207193_1_)
	{
		return false;
	}

	@Override
	public int getAmount(FluidState p_207192_1_)
	{
		return 0;
	}
}