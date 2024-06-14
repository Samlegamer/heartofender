package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.inits.*;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import fr.samlegamer.heartofender.inits.forfluids.ModItems;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.utils.RendersMod;
import fr.samlegamer.heartofender.world.WorldsGenHeartofEnder;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
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
	
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}