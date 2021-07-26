package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.block.HoEBlockRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.utils.ModeTabHeartofEnder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = HeartofEnder.MODID)
public class HeartofEnder
{
	public static final String MODID = "heartofender";
	
	public static final ModeTabHeartofEnder CREATIVE_TAB_BLOCKS = new ModeTabHeartofEnder("heartofender_blocks");
	public static final ModeTabHeartofEnder CREATIVE_TAB_ITEMS = new ModeTabHeartofEnder("heartofender_items");
	
	public HeartofEnder()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonProxySetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientProxySetup);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		HoEBlockRegistry.REGISTRY_BLOCK.register(bus);
		HoeItemsRegistry.REGISTRY_ITEM.register(bus);
	}
	
	private void commonProxySetup(FMLCommonSetupEvent event)
	{
		
	}
	
	private void clientProxySetup(FMLClientSetupEvent event)
	{
		
	}
}
