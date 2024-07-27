package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeFeatures
{
	public static final DeferredRegister<ConfiguredFeature<?, ?>> REGISTRY_CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, HeartofEnder.MODID);

	public static final WeightedStateProvider LILAC_VEGETATION_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
	.add(HoeBlocksRegistry.LILAC_ROOTS.get().defaultBlockState(), 87)
	/*.add(HoeBlocksRegistry.LILAC_FUNGUS.get().defaultBlockState(), 11)
	.add(HoeBlocksRegistry.LEAFY_FUNGUS.get().defaultBlockState(), 1)*/);
	public static final WeightedStateProvider LEAFY_VEGETATION_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
	.add(HoeBlocksRegistry.LEAFY_ROOTS.get().defaultBlockState(), 85)
	.add(HoeBlocksRegistry.LILAC_ROOTS.get().defaultBlockState(), 1)
	/*.add(HoeBlocksRegistry.LEAFY_FUNGUS.get().defaultBlockState(), 13)
	.add(HoeBlocksRegistry.LILAC_FUNGUS.get().defaultBlockState(), 1))*/);
   // public static final ResourceKey<ConfiguredFeature<?, ?>> LILAC_FOREST_VEGETATION_BONEMEAL = REGISTRY_CONFIGURED_FEATURES.register("lilac_forest_vegetation_bonemeal", () -> new NetherForestVegetationConfig(LILAC_VEGETATION_PROVIDER, 3, 1));
    		//FeatureUtils.createKey("");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAFY_FOREST_VEGETATION_BONEMEAL = FeatureUtils.createKey("leafy_forest_vegetation_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOE_SPROUTS_BONEMEAL = FeatureUtils.createKey("hoe_sprouts_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOE_TWISTING_VINES_BONEMEAL = FeatureUtils.createKey("hoe_twisting_vines_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LILAC_FUNGUS = FeatureUtils.createKey("lilac_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LILAC_FUNGUS_PLANTED = FeatureUtils.createKey("lilac_fungus_planted");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAFY_FUNGUS = FeatureUtils.createKey("leafy_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAFY_FUNGUS_PLANTED = FeatureUtils.createKey("leafy_fungus_planted");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
    	//FeatureUtils.register(pContext, LILAC_FOREST_VEGETATION_BONEMEAL, HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), );
    	FeatureUtils.register(pContext, LEAFY_FOREST_VEGETATION_BONEMEAL, HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), new NetherForestVegetationConfig(LEAFY_VEGETATION_PROVIDER, 3, 1));
    	FeatureUtils.register(pContext, HOE_SPROUTS_BONEMEAL, HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), new NetherForestVegetationConfig(BlockStateProvider.simple(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get()), 3, 1));
    	FeatureUtils.register(pContext, HOE_TWISTING_VINES_BONEMEAL, HoeFeaturesRegistry.HOE_TWISTING_VINES.get(), new TwistingVinesConfig(3, 1, 2));
    	FeatureUtils.register(pContext, LILAC_FUNGUS, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), null, false));
    	FeatureUtils.register(pContext, LILAC_FUNGUS_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), null, true));
    	FeatureUtils.register(pContext, LEAFY_FUNGUS, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), null, false));
    	FeatureUtils.register(pContext, LEAFY_FUNGUS_PLANTED, Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), null, true));
    }
}