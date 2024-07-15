package fr.samlegamer.heartofender.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.compat.HoeCompats;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.dimension.HoeDimensionRegistry;
import fr.samlegamer.heartofender.entity.*;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.features.HoeFeaturesRegistry;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import fr.samlegamer.heartofender.poi.HoePOI;
import fr.samlegamer.heartofender.potion.HoePotionRecipes;
import fr.samlegamer.heartofender.potion.HoePotionRegisty;
import fr.samlegamer.heartofender.utils.tab.HoeTabs;
import fr.samlegamer.heartofender.world.HoeConfiguredFeature;
import fr.samlegamer.heartofender.world.HoePlacedFeature;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
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
	private static final Logger LOGGER = LogManager.getLogger();

	public HeartofEnder()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HoeConfigsRegistry.SERVER_CONFIG);
		HoeDimensionRegistry.register();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::SetupClient);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::SetupCommon);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forge = MinecraftForge.EVENT_BUS;
		HoeEntityRegistry.REGISTRY_ENTITIES.register(bus);
		HoeItemsRegistry.REGISTRY_ITEMS.register(bus);
		HoeBlocksRegistry.REGISTRY_BLOCKS.register(bus);
		HoeConfiguredFeature.REGISTRY_CONFIGURED_FEATURE.register(bus);
		HoePlacedFeature.REGISTRY_PLACED_FEATURE.register(bus);
		HoePOI.REGISTRY_POI.register(bus);
		HoeFluidsRegistry.REGISTRY_FLUIDS.register(bus);
		HoeParticleRegistry.REGISTRY_PARTICLES.register(bus);
		HoeFeaturesRegistry.REGISTRY_FEATURES.register(bus);
		HoeBlockEntityRegistry.REGISTRY_BLOCK_ENTITY.register(bus);
		HoePotionRegisty.REGISTRY_POTIONS.register(bus);
		HoeCompats();
		forge.register(HoeEvents.class);
	}
	
	private void SetupCommon(FMLCommonSetupEvent common)
	{
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
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HOE_PORTAL.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_WEEPING_VINES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_WEEPING_VINES_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TWISTING_VINES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TWISTING_VINES_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_FUNGUS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_FUNGUS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_ROOTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_ROOTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_FIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_LANTERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_CAMPFIRE.get(), RenderType.cutout());

		if(ModList.get().isLoaded("charm") && HoeConfig.charmCompat)
		{
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Charm.green_gold_lantern.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Charm.purple_gold_lantern.get(), RenderType.cutout());
		}
		
		if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat)
		{
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Quark.lilac_ladder.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Quark.leafy_ladder.get(), RenderType.cutout());
		}
	}
	
	public static void msg(String msg)
	{
		LOGGER.info(msg);
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
	
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void bakeAttributes(EntityAttributeCreationEvent creationEvent)
    {
        creationEvent.put(HoeEntityRegistry.ENDER_KID.get(), EnderKid.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_BLAZE.get(), HeartBlaze.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_GHAST.get(), HeartGhast.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.BLUE_MAGMA_CUBE.get(), BlueMagmaCube.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_SKELETON.get(), HeartSkeleton.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEROBRINE.get(), Herobrine.createAttributes().build());
    }
		
	static void HoeCompats()
	{
		HoeCompats.Quark.InitQuark();
		HoeCompats.Charm.InitCharm();
		HoeCompats.Aquaculture.InitAquaculture();
		HoeCompats.MoreCraftingTables.InitMoreCraftingTables();
	}
}