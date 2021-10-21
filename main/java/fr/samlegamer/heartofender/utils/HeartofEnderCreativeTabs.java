package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.ItemsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HeartofEnderCreativeTabs extends CreativeTabs
{
	public HeartofEnderCreativeTabs(String label)
	{
        super(label);
    }
	
	@Override
	public ItemStack getTabIconItem()
	{
        return this == HeartofEnder.CREATIVE_TAB_ITEMS ? new ItemStack(ItemsMod.diamond_apple) : new ItemStack(BlocksMod.heart_ender_portal_block);
	}
	
    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
}