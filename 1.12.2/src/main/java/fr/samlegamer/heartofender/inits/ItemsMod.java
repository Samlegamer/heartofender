package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.item.*;
import fr.samlegamer.heartofender.utils.config.HoeConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod
{
	public static Item dead_eye, heart_ender_piece, azurium_ingot, azurium_nuggets, black_rod, purple_glowstone_dust, blue_magma_cream, milathium, milathium_ingot, heart_bone;
	public static ItemFood diamond_apple, iron_apple, lapis_apple, redstone_apple;
	public static ItemArmor azurium_helmet, azurium_chestplate, azurium_leggings, azurium_boots, milathium_helmet,  milathium_chestplate, milathium_leggings, milathium_boots;
	public static FlintAndAzurium flint_and_azurium;
	public static SwordGeneric milathium_sword, azurium_sword;
	public static PickaxeGeneric azurium_pickaxe, milathium_pickaxe;
	public static AxeGeneric azurium_axe, milathium_axe;
	public static ShovelGeneric azurium_spade, milathium_shovel;
	public static AzuriumBow azurium_bow;
	public static HeartBoneBow heart_bone_bow;
	public static MilathiumBow milathium_bow;
	
	public static void init()
	{
		dead_eye = new ItemMod("dead_eye").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		heart_ender_piece = new ItemMod("heart_ender_piece").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_ingot = new ItemMod("azurium_ingot").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_nuggets = new ItemMod("azurium_nuggets").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		black_rod = new ItemMod("black_rod").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		purple_glowstone_dust = new ItemMod("purple_glowstone_dust").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium = new ItemMod("milathium").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_ingot = new ItemMod("milathium_ingot").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		blue_magma_cream = new ItemMod("blue_magma_cream").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		heart_bone = new ItemMod("heart_bone").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		flint_and_azurium = (FlintAndAzurium) new FlintAndAzurium("flint_and_azurium").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);

		azurium_helmet = (ItemArmor) new ArmorGeneric("azurium_helmet", azuriumMat, EntityEquipmentSlot.HEAD, ItemsMod.azurium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_chestplate = (ItemArmor) new ArmorGeneric("azurium_chestplate", azuriumMat, EntityEquipmentSlot.CHEST, ItemsMod.azurium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_leggings = (ItemArmor) new ArmorGeneric("azurium_leggings", azuriumMat, EntityEquipmentSlot.LEGS, ItemsMod.azurium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_boots = (ItemArmor) new ArmorGeneric("azurium_boots", azuriumMat, EntityEquipmentSlot.FEET, ItemsMod.azurium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_helmet = (ItemArmor) new ArmorGeneric("milathium_helmet", milathiumMat, EntityEquipmentSlot.HEAD, ItemsMod.milathium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_chestplate = (ItemArmor) new ArmorGeneric("milathium_chestplate", milathiumMat, EntityEquipmentSlot.CHEST, ItemsMod.milathium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_leggings = (ItemArmor) new ArmorGeneric("milathium_leggings", milathiumMat, EntityEquipmentSlot.LEGS, ItemsMod.milathium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_boots = (ItemArmor) new ArmorGeneric("milathium_boots", milathiumMat, EntityEquipmentSlot.FEET, ItemsMod.milathium_ingot).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);

		azurium_sword = (SwordGeneric) new SwordGeneric("azurium_sword", toolazuSword).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_pickaxe =   (PickaxeGeneric) new PickaxeGeneric("azurium_pickaxe", toolazuPickaxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_axe =   (AxeGeneric) new AxeGeneric("azurium_axe", toolazuAxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_spade =   (ShovelGeneric) new ShovelGeneric("azurium_spade", toolazuSpade).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_bow = (AzuriumBow) new AzuriumBow("azurium_bow", toolazuBow).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_sword = (SwordGeneric) new SwordGeneric("milathium_sword", toolmilaSword).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_pickaxe =   (PickaxeGeneric) new PickaxeGeneric("milathium_pickaxe", toolmilaPickaxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_axe =   (AxeGeneric) new AxeGeneric("milathium_axe", toolmilaAxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_shovel =   (ShovelGeneric) new ShovelGeneric("milathium_shovel", toolmilaSpade).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_bow = (MilathiumBow) new MilathiumBow("milathium_bow", toolmilaBow).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		heart_bone_bow = (HeartBoneBow) new HeartBoneBow("heart_bone_bow", toolheartBoneBow).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);

		diamond_apple = (ItemFood) new DiamondApple("diamond_apple", 10, 20).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		iron_apple = (ItemFood) new AppleEffectSet("iron_apple", 6, 4, 75, 11).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		lapis_apple = (ItemFood) new AppleEffectSet("lapis_apple", 6, 4, 150, 16).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		redstone_apple = (ItemFood) new AppleEffectSet("redstone_apple", 6, 4, 150, 1).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(dead_eye, heart_ender_piece, diamond_apple, iron_apple, lapis_apple, redstone_apple, azurium_ingot, azurium_nuggets, azurium_helmet, azurium_chestplate, 
		azurium_leggings, azurium_boots, azurium_sword, azurium_pickaxe, azurium_axe, azurium_spade, black_rod, azurium_bow, flint_and_azurium, purple_glowstone_dust, milathium, milathium_ingot,
		blue_magma_cream, milathium_helmet, milathium_chestplate, milathium_leggings, milathium_boots, milathium_sword, milathium_pickaxe, milathium_axe, milathium_shovel, heart_bone, 
		heart_bone_bow, milathium_bow);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(dead_eye);
		registerRender(heart_ender_piece);
		registerRender(diamond_apple);
		registerRender(iron_apple);
		registerRender(lapis_apple);
		registerRender(redstone_apple);
		registerRender(azurium_ingot);
		registerRender(azurium_nuggets);
		registerRender(azurium_helmet);
		registerRender(azurium_chestplate);
		registerRender(azurium_leggings);
		registerRender(azurium_boots);
		registerRender(azurium_sword);
		registerRender(azurium_pickaxe);
		registerRender(azurium_axe);
		registerRender(azurium_spade);
		registerRender(black_rod);
		registerRender(azurium_bow);
		registerRender(flint_and_azurium);
		registerRender(purple_glowstone_dust);
		registerRender(milathium);
		registerRender(milathium_ingot);
		registerRender(blue_magma_cream);
		registerRender(milathium_helmet);
		registerRender(milathium_chestplate);
		registerRender(milathium_leggings);
		registerRender(milathium_boots);
		registerRender(milathium_sword);
		registerRender(milathium_pickaxe);
		registerRender(milathium_axe);
		registerRender(milathium_shovel);
		registerRender(heart_bone);
		registerRender(heart_bone_bow);
		registerRender(milathium_bow);
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
		
	public static final ItemArmor.ArmorMaterial azuriumMat = EnumHelper.addArmorMaterial("azuriumMat", References.MODID + ":azurium_armor", HoeConfig.azuriumArmorDurability, new int[] {8, 9, 12, 10}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	public static final ItemArmor.ArmorMaterial milathiumMat = EnumHelper.addArmorMaterial("milathiumMat", References.MODID + ":milathium_armor", HoeConfig.milathiumArmorDurability, new int[] {11, 12, 19, 18}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0F);
	public static final ItemTool.ToolMaterial toolazuSword = EnumHelper.addToolMaterial("toolazuSword", 3, HoeConfig.azuriumToolDurability, 30.0F, 14.0F, 40);
	public static final ItemTool.ToolMaterial toolazuSpade = EnumHelper.addToolMaterial("toolazuSpade", 3, HoeConfig.azuriumToolDurability, 30.0F, 4.0F, 40);
	public static final ItemTool.ToolMaterial toolazuPickaxe = EnumHelper.addToolMaterial("toolazuPickaxe", 3, HoeConfig.azuriumToolDurability, 30.0F, 4.0F, 40);
	public static final ItemTool.ToolMaterial toolazuAxe = EnumHelper.addToolMaterial("toolazuAxe", 3, HoeConfig.azuriumToolDurability, 30.0F, 16.0F, 40);
	public static final ItemTool.ToolMaterial toolmilaSword = EnumHelper.addToolMaterial("toolmilaSword", 6, HoeConfig.milathiumToolDurability, 50.0F, 22.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaSpade = EnumHelper.addToolMaterial("toolmilaSpade", 6, HoeConfig.milathiumToolDurability, 50.0F, 12.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaPickaxe = EnumHelper.addToolMaterial("toolmilaPickaxe", 6, HoeConfig.milathiumToolDurability, 50.0F, 12.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaAxe = EnumHelper.addToolMaterial("toolmilaAxe", 6, HoeConfig.milathiumToolDurability, 50.0F, 24.0F, 20);
	public static final ItemBow.ToolMaterial toolazuBow = EnumHelper.addToolMaterial("toolazuBow", 3, HoeConfig.azuriumToolDurability, 30.0F, 14.0F, 40);
	public static final ItemBow.ToolMaterial toolmilaBow = EnumHelper.addToolMaterial("toolmilaBow", 6, HoeConfig.milathiumToolDurability, 30.0F, 22.0F, 20);
	public static final ItemBow.ToolMaterial toolheartBoneBow = EnumHelper.addToolMaterial("toolmilaBow", 0, HoeConfig.milathiumToolDurability, 30.0F, 22.0F, 20);
}