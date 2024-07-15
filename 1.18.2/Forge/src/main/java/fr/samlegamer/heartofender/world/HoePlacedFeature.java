package fr.samlegamer.heartofender.world;

import java.util.List;

import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HoePlacedFeature
{
	public static final DeferredRegister<PlacedFeature> REGISTRY_PLACED_FEATURE = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, HeartofEnder.MODID);

    public static final RegistryObject<PlacedFeature> OVERWORLD_AZURIUM = REGISTRY_PLACED_FEATURE.register("azurium_ore",
            () -> new PlacedFeature(HoeConfiguredFeature.OVERWORLD_RPLST.getHolder().get(),
                    commonOrePlacement(HoeConfigsRegistry.SERVER.AzuriumOreChance.get(), HeightRangePlacement.triangle(
                    		VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(HoeConfigsRegistry.SERVER.YmaxAzuriumOre.get())
                    ))));

	private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}