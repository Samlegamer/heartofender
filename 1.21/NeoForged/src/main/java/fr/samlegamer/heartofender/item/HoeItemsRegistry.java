package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import fr.samlegamer.heartofender.utils.HoeItemUtils;
import net.minecraft.core.Direction;
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
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeItemsRegistry
{
	public static final DeferredRegister.Items REGISTRY_ITEMS = DeferredRegister.createItems(HeartofEnder.MODID);
	
	public static final DeferredItem<Item> DEAD_EYE = REGISTRY_ITEMS.register("dead_eye", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> HEART_ENDER_PORTAL_PIECE = REGISTRY_ITEMS.register("heart_ender_portal_piece", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> AZURIUM_INGOT = REGISTRY_ITEMS.register("azurium_ingot", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> AZURIUM_NUGGET = REGISTRY_ITEMS.register("azurium_nugget", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> BLACK_ROD = REGISTRY_ITEMS.register("black_rod", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<FlintAndAzuriumItem> FLINT_AND_AZURIUM = REGISTRY_ITEMS.register("flint_and_azurium", () -> new FlintAndAzuriumItem(new Item.Properties().stacksTo(1).durability(HoeConfig.UseCountFlintAndAzurium)));
	//public static final DeferredItem<Item> GREEN_TORCH_ITEM = REGISTRY_ITEMS.register("green_torch", () -> new StandingAndWallBlockItem(HoeBlocksRegistry.GREEN_TORCH.get(), HoeBlocksRegistry.GREEN_TORCH_WALL.get(), new Item.Properties(), Direction.DOWN));
	//public static final DeferredItem<Item> HEART_ENDER_WART_ITEM = REGISTRY_ITEMS.register("heart_ender_wart_block", () -> new ItemNameBlockItem(HoeBlocksRegistry.HEART_ENDER_WART_BLOCK.get(), new Item.Properties()));

	public static final DeferredItem<Item> DIAMOND_APPLE = REGISTRY_ITEMS.register("diamond_apple", () -> new DiamondAppleItem());
	public static final DeferredItem<Item> IRON_APPLE = REGISTRY_ITEMS.register("iron_apple", () -> new Item(HoeItemUtils.IRON_APPLE));
	public static final DeferredItem<Item> LAPIS_APPLE = REGISTRY_ITEMS.register("lapis_apple", () -> new Item(HoeItemUtils.LAPIS_APPLE));
	public static final DeferredItem<Item> REDSTONE_APPLE = REGISTRY_ITEMS.register("redstone_apple", () -> new Item(HoeItemUtils.REDSTONE_APPLE));

	public static final DeferredItem<Item> PURPLE_GLOWSTONE_DUST = REGISTRY_ITEMS.register("purple_glowstone_dust", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> MILATHIUM = REGISTRY_ITEMS.register("milathium", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> MILATHIUM_INGOT = REGISTRY_ITEMS.register("milathium_ingot", () -> new Item(HoeItemUtils.BASE.fireResistant()));
	public static final DeferredItem<Item> BLUE_MAGMA_CREAM = REGISTRY_ITEMS.register("blue_magma_cream", () -> new Item(HoeItemUtils.BASE));
	public static final DeferredItem<Item> HEART_BONE = REGISTRY_ITEMS.register("heart_bone", () -> new Item(HoeItemUtils.BASE.fireResistant()));
	public static final DeferredItem<Item> GREEN_FIRE_CHARGE = REGISTRY_ITEMS.register("green_fire_charge", () -> new GreenFireChargeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(16)));
	public static final DeferredItem<FlintAndAzuriumItem> FLINT_AND_MILATHIUM = REGISTRY_ITEMS.register("flint_and_milathium", () -> new FlintAndAzuriumItem(new Item.Properties().stacksTo(1).durability(HoeConfig.UseCountFlintAndMilathium).fireResistant()));

	//Armor
	public static final DeferredItem<Item> AZURIUM_HELMET = REGISTRY_ITEMS.register("azurium_helmet", () -> new ArmorItem(HoeEquipment.AZURIUM_ARMOR, ArmorItem.Type.HELMET, HoeItemUtils.ARMORS.durability(ArmorItem.Type.HELMET.getDurability(250))));
    public static final DeferredItem<Item> AZURIUM_CHESTPLATE = REGISTRY_ITEMS.register("azurium_chestplate", () -> new ArmorItem(HoeEquipment.AZURIUM_ARMOR, ArmorItem.Type.CHESTPLATE, HoeItemUtils.ARMORS.durability(ArmorItem.Type.CHESTPLATE.getDurability(250))));
    public static final DeferredItem<Item> AZURIUM_LEGGINGS = REGISTRY_ITEMS.register("azurium_leggings", () -> new ArmorItem(HoeEquipment.AZURIUM_ARMOR, ArmorItem.Type.LEGGINGS, HoeItemUtils.ARMORS.durability(ArmorItem.Type.LEGGINGS.getDurability(250))));
    public static final DeferredItem<Item> AZURIUM_BOOTS = REGISTRY_ITEMS.register("azurium_boots", () -> new ArmorItem(HoeEquipment.AZURIUM_ARMOR, ArmorItem.Type.BOOTS, HoeItemUtils.ARMORS.durability(ArmorItem.Type.BOOTS.getDurability(250))));

	public static final DeferredItem<Item> MILATHIUM_HELMET = REGISTRY_ITEMS.register("milathium_helmet", () -> new MilathiumArmor(HoeEquipment.MILATHIUM_ARMOR, ArmorItem.Type.HELMET, HoeItemUtils.ARMORS.fireResistant().durability(ArmorItem.Type.HELMET.getDurability(500))));
    public static final DeferredItem<Item> MILATHIUM_CHESTPLATE = REGISTRY_ITEMS.register("milathium_chestplate", () -> new MilathiumArmor(HoeEquipment.MILATHIUM_ARMOR, ArmorItem.Type.CHESTPLATE, HoeItemUtils.ARMORS.fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(500))));
    public static final DeferredItem<Item> MILATHIUM_LEGGINGS = REGISTRY_ITEMS.register("milathium_leggings", () -> new MilathiumArmor(HoeEquipment.MILATHIUM_ARMOR, ArmorItem.Type.LEGGINGS, HoeItemUtils.ARMORS.fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(500))));
    public static final DeferredItem<Item> MILATHIUM_BOOTS = REGISTRY_ITEMS.register("milathium_boots", () -> new MilathiumArmor(HoeEquipment.MILATHIUM_ARMOR, ArmorItem.Type.BOOTS, HoeItemUtils.ARMORS.fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(500))));
    
    //Weapons or Tools
	public static final DeferredItem<Item> AZURIUM_SWORD = REGISTRY_ITEMS.register("azurium_sword", () -> new SwordItem(HoeEquipment.AZURIUM_TOOLS, HoeItemUtils.TOOLS.attributes(SwordItem.createAttributes(HoeEquipment.AZURIUM_TOOLS, 3, -2.4f))));
	public static final DeferredItem<Item> AZURIUM_PICKAXE = REGISTRY_ITEMS.register("azurium_pickaxe", () -> new PickaxeItem(HoeEquipment.AZURIUM_TOOLS, HoeItemUtils.TOOLS.attributes(PickaxeItem.createAttributes(HoeEquipment.AZURIUM_TOOLS, -8, -2.4f))));
	public static final DeferredItem<Item> AZURIUM_AXE = REGISTRY_ITEMS.register("azurium_axe", () -> new AxeItem(HoeEquipment.AZURIUM_TOOLS, HoeItemUtils.TOOLS.attributes(AxeItem.createAttributes(HoeEquipment.AZURIUM_TOOLS, 5, -2.4f))));
	public static final DeferredItem<Item> AZURIUM_SHOVEL = REGISTRY_ITEMS.register("azurium_shovel", () -> new ShovelItem(HoeEquipment.AZURIUM_TOOLS, HoeItemUtils.TOOLS.attributes(ShovelItem.createAttributes(HoeEquipment.AZURIUM_TOOLS, -8, -2.4f))));

	public static final DeferredItem<Item> MILATHIUM_SWORD = REGISTRY_ITEMS.register("milathium_sword", () -> new SwordItem(HoeEquipment.MILATHIUM_TOOLS, HoeItemUtils.TOOLS.fireResistant().attributes(SwordItem.createAttributes(HoeEquipment.MILATHIUM_TOOLS, 3, -2.4f))));
	public static final DeferredItem<Item> MILATHIUM_PICKAXE = REGISTRY_ITEMS.register("milathium_pickaxe", () -> new PickaxeItem(HoeEquipment.MILATHIUM_TOOLS, HoeItemUtils.TOOLS.fireResistant().attributes(PickaxeItem.createAttributes(HoeEquipment.MILATHIUM_TOOLS, -8, -2.4f))));
	public static final DeferredItem<Item> MILATHIUM_AXE = REGISTRY_ITEMS.register("milathium_axe", () -> new AxeItem(HoeEquipment.MILATHIUM_TOOLS, HoeItemUtils.TOOLS.fireResistant().attributes(AxeItem.createAttributes(HoeEquipment.MILATHIUM_TOOLS, 5, -2.4f))));
	public static final DeferredItem<Item> MILATHIUM_SHOVEL = REGISTRY_ITEMS.register("milathium_shovel", () -> new ShovelItem(HoeEquipment.MILATHIUM_TOOLS, HoeItemUtils.TOOLS.fireResistant().attributes(ShovelItem.createAttributes(HoeEquipment.MILATHIUM_TOOLS, -8, -2.4f))));

	public static final DeferredItem<Item> HEART_BONE_SWORD = REGISTRY_ITEMS.register("heart_bone_sword", () -> new HeartBoneSwordItem(HoeEquipment.HEART_BONE_TOOLS, HoeItemUtils.TOOLS.fireResistant().attributes(HeartBoneSwordItem.createAttributes(HoeEquipment.HEART_BONE_TOOLS, 3, -2.4f))));
	
	public static final DeferredItem<SpawnEggItem> ENDER_KID_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_ender_kid", () -> new DeferredSpawnEggItem(HoeEntityRegistry.ENDER_KID, 1447468, 657930, new Item.Properties()));
	public static final DeferredItem<SpawnEggItem> HEART_BLAZE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_blaze", () -> new DeferredSpawnEggItem(HoeEntityRegistry.HEART_BLAZE, 20224, 5120, new Item.Properties()));
	public static final DeferredItem<SpawnEggItem> HEART_GHAST_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_ghast", () -> new DeferredSpawnEggItem(HoeEntityRegistry.HEART_GHAST, 11979231, 27616, new Item.Properties()));
	public static final DeferredItem<SpawnEggItem> BLUE_MAGMA_CUBE_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_blue_magma_cube", () -> new DeferredSpawnEggItem(HoeEntityRegistry.BLUE_MAGMA_CUBE, 18342, 819, new Item.Properties()));
	public static final DeferredItem<SpawnEggItem> HEART_SKELETON_EGG_SPAWN = REGISTRY_ITEMS.register("spawn_egg_heart_skeleton", () -> new DeferredSpawnEggItem(HoeEntityRegistry.HEART_SKELETON, 7674912, 3939360, new Item.Properties()));
}