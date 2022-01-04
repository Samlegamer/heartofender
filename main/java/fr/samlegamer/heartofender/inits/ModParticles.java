package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles
{
	//Thanks Mr-Pineapple for the Tutorial 1.15
	public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HeartofEnder.MODID);

	public static final RegistryObject<BasicParticleType> GREEN_FLAME = PARTICLE_REGISTRY.register("green_flame", () -> new BasicParticleType(true));
	public static final RegistryObject<BasicParticleType> GREEN_LAVA = PARTICLE_REGISTRY.register("green_lava", () -> new BasicParticleType(true));
}