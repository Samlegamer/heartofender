package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HoeItemsRegistry
{
	public static final DeferredRegister<Item> REGISTRY_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, HeartofEnder.MODID);
	
	//Items
	public static final RegistryObject<Item> DEAD_EYE = REGISTRY_ITEM.register("dead_eye", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> HEART_ENDER_PORTAL_PIECE = REGISTRY_ITEM.register("heart_ender_portal_piece", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_INGOT = REGISTRY_ITEM.register("azurium_ingot", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_NUGGET = REGISTRY_ITEM.register("azurium_nugget", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> BLACK_ROD = REGISTRY_ITEM.register("black_rod", () -> new Item(new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

	//Foods
	public static final RegistryObject<Item> DIAMOND_APPLE = REGISTRY_ITEM.register("diamond_apple", () -> new Item(new Item.Properties()
	.tab(HeartofEnder.CREATIVE_TAB_ITEMS)
    .food(new FoodProperties.Builder().nutrition(10).saturationMod(15.0F)
    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100 * 30, 4), 1.0f)
    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 125 * 30, 5), 1.0f)
    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 125 * 30, 1), 1.0f)
    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50 * 30, 4), 1.0f)
    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100 * 30, 2), 1.0f).build())));
	
	//armor
	public static final RegistryObject<Item> AZURIUM_HELMET = REGISTRY_ITEM.register("azurium_helmet", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlot.HEAD, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_CHESTPLATE = REGISTRY_ITEM.register("azurium_chestplate", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlot.CHEST, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_LEGGINGS = REGISTRY_ITEM.register("azurium_leggings", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlot.LEGS, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_BOOTS = REGISTRY_ITEM.register("azurium_boots", () -> new ArmorItem(AzuriumArmorItem.AZURIUM_ARMOR, EquipmentSlot.FEET, new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)));

	//Weapons or Tools
	public static final RegistryObject<Item> AZURIUM_SWORD = REGISTRY_ITEM.register("azurium_sword", () -> new SwordItem(AzuriumToolsItem.AZURIUM_TOOLS, 3, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_PICKAXE = REGISTRY_ITEM.register("azurium_pickaxe", () -> new PickaxeItem(AzuriumToolsItem.AZURIUM_TOOLS, -8, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_AXE = REGISTRY_ITEM.register("azurium_axe", () -> new AxeItem(AzuriumToolsItem.AZURIUM_TOOLS, 5, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	public static final RegistryObject<Item> AZURIUM_SHOVEL = REGISTRY_ITEM.register("azurium_shovel", () -> new ShovelItem(AzuriumToolsItem.AZURIUM_TOOLS, -8, -2.4f, new Item.Properties().stacksTo(1).tab(HeartofEnder.CREATIVE_TAB_ITEMS)));
	
}