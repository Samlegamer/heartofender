package fr.samlegamer.heartofender.world;

import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OreGen
{
	public static ConfiguredFeature<?, ?> ORE_AZURIUM_FEATURE;

    public void init()
    {
    	if(HoeConfig.generateAzuriumOre)
    	{
            ORE_AZURIUM_FEATURE = register("ore_azurium", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.AZURIUM_ORE.get().defaultBlockState(), HoeConfig.AzuriumOreMax))
                    .squared()
                    .range(HoeConfig.YmaxAzuriumOre)
                    .count(HoeConfig.YminAzuriumOre)
                    .countRandom(HoeConfig.AzuriumOreChance)
                    );
    	}
    }

    public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature)
    {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }
    
    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e)
    {
        BiomeGenerationSettingsBuilder generation = e.getGeneration();
        if(e.getCategory() != Biome.Category.NETHER && HoeConfig.generateAzuriumOre)
        {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_AZURIUM_FEATURE);
        }
    }
}