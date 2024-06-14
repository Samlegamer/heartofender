package fr.samlegamer.heartofender.particle;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Bus.MOD)
public class HoeRendersParticles
{
	@SuppressWarnings("resource")
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void registerParticles(ParticleFactoryRegisterEvent event)
	{
		Minecraft.getInstance().particleEngine.register(HoeParticleRegistry.GREEN_FLAME.get(), FlameParticle.Provider::new);
		Minecraft.getInstance().particleEngine.register(HoeParticleRegistry.GREEN_LAVA.get(), LavaParticle.Provider::new);
	}
}