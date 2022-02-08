package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeFeaturesRegistry
{
	public static final DeferredRegister<Feature<?>> REGISTRY_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HeartofEnder.MODID);

	public static final RegistryObject<PurpleGlowstoneBlobFeature> PURPLE_GLOWSTONE_BLOB = REGISTRY_FEATURES.register("purple_glowstone_blob", () -> new PurpleGlowstoneBlobFeature(NoneFeatureConfiguration.CODEC));

}