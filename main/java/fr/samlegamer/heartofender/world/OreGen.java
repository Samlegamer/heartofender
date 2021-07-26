package fr.samlegamer.heartofender.world;

public class OreGen
{/*
	public ConfiguredFeature<?, ?> ORE_AZURIUM_FEATURE;

    public void init()
    {
        ORE_AZURIUM_FEATURE = register("ore_azurium", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
        HoEBlockRegistry.AZURIUM_ORE.get().defaultBlockState(), 5))
        .squared()
        .range(10)
        .count(6)
        .countRandom(5) 
        );
    }

    public <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature)
    {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e)
    {
        BiomeGenerationSettingsBuilder generation = e.getGeneration();
        if(e.getCategory() != Biome.Category.NETHER)
        {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_AZURIUM_FEATURE);
        }
    } */
}