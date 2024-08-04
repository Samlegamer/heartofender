package fr.samlegamer.heartofender.data.worldgen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class HoeWorldGenProvider extends DatapackBuiltinEntriesProvider
{
    public HoeWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, new RegistrySetBuilder()
        		.add(Registries.CONFIGURED_FEATURE, HoeConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, HoePlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, HoeBiomesModifier::bootstrap),
                Set.of(HeartofEnder.MODID));
    }
}