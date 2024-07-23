package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeFeaturesRegistry
{
	public static final DeferredRegister<Feature<?>> REGISTRY_FEATURES = DeferredRegister.create(Registries.FEATURE, HeartofEnder.MODID);

	public static final DeferredHolder<Feature<?>, PurpleGlowstoneBlobFeature> PURPLE_GLOWSTONE_BLOB = REGISTRY_FEATURES.register("purple_glowstone_blob", () -> new PurpleGlowstoneBlobFeature(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, HoeForestVegetationFeature> HOE_FOREST_VEGETATION = REGISTRY_FEATURES.register("hoe_forest_vegetation", () -> new HoeForestVegetationFeature(NetherForestVegetationConfig.CODEC));
	public static final DeferredHolder<Feature<?>, HoeTwistingVinesFeature> HOE_TWISTING_VINES = REGISTRY_FEATURES.register("hoe_twisting_vines", () -> new HoeTwistingVinesFeature(TwistingVinesConfig.CODEC));
	public static final DeferredHolder<Feature<?>, HoeWeepingVinesFeature> HOE_WEEPING_VINES = REGISTRY_FEATURES.register("hoe_weeping_vines", () -> new HoeWeepingVinesFeature(NoneFeatureConfiguration.CODEC));

}