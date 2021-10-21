package fr.samlegamer.heartofender.core;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.config.Configuration;
import fr.samlegamer.heartofender.utils.HeartofEnderCreativeTabs;
import fr.samlegamer.heartofender.utils.config.HoeConfig;
import fr.samlegamer.heartofender.world.worldgen.fortress.GenStructure;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.Loader;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class HeartofEnder
{
	public static Configuration config;
	public static HoeConfig CONFIG = new HoeConfig();
	
	 public static void loadConfig() {
	        File configFile = new File(Loader.instance().getConfigDir(), "heartofender.cfg");
	        if (!configFile.exists()) {
	            try {
	                configFile.createNewFile();
	            } catch (Exception e) {
	            	LOGGER.warn("Could not create a new Heart of Ender config file.");
	            	LOGGER.warn(e.getLocalizedMessage());
	            }
	        }
	        config = new Configuration(configFile);
	        config.load();
	    }

	    public static void syncConfig() {
	        CONFIG.init(config);
	        config.save();
	    }
	    
	@Instance(References.MODID)
	public static HeartofEnder instance;
	
	public static final Logger LOGGER = LogManager.getLogger(References.MODID);
	
	@SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
	public static CommonProxy proxy;
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	public static final HeartofEnderCreativeTabs CREATIVE_TAB_BLOCKS = new HeartofEnderCreativeTabs("heartofender_blocks");
	public static final HeartofEnderCreativeTabs CREATIVE_TAB_ITEMS = new HeartofEnderCreativeTabs("heartofender_items");
	
	//@Mod.
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
		loadConfig();
	    syncConfig();
	}
	
	//@Mod.
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	//@Mod.
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
}