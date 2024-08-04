package fr.samlegamer.heartofender.data.worldgen;

import java.util.List;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.world.HoeOreGenerator;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class HoePlacedFeatures
{
    public static ResourceKey<PlacedFeature> AZURIUM_ORE = createKey("azurium_ore");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> holder =
                configuredFeatures.getOrThrow(HoeConfiguredFeatures.OVERWORLD_AZURIUM_ORE);

        register(context, AZURIUM_ORE, holder, HoeOreGenerator.commonOrePlacement(HoeConfigsRegistry.SERVER.AzuriumOreChance.get(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(HoeConfigsRegistry.SERVER.YmaxAzuriumOre.get()))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
        context.register(key, new PlacedFeature(feature, placementModifiers));
    }
}