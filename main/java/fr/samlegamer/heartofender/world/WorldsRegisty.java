package fr.samlegamer.heartofender.world;

import fr.samlegamer.heartofender.inits.WorldGenStructures;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldsRegisty
{
	public static void MainRegistry()
	{
		registerWorldGen (new WorldGenStructures(), -1);
		registerWorldGen (new WorldGenStructures(), 0);
		registerWorldGen(new WorldGenStructures(), 1);
		registerWorldGen(new WorldGenStructures(), 2);
	}

	private static void registerWorldGen(IWorldGenerator iGenerator, int weightProbability)
	{
		GameRegistry.registerWorldGenerator(iGenerator, weightProbability);
	}
}