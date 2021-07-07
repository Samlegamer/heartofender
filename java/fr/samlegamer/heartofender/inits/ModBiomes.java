package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes
{
	public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, HeartofEnder.MODID);
}