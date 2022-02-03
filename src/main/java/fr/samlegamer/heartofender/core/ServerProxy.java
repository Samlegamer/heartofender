package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.inits.*;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.world.WorldsGenHeartofEnder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
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