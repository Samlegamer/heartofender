package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class RendersFluids
{
	@SubscribeEvent
	public static void onRenderFluids(RegistryEvent.Register<Block> event)
	{
		ModelLoader.setCustomStateMapper(ModBlocks.GREEN_LAVA_BLOCK, new StateMapperBase()
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return new ModelResourceLocation(References.MODID + ":green_lava_fluid", "fluid");
			}
		});
	}
}