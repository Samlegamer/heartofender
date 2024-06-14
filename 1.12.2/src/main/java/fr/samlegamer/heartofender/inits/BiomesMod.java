package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.world.biome.DarkBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(References.MODID)
public class BiomesMod
{
	public static final Biome BIOME_DARK = new DarkBiome();
	
	@Mod.EventBusSubscriber(modid = References.MODID)
	public static class Register {
		
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event)
		{
			final Biome[] biomes =
				{
					BIOME_DARK
			};
			
			event.getRegistry().registerAll(biomes);
			
			spawnBiomes();
		}
		
		private static void spawnBiomes() {}
	}
}