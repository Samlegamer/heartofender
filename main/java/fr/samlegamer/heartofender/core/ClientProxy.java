package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.inits.BiomesMod;
import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.DimensionsMod;
import fr.samlegamer.heartofender.inits.EntitiesMod;
import fr.samlegamer.heartofender.inits.FluidsMod;
import fr.samlegamer.heartofender.inits.ItemsMod;
import fr.samlegamer.heartofender.inits.RecipesMod;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import fr.samlegamer.heartofender.inits.forfluids.ModItems;
import fr.samlegamer.heartofender.utils.HeartofEnderCreativeTabs;
import fr.samlegamer.heartofender.utils.IHasModel;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.utils.RendersFluids;
import fr.samlegamer.heartofender.utils.RendersMod;
import fr.samlegamer.heartofender.world.WorldsGenHeartofEnder;
import fr.samlegamer.heartofender.world.WorldsRegisty;
import fr.samlegamer.heartofender.world.worldgen.fortress.GenStructure;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		super.preInit();
		ItemsMod.init();
		BlocksMod.init();
		EntitiesMod.registerEntities();
		RendersMod.registerEntityRenders();
		GameRegistry.registerWorldGenerator(new WorldsGenHeartofEnder(), 0);
		RegistryHandler.preInitRegistries();
		RecipesMod.initRecipes();
		//GameRegistry.registerWorldGenerator(new GenStructure(), 2);
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
	
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}