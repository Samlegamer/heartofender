package fr.samlegamer.heartofender.utils.tab;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class HoeTabs extends CreativeModeTab
{
	public HoeTabs(String label)
	{
		super(label);
	}

	@Override
	public ItemStack makeIcon()
	{
		return this == HeartofEnder.TAB_ITEMS ? new ItemStack(HoeItemsRegistry.DIAMOND_APPLE.get()) : new ItemStack(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get());
	}
	
	@Override
	public boolean hasSearchBar()
	{
		return false;
	}
}
