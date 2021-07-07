package fr.samlegamer.heartofender.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModEntities;
import fr.samlegamer.heartofender.inits.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import fr.samlegamer.heartofender.utils.CreaTabHeartofEnder;
import fr.samlegamer.heartofender.world.OreGen;


@Mod(value = HeartofEnder.MODID)
public class HeartofEnder
{
	public static final String MODID = "heartofender";
    public static final Logger logg = LogManager.getLogger();

	public static final CreaTabHeartofEnder CREATIVE_TAB_BLOCKS = new CreaTabHeartofEnder("heartofender_blocks");
	public static final CreaTabHeartofEnder CREATIVE_TAB_ITEMS = new CreaTabHeartofEnder("heartofender_items");
			
	public HeartofEnder()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
				
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.ITEMS_REGISTRY.register(bus);
		ModBlocks.BLOCKS_REGISTRY.register(bus);
	}
	
	private void setup(FMLCommonSetupEvent event)
	{
		OreGen features = new OreGen();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
        logg.info(ModEntities.LOADED_ENTITIES);
	}
	
	private void ClientSetup(FMLClientSetupEvent event)
	{
		ClientRender.setupClient();
	}
	
}