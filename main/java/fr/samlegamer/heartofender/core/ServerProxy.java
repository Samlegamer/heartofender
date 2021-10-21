package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.DimensionsMod;
import fr.samlegamer.heartofender.inits.EntitiesMod;
import fr.samlegamer.heartofender.inits.ItemsMod;
import fr.samlegamer.heartofender.inits.RecipesMod;
import fr.samlegamer.heartofender.utils.RegistryHandler;
import fr.samlegamer.heartofender.world.WorldsGenHeartofEnder;
import fr.samlegamer.heartofender.world.WorldsRegisty;
import fr.samlegamer.heartofender.world.worldgen.fortress.GenStructure;
import net.minecraft.item.Item;
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