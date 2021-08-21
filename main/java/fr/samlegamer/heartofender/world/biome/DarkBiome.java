package fr.samlegamer.heartofender.world.biome;

import fr.samlegamer.heartofender.inits.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class DarkBiome 
{	
	//Inspired The Legends of Herobrine Mod
	
    private static int getSkyColorWithTemperatureModifier(float temperature)
    {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    private static Biome DarkBiomeBuilder(float depth, float scale, MobSpawnInfo.Builder mobSpawnBuilder) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(DarkBiomeSurfaceBuilder.DARK_BIOME_BUILDER);
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addOceanCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addForestFlowers(biomegenerationsettings$builder);
        /*
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDefaultFlowers(biomegenerationsettings$builder);
        */
        DefaultBiomeFeatures.addForestGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addMushroomFieldVegetation(biomegenerationsettings$builder);
        /*
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withExtraGoldOre(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withTreesInWater(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withEmeraldOre(biomegenerationsettings$builder);
        */
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST).depth(depth).scale(scale).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).foliageColorOverride(0x9EA94D).grassColorOverride(0x90A94D).skyColor(getSkyColorWithTemperatureModifier(0.7F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobSpawnBuilder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    private static MobSpawnInfo.Builder getStandardMobSpawnBuilder() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
        return mobspawninfo$builder;
    }

    public static Biome CREATE(float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = getStandardMobSpawnBuilder()
        .addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntities.ENDER_KID, 5, 4, 4))
        .setPlayerCanSpawn();
        return DarkBiomeBuilder(depth, scale, mobspawninfo$builder);
    }
}