package fr.samlegamer.heartofender.world;

import java.util.ArrayList;
import java.util.List;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class HoeOreGenerator
{
	/*
	 * Thanks TurtyWurty for Ore Gen Tutorial
	 */
    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
    public static final List<PlacedFeature> END_ORES = new ArrayList<>();
    public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();

    public static final List<OreConfiguration.TargetBlockState>  target_azu = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
            HoeBlocksRegistry.AZURIUM_ORE.get().defaultBlockState()),
    OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
            HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get().defaultBlockState()));
    
    public static void registerOres()
    {
    	
    	/*
        final ConfiguredFeature<?, ?> AzuriumOre = Feature.ORE
                .place(new OreConfiguration(,
                		HoeConfigsRegistry.SERVER.AzuriumOreMax.get()));
                        
        if(HoeConfigsRegistry.SERVER.generateAzuriumOre.get())
        {
            final PlacedFeature placedAzuriumOre = PlacementUtils.register("azurium_ore",
            		AzuriumOre.placed(
        }*/
    }
    
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
     }

     public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
     }

     private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
     }
}