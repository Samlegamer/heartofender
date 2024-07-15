package fr.samlegamer.heartofender.client;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.block.HoeBlocks;
import fr.samlegamer.heartofender.client.models.EnderKidModel;
import fr.samlegamer.heartofender.client.renders.BlueMagmaCubeRender;
import fr.samlegamer.heartofender.client.renders.EnderKidRender;
import fr.samlegamer.heartofender.client.renders.HeartBlazeRender;
import fr.samlegamer.heartofender.client.renders.HeartGhastRender;
import fr.samlegamer.heartofender.client.renders.HeartStriderRender;
import fr.samlegamer.heartofender.fluid.HoeFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class HoeClient implements ClientModInitializer
{
    public static final EntityModelLayer ENDER_KID = new EntityModelLayer(new Identifier(HeartofEnder.MODID, "ender_kid"), "main");

	@Override
	public void onInitializeClient()
	{
		EntityRendererRegistry.register(HeartofEnder.HEART_BLAZE, (context) -> { return new HeartBlazeRender(context); });
		EntityRendererRegistry.register(HeartofEnder.ENDER_KID, (context) -> { return new EnderKidRender(context); });
		EntityRendererRegistry.register(HeartofEnder.HEART_GHAST, (context) -> { return new HeartGhastRender(context); });
		EntityRendererRegistry.register(HeartofEnder.BLUE_MAGMA_CUBE, (context) -> { return new BlueMagmaCubeRender(context); });
		EntityRendererRegistry.register(HeartofEnder.HEART_STRIDER, (context) -> { return new HeartStriderRender(context); });

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), HoeBlocks.GREEN_LANTERN, HoeBlocks.GREEN_FIRE);
		
        EntityModelLayerRegistry.registerModelLayer(ENDER_KID, EnderKidModel::getTexturedModelData);

		FluidRenderHandlerRegistry.INSTANCE.register(HoeFluids.GREEN_LAVA, HoeFluids.FLOWING_GREEN_LAVA, new SimpleFluidRenderHandler(new Identifier(HeartofEnder.MODID, "blocks/green_lava_still"), new Identifier(HeartofEnder.MODID, "blocks/green_lava_flow")));

	}
}