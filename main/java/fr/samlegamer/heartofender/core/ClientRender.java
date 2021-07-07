package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.entity.renders.EnderKidRender;
import fr.samlegamer.heartofender.inits.ModEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientRender
{
	public static void setupClient()
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ENDER_KID, manager -> new EnderKidRender(manager));

	}
}