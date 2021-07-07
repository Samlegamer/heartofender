package fr.samlegamer.heartofender.world;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldsRegisty
{
	public static void MainRegistry()
	{
		registerWorldGen ((IWorldGenerator) new WorldsRegisty(), -1);
		registerWorldGen ((IWorldGenerator) new WorldsRegisty(), 0);
		registerWorldGen( (IWorldGenerator) new WorldsRegisty(), 1);
	}

	private static void registerWorldGen(IWorldGenerator iGenerator, int weightProbability)
	{
		GameRegistry.registerWorldGenerator(iGenerator, weightProbability);
	}
}