package fr.samlegamer.heartofender.world.biome;

import fr.samlegamer.heartofender.inits.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;

public class DarkBiome
{
	//Inspired The Legends of Herobrine Mod
	
    private static int getSkyColorWithTemperatureModifier(float temperature)
    {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    private static Biome DarkBiomeBuilder(float depth, float scale, MobSpawnInfo.Builder mobSpawnBuilder)
    {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(DarkBiomeSurfaceBuilder.DARK_BIOME_BUILDER);
        
        /*
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDefaultFlowers(biomegenerationsettings$builder);
        */
        /*
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withExtraGoldOre(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withTreesInWater(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withEmeraldOre(biomegenerationsettings$builder);
        */
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.NETHER).depth(depth).scale(scale).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).foliageColorOverride(0x9EA94D).grassColorOverride(0x90A94D).skyColor(getSkyColorWithTemperatureModifier(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobSpawnBuilder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    private static MobSpawnInfo.Builder getStandardMobSpawnBuilder() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        return mobspawninfo$builder;
    }

    public static Biome CREATE(float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = getStandardMobSpawnBuilder()
        .addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.ENDER_KID, 5, 4, 4))
        .addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.HEART_GHAST, 2, 1, 1))
        .addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.BLUE_MAGMA_CUBE, 4, 1, 1))
        .setPlayerCanSpawn();
        return DarkBiomeBuilder(depth, scale, mobspawninfo$builder);
    }
}