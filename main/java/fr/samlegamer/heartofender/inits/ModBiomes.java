package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.world.biome.DarkBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes
{
    private static final RegistryKey<Biome> DARK_BIOME = RegistryKey.create(Registry.BIOME_REGISTRY, HeartofEnder.location("dark"));
    
    public static void registerBiomes()
    {
        ForgeRegistries.BIOMES.register(DarkBiome.CREATE(0.1F, 0.2F).setRegistryName(HeartofEnder.MODID, "dark"));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(DARK_BIOME, 30));
        BiomeDictionary.addTypes(DARK_BIOME, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE);
    }
}