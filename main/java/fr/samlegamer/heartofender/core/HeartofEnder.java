package fr.samlegamer.heartofender.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.samlegamer.heartofender.inits.EntitiesMod;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import fr.samlegamer.heartofender.inits.forfluids.ModItems;
import fr.samlegamer.heartofender.utils.HeartofEnderCreativeTabs;
import fr.samlegamer.heartofender.utils.IHasModel;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.utils.RendersFluids;
import fr.samlegamer.heartofender.utils.RendersMod;
import fr.samlegamer.heartofender.world.worldgen.fortress.GenStructure;
import fr.samlegamer.heartofender.world.worldgen.fortress.StructureHeartBridgePieces;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class HeartofEnder
{
	@Instance(References.MODID)
	public static HeartofEnder instance;
	
	public static final Logger LOGGER = LogManager.getLogger(References.MODID);
	
	@SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SEVERPROXY)
	public static CommonProxy proxy;
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	public static final HeartofEnderCreativeTabs CREATIVE_TAB_BLOCKS = new HeartofEnderCreativeTabs("heartofender_blocks");
	public static final HeartofEnderCreativeTabs CREATIVE_TAB_ITEMS = new HeartofEnderCreativeTabs("heartofender_items");
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
}