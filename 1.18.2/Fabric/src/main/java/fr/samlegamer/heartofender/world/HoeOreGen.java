package fr.samlegamer.heartofender.world;

import java.util.Arrays;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.block.HoeBlocks;
import fr.samlegamer.heartofender.cfg.HoeConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class HoeOreGen
{
	private static ConfiguredFeature<?, ?> AZU_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
		      (Feature.ORE, new OreFeatureConfig(
		          OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
		          HoeBlocks.AZURIUM_ORE.getDefaultState(),
		          HoeConfig.AzuriumOreMax)); // vein size
		 
		  public static PlacedFeature AZU_ORE_PLACED_FEATURE = new PlacedFeature(
		      RegistryEntry.of(AZU_ORE_CONFIGURED_FEATURE),
		      Arrays.asList(
		          CountPlacementModifier.of(HoeConfig.AzuriumOreChance), // number of veins per chunk
		          SquarePlacementModifier.of(), // spreading horizontally
		          HeightRangePlacementModifier.uniform(YOffset.fixed(15), YOffset.fixed(HoeConfig.YmaxAzuriumOre))
		      )); // height

		  private static ConfiguredFeature<?, ?> DEEP_AZU_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
			      (Feature.ORE, new OreFeatureConfig(
			          OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
			          HoeBlocks.DEEPSLATE_AZURIUM_ORE.getDefaultState(),
			          HoeConfig.AzuriumOreMax)); // vein size
			 
			  public static PlacedFeature DEEP_AZU_ORE_PLACED_FEATURE = new PlacedFeature(
			      RegistryEntry.of(DEEP_AZU_ORE_CONFIGURED_FEATURE),
			      Arrays.asList(
			          CountPlacementModifier.of(HoeConfig.AzuriumOreChance), // number of veins per chunk
			          SquarePlacementModifier.of(), // spreading horizontally
			          HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(16))
			      )); // height
			  
	public static void InitOres()
	{
	    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
	            new Identifier(HeartofEnder.MODID, "azurium_gen"), AZU_ORE_CONFIGURED_FEATURE);
	        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(HeartofEnder.MODID, "azurium_gen"),
	            AZU_ORE_PLACED_FEATURE);
	        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_ORES,
	            RegistryKey.of(Registry.PLACED_FEATURE_KEY,
	                new Identifier(HeartofEnder.MODID, "azurium_gen")));
	        
		    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
		            new Identifier(HeartofEnder.MODID, "deep_azurium_gen"), DEEP_AZU_ORE_CONFIGURED_FEATURE);
		        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(HeartofEnder.MODID, "deep_azurium_gen"),
		        		DEEP_AZU_ORE_PLACED_FEATURE);
		        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_ORES,
		            RegistryKey.of(Registry.PLACED_FEATURE_KEY,
		                new Identifier(HeartofEnder.MODID, "deep_azurium_gen")));
	}
}