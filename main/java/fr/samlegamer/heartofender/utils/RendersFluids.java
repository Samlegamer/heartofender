package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.client.model.ModelLoader;

public class RendersFluids
{
	public static void registerCustomStateMapper()
	{
		ModelLoader.setCustomStateMapper(ModBlocks.GREEN_LAVA_BLOCK, new StateMapperBase()
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return new ModelResourceLocation("heartofender:green_lava_fluid", "fluid");
			}
		});
	}
}