package fr.samlegamer.heartofender.dimension;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class HoeDimensionRegistry
{
	public static final ResourceKey<Registry<Level>> HEART_OF_ENDER = ResourceKey.create(Registries.DIMENSION.registryKey(), ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "heartofender"));
	//public static final ResourceKey<DimensionType> HOE_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(HeartofEnder.MODID, "heartofender_type"));
	
	public static ResourceKey<Registry<Level>> HoeKey()
	{
		return HEART_OF_ENDER;
	}
}