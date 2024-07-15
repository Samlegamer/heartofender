package fr.samlegamer.heartofender.features;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.block.HoeBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig;
import net.minecraft.world.gen.feature.TwistingVinesFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class HoeFeatures
{
	public static final Feature<DefaultFeatureConfig> PURPLE_GLOWSTONE_BLOB = new PurpleGlowstoneBlobFeature(DefaultFeatureConfig.CODEC);

    public static final Feature<NetherForestVegetationFeatureConfig> HOE_FOREST_VEGETATION = new HoeForestVegetationFeature(NetherForestVegetationFeatureConfig.VEGETATION_CODEC);
    public static final Feature<TwistingVinesFeatureConfig> HOE_TWISTING_VINES = new HoeTwistingVinesFeature(TwistingVinesFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> HOE_WEEPING_VINES = new HoeWeepingVinesFeature(DefaultFeatureConfig.CODEC);

	public static void registry()
	{
    	Registry.register(Registry.FEATURE, new Identifier(HeartofEnder.MODID, "purple_glowstone_blob"), PURPLE_GLOWSTONE_BLOB);
    	Registry.register(Registry.FEATURE, new Identifier(HeartofEnder.MODID, "hoe_twisting_vines"), HOE_TWISTING_VINES);
    	Registry.register(Registry.FEATURE, new Identifier(HeartofEnder.MODID, "hoe_weeping_vines"), HOE_WEEPING_VINES);

	}
	//minecraft:nether_forest_vegetation
	public static class Dimension
	{
		public static final WeightedBlockStateProvider LILAC_FOREST_VEGETATION_PROVIDER = new WeightedBlockStateProvider(DataPool.<BlockState>builder()
				.add(HoeBlocks.LILAC_ROOTS.getDefaultState(), 87)
				.add(HoeBlocks.LILAC_FUNGUS.getDefaultState(), 11)
				.add(HoeBlocks.LEAFY_FUNGUS.getDefaultState(), 1));
	    public static final WeightedBlockStateProvider LEAFY_FOREST_VEGETATION_PROVIDER = new WeightedBlockStateProvider(DataPool.<BlockState>builder()
	    		.add(HoeBlocks.LEAFY_ROOTS.getDefaultState(), 85)
	    		.add(HoeBlocks.LILAC_ROOTS.getDefaultState(), 1)
	    		.add(HoeBlocks.LEAFY_FUNGUS.getDefaultState(), 13)
	    		.add(HoeBlocks.LILAC_FUNGUS.getDefaultState(), 1));
		
	    public static final ConfiguredFeature<?, ?> LILAC_FOREST_VEGETATION_BONEMEAL = new ConfiguredFeature(HoeFeatures.HOE_FOREST_VEGETATION, new NetherForestVegetationFeatureConfig(LILAC_FOREST_VEGETATION_PROVIDER, 3, 1));
	    public static final ConfiguredFeature<?, ?> LEAFY_FOREST_VEGETATION_BONEMEAL = new ConfiguredFeature(HoeFeatures.HOE_FOREST_VEGETATION, new NetherForestVegetationFeatureConfig(LEAFY_FOREST_VEGETATION_PROVIDER, 3, 1));
	    public static final ConfiguredFeature<?, ?> HOE_SPROUTS_BONEMEAL = new ConfiguredFeature(HoeFeatures.HOE_FOREST_VEGETATION, new NetherForestVegetationFeatureConfig(BlockStateProvider.of(HoeBlocks.HEART_OF_ENDER_SPROUTS), 3, 1));
	    public static final ConfiguredFeature<?, ?> HOE_TWISTING_VINES_BONEMEAL = new ConfiguredFeature(HoeFeatures.HOE_TWISTING_VINES, new TwistingVinesFeatureConfig(3, 1, 2));
	}
	
	public static class Tree
	{
	    public static final ConfiguredFeature<HugeFungusFeatureConfig, ?> LILAC_FUNGUS_PLANTED = new ConfiguredFeature(Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(HoeBlocks.LILAC_NYLIUM.getDefaultState(), HoeBlocks.LILAC_STEM.getDefaultState(), HoeBlocks.LILAC_WART_BLOCK.getDefaultState(), HoeBlocks.SOUL_SHROOMLIGHT.getDefaultState(), true));
	    public static final ConfiguredFeature<HugeFungusFeatureConfig, ?> LEAFY_FUNGUS_PLANTED = new ConfiguredFeature(Feature.HUGE_FUNGUS, new HugeFungusFeatureConfig(HoeBlocks.LEAFY_NYLIUM.getDefaultState(), HoeBlocks.LEAFY_STEM.getDefaultState(), HoeBlocks.LEAFY_WART_BLOCK.getDefaultState(), HoeBlocks.LILAC_SHROOMLIGHT.getDefaultState(), true));
	}
}