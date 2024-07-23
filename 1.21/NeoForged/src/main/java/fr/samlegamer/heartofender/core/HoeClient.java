package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.block_entity.render.GreenCampfireRenderer;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import fr.samlegamer.heartofender.entity.models.HerobrineModel;
import fr.samlegamer.heartofender.entity.renders.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = HeartofEnder.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class HoeClient
{
    public static final ModelLayerLocation ENDER_KID_MODEL = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "ender_kid_model"), "ender_kid_model");
    public static final ModelLayerLocation HEROBRINE_MODEL = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "herobrine_model"), "herobrine_model");
    public static final ModelLayerLocation LILAC_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "lilac_chest"), "main");
    public static final ModelLayerLocation LILAC_CHEST_LEFT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "lilac_chest_left"), "main");
    public static final ModelLayerLocation LILAC_CHEST_RIGHT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "lilac_chest_right"), "main");
    public static final ModelLayerLocation LEAFY_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "leafy_chest"), "main");
    public static final ModelLayerLocation LEAFY_CHEST_LEFT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "leafy_chest_left"), "main");
    public static final ModelLayerLocation LEAFY_CHEST_RIGHT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "leafy_chest_right"), "main");

    public static final ModelLayerLocation TRAP_LILAC_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_lilac_chest"), "main");
    public static final ModelLayerLocation TRAP_LILAC_CHEST_LEFT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_lilac_chest_left"), "main");
    public static final ModelLayerLocation TRAP_LILAC_CHEST_RIGHT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_lilac_chest_right"), "main");
    public static final ModelLayerLocation TRAP_LEAFY_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_leafy_chest"), "main");
    public static final ModelLayerLocation TRAP_LEAFY_CHEST_LEFT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_leafy_chest_left"), "main");
    public static final ModelLayerLocation TRAP_LEAFY_CHEST_RIGHT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "trap_leafy_chest_right"), "main");

    public static final ModelLayerLocation IRON_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "iron_chest"), "main");

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        //event.registerLayerDefinition(ENDER_KID_MODEL, EnderKidModel::createLayer);
       // event.registerLayerDefinition(HEROBRINE_MODEL, HerobrineModel::createLayer);
        /*event.registerLayerDefinition(LILAC_CHEST, ChestRendererLilac::createSingleBodyLayer);
        event.registerLayerDefinition(LILAC_CHEST_LEFT, ChestRendererLilac::createDoubleBodyLeftLayer);
        event.registerLayerDefinition(LILAC_CHEST_RIGHT, ChestRendererLilac::createDoubleBodyRightLayer);
        event.registerLayerDefinition(LEAFY_CHEST, ChestRendererLeafy::createSingleBodyLayer);
        event.registerLayerDefinition(LEAFY_CHEST_LEFT, ChestRendererLeafy::createDoubleBodyLeftLayer);
        event.registerLayerDefinition(LEAFY_CHEST_RIGHT, ChestRendererLeafy::createDoubleBodyRightLayer);
        
        if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat && HoeConfig.quarkChestModule)
        {
            event.registerLayerDefinition(TRAP_LILAC_CHEST, TrapChestRendererLilac::createSingleBodyLayer);
            event.registerLayerDefinition(TRAP_LILAC_CHEST_LEFT, TrapChestRendererLilac::createDoubleBodyLeftLayer);
            event.registerLayerDefinition(TRAP_LILAC_CHEST_RIGHT, TrapChestRendererLilac::createDoubleBodyRightLayer);
            event.registerLayerDefinition(TRAP_LEAFY_CHEST, TrapChestRendererLeafy::createSingleBodyLayer);
            event.registerLayerDefinition(TRAP_LEAFY_CHEST_LEFT, TrapChestRendererLeafy::createDoubleBodyLeftLayer);
            event.registerLayerDefinition(TRAP_LEAFY_CHEST_RIGHT, TrapChestRendererLeafy::createDoubleBodyRightLayer);
        }*/
    }
    
    @SubscribeEvent
    public static void registerRendererEntity(EntityRenderersEvent.RegisterRenderers event)
    {
        /*event.registerEntityRenderer(HoeEntityRegistry.ENDER_KID.get(), (context) -> new EnderKidRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.HEART_BLAZE.get(), (context) -> new HeartBlazeRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.HEART_GHAST.get(), (context) -> new HeartGhastRender(context));
        event.registerEntityRenderer(HoeEntityRegistry.BLUE_MAGMA_CUBE.get(), BlueMagmaCubeRender::new);
        event.registerEntityRenderer(HoeEntityRegistry.HEART_SKELETON.get(), HeartSkeletonRender::new);
        event.registerEntityRenderer(HoeEntityRegistry.HEROBRINE.get(), HerobrineRender::new);*/

       event.registerBlockEntityRenderer(HoeBlockEntityRegistry.GREEN_CAMPFIRE_TILE.get(), (context) -> new GreenCampfireRenderer(context));

       /*if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat && HoeConfig.quarkChestModule)
       {
    	   event.registerBlockEntityRenderer(HoeCompats.Quark.lilac_chest_be.get(), ChestRendererLilac::new);
    	   event.registerBlockEntityRenderer(HoeCompats.Quark.leafy_chest_be.get(), ChestRendererLeafy::new);
    	   event.registerBlockEntityRenderer(HoeCompats.Quark.trapped_lilac_chest_be.get(), TrapChestRendererLilac::new);
    	   event.registerBlockEntityRenderer(HoeCompats.Quark.trapped_leafy_chest_be.get(), TrapChestRendererLeafy::new);
       }*/
    }
}