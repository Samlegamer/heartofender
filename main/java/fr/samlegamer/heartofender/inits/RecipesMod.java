package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.utils.config.HoeConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesMod
{
	public static RecipesMod instance = new RecipesMod();
	
	public static void initRecipes()
	{
		if(HoeConfig.enableAzuriumFurnaceRecipe)
		{
			GameRegistry.addSmelting(BlocksMod.azurium_ore, new ItemStack(ItemsMod.azurium_ingot, 1), 3.5f);
		}
		
		if(HoeConfig.enableMilathiumFurnaceRecipe)
		{
			GameRegistry.addSmelting(BlocksMod.milathium_ore, new ItemStack(ItemsMod.milathium, 1), 3.5f);
		}
	}
}