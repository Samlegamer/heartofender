package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.cfg.HoeConfig;
import fr.samlegamer.heartofender.fluid.HoeFluids;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class HoeItems
{
	public static Item DEAD_EYE, HEART_ENDER_PORTAL_PIECE, AZURIUM_INGOT, AZURIUM_NUGGET, BLACK_ROD, DIAMOND_APPLE, 
	IRON_APPLE, LAPIS_APPLE, REDSTONE_APPLE, PURPLE_GLOWSTONE_DUST, MILATHIUM, MILATHIUM_INGOT, BLUE_MAGMA_CREAM, 
	HEART_BONE, AZURIUM_SWORD, AZURIUM_PICKAXE, AZURIUM_AXE, AZURIUM_SHOVEL, MILATHIUM_SWORD, MILATHIUM_PICKAXE,
	MILATHIUM_AXE, MILATHIUM_SHOVEL, AZURIUM_HELMET, AZURIUM_CHESTPLATE, AZURIUM_LEGGINGS, AZURIUM_BOOTS, MILATHIUM_HELMET,
	MILATHIUM_CHESTPLATE, MILATHIUM_LEGGINGS, MILATHIUM_BOOTS, HEART_BONE_SWORD;

	public static FlintAndAzuriumItem FLINT_AND_AZURIUM;
	//For Entities
    public static final Item GREEN_LAVA_BUCKET = new BucketItem(HoeFluids.GREEN_LAVA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(HeartofEnder.TAB_ITEMS));

	public static final SpawnEggItem ENDER_KID_EGG_SPAWN = new SpawnEggItem(HeartofEnder.ENDER_KID, 1447468, 657930, new Item.Settings().group(HeartofEnder.TAB_ITEMS));
	public static final SpawnEggItem HEART_BLAZE_EGG_SPAWN = new SpawnEggItem(HeartofEnder.HEART_BLAZE, 20224, 5120, new Item.Settings().group(HeartofEnder.TAB_ITEMS));
	public static final SpawnEggItem HEART_GHAST_EGG_SPAWN = new SpawnEggItem(HeartofEnder.HEART_GHAST, 11979231, 27616, new Item.Settings().group(HeartofEnder.TAB_ITEMS));
	//public static final RegistryObject<SpawnEggItem> BLUE_MAGMA_CUBE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_blue_magma_cube", () -> new SpawnEggItem(HoeEntityRegistry.BLUE_MAGMA_CUBE, 18342, 819, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	//public static final RegistryObject<SpawnEggItem> HEART_SKELETON_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_skeleton", () -> new SpawnEggItem(HoeEntityRegistry.HEART_SKELETON, 7674912, 3939360, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	//public static final RegistryObject<SpawnEggItem> HEART_STRIDER_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_strider", () -> new SpawnEggItem(HoeEntityRegistry.HEART_STRIDER, 4588092, 9590012, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
   /*
spawn_egg_ender_kid
spawn_egg_heart_blaze
spawn_egg_heart_ghast
    */

	public static void initItems()
	{
		DEAD_EYE = new Item(HoeItemSet.BASIC);
		HEART_ENDER_PORTAL_PIECE = new Item(HoeItemSet.BASIC);
		AZURIUM_INGOT = new Item(HoeItemSet.BASIC);
		AZURIUM_NUGGET = new Item(HoeItemSet.BASIC);
		BLACK_ROD = new Item(HoeItemSet.BASIC);
		
		DIAMOND_APPLE = new Item(FoodsPropertiesHoe.DIAMOND_APPLE);
		IRON_APPLE = new Item(FoodsPropertiesHoe.IRON_APPLE);
		LAPIS_APPLE = new Item(FoodsPropertiesHoe.LAPIS_APPLE);
		REDSTONE_APPLE = new Item(FoodsPropertiesHoe.REDSTONE_APPLE);

		PURPLE_GLOWSTONE_DUST = new Item(HoeItemSet.BASIC);
		MILATHIUM = new Item(HoeItemSet.BASIC);
		MILATHIUM_INGOT = new Item(HoeItemSet.BASIC);
		BLUE_MAGMA_CREAM = new Item(HoeItemSet.BASIC);
		HEART_BONE = new Item(HoeItemSet.BASIC);

		AZURIUM_SWORD = new SwordItem(HoeTiers.AZURIUM_TOOLS, 3, -2.4f, HoeItemSet.TOOLS);
		AZURIUM_PICKAXE = new HoePickaxe(HoeTiers.AZURIUM_TOOLS, -8, -2.4f, HoeItemSet.TOOLS);
		AZURIUM_AXE = new HoeAxe(HoeTiers.AZURIUM_TOOLS, 5, -2.4f, HoeItemSet.TOOLS);
		AZURIUM_SHOVEL = new ShovelItem(HoeTiers.AZURIUM_TOOLS, -8, -2.4f, HoeItemSet.TOOLS);
		
		MILATHIUM_SWORD = new SwordItem(HoeTiers.MILATHIUM_TOOLS, 3, -2.4f, HoeItemSet.TOOLS.fireproof());
		MILATHIUM_PICKAXE = new HoePickaxe(HoeTiers.MILATHIUM_TOOLS, -8, -2.4f, HoeItemSet.TOOLS.fireproof());
		MILATHIUM_AXE = new HoeAxe(HoeTiers.MILATHIUM_TOOLS, 5, -2.4f, HoeItemSet.TOOLS.fireproof());
		MILATHIUM_SHOVEL = new ShovelItem(HoeTiers.MILATHIUM_TOOLS, -8, -2.4f, HoeItemSet.TOOLS);

		AZURIUM_HELMET = new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.HEAD, HoeItemSet.ARMORS);
		AZURIUM_CHESTPLATE = new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.CHEST, HoeItemSet.ARMORS);
		AZURIUM_LEGGINGS = new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.LEGS, HoeItemSet.ARMORS);
		AZURIUM_BOOTS = new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.FEET, HoeItemSet.ARMORS);

		MILATHIUM_HELMET = new ArmorItem(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.HEAD, HoeItemSet.ARMORS.fireproof());
		MILATHIUM_CHESTPLATE = new ArmorItem(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.CHEST, HoeItemSet.ARMORS.fireproof());
		MILATHIUM_LEGGINGS = new ArmorItem(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.LEGS, HoeItemSet.ARMORS.fireproof());
		MILATHIUM_BOOTS = new ArmorItem(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.FEET, HoeItemSet.ARMORS.fireproof());

		FLINT_AND_AZURIUM = new FlintAndAzuriumItem(new Item.Settings().maxCount(1).maxDamage(HoeConfig.UseCountFlintAndAzurium).group(HeartofEnder.TAB_ITEMS));
		
		HEART_BONE_SWORD = new HeartBoneSwordItem(HoeTiers.HEART_BONE, 3, -2.4f, HoeItemSet.TOOLS);		
	}
	
	public static void registryAll()
	{
		add("dead_eye", DEAD_EYE);
		add("heart_ender_portal_piece", HEART_ENDER_PORTAL_PIECE);
		add("azurium_ingot", AZURIUM_INGOT);
		add("azurium_nugget", AZURIUM_NUGGET);
		add("black_rod", BLACK_ROD);
		add("diamond_apple", DIAMOND_APPLE);
		add("iron_apple", IRON_APPLE);
		add("lapis_apple", LAPIS_APPLE);
		add("redstone_apple", REDSTONE_APPLE);
		add("purple_glowstone_dust", PURPLE_GLOWSTONE_DUST);
		add("milathium", MILATHIUM);
		add("milathium_ingot", MILATHIUM_INGOT);
		add("blue_magma_cream", BLUE_MAGMA_CREAM);
		add("heart_bone", HEART_BONE);
		add("green_lava_bucket", GREEN_LAVA_BUCKET);
		add("azurium_sword", AZURIUM_SWORD);
		add("azurium_pickaxe", AZURIUM_PICKAXE);
		add("azurium_axe", AZURIUM_AXE);
		add("azurium_shovel", AZURIUM_SHOVEL);
		add("milathium_sword", MILATHIUM_SWORD);
		add("milathium_pickaxe", MILATHIUM_PICKAXE);
		add("milathium_axe", MILATHIUM_AXE);
		add("milathium_shovel", MILATHIUM_SHOVEL);
		add("azurium_helmet", AZURIUM_HELMET);
		add("azurium_chestplate", AZURIUM_CHESTPLATE);
		add("azurium_leggings", AZURIUM_LEGGINGS);
		add("azurium_boots", AZURIUM_BOOTS);
		add("milathium_helmet", MILATHIUM_HELMET);
		add("milathium_chestplate", MILATHIUM_CHESTPLATE);
		add("milathium_leggings", MILATHIUM_LEGGINGS);
		add("milathium_boots", MILATHIUM_BOOTS);
		
		add("flint_and_azurium", FLINT_AND_AZURIUM);
		
		add("heart_bone_sword", HEART_BONE_SWORD);
		
		add("spawn_egg_ender_kid", ENDER_KID_EGG_SPAWN);
		add("spawn_egg_heart_blaze", HEART_BLAZE_EGG_SPAWN);
		add("spawn_egg_heart_ghast", HEART_GHAST_EGG_SPAWN);

	}
	
    private static void add(String name, Item i)
    {
    	Registry.register(Registry.ITEM, new Identifier(HeartofEnder.MODID, name), i);
    }
    
    static class HoeItemSet
    {
    	public static final Item.Settings BASIC = new Item.Settings().maxCount(64).group(HeartofEnder.TAB_ITEMS);
    	public static final Item.Settings TOOLS = new Item.Settings().maxCount(1).group(HeartofEnder.TAB_ITEMS);
    	public static final Item.Settings ARMORS = new Item.Settings().maxCount(1).group(HeartofEnder.TAB_ITEMS);

    }
    
    static class FoodsPropertiesHoe
    {
    	public static final Item.Settings DIAMOND_APPLE = new Item.Settings().group(HeartofEnder.TAB_ITEMS)
    			.food(new FoodComponent.Builder().hunger(10).saturationModifier(15.0F)
    			.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100 * 30, 4), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 125 * 30, 5), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 125 * 30, 1), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50 * 30, 4), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100 * 30, 2), 1.0f).build());
    	
    	public static final Item.Settings IRON_APPLE = new Item.Settings().group(HeartofEnder.TAB_ITEMS)
                .food(new FoodComponent.Builder().hunger(6).saturationModifier(4.0F).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 75 * 30, 0), 1.0f).build());
    	
    	public static final Item.Settings LAPIS_APPLE = new Item.Settings().group(HeartofEnder.TAB_ITEMS)
                .food(new FoodComponent.Builder().hunger(6).saturationModifier(4.0F).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 150 * 30, 0), 1.0f).build());

    	public static final Item.Settings REDSTONE_APPLE = new Item.Settings().group(HeartofEnder.TAB_ITEMS)
                .food(new FoodComponent.Builder().hunger(6).saturationModifier(4.0F).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150 * 30, 0), 1.0f).build());

    }
    /*
	public static final RegistryObject<Item> GREEN_TORCH_ITEM = REGISTRY_ITEMS.register("green_torch", () -> new StandingAndWallBlockItem(HoeBlocksRegistry.GREEN_TORCH.get(), HoeBlocksRegistry.GREEN_TORCH_WALL.get(), (new Item.Properties().tab(HeartofEnder.TAB_ITEMS))));
	public static final RegistryObject<Item> HEART_ENDER_WART_ITEM = REGISTRY_ITEMS.register("heart_ender_wart_block", () -> new ItemNameBlockItem(HoeBlocksRegistry.HEART_ENDER_WART_BLOCK.get(), new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));


	public static final RegistryObject<Item> GREEN_FIRE_CHARGE = REGISTRY_ITEMS.register("green_fire_charge", () -> new GreenFireChargeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(16).tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<FlintAndMilathiumItem> FLINT_AND_MILATHIUM = REGISTRY_ITEMS.register("flint_and_milathium", () -> new FlintAndMilathiumItem(new Item.Properties().stacksTo(1).durability(HoeConfig.UseCountFlintAndAzurium).tab(HeartofEnder.TAB_ITEMS)));
	
	public static final RegistryObject<SpawnEggItem> ENDER_KID_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_ender_kid", () -> new SpawnEggItem(HoeEntityRegistry.ENDER_KID, 1447468, 657930, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_BLAZE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_blaze", () -> new SpawnEggItem(HoeEntityRegistry.HEART_BLAZE, 20224, 5120, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_GHAST_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_ghast", () -> new SpawnEggItem(HoeEntityRegistry.HEART_GHAST, 11979231, 27616, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> BLUE_MAGMA_CUBE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_blue_magma_cube", () -> new SpawnEggItem(HoeEntityRegistry.BLUE_MAGMA_CUBE, 18342, 819, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_SKELETON_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_skeleton", () -> new SpawnEggItem(HoeEntityRegistry.HEART_SKELETON, 7674912, 3939360, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_STRIDER_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_strider", () -> new SpawnEggItem(HoeEntityRegistry.HEART_STRIDER, 4588092, 9590012, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
     */
}