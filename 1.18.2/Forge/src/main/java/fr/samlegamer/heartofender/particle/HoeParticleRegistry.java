package fr.samlegamer.heartofender.particle;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeParticleRegistry
{
	public static final DeferredRegister<ParticleType<?>> REGISTRY_PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HeartofEnder.MODID);

	public static final RegistryObject<SimpleParticleType> GREEN_FLAME = REGISTRY_PARTICLES.register("green_flame", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GREEN_LAVA = REGISTRY_PARTICLES.register("green_lava", () -> new SimpleParticleType(true));
}