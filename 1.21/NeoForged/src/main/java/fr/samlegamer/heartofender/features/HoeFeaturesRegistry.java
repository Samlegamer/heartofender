package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeFeaturesRegistry
{
	public static final DeferredRegister<Feature<?>> REGISTRY_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HeartofEnder.MODID);

	public static final RegistryObject<PurpleGlowstoneBlobFeature> PURPLE_GLOWSTONE_BLOB = REGISTRY_FEATURES.register("purple_glowstone_blob", () -> new PurpleGlowstoneBlobFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<HoeForestVegetationFeature> HOE_FOREST_VEGETATION = REGISTRY_FEATURES.register("hoe_forest_vegetation", () -> new HoeForestVegetationFeature(NetherForestVegetationConfig.CODEC));
	public static final RegistryObject<HoeTwistingVinesFeature> HOE_TWISTING_VINES = REGISTRY_FEATURES.register("hoe_twisting_vines", () -> new HoeTwistingVinesFeature(TwistingVinesConfig.CODEC));
	public static final RegistryObject<HoeWeepingVinesFeature> HOE_WEEPING_VINES = REGISTRY_FEATURES.register("hoe_weeping_vines", () -> new HoeWeepingVinesFeature(NoneFeatureConfiguration.CODEC));

}