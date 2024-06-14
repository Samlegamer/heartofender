package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreaTabHeartofEnder extends ItemGroup
{
	public CreaTabHeartofEnder(String label)
	{
        super(label);
    }
	
	@Override
	public ItemStack makeIcon()
	{
        return this == HeartofEnder.CREATIVE_TAB_ITEMS ? new ItemStack(ModItems.DIAMOND_APPLE.get()) : new ItemStack(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get());
	}
	
    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
}