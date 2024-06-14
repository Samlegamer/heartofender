package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.feature.PurpleGlowstoneBlobFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES_REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, HeartofEnder.MODID);

	public static final RegistryObject<Feature<NoFeatureConfig>> PURPLE_GLOWSTONE_BLOB = FEATURES_REGISTRY.register("purple_glowstone_blob", () -> new PurpleGlowstoneBlobFeature(NoFeatureConfig.CODEC));
}