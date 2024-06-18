package fr.samlegamer.heartofender.compat.mctb;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CraftTable
{
	public static class Lilac extends CraftingTableBlock
	{
		private static final Component CONTAINER_TITLE = new TranslatableComponent("container.crafting");

		public Lilac(Properties p_52225_)
		{
			super(p_52225_);
		}

		public MenuProvider getMenuProvider(BlockState p_52240_, Level p_52241_, BlockPos p_52242_)
		{
		      return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> {
		         return new CraftTableContainer.Lilac(p_52229_, p_52230_, ContainerLevelAccess.create(p_52241_, p_52242_));
		      }, CONTAINER_TITLE);
		}
	}
	
	public static class Leafy extends CraftingTableBlock
	{
		private static final Component CONTAINER_TITLE = new TranslatableComponent("container.crafting");

		public Leafy(Properties p_52225_)
		{
			super(p_52225_);
		}

		public MenuProvider getMenuProvider(BlockState p_52240_, Level p_52241_, BlockPos p_52242_)
		{
		      return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> {
		         return new CraftTableContainer.Leafy(p_52229_, p_52230_, ContainerLevelAccess.create(p_52241_, p_52242_));
		      }, CONTAINER_TITLE);
		}
	}
}