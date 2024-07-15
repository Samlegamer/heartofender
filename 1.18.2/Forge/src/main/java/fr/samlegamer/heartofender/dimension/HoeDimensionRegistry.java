package fr.samlegamer.heartofender.dimension;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class HoeDimensionRegistry
{
	/*
	 * Thanks Modding by Kaupenjoe for this updated Tutorial :)
	 * youtu.be/l5-MgePztOs
	 * 
	 * github:
	 * github.com/Tutorials-By-Kaupenjoe/Forge-Tutorial-1.18.1/blob/65-dimension/src/main/java/net/kaupenjoe/tutorialmod/world/dimension/ModDimensions.java
	 */
	public static final ResourceKey<Level> HEART_OF_ENDER = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(HeartofEnder.MODID, "heartofender"));
    public static final ResourceKey<DimensionType> HEART_OF_ENDER_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(HeartofEnder.MODID, "heartofender"));

	
    public static void register()
    {
        HeartofEnder.msg("HoeDimensionRegistry is Charged !");
    }

	public static ResourceKey<Level> HoeKey()
	{
		return HEART_OF_ENDER;
	}
}