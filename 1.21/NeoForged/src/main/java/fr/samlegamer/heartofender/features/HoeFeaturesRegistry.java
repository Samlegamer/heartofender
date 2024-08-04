package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.world.HoeOreGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeFeaturesRegistry
{
	public static final DeferredRegister<Feature<?>> REGISTRY_FEATURES = DeferredRegister.create(Registries.FEATURE, HeartofEnder.MODID);
	//public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, HeartofEnder.MODID);
	//public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, HeartofEnder.MODID);

	//public static final DeferredHolder<ConfiguredFeature<?, ?>, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>> AZURIUM_ORE_CONFIG = CONFIGURED_FEATURES.register("azurium_ore_config", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(HoeOreGenerator.target_azu, 4)));

	//public static final DeferredHolder<PlacedFeature, PlacedFeature> AZURIUM_ORE_PLACED = PLACED_FEATURES.register("azurium_ore_placed", () -> new PlacedFeature(AZURIUM_ORE_CONFIG, HoeOreGenerator.commonOrePlacement(HoeConfigsRegistry.SERVER.AzuriumOreChance.get(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(HoeConfigsRegistry.SERVER.YmaxAzuriumOre.get())))));

	public static final DeferredHolder<Feature<?>, PurpleGlowstoneBlobFeature> PURPLE_GLOWSTONE_BLOB = REGISTRY_FEATURES.register("purple_glowstone_blob", () -> new PurpleGlowstoneBlobFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, HoeForestVegetationFeature> HOE_FOREST_VEGETATION = REGISTRY_FEATURES.register("hoe_forest_vegetation", () -> new HoeForestVegetationFeature(NetherForestVegetationConfig.CODEC));
	public static final DeferredHolder<Feature<?>, HoeTwistingVinesFeature> HOE_TWISTING_VINES = REGISTRY_FEATURES.register("hoe_twisting_vines", () -> new HoeTwistingVinesFeature(TwistingVinesConfig.CODEC));
	public static final DeferredHolder<Feature<?>, HoeWeepingVinesFeature> HOE_WEEPING_VINES = REGISTRY_FEATURES.register("hoe_weeping_vines", () -> new HoeWeepingVinesFeature(NoneFeatureConfiguration.CODEC));

}