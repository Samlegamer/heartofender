package fr.samlegamer.heartofender.core;

import java.util.stream.Collectors;

import fr.samlegamer.heartofender.config.ConfigFileHeartofEnder;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.inits.*;
import fr.samlegamer.heartofender.potions.PotionsLists;
import fr.samlegamer.heartofender.potions.recipes.PotionRecipesRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import fr.samlegamer.heartofender.utils.CreaTabHeartofEnder;
import fr.samlegamer.heartofender.world.OreGen;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	public static final Logger LOGGER = LogManager.getLogger();

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
		HoeClients.init();
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
	
	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		InterModComms.sendTo("ba_bt", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event)
	{
		LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event)
	{
		LOGGER.info("HELLO from server starting");
	}
}