package fr.samlegamer.heartofender.compat.mctb;

import fr.samlegamer.heartofender.compat.HoeCompats;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

public class CraftTableContainer
{
    public static class Lilac extends CraftingMenu
    {
    	private final ContainerLevelAccess access;

        public Lilac(int i, Inventory inv, ContainerLevelAccess c)
    	{
    		super(i, inv, c);
    		this.access = c;
    	}
        
        public boolean stillValid(Player p_39368_) {
            return stillValid(this.access, p_39368_, HoeCompats.MoreCraftingTables.lilac_crafting_table.get());
         }
        
        protected static boolean stillValid(ContainerLevelAccess p_38890_, Player p_38891_, Block p_38892_) {
            return p_38890_.evaluate((p_38916_, p_38917_) -> {
               return !p_38916_.getBlockState(p_38917_).is(p_38892_) ? false : p_38891_.distanceToSqr((double)p_38917_.getX() + 0.5D, (double)p_38917_.getY() + 0.5D, (double)p_38917_.getZ() + 0.5D) <= 64.0D;
            }, true);
         }
    }
    
    public static class Leafy extends CraftingMenu
    {
    	private final ContainerLevelAccess access;

        public Leafy(int i, Inventory inv, ContainerLevelAccess c)
    	{
    		super(i, inv, c);
    		this.access = c;
    	}
        
        public boolean stillValid(Player p_39368_) {
            return stillValid(this.access, p_39368_, HoeCompats.MoreCraftingTables.leafy_crafting_table.get());
         }
        
        protected static boolean stillValid(ContainerLevelAccess p_38890_, Player p_38891_, Block p_38892_) {
            return p_38890_.evaluate((p_38916_, p_38917_) -> {
               return !p_38916_.getBlockState(p_38917_).is(p_38892_) ? false : p_38891_.distanceToSqr((double)p_38917_.getX() + 0.5D, (double)p_38917_.getY() + 0.5D, (double)p_38917_.getZ() + 0.5D) <= 64.0D;
            }, true);
         }
    }
}