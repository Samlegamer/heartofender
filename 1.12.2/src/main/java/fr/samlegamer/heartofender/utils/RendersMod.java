package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.entity.*;
import fr.samlegamer.heartofender.entity.render.*;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RendersMod
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderKid.class, new IRenderFactory<EntityEnderKid>()
		{
			@Override
			public Render<? super EntityEnderKid> createRenderFor(RenderManager manager)
			{
				return new RenderEnderKid(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHerobrine.class, new IRenderFactory<EntityHerobrine>()
		{
			@Override
			public Render<? super EntityHerobrine> createRenderFor(RenderManager manager)
			{
				return new RenderHerobrine(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHeartGhast.class, new IRenderFactory<EntityHeartGhast>()
		{
			@Override
			public Render<? super EntityHeartGhast> createRenderFor(RenderManager manager)
			{
				return new RenderHeartGhast(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHeartBlaze.class, new IRenderFactory<EntityHeartBlaze>()
		{
			@Override
			public Render<? super EntityHeartBlaze> createRenderFor(RenderManager manager)
			{
				return new RenderHeartBlaze(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueMagmaBlock.class, new IRenderFactory<EntityBlueMagmaBlock>()
		{
			@Override
			public Render<? super EntityBlueMagmaBlock> createRenderFor(RenderManager manager)
			{
				return new RenderBlueMagmaBlock(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHeartSkeleton.class, new IRenderFactory<EntityHeartSkeleton>()
		{
			@Override
			public Render<? super EntityHeartSkeleton> createRenderFor(RenderManager manager)
			{
				return new RenderHeartSkeleton(manager);
			}
		});
	}
}