package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityBlueMagmaBlock;
import fr.samlegamer.heartofender.entity.EntityEnderKid;
import fr.samlegamer.heartofender.entity.EntityHeartBlaze;
import fr.samlegamer.heartofender.entity.EntityHeartGhast;
import fr.samlegamer.heartofender.entity.EntityHeartSkeleton;
import fr.samlegamer.heartofender.entity.EntityHerobrine;
import fr.samlegamer.heartofender.entity.render.RenderBlueMagmaBlock;
import fr.samlegamer.heartofender.entity.render.RenderEnderKid;
import fr.samlegamer.heartofender.entity.render.RenderHeartBlaze;
import fr.samlegamer.heartofender.entity.render.RenderHeartGhast;
import fr.samlegamer.heartofender.entity.render.RenderHeartSkeleton;
import fr.samlegamer.heartofender.entity.render.RenderHerobrine;
import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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