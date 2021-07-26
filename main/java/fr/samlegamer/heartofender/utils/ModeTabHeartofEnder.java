package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.block.HoEBlockRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModeTabHeartofEnder extends CreativeModeTab
{
	public ModeTabHeartofEnder(String label)
	{
        super(label);
    }
	
	@Override
	public ItemStack makeIcon()
	{
        return this == HeartofEnder.CREATIVE_TAB_ITEMS ? new ItemStack(HoeItemsRegistry.DIAMOND_APPLE.get()) : new ItemStack(HoEBlockRegistry.HEART_ENDER_PORTAL_BLOCK.get());
	}
	
    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
}
