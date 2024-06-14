package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimension
{
	public static final RegistryKey<World> HEART_OF_ENDER = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(HeartofEnder.MODID, "heartofender"));

	public static RegistryKey<World> HoeKey()
	{
		return HEART_OF_ENDER;
	}
}