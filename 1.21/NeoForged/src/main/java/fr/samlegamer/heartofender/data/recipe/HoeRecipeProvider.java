package fr.samlegamer.heartofender.data.recipe;

import java.util.concurrent.CompletableFuture;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class HoeRecipeProvider extends RecipeProvider
{
    public HoeRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    /*For Apple*/
	private void recipeApple(RecipeOutput output, ItemLike item, String hasitem, ItemLike blockitem, String hasblock, ItemLike resultApple)
	{
    	ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, resultApple)
        .pattern("#D#")
        .pattern("DAD")
        .pattern("#D#")
        .define('A', Items.APPLE)
        .define('#', item)
        .define('D', blockitem)
        .unlockedBy("has_apple", has(Items.APPLE)).unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_"+hasblock, has(blockitem))
        .save(output);
	}
	
	/*Used for Block or Nuggets*/
	private void recipeFull(RecipeOutput output, ItemLike item, String hasitem, ItemLike result)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
        .pattern("AAA")
        .pattern("AAA")
        .pattern("AAA")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
	}

	/*Used for Azurium Block to Ingot or Stem to plank, or button*/
	private void recipeOneBlockToBlockOrItem(RecipeOutput output, RecipeCategory category, ItemLike item, String hasitem, ItemLike result, int count)
	{
		ShapedRecipeBuilder.shaped(category, result, count)
        .pattern("A")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
	}
	
	private void recipeOneBlockToBlockOrItem(RecipeOutput output, RecipeCategory category, ItemLike item, String hasitem, ItemLike result, int count, String rl)
	{
		ShapedRecipeBuilder.shaped(category, result, count)
        .pattern("A")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, result.asItem().toString()+rl));
	}
	
	/*Used for Bricks or Magma*/
	private void recipe4toResult(RecipeOutput output, RecipeCategory category, ItemLike item, String hasitem, ItemLike result, int count)
	{
		ShapedRecipeBuilder.shaped(category, result, count)
        .pattern("AA")
        .pattern("AA")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
	}
	
	private void recipeArmors(RecipeOutput output, ItemLike item, String hasitem, ItemLike resultHelmet, ItemLike resultChestplate, ItemLike resultLeggings, ItemLike resultBoots)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultHelmet)
        .pattern("AAA")
        .pattern("A A")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultChestplate)
        .pattern("A A")
        .pattern("AAA")
        .pattern("AAA")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultLeggings)
        .pattern("AAA")
        .pattern("A A")
        .pattern("A A")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultBoots)
        .pattern("A A")
        .pattern("A A")
        .define('A', item)
        .unlockedBy("has_"+hasitem, has(item))
        .save(output);
	}
	
	private void recipeSwordAndTools(RecipeOutput output, ItemLike item, String hasitem, ItemLike resultSword, ItemLike resultPickaxe, ItemLike resultAxe, ItemLike resultShovel)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultSword)
        .pattern("A")
        .pattern("A")
        .pattern("/")
        .define('A', item)
        .define('/', HoeItemsRegistry.BLACK_ROD)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_black_rod", has(HoeItemsRegistry.BLACK_ROD))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultPickaxe)
        .pattern("AAA")
        .pattern(" / ")
        .pattern(" / ")
        .define('A', item)
        .define('/', HoeItemsRegistry.BLACK_ROD)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_black_rod", has(HoeItemsRegistry.BLACK_ROD))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultAxe)
        .pattern("AA")
        .pattern("A/")
        .pattern(" /")
        .define('A', item)
        .define('/', HoeItemsRegistry.BLACK_ROD)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_black_rod", has(HoeItemsRegistry.BLACK_ROD))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultShovel)
        .pattern("A")
        .pattern("/")
        .pattern("/")
        .define('A', item)
        .define('/', HoeItemsRegistry.BLACK_ROD)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_black_rod", has(HoeItemsRegistry.BLACK_ROD))
        .save(output);
	}
	
	/*Used for Dead Soul Sand or Milathium Ingot*/
	private void recipeendercheststyle(RecipeOutput output, RecipeCategory category, ItemLike item, String hasitem, ItemLike item2, String hasitem2, ItemLike result, int count)
	{
		ShapedRecipeBuilder.shaped(category, result, count)
        .pattern("AAA")
        .pattern("AXA")
        .pattern("AAA")
        .define('A', item)
        .define('X', item2)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_"+hasitem2, has(item2))
        .save(output);
	}
	
	private void recipeendercheststyle(RecipeOutput output, RecipeCategory category, ItemLike item, String hasitem, ItemLike item2, String hasitem2, ItemLike result, int count, String rl)
	{
		ShapedRecipeBuilder.shaped(category, result, count)
        .pattern("AAA")
        .pattern("AXA")
        .pattern("AAA")
        .define('A', item)
        .define('X', item2)
        .unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_"+hasitem2, has(item2))
        .save(output, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, result.asItem().toString()+rl));
	}

	
	private void recipeFurnaceOre(RecipeOutput output, ItemLike item, ItemLike result)
	{
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), RecipeCategory.MISC, result, 0.5f, 200).save(output, result.asItem().toString()+"_smelting");
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), RecipeCategory.MISC, result, 0.5f, 100).save(output, result.asItem().toString()+"_blasting");
	}
	
	private void recipeFlintAnd(RecipeOutput output, ItemLike item, String hasitem, ItemLike result)
	{
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, result).requires(item).requires(Items.FLINT)
		.unlockedBy("has_"+hasitem, has(item)).unlockedBy("has_flint", has(Items.FLINT)).save(output);
	}
	
    @Override
    protected void buildRecipes(RecipeOutput output)
    {
    	recipeApple(output, Items.IRON_INGOT, "iron_ingot", Items.IRON_BLOCK, "iron_block", HoeItemsRegistry.IRON_APPLE);
    	recipeApple(output, Items.LAPIS_LAZULI, "lapis_lazuli", Items.LAPIS_BLOCK, "lapis_block", HoeItemsRegistry.LAPIS_APPLE);
    	recipeApple(output, Items.REDSTONE, "redstone", Items.REDSTONE_BLOCK, "redstone_block", HoeItemsRegistry.REDSTONE_APPLE);
    	recipeApple(output, Items.DIAMOND, "diamond", Items.DIAMOND_BLOCK, "diamond_block", HoeItemsRegistry.DIAMOND_APPLE);
            	
    	recipeFull(output, HoeItemsRegistry.AZURIUM_INGOT, "azurium_ingot", HoeBlocksRegistry.AZURIUM_BLOCK);
    	recipeFull(output, HoeItemsRegistry.MILATHIUM_INGOT, "milathium_ingot", HoeBlocksRegistry.MILATHIUM_BLOCK);
    	recipeFull(output, HoeItemsRegistry.AZURIUM_NUGGET, "azurium_nugget", HoeItemsRegistry.AZURIUM_INGOT);

    	recipeOneBlockToBlockOrItem(output, RecipeCategory.REDSTONE, HoeBlocksRegistry.DARK_END_STONE, "dark_end_stone", HoeBlocksRegistry.DARK_END_STONE_BUTTON, 1);
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.REDSTONE, HoeBlocksRegistry.DARK_END_STONE_BRICK, "dark_end_stone_brick", HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON, 1);

    	recipeOneBlockToBlockOrItem(output, RecipeCategory.MISC, HoeBlocksRegistry.AZURIUM_BLOCK, "azurium_block", HoeItemsRegistry.AZURIUM_INGOT, 9, "_from_block");
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.MISC, HoeBlocksRegistry.MILATHIUM_BLOCK, "milathium_block", HoeItemsRegistry.MILATHIUM_INGOT, 9);
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.MISC, HoeItemsRegistry.AZURIUM_INGOT, "azurium_ingot", HoeItemsRegistry.AZURIUM_NUGGET, 9);

    	recipeOneBlockToBlockOrItem(output, RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.LILAC_STEM, "lilac_stem", HoeBlocksRegistry.LILAC_PLANKS, 4);
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.LEAFY_STEM, "leafy_stem", HoeBlocksRegistry.LEAFY_PLANKS, 4);
    	
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.STRIPPED_LILAC_STEM, "stripped_lilac_stem", HoeBlocksRegistry.LILAC_PLANKS, 4, "_from_stripped");
    	recipeOneBlockToBlockOrItem(output, RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.STRIPPED_LEAFY_STEM, "stripped_leafy_stem", HoeBlocksRegistry.LEAFY_PLANKS, 4, "_from_stripped");

    	recipeOneBlockToBlockOrItem(output, RecipeCategory.MISC, HoeItemsRegistry.HEART_BONE, "heart_bone", Items.BONE_MEAL, 6);

    	recipe4toResult(output, RecipeCategory.BUILDING_BLOCKS, HoeItemsRegistry.BLUE_MAGMA_CREAM, "blue_magma_cream", HoeBlocksRegistry.BLUE_MAGMA_BLOCK, 1);
    	recipe4toResult(output, RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.DARK_END_STONE, "dark_end_stone", HoeBlocksRegistry.DARK_END_STONE_BRICK, 4);

    	recipeArmors(output, HoeItemsRegistry.AZURIUM_INGOT, "azurium_ingot", HoeItemsRegistry.AZURIUM_HELMET, HoeItemsRegistry.AZURIUM_CHESTPLATE, HoeItemsRegistry.AZURIUM_LEGGINGS, HoeItemsRegistry.AZURIUM_BOOTS);
    	recipeArmors(output, HoeItemsRegistry.MILATHIUM_INGOT, "milathium_ingot", HoeItemsRegistry.MILATHIUM_HELMET, HoeItemsRegistry.MILATHIUM_CHESTPLATE, HoeItemsRegistry.MILATHIUM_LEGGINGS, HoeItemsRegistry.MILATHIUM_BOOTS);

    	recipeSwordAndTools(output, HoeItemsRegistry.AZURIUM_INGOT, "azurium_ingot", HoeItemsRegistry.AZURIUM_SWORD, HoeItemsRegistry.AZURIUM_PICKAXE, HoeItemsRegistry.AZURIUM_AXE, HoeItemsRegistry.AZURIUM_SHOVEL);
    	recipeSwordAndTools(output, HoeItemsRegistry.MILATHIUM_INGOT, "milathium_ingot", HoeItemsRegistry.MILATHIUM_SWORD, HoeItemsRegistry.MILATHIUM_PICKAXE, HoeItemsRegistry.MILATHIUM_AXE, HoeItemsRegistry.MILATHIUM_SHOVEL);

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HoeItemsRegistry.HEART_BONE_SWORD)
        .pattern("A")
        .pattern("A")
        .pattern("/")
        .define('A', HoeItemsRegistry.HEART_BONE)
        .define('/', HoeItemsRegistry.BLACK_ROD)
        .unlockedBy("has_heart_bone", has(HoeItemsRegistry.HEART_BONE)).unlockedBy("has_black_rod", has(HoeItemsRegistry.BLACK_ROD))
        .save(output);

		recipeendercheststyle(output, RecipeCategory.MISC, Items.COAL, "coal", Items.BLAZE_ROD, "blaze_rod", HoeItemsRegistry.BLACK_ROD, 1);
		recipeendercheststyle(output, RecipeCategory.BUILDING_BLOCKS, Items.COAL, "coal", Items.END_STONE, "end_stone", HoeBlocksRegistry.DARK_END_STONE, 1);
		recipeendercheststyle(output, RecipeCategory.MISC, Items.FERMENTED_SPIDER_EYE, "fermented_spider_eye", Items.ENDER_EYE, "ender_eye", HoeItemsRegistry.DEAD_EYE, 1);
		recipeendercheststyle(output, RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SAND, "soul_sand", Items.SKELETON_SKULL, "skeleton_skull", HoeBlocksRegistry.DEAD_SOUL_SAND, 8, "_from_skeleton_skull");
		recipeendercheststyle(output, RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SAND, "soul_sand", Items.WITHER_SKELETON_SKULL, "wither_skeleton_skull", HoeBlocksRegistry.DEAD_SOUL_SAND, 8, "_from_wither_skull");
		recipeendercheststyle(output, RecipeCategory.BUILDING_BLOCKS, HoeItemsRegistry.HEART_ENDER_PORTAL_PIECE, "heart_ender_portal_piece", HoeItemsRegistry.DEAD_EYE, "dead_eye", HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK, 1);
		
		recipeFlintAnd(output, HoeItemsRegistry.AZURIUM_INGOT, "azurium_ingot", HoeItemsRegistry.FLINT_AND_AZURIUM);
		recipeFlintAnd(output, HoeItemsRegistry.MILATHIUM_INGOT, "milathium_ingot", HoeItemsRegistry.FLINT_AND_MILATHIUM);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HoeBlocksRegistry.HEROBRINE_HEAD, 1)
        .pattern("AAA")
        .pattern("XTX")
        .pattern("TTT")
        .define('A', Items.BROWN_TERRACOTTA)
        .define('X', Items.NETHER_STAR)
        .define('T', Items.TERRACOTTA)
        .unlockedBy("has_brown_terracotta", has(Items.BROWN_TERRACOTTA)).unlockedBy("has_nether_star", has(Items.NETHER_STAR)).unlockedBy("has_terracotta", has(Items.TERRACOTTA))
        .save(output);
		
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HoeItemsRegistry.HEART_ENDER_PORTAL_PIECE, 1)
        .pattern("AAA")
        .pattern("XXX")
        .pattern("AAA")
        .define('A', Items.END_STONE)
        .define('X', Items.POPPED_CHORUS_FRUIT)
        .unlockedBy("has_end_stone", has(Items.END_STONE)).unlockedBy("has_popped_chorus_fruit", has(Items.POPPED_CHORUS_FRUIT))
        .save(output);
		
		recipeFurnaceOre(output, HoeBlocksRegistry.AZURIUM_ORE, HoeItemsRegistry.AZURIUM_INGOT);
		recipeFurnaceOre(output, HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE, HoeItemsRegistry.AZURIUM_INGOT);
		recipeFurnaceOre(output, HoeBlocksRegistry.MILATHIUM_ORE, HoeItemsRegistry.MILATHIUM);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(HoeBlocksRegistry.DEAD_SOUL_SAND), RecipeCategory.BUILDING_BLOCKS, HoeBlocksRegistry.DEAD_SOUL_SOIL, 0.5f, 200);
    }
}