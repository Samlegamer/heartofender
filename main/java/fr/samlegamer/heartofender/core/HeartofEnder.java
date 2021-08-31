package fr.samlegamer.heartofender.core;

import org.antlr.v4.runtime.misc.NotNull;

import fr.samlegamer.heartofender.entity.renders.BlueMagmaCubeRenderer;
import fr.samlegamer.heartofender.entity.renders.EnderKidRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartBlazeRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartGhastRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartSkeletonRenderer;
import fr.samlegamer.heartofender.inits.ModBiomes;
import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModEntities;
import fr.samlegamer.heartofender.inits.ModFluids;
import fr.samlegamer.heartofender.inits.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import fr.samlegamer.heartofender.utils.CreaTabHeartofEnder;
import fr.samlegamer.heartofender.world.OreGen;

@SuppressWarnings("deprecation")
@Mod(value = HeartofEnder.MODID)
@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeartofEnder
{
	public static final String MODID = "heartofender";

	public static final CreaTabHeartofEnder CREATIVE_TAB_BLOCKS = new CreaTabHeartofEnder("heartofender_blocks");
	public static final CreaTabHeartofEnder CREATIVE_TAB_ITEMS = new CreaTabHeartofEnder("heartofender_items");
		
	public HeartofEnder()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
				
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.ITEMS_REGISTRY.register(bus);
		ModBlocks.BLOCKS_REGISTRY.register(bus);
        ModFluids.FLUIDS_REGISTRY.register(bus);
       // ModFluids.init();
	}
	
	private void setup(FMLCommonSetupEvent event)
	{
		OreGen features = new OreGen();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
        ModEntities.class.getDeclaredFields();
	}
	
	private void ClientSetup(FMLClientSetupEvent event)
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_BLAZE, manager -> new HeartBlazeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ENDER_KID, manager -> new EnderKidRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_GHAST, manager -> new HeartGhastRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLUE_MAGMA_CUBE, manager -> new BlueMagmaCubeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_SKELETON, manager -> new HeartSkeletonRenderer(manager));

		RenderTypeLookup.setRenderLayer(ModBlocks.HEART_ENDER_WART_BLOCK.get(), RenderType.cutout());
	}
	
	//Other
	public static ResourceLocation location(String name) {
        return new ResourceLocation(MODID, name);
    }
	
	@SubscribeEvent
    public static void registerBiomes(@NotNull final RegistryEvent.Register<Biome> event)
	{
        ModBiomes.registerBiomes();
    }
}