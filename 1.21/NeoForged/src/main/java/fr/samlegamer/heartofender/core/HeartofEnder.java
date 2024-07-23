package fr.samlegamer.heartofender.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.entity.*;
import fr.samlegamer.heartofender.features.HoeFeaturesRegistry;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.item.HoeEquipment;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import fr.samlegamer.heartofender.particle.HoeRendersParticles;
import fr.samlegamer.heartofender.utils.tab.HoeTabs;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod(HeartofEnder.MODID)
//@EventBusSubscriber(modid = HeartofEnder.MODID, bus = EventBusSubscriber.Bus.MOD)
public class HeartofEnder
{
	public static final String MODID = "heartofender";
	private static final Logger LOGGER = LogManager.getLogger();

	public HeartofEnder(IEventBus bus, ModContainer modContainer)
	{
		modContainer.registerConfig(ModConfig.Type.COMMON, HoeConfigsRegistry.SERVER_CONFIG);
		bus.addListener(this::SetupClient);
		bus.addListener(HoeTabs::addToTab);
		bus.addListener(HoeRendersParticles::registerParticles);
		bus.addListener(this::SetupCommon);
		//IEventBus forge = NeoForge.EVENT_BUS;
		HoeParticleRegistry.REGISTRY_PARTICLES.register(bus);
		HoeBlocksRegistry.REGISTRY_BLOCKS.register(bus);
		HoeItemsRegistry.REGISTRY_ITEMS.register(bus);
		HoeEquipment.ARMOR_MATERIALS.register(bus);
		HoeEntityRegistry.REGISTRY_ENTITIES.register(bus);
		//HoePOI.REGISTRY_POI.register(bus);
		HoeFluidsRegistry.REGISTRY_FLUIDS.register(bus);
		HoeFeaturesRegistry.REGISTRY_FEATURES.register(bus);
		HoeBlockEntityRegistry.REGISTRY_BLOCK_ENTITY.register(bus);
		//HoePotionRegisty.REGISTRY_POTIONS.register(bus);
		HoeTabs.REGISTRY_TABS.register(bus);
		//HoeCompats();
		//bus.register(HoeEvents.class);
		bus.addListener(this::bakeAttributes);
	}
	
	private void SetupCommon(FMLCommonSetupEvent common)
	{
		 //common.enqueueWork(()->{HoeOreGenerator.registerOres();});
		 //HoePotionRecipes.registerRecipes();
	}

	private void SetupClient(FMLClientSetupEvent client)
	{
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HEART_ENDER_WART_BLOCK.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_FIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_LANTERN.get(), RenderType.cutout());
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_TORCH.get(), RenderType.cutout());
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_TORCH_WALL.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.GREEN_CAMPFIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_DOOR.get(), RenderType.cutout());
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HOE_PORTAL.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_WEEPING_VINES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_WEEPING_VINES_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TWISTING_VINES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_TWISTING_VINES_PLANT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get(), RenderType.cutout());
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_FUNGUS.get(), RenderType.cutout());
		//ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_FUNGUS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LEAFY_ROOTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.LILAC_ROOTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_FIRE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_LANTERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(HoeBlocksRegistry.PURPLE_CAMPFIRE.get(), RenderType.cutout());

		/*if(ModList.get().isLoaded("charm") && HoeConfig.charmCompat)
		{
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Charm.green_gold_lantern.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Charm.purple_gold_lantern.get(), RenderType.cutout());
		}
		
		if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat)
		{
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Quark.lilac_ladder.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(HoeCompats.Quark.leafy_ladder.get(), RenderType.cutout());
		}*/
	}
	
	//@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void bakeAttributes(EntityAttributeCreationEvent creationEvent)
    {
        creationEvent.put(HoeEntityRegistry.ENDER_KID.get(), EnderKid.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_BLAZE.get(), HeartBlaze.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_GHAST.get(), HeartGhast.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.BLUE_MAGMA_CUBE.get(), BlueMagmaCube.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEART_SKELETON.get(), HeartSkeleton.createAttributes().build());
        creationEvent.put(HoeEntityRegistry.HEROBRINE.get(), Herobrine.createAttributes().build());
    }
	
	/*@SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event)
	{
       final ModConfig config = event.getConfig();
       
       if (config.getSpec() == HoeConfigsRegistry.SERVER_CONFIG)
       {
           HoeConfig.serverInit(config);
       }
	}*/
	
	public static void msg(String msg)
	{
		LOGGER.info(msg);
	}
	
	public static ResourceLocation location(String key)
	{
		return ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, key);
	}
	
	/**/
		
	static void HoeCompats()
	{
		/*HoeCompats.Quark.InitQuark();
		HoeCompats.Charm.InitCharm();
		HoeCompats.Aquaculture.InitAquaculture();
		HoeCompats.MoreCraftingTables.InitMoreCraftingTables();*/
	}
}