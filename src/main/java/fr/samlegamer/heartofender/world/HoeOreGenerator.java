package fr.samlegamer.heartofender.world;

import java.util.ArrayList;
import java.util.List;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class HoeOreGenerator
{
	/*
	 * Thanks TurtyWurty for Ore Gen Tutorial
	 */
    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
    public static final List<PlacedFeature> END_ORES = new ArrayList<>();
    public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();

    public static void registerOres()
    {
        final ConfiguredFeature<?, ?> AzuriumOre = Feature.ORE
                .configured(new OreConfiguration(List.of(
                        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
                                HoeBlocksRegistry.AZURIUM_ORE.get().defaultBlockState()),
                        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                                HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get().defaultBlockState())),
                		HoeConfigsRegistry.SERVER.AzuriumOreMax.get()));
                        
        if(HoeConfigsRegistry.SERVER.generateAzuriumOre.get())
        {
            final PlacedFeature placedAzuriumOre = PlacementUtils.register("azurium_ore",
            		AzuriumOre.placed(commonOrePlacement(HoeConfigsRegistry.SERVER.AzuriumOreChance.get(), HeightRangePlacement
                            .uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(HoeConfigsRegistry.SERVER.YmaxAzuriumOre.get())))));
            OVERWORLD_ORES.add(placedAzuriumOre);
        }
    }
    
    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
     }

     private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
     }

     private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
     }
}