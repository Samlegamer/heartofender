package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import fr.samlegamer.heartofender.entity.renders.EnderKidRender;
import fr.samlegamer.heartofender.entity.renders.HeartBlazeRender;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HoeClient
{
    public static final ModelLayerLocation ENDER_KID_MODEL = new ModelLayerLocation(new ResourceLocation(HeartofEnder.MODID, "ender_kid_model"), "ender_kid_model");

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ENDER_KID_MODEL, EnderKidModel::createLayer);

    }
    
    @SubscribeEvent
    public static void registerRendererEntity(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(HoeEntityRegistry.ENDER_KID, (context) -> new EnderKidRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.HEART_BLAZE, (context) -> new HeartBlazeRender(context));

    }
}