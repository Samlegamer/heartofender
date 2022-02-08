package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.features.HoeFeaturesRegistry;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import fr.samlegamer.heartofender.poi.HoePOI;
import fr.samlegamer.heartofender.potion.HoePotionRecipes;
import fr.samlegamer.heartofender.potion.HoePotionRegisty;
import fr.samlegamer.heartofender.utils.tab.HoeTabs;
import fr.samlegamer.heartofender.world.HoeOreGenerator;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

@Mod(HeartofEnder.MODID)
@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HeartofEnder
{
	public static final String MODID = "heartofender";
	
	public static final HoeTabs TAB_BLOCKS = new HoeTabs("heartofender_blocks");
	public static final HoeTabs TAB_ITEMS = new HoeTabs("heartofender_items");

	public HeartofEnder()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HoeConfigsRegistry.SERVER_CONFIG);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::SetupClient);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::SetupCommon);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forge = MinecraftForge.EVENT_BUS;
		HoeItemsRegistry.REGISTRY_ITEMS.register(bus);
		HoeBlocksRegistry.REGISTRY_BLOCKS.register(bus);
		HoePOI.REGISTRY_POI.register(bus);
		HoeFluidsRegistry.REGISTRY_FLUIDS.register(bus);
		HoeParticleRegistry.REGISTRY_PARTICLES.register(bus);
		HoeFeaturesRegistry.REGISTRY_FEATURES.register(bus);
		HoeBlockEntityRegistry.REGISTRY_BLOCK_ENTITY.register(bus);
		HoePotionRegisty.REGISTRY_POTIONS.register(bus);
		
		forge.register(HoeEvents.class);
	}
	
	private void SetupCommon(FMLCommonSetupEvent common)
	{
		 common.enqueueWork(()->{HoeOreGenerator.registerOres();});
		 HoePotionRecipes.registerRecipes();
	}

	private void SetupClient(FMLClientSetupEvent client)
	{
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HEART_ENDER_WART_BLOCK.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_FIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_LANTERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_TORCH_WALL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_CAMPFIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HOE_PORTAL.get(), RenderType.translucent());
	}
	
	public static ResourceLocation location(String key)
	{
		return new ResourceLocation(HeartofEnder.MODID, key);
	}
	
	@SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event)
	{
       final ModConfig config = event.getConfig();
       
       if (config.getSpec() == HoeConfigsRegistry.SERVER_CONFIG)
       {
           HoeConfig.serverInit(config);
       }
	}
}