package fr.samlegamer.heartofender.potion;

import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

//with the help of Bountiful Bauble's code, Thanks ^^
//Ported to 1.18.1
public class HoePotionRecipes
{
	public static void register(String potionUsed, String potionResulted, Ingredient ingredient)
	{
		CompoundTag potionUse = new CompoundTag();
		potionUse.putString("Potion", "minecraft:strong_"+potionUsed+"");
		ItemStack potion1 = new ItemStack(Items.POTION);
		potion1.setTag(potionUse.copy());
		
		CompoundTag potionResult = new CompoundTag();
		potionResult.putString("Potion", "heartofender:"+potionResulted+"");
		ItemStack potionheal3 = new ItemStack(Items.POTION);
		potionheal3.setTag(potionResult.copy());

		BrewingRecipeRegistry.addRecipe(Ingredient.of(potion1), ingredient, potionheal3);
	}
	
	public static void registerRecipes()
	{
		register("healing", "heal_boost_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("swiftness", "speed_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("regeneration", "regeneration_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("strength", "strength_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("slowness", "slowness_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("leaping", "jump_boost_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
		register("poison", "poison_iii", Ingredient.of(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get()));
	}
}