package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.utils.HoeItemUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeItemsRegistry
{
	public static final DeferredRegister<Item> REGISTRY_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HeartofEnder.MODID);

	public static final RegistryObject<Item> DEAD_EYE = REGISTRY_ITEMS.register("dead_eye", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> HEART_ENDER_PORTAL_PIECE = REGISTRY_ITEMS.register("heart_ender_portal_piece", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> AZURIUM_INGOT = REGISTRY_ITEMS.register("azurium_ingot", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> AZURIUM_NUGGET = REGISTRY_ITEMS.register("azurium_nugget", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> BLACK_ROD = REGISTRY_ITEMS.register("black_rod", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<FlintAndAzuriumItem> FLINT_AND_AZURIUM = REGISTRY_ITEMS.register("flint_and_azurium", () -> new FlintAndAzuriumItem(new Item.Properties().stacksTo(1).durability(HoeConfig.UseCountFlintAndAzurium).tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<Item> GREEN_TORCH_ITEM = REGISTRY_ITEMS.register("green_torch", () -> new StandingAndWallBlockItem(HoeBlocksRegistry.GREEN_TORCH.get(), HoeBlocksRegistry.GREEN_TORCH_WALL.get(), (new Item.Properties().tab(HeartofEnder.TAB_ITEMS))));
	public static final RegistryObject<Item> HEART_ENDER_WART_ITEM = REGISTRY_ITEMS.register("heart_ender_wart_block", () -> new ItemNameBlockItem(HoeBlocksRegistry.HEART_ENDER_WART_BLOCK.get(), new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));

	public static final RegistryObject<Item> DIAMOND_APPLE = REGISTRY_ITEMS.register("diamond_apple", () -> new DiamondAppleItem());
	public static final RegistryObject<Item> IRON_APPLE = REGISTRY_ITEMS.register("iron_apple", () -> new Item(HoeItemUtils.IRON_APPLE));
	public static final RegistryObject<Item> LAPIS_APPLE = REGISTRY_ITEMS.register("lapis_apple", () -> new Item(HoeItemUtils.LAPIS_APPLE));
	public static final RegistryObject<Item> REDSTONE_APPLE = REGISTRY_ITEMS.register("redstone_apple", () -> new Item(HoeItemUtils.REDSTONE_APPLE));

	public static final RegistryObject<Item> PURPLE_GLOWSTONE_DUST = REGISTRY_ITEMS.register("purple_glowstone_dust", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> MILATHIUM = REGISTRY_ITEMS.register("milathium", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> MILATHIUM_INGOT = REGISTRY_ITEMS.register("milathium_ingot", () -> new Item(HoeItemUtils.BASE.fireResistant()));
	public static final RegistryObject<Item> BLUE_MAGMA_CREAM = REGISTRY_ITEMS.register("blue_magma_cream", () -> new Item(HoeItemUtils.BASE));
	public static final RegistryObject<Item> HEART_BONE = REGISTRY_ITEMS.register("heart_bone", () -> new Item(HoeItemUtils.BASE.fireResistant()));
	public static final RegistryObject<Item> GREEN_FIRE_CHARGE = REGISTRY_ITEMS.register("green_fire_charge", () -> new GreenFireChargeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(16).tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<FlintAndMilathiumItem> FLINT_AND_MILATHIUM = REGISTRY_ITEMS.register("flint_and_milathium", () -> new FlintAndMilathiumItem(new Item.Properties().stacksTo(1).durability(HoeConfig.UseCountFlintAndMilathium).fireResistant().tab(HeartofEnder.TAB_ITEMS)));

	//Armor
	public static final RegistryObject<Item> AZURIUM_HELMET = REGISTRY_ITEMS.register("azurium_helmet", () -> new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.HEAD, HoeItemUtils.ARMORS));
    public static final RegistryObject<Item> AZURIUM_CHESTPLATE = REGISTRY_ITEMS.register("azurium_chestplate", () -> new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.CHEST, HoeItemUtils.ARMORS));
    public static final RegistryObject<Item> AZURIUM_LEGGINGS = REGISTRY_ITEMS.register("azurium_leggings", () -> new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.LEGS, HoeItemUtils.ARMORS));
    public static final RegistryObject<Item> AZURIUM_BOOTS = REGISTRY_ITEMS.register("azurium_boots", () -> new ArmorItem(HoeArmors.AZURIUM_ARMOR, EquipmentSlot.FEET, HoeItemUtils.ARMORS));

	public static final RegistryObject<Item> MILATHIUM_HELMET = REGISTRY_ITEMS.register("milathium_helmet", () -> new MilathiumArmor(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.HEAD, HoeItemUtils.ARMORS.fireResistant()));
    public static final RegistryObject<Item> MILATHIUM_CHESTPLATE = REGISTRY_ITEMS.register("milathium_chestplate", () -> new MilathiumArmor(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.CHEST, HoeItemUtils.ARMORS.fireResistant()));
    public static final RegistryObject<Item> MILATHIUM_LEGGINGS = REGISTRY_ITEMS.register("milathium_leggings", () -> new MilathiumArmor(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.LEGS, HoeItemUtils.ARMORS.fireResistant()));
    public static final RegistryObject<Item> MILATHIUM_BOOTS = REGISTRY_ITEMS.register("milathium_boots", () -> new MilathiumArmor(HoeArmors.MILATHIUM_ARMOR, EquipmentSlot.FEET, HoeItemUtils.ARMORS.fireResistant()));
    
    //Weapons or Tools
	public static final RegistryObject<Item> AZURIUM_SWORD = REGISTRY_ITEMS.register("azurium_sword", () -> new SwordItem(HoeTiers.AZURIUM_TOOLS, 3, -2.4f, HoeItemUtils.TOOLS));
	public static final RegistryObject<Item> AZURIUM_PICKAXE = REGISTRY_ITEMS.register("azurium_pickaxe", () -> new PickaxeItem(HoeTiers.AZURIUM_TOOLS, -8, -2.4f, HoeItemUtils.TOOLS));
	public static final RegistryObject<Item> AZURIUM_AXE = REGISTRY_ITEMS.register("azurium_axe", () -> new AxeItem(HoeTiers.AZURIUM_TOOLS, 5, -2.4f, HoeItemUtils.TOOLS));
	public static final RegistryObject<Item> AZURIUM_SHOVEL = REGISTRY_ITEMS.register("azurium_shovel", () -> new ShovelItem(HoeTiers.AZURIUM_TOOLS, -8, -2.4f, HoeItemUtils.TOOLS));

	public static final RegistryObject<Item> MILATHIUM_SWORD = REGISTRY_ITEMS.register("milathium_sword", () -> new SwordItem(HoeTiers.MILATHIUM_TOOLS, 3, -2.4f, HoeItemUtils.TOOLS.fireResistant()));
	public static final RegistryObject<Item> MILATHIUM_PICKAXE = REGISTRY_ITEMS.register("milathium_pickaxe", () -> new PickaxeItem(HoeTiers.MILATHIUM_TOOLS, -8, -2.4f, HoeItemUtils.TOOLS.fireResistant()));
	public static final RegistryObject<Item> MILATHIUM_AXE = REGISTRY_ITEMS.register("milathium_axe", () -> new AxeItem(HoeTiers.MILATHIUM_TOOLS, 5, -2.4f, HoeItemUtils.TOOLS.fireResistant()));
	public static final RegistryObject<Item> MILATHIUM_SHOVEL = REGISTRY_ITEMS.register("milathium_shovel", () -> new ShovelItem(HoeTiers.MILATHIUM_TOOLS, -8, -2.4f, HoeItemUtils.TOOLS.fireResistant()));

	public static final RegistryObject<Item> HEART_BONE_SWORD = REGISTRY_ITEMS.register("heart_bone_sword", () -> new HeartBoneSwordItem(HoeTiers.HEART_BONE, 3, -2.4f, HoeItemUtils.TOOLS.fireResistant()));
	
	public static final RegistryObject<SpawnEggItem> ENDER_KID_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_ender_kid", () -> new ForgeSpawnEggItem(HoeEntityRegistry.ENDER_KID, 1447468, 657930, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_BLAZE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_blaze", () -> new ForgeSpawnEggItem(HoeEntityRegistry.HEART_BLAZE, 20224, 5120, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_GHAST_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_ghast", () -> new ForgeSpawnEggItem(HoeEntityRegistry.HEART_GHAST, 11979231, 27616, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> BLUE_MAGMA_CUBE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_blue_magma_cube", () -> new ForgeSpawnEggItem(HoeEntityRegistry.BLUE_MAGMA_CUBE, 18342, 819, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
	public static final RegistryObject<SpawnEggItem> HEART_SKELETON_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_skeleton", () -> new ForgeSpawnEggItem(HoeEntityRegistry.HEART_SKELETON, 7674912, 3939360, new Item.Properties().tab(HeartofEnder.TAB_ITEMS)));
}