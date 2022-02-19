package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.block_entity.render.GreenCampfireBlockEntityRenderer;
import fr.samlegamer.heartofender.compat.HoeCompats;
import fr.samlegamer.heartofender.compat.quark.block_entity.renderer.ChestRendererLilac;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import fr.samlegamer.heartofender.entity.models.HerobrineModel;
import fr.samlegamer.heartofender.entity.renders.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HoeClient
{
    public static final ModelLayerLocation ENDER_KID_MODEL = new ModelLayerLocation(new ResourceLocation(HeartofEnder.MODID, "ender_kid_model"), "ender_kid_model");
    public static final ModelLayerLocation HEROBRINE_MODEL = new ModelLayerLocation(new ResourceLocation(HeartofEnder.MODID, "herobrine_model"), "herobrine_model");
    
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ENDER_KID_MODEL, EnderKidModel::createLayer);
        event.registerLayerDefinition(HEROBRINE_MODEL, HerobrineModel::createLayer);
        
    }
    
    @SubscribeEvent
    public static void registerRendererEntity(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(HoeEntityRegistry.ENDER_KID, (context) -> new EnderKidRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.HEART_BLAZE, (context) -> new HeartBlazeRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.HEART_GHAST, (context) -> new HeartGhastRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.BLUE_MAGMA_CUBE, BlueMagmaCubeRender::new);
        event.registerEntityRenderer(HoeEntityRegistry.HEART_SKELETON, HeartSkeletonRender::new);
        event.registerEntityRenderer(HoeEntityRegistry.HEROBRINE, HerobrineRender::new);

       event.registerBlockEntityRenderer(HoeBlockEntityRegistry.GREEN_CAMPFIRE_TILE.get(), (context) -> new GreenCampfireBlockEntityRenderer(context));
       
       if(ModList.get().isLoaded("quark"))
       {
    	   event.registerBlockEntityRenderer(HoeCompats.Quark.leafy_chest_be.get(), ChestRendererLilac::new);
       }
    }
}