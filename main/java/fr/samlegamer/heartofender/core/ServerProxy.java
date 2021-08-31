package fr.samlegamer.heartofender.core;

import java.io.File;

import fr.samlegamer.heartofender.inits.BiomesMod;
import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.DimensionsMod;
import fr.samlegamer.heartofender.inits.EntitiesMod;
import fr.samlegamer.heartofender.inits.FluidsMod;
import fr.samlegamer.heartofender.inits.ItemsMod;
import fr.samlegamer.heartofender.inits.RecipesMod;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import fr.samlegamer.heartofender.inits.forfluids.ModItems;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.utils.RendersFluids;
import fr.samlegamer.heartofender.utils.RendersMod;
import fr.samlegamer.heartofender.world.WorldsGenHeartofEnder;
import fr.samlegamer.heartofender.world.WorldsRegisty;
import fr.samlegamer.heartofender.world.worldgen.fortress.GenStructure;
import fr.samlegamer.heartofender.world.worldgen.fortress.MapGeneratorHeartFortress;
import fr.samlegamer.heartofender.world.worldgen.fortress.StructureHeartBridgePieces;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		super.preInit();
		ItemsMod.init();
		BlocksMod.init();
		EntitiesMod.registerEntities();
		GameRegistry.registerWorldGenerator(new WorldsGenHeartofEnder(), 0);
		RegistryHandler.preInitRegistries();
		RecipesMod.initRecipes();
		MinecraftForge.EVENT_BUS.register(HeartofEnder.proxy);
	}
	
	@Override
	public void init()
	{
		super.init();
		DimensionsMod.init();
		RecipesMod.instance.initRecipes();
	}
	
	@Override
	public void postInit()
	{
		super.postInit();
	}
}