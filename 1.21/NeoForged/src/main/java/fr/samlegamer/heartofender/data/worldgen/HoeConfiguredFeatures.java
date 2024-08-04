package fr.samlegamer.heartofender.data.worldgen;

import java.util.List;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class HoeConfiguredFeatures
{
    protected static ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AZURIUM_ORE = createKey("overworld_azurium_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> examplOre = List.of(OreConfiguration.target(stoneReplacable, HoeBlocksRegistry.AZURIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplacable, HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_AZURIUM_ORE, Feature.ORE, new OreConfiguration(examplOre, HoeConfigsRegistry.SERVER.AzuriumOreMax.get()));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, name));
    }

    private static  <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}