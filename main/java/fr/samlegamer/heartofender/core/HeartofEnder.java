package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.config.ConfigFileHeartofEnder;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.entity.renders.*;
import fr.samlegamer.heartofender.inits.*;
import fr.samlegamer.heartofender.potions.PotionsLists;
import fr.samlegamer.heartofender.potions.recipes.PotionRecipesRegistry;
import fr.samlegamer.heartofender.tile.GreenCampfireTileEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import fr.samlegamer.heartofender.utils.CreaTabHeartofEnder;
import fr.samlegamer.heartofender.world.OreGen;
import net.minecraftforge.fml.config.ModConfig;

/*
 * Heart of Ender by Samlegamer
 * Public Domain
 * The Code is free to use
 */
@Mod(value = HeartofEnder.MODID)
@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeartofEnder
{
	public static final String MODID = "heartofender";

	public static final CreaTabHeartofEnder CREATIVE_TAB_BLOCKS = new CreaTabHeartofEnder("heartofender_blocks");
	public static final CreaTabHeartofEnder CREATIVE_TAB_ITEMS = new CreaTabHeartofEnder("heartofender_items");
		
	public HeartofEnder()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigFileHeartofEnder.SERVER_CONFIG);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forge = MinecraftForge.EVENT_BUS;
       
		ModParticles.PARTICLE_REGISTRY.register(bus);
		ModTileEntities.TILE_ENTITIES_REGISTRY.register(bus);
		ModBlocks.BLOCKS_REGISTRY.register(bus);
		ModItems.ITEMS_REGISTRY.register(bus);
        ModFluids.FLUIDS_REGISTRY.register(bus);
        PotionsLists.POTIONS_REGISTRY.register(bus);
        ModPOI.POI_REGISTRY.register(bus);
        ModFeatures.FEATURES_REGISTRY.register(bus);
        //ModStructures.STRUCTURE_REGISTRY.register(bus);
        
        forge.register(HoeEvents.class);
	}
	
	private void setup(FMLCommonSetupEvent event)
	{
		OreGen features = new OreGen();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
        ModEntities.class.getDeclaredFields();
		PotionRecipesRegistry.registerRecipes();
	}
		
	private void ClientSetup(FMLClientSetupEvent event)
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_BLAZE, manager -> new HeartBlazeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ENDER_KID, manager -> new EnderKidRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_GHAST, manager -> new HeartGhastRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLUE_MAGMA_CUBE, manager -> new BlueMagmaCubeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_SKELETON, manager -> new HeartSkeletonRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEROBRINE, manager -> new HerobrineRenderer(manager));

        ClientRegistry.bindTileEntityRenderer(ModTileEntities.GREEN_CAMPFIRE_TILE.get(), GreenCampfireTileEntityRenderer::new);
        
		RenderTypeLookup.setRenderLayer(ModBlocks.HEART_ENDER_WART_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_FIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_TORCH_WALL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_CAMPFIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_LANTERN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HEART_OF_ENDER_PORTAL.get(), RenderType.translucent());
	}
	
	public static ResourceLocation location(String key)
	{
		return new ResourceLocation(HeartofEnder.MODID, key);
	}
	
	@SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
       final ModConfig config = event.getConfig();
       
       if (config.getSpec() == ConfigFileHeartofEnder.SERVER_CONFIG)
       {
           HoeConfig.serverInit(config);
       }
	}
}