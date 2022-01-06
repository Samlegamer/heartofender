package fr.samlegamer.heartofender.potions.recipes;

import fr.samlegamer.heartofender.inits.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class PotionRecipesRegistry
{
	public static void register(String potionUsed, String potionResulted, Ingredient ingredient)
	{
		CompoundNBT potionUse = new CompoundNBT();
		potionUse.putString("Potion", "minecraft:strong_"+potionUsed+"");
		ItemStack potion1 = new ItemStack(Items.POTION);
		potion1.setTag(potionUse.copy());
		
		CompoundNBT potionResult = new CompoundNBT();
		potionResult.putString("Potion", "heartofender:"+potionResulted+"");
		ItemStack potionheal3 = new ItemStack(Items.POTION);
		potionheal3.setTag(potionResult.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion1), ingredient, potionheal3);
	}
	
	//with the help of Bountiful Bauble's code, Thanks ^^
	public static void registerRecipes()
	{
		register("healing", "heal_boost_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("swiftness", "speed_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("regeneration", "regeneration_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("strength", "strength_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("slowness", "slowness_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("leaping", "jump_boost_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
		register("poison", "poison_iii", Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()));
	}
}