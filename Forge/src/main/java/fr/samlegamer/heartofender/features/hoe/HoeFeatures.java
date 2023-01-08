package fr.samlegamer.heartofender.features.hoe;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.features.HoeFeaturesRegistry;
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

	public static final ConfiguredFeature<?, ?> LILAC_FOREST_VEGETATION_BONEMEAL = FeatureUtils.register("lilac_forest_vegetation_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get().configured(new NetherForestVegetationConfig(LILAC_VEGETATION_PROVIDER, 3, 1)));
	public static final ConfiguredFeature<?, ?> LEAFY_FOREST_VEGETATION_BONEMEAL = FeatureUtils.register("leafy_forest_vegetation_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get().configured(new NetherForestVegetationConfig(LEAFY_VEGETATION_PROVIDER, 3, 1)));
	public static final ConfiguredFeature<?, ?> HOE_SPROUTS_BONEMEAL = FeatureUtils.register("hoe_sprouts_bonemeal", HoeFeaturesRegistry.HOE_FOREST_VEGETATION.get().configured(new NetherForestVegetationConfig(BlockStateProvider.simple(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get()), 3, 1)));
	public static final ConfiguredFeature<?, ?> HOE_TWISTING_VINES_BONEMEAL = FeatureUtils.register("hoe_twisting_vines_bonemeal", HoeFeaturesRegistry.HOE_TWISTING_VINES.get().configured(new TwistingVinesConfig(3, 1, 2)));

	public static class Tree
	{
		   public static final ConfiguredFeature<HugeFungusConfiguration, ?> LILAC_FUNGUS = FeatureUtils.register("lilac_fungus", Feature.HUGE_FUNGUS.configured(new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), false)));
		   public static final ConfiguredFeature<HugeFungusConfiguration, ?> LILAC_FUNGUS_PLANTED = FeatureUtils.register("lilac_fungus_planted", Feature.HUGE_FUNGUS.configured(new HugeFungusConfiguration(HoeBlocksRegistry.LILAC_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState(), HoeBlocksRegistry.LILAC_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.SOUL_SHROOMLIGHT.get().defaultBlockState(), true)));
		   public static final ConfiguredFeature<HugeFungusConfiguration, ?> LEAFY_FUNGUS = FeatureUtils.register("leafy_fungus", Feature.HUGE_FUNGUS.configured(new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), false)));
		   public static final ConfiguredFeature<HugeFungusConfiguration, ?> LEAFY_FUNGUS_PLANTED = FeatureUtils.register("leafy_fungus_planted", Feature.HUGE_FUNGUS.configured(new HugeFungusConfiguration(HoeBlocksRegistry.LEAFY_NYLIUM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_STEM.get().defaultBlockState(), HoeBlocksRegistry.LEAFY_WART_BLOCK.get().defaultBlockState(), HoeBlocksRegistry.LILAC_SHROOMLIGHT.get().defaultBlockState(), true)));
	}
	/*
	public static ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_LILAC_ROOTS;
	public static ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_PURPLE_FIRE;

	public static void init()
	{
		PATCH_LILAC_ROOTS = FeatureUtils.register("patch_lilac_roots", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.CRIMSON_ROOTS))))));
		PATCH_PURPLE_FIRE = FeatureUtils.register("patch_purple_fire", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SOUL_FIRE))), List.of(Blocks.SOUL_SOIL))));
	}*/
}