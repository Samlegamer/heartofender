package fr.samlegamer.heartofender.world.biome;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DarkBiomeSurfaceBuilder
{
    public static final SurfaceBuilderConfig DARK_BIOME_SURFACE = new SurfaceBuilderConfig(ModBlocks.DARK_END_STONE.get().defaultBlockState(), ModBlocks.DARK_END_STONE.get().defaultBlockState(), ModBlocks.DARK_END_STONE.get().defaultBlockState());

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DARK_BIOME_BUILDER = register("dark", SurfaceBuilder.NETHER.configured(DARK_BIOME_SURFACE));

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(HeartofEnder.MODID, name), configuredSurfaceBuilder);
    }
}