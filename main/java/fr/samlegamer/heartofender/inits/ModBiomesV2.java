package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomesV2
{
    public static final RegistryKey<Biome> DARK_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(HeartofEnder.MODID, "heartofender_wastes"));
    
}