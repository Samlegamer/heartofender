package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.world.worldgen.WorldProviderHeartofEnder;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class DimensionsMod
{
	public static final DimensionType HEART_OF_ENDER = DimensionType.register("HeartofEnder", "_heartofender", 2, WorldProviderHeartofEnder.class, false);

	public static void init()
	{
		DimensionManager.registerDimension(2, HEART_OF_ENDER);
	}
}