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

		/*
		CompoundNBT strong_healing = new CompoundNBT();
		strong_healing.putString("Potion", "minecraft:strong_healing");
		ItemStack potion1 = new ItemStack(Items.POTION);
		potion1.setTag(strong_healing.copy());
		
		CompoundNBT heal3 = new CompoundNBT();
		heal3.putString("Potion", "heartofender:");
		ItemStack potionheal3 = new ItemStack(Items.POTION);
		potionheal3.setTag(heal3.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion1), Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()), potionheal3);
	
		CompoundNBT strong_swiftness = new CompoundNBT();
		strong_swiftness.putString("Potion", "minecraft:strong_swiftness");
		ItemStack potion2 = new ItemStack(Items.POTION);
		potion2.setTag(strong_swiftness.copy());
		
		CompoundNBT swiftness3 = new CompoundNBT();
		swiftness3.putString("Potion", "heartofender:speed_iii");
		ItemStack potionswiftness3 = new ItemStack(Items.POTION);
		potionswiftness3.setTag(swiftness3.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion2), Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()), potionswiftness3);
		
		CompoundNBT strong_regeneration = new CompoundNBT();
		strong_regeneration.putString("Potion", "minecraft:strong_regeneration");
		ItemStack potion3 = new ItemStack(Items.POTION);
		potion3.setTag(strong_regeneration.copy());
		
		CompoundNBT regeneration3 = new CompoundNBT();
		regeneration3.putString("Potion", "heartofender:regeneration_iii");
		ItemStack potionregeneration3 = new ItemStack(Items.POTION);
		potionregeneration3.setTag(regeneration3.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion3), Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()), potionregeneration3);

		CompoundNBT strength_regeneration = new CompoundNBT();
		strength_regeneration.putString("Potion", "minecraft:strong_strength");
		ItemStack potion4 = new ItemStack(Items.POTION);
		potion4.setTag(strength_regeneration.copy());
		
		CompoundNBT strength3 = new CompoundNBT();
		strength3.putString("Potion", "heartofender:strengh_iii");
		ItemStack potionstrength3 = new ItemStack(Items.POTION);
		potionstrength3.setTag(strength3.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion4), Ingredient.of(ModItems.HEART_ENDER_WART_ITEM.get()), potionstrength3);
		*/
	}
}