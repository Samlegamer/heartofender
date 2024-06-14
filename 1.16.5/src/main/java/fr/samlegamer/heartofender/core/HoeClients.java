package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.entity.renders.BlueMagmaCubeRenderer;
import fr.samlegamer.heartofender.entity.renders.EnderKidRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartBlazeRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartGhastRenderer;
import fr.samlegamer.heartofender.entity.renders.HeartSkeletonRenderer;
import fr.samlegamer.heartofender.entity.renders.HerobrineRenderer;
import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModEntities;
import fr.samlegamer.heartofender.inits.ModTileEntities;
import fr.samlegamer.heartofender.tile.GreenCampfireTileEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class HoeClients
{
	@OnlyIn(Dist.CLIENT)
	public static void init()
	{
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_BLAZE, HeartBlazeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ENDER_KID, EnderKidRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_GHAST, HeartGhastRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLUE_MAGMA_CUBE, BlueMagmaCubeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEART_SKELETON, HeartSkeletonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HEROBRINE, HerobrineRenderer::new);

        ClientRegistry.bindTileEntityRenderer(ModTileEntities.GREEN_CAMPFIRE_TILE.get(), GreenCampfireTileEntityRenderer::new);
        
		RenderTypeLookup.setRenderLayer(ModBlocks.HEART_ENDER_WART_BLOCK.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_FIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_TORCH_WALL.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_CAMPFIRE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_LANTERN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.HEART_OF_ENDER_PORTAL.get(), RenderType.translucent());
	}
}