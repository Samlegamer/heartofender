package fr.samlegamer.heartofender.particle;

import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

//@EventBusSubscriber(modid = HeartofEnder.MODID, bus = Bus.MOD)
public class HoeRendersParticles
{
	//@SubscribeEvent(priority = EventPriority.HIGH)
	@OnlyIn(Dist.CLIENT)
	public static void registerParticles(RegisterParticleProvidersEvent event)
	{
		event.registerSpriteSet(HoeParticleRegistry.GREEN_FLAME.get(), FlameParticle.Provider::new);
		event.registerSpriteSet(HoeParticleRegistry.GREEN_LAVA.get(), LavaParticle.Provider::new);
	}
}