package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.AzuriumArmorItem;
import fr.samlegamer.heartofender.item.AzuriumToolsItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
	public static final DeferredRegister<Item> ITEMS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HeartofEnder.MODID);

	//normal items
	public static final RegistryObject<Item> DEAD_EYE = ITEMS_REGISTRY.register("dead_eye", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> HEART_ENDER_PORTAL_PIECE = ITEMS_REGISTRY.register("heart_ender_portal_piece", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_INGOT = ITEMS_REGISTRY.register("azurium_ingot", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_NUGGET = ITEMS_REGISTRY.register("azurium_nugget", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> BLACK_ROD = ITEMS_REGISTRY.register("black_rod", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

	//food items
	public static final RegistryObject<Item> DIAMOND_APPLE = ITEMS_REGISTRY.register("diamond_apple", () -> new Item(new Item.Properties()
            .tab(HeartofEnder.CREATIVE_TAB_ITEMS)
            .food(new Food.Builder().nutrition(10).saturationMod(15.0F)
            .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 100 * 30, 4), 1.0f)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 125 * 30, 5), 1.0f)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 125 * 30, 1), 1.0f)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 50 * 30, 4), 1.0f)
            .effect(() -> new EffectInstance(Effects.DIG_SPEED, 100 * 30, 2), 1.0f).build())));
	
	//armor
	public static final RegistryObject<Item> AZURIUM_HELMET = ITEMS_REGISTRY.register("azurium_helmet", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
    public static final RegistryObject<Item> AZURIUM_CHESTPLATE = ITEMS_REGISTRY.register("azurium_chestplate", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
    public static final RegistryObject<Item> AZURIUM_LEGGINGS = ITEMS_REGISTRY.register("azurium_leggings", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
    public static final RegistryObject<Item> AZURIUM_BOOTS = ITEMS_REGISTRY.register("azurium_boots", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

    //Weapons or Tools
	public static final RegistryObject<Item> AZURIUM_SWORD = ITEMS_REGISTRY.register("azurium_sword", () -> new SwordItem(AzuriumToolsItem.AZURIUM_TOOLS, 3, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_PICKAXE = ITEMS_REGISTRY.register("azurium_pickaxe", () -> new PickaxeItem(AzuriumToolsItem.AZURIUM_TOOLS, -8, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_AXE = ITEMS_REGISTRY.register("azurium_axe", () -> new AxeItem(AzuriumToolsItem.AZURIUM_TOOLS, 5, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_SHOVEL = ITEMS_REGISTRY.register("azurium_shovel", () -> new ShovelItem(AzuriumToolsItem.AZURIUM_TOOLS, -8, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

	public static final RegistryObject<Item> PURPLE_GLOWSTONE_DUST = ITEMS_REGISTRY.register("purple_glowstone_dust", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> MILATHIUM = ITEMS_REGISTRY.register("milathium", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> MILATHIUM_INGOT = ITEMS_REGISTRY.register("milathium_ingot", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

	public static final RegistryObject<Item> HEART_WART = ITEMS_REGISTRY.register("heart_wart", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
}