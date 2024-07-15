package fr.samlegamer.heartofender.features.hoe;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.features.HoeFeaturesRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class HoeFeatures
{
	public static final WeightedStateProvider LILAC_VEGETATION_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
	.add(HoeBlocksRegistry.LILAC_ROOTS.get().defaultBlockState(), 87)
	.add(HoeBlocksRegistry.LILAC_FUNGUS.get().defaultBlockState(), 11)
	.add(HoeBlocksRegistry.LEAFY_FUNGUS.get().defaultBlockState(), 1));
	public static final WeightedStateProvider LEAFY_VEGETATION_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
	.add(HoeBlocksRegistry.LEAFY_ROOTS.get().defaultBlockState(), 85)
	.add(HoeBlocksRegistry.LILAC_ROOTS.get().defaultBlockState(), 1)
	.add(HoeBlocksRegistry.LEAFY_FUNGUS.get().defaultBlockState(), 13)
	.add(HoeBlocksRegistry.LILAC_FUNGUS.get().defaultBlockState(), 1));

	public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> LILAC_FOREST_VEGETATION_BONEMEAL = FeatureUtils.register("lilac_forest_vegetation_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), new NetherForestVegetationConfig(LILAC_VEGETATION_PROVIDER, 3, 1));
	public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> LEAFY_FOREST_VEGETATION_BONEMEAL = FeatureUtils.register("leafy_forest_vegetation_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), new NetherForestVegetationConfig(LEAFY_VEGETATION_PROVIDER, 3, 1));
	public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> HOE_SPROUTS_BONEMEAL = FeatureUtils.register("hoe_sprouts_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get(), new NetherForestVegetationConfig(BlockStateProvider.simple(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get()), 3, 1));
	public static final Holder<ConfiguredFeature<TwistingVinesConfig, ?>> HOE_TWISTING_VINES_BONEMEAL = FeatureUtils.register("hoe_twisting_vines_bonemeal", HoeFeaturesRegistry.HOE_TWISTING_VINES.get(), new TwistingVinesConfig(3, 1, 2));

	public static final Holder<ConfiguredFeature<HugeFungusConfiguration, ?>> LILAC_FUNGUS = FeatureUtils.register("lilac_fungus", Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), false));
	public static final Holder<ConfiguredFeature<HugeFungusConfiguration, ?>> LILAC_FUNGUS_PLANTED = FeatureUtils.register("lilac_fungus_planted", Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), true));
	public static final Holder<ConfiguredFeature<HugeFungusConfiguration, ?>> LEAFY_FUNGUS = FeatureUtils.register("leafy_fungus", Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), false));
	public static final Holder<ConfiguredFeature<HugeFungusConfiguration, ?>> LEAFY_FUNGUS_PLANTED = FeatureUtils.register("leafy_fungus_planted", Feature.HUGE_FUNGUS, new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), true));
}