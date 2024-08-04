package fr.samlegamer.heartofender.data.worldgen;

import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class HoeBiomesModifier
{
    protected static ResourceKey<BiomeModifier> ADD_AZURIUM_ORE = createKey("add_azurium_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        if(HoeConfigsRegistry.SERVER.generateAzuriumOre.get())
        {

        context.register(
        		ADD_AZURIUM_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(HoePlacedFeatures.AZURIUM_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        }
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, name));
    }

}
