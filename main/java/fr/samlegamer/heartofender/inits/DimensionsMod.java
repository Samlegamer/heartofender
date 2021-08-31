package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.utils.config.HoeConfig;
import fr.samlegamer.heartofender.world.worldgen.WorldProviderHeartofEnder;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class DimensionsMod
{
	public static final DimensionType HEART_OF_ENDER = DimensionType.register("HeartofEnder", "_heartofender", HoeConfig.heartofenderDimID, WorldProviderHeartofEnder.class, false);

	public static void init()
	{
		DimensionManager.registerDimension(HoeConfig.heartofenderDimID, HEART_OF_ENDER);
	}
}