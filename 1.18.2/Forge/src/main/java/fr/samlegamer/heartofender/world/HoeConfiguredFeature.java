package fr.samlegamer.heartofender.world;

import java.util.List;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HoeConfiguredFeature
{
	/*
	 * Thanks TurtyWurty for Ore Gen Tutorial
	 */
	public static final DeferredRegister<ConfiguredFeature<?, ?>> REGISTRY_CONFIGURED_FEATURE = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, HeartofEnder.MODID);
	
    private static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_REPLACING = Suppliers.memoize(() ->
    List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, HoeBlocksRegistry.AZURIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_RPLST = REGISTRY_CONFIGURED_FEATURE.register("azurium_ore_rplc",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_REPLACING.get(), HoeConfigsRegistry.SERVER.AzuriumOreMax.get())));
}