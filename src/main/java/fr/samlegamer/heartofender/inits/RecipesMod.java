package fr.samlegamer.heartofender.inits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesMod
{
	public static RecipesMod instance = new RecipesMod();
	
	public static void initRecipes()
	{
		GameRegistry.addSmelting(BlocksMod.azurium_ore, new ItemStack(ItemsMod.azurium_ingot, 1), 3.5f);
		GameRegistry.addSmelting(BlocksMod.milathium_ore, new ItemStack(ItemsMod.milathium, 1), 3.5f);
	}
}