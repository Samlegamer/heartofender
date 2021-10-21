package fr.samlegamer.heartofender.world.biomes.types;

import fr.samlegamer.heartofender.inits.BiomesMod;
import fr.samlegamer.heartofender.world.biomes.DarkBiome;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class WorldTypeDarkBiome extends WorldType
{
	public WorldTypeDarkBiome() 
	{
		super("Dark");
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) 
	{
		BiomeProvider provider = new BiomeProviderSingle(BiomesMod.BIOME_DARK);
		return provider;
	}
}