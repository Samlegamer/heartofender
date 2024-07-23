package fr.samlegamer.heartofender.particle;

import java.util.function.Supplier;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeParticleRegistry
{
	public static final DeferredRegister<ParticleType<?>> REGISTRY_PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, HeartofEnder.MODID);

	public static final Supplier<SimpleParticleType> GREEN_FLAME = REGISTRY_PARTICLES.register("green_flame", () -> new SimpleParticleType(true));
	public static final Supplier<SimpleParticleType> GREEN_LAVA = REGISTRY_PARTICLES.register("green_lava", () -> new SimpleParticleType(true));
}