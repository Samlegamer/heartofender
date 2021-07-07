package fr.samlegamer.heartofender.inits;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.item.AzuriumAxe;
import fr.samlegamer.heartofender.item.AzuriumBoots;
import fr.samlegamer.heartofender.item.AzuriumBow;
import fr.samlegamer.heartofender.item.AzuriumChestplate;
import fr.samlegamer.heartofender.item.AzuriumHelmet;
import fr.samlegamer.heartofender.item.AzuriumLeggings;
import fr.samlegamer.heartofender.item.AzuriumPickaxe;
import fr.samlegamer.heartofender.item.AzuriumSpade;
import fr.samlegamer.heartofender.item.AzuriumSword;
import fr.samlegamer.heartofender.item.BlackArrow;
import fr.samlegamer.heartofender.item.DiamondApple;
import fr.samlegamer.heartofender.item.FlintAndAzurium;
import fr.samlegamer.heartofender.item.IronApple;
import fr.samlegamer.heartofender.item.ItemHeartSkeletonSkull;
import fr.samlegamer.heartofender.item.ItemMod;
import fr.samlegamer.heartofender.item.LapisApple;
import fr.samlegamer.heartofender.item.MilathiumAxe;
import fr.samlegamer.heartofender.item.MilathiumBoots;
import fr.samlegamer.heartofender.item.MilathiumChestplate;
import fr.samlegamer.heartofender.item.MilathiumHelmet;
import fr.samlegamer.heartofender.item.MilathiumLeggings;
import fr.samlegamer.heartofender.item.MilathiumPickaxe;
import fr.samlegamer.heartofender.item.MilathiumShovel;
import fr.samlegamer.heartofender.item.MilathiumSword;
import fr.samlegamer.heartofender.item.RedstoneApple;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.capability.ItemFluidContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ItemsMod
{
	public static Item dead_eye;
	public static Item heart_ender_piece;
	public static Item azurium_ingot;
	public static Item azurium_nuggets;
	public static ItemFood diamond_apple;
	public static ItemArmor azurium_helmet;
	public static ItemArmor azurium_chestplate;
	public static ItemArmor azurium_leggings;
	public static ItemArmor azurium_boots;
	public static AzuriumSword azurium_sword;
	public static AzuriumPickaxe azurium_pickaxe;
	public static AzuriumAxe azurium_axe;
	public static AzuriumSpade azurium_spade;
	public static Item black_rod;
	public static AzuriumBow azurium_bow;
	public static ItemFood iron_apple;
	public static ItemFood lapis_apple;
	public static ItemFood redstone_apple;
	public static FlintAndAzurium flint_and_azurium;
	public static Item purple_glowstone_dust;
	public static Item blue_magma_cream;
	public static Item milathium;
	public static Item milathium_ingot;
	
	public static MilathiumHelmet milathium_helmet;
	public static MilathiumChestplate milathium_chestplate;
	public static MilathiumLeggings milathium_leggings;
	public static MilathiumBoots milathium_boots;
	
	public static MilathiumSword milathium_sword;
	public static MilathiumPickaxe milathium_pickaxe;
	public static MilathiumAxe milathium_axe;
	public static MilathiumShovel milathium_shovel;
	
	public static ItemHeartSkeletonSkull heart_skeleton_skull_item;
	
	//public static Item heart_wart;
	//public static BlackArrow black_arrow;
	
	public static void init()
	{
		dead_eye = new ItemMod("dead_eye").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		heart_ender_piece = new ItemMod("heart_ender_piece").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		diamond_apple = (ItemFood) new DiamondApple("diamond_apple", 10, 20, false).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		iron_apple = (ItemFood) new IronApple("iron_apple", 6, 4, false).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		lapis_apple = (ItemFood) new LapisApple("lapis_apple", 6, 4, false).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		redstone_apple = (ItemFood) new RedstoneApple("redstone_apple", 6, 4, false).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_ingot = new ItemMod("azurium_ingot").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_nuggets = new ItemMod("azurium_nuggets").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_helmet = (ItemArmor) new AzuriumHelmet("azurium_helmet", azuriumMat, EntityEquipmentSlot.HEAD).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_chestplate = (ItemArmor) new AzuriumChestplate("azurium_chestplate", azuriumMat, EntityEquipmentSlot.CHEST).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_leggings = (ItemArmor) new AzuriumLeggings("azurium_leggings", azuriumMat, EntityEquipmentSlot.LEGS).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_boots = (ItemArmor) new AzuriumBoots("azurium_boots", azuriumMat, EntityEquipmentSlot.FEET).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_sword = (AzuriumSword) new AzuriumSword("azurium_sword", toolazuSword).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_pickaxe =   (AzuriumPickaxe) new AzuriumPickaxe("azurium_pickaxe", toolazuPickaxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_axe =   (AzuriumAxe) new AzuriumAxe("azurium_axe", toolazuAxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_spade =   (AzuriumSpade) new AzuriumSpade("azurium_spade", toolazuSpade).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		black_rod = new ItemMod("black_rod").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		azurium_bow = (AzuriumBow) new AzuriumBow("azurium_bow", toolazuBow).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		flint_and_azurium = (FlintAndAzurium) new FlintAndAzurium("flint_and_azurium").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		purple_glowstone_dust = new ItemMod("purple_glowstone_dust").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium = new ItemMod("milathium").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_ingot = new ItemMod("milathium_ingot").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		blue_magma_cream = new ItemMod("blue_magma_cream").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);

		milathium_helmet = (MilathiumHelmet) new MilathiumHelmet("milathium_helmet", milathiumMat, EntityEquipmentSlot.HEAD).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_chestplate = (MilathiumChestplate) new MilathiumChestplate("milathium_chestplate", milathiumMat, EntityEquipmentSlot.CHEST).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_leggings = (MilathiumLeggings) new MilathiumLeggings("milathium_leggings", milathiumMat, EntityEquipmentSlot.LEGS).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_boots = (MilathiumBoots) new MilathiumBoots("milathium_boots", milathiumMat, EntityEquipmentSlot.FEET).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		
		milathium_sword = (MilathiumSword) new MilathiumSword("milathium_sword", toolmilaSword).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_pickaxe =   (MilathiumPickaxe) new MilathiumPickaxe("milathium_pickaxe", toolmilaPickaxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_axe =   (MilathiumAxe) new MilathiumAxe("milathium_axe", toolmilaAxe).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		milathium_shovel =   (MilathiumShovel) new MilathiumShovel("milathium_shovel", toolmilaSpade).setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);

		heart_skeleton_skull_item = (ItemHeartSkeletonSkull) new ItemHeartSkeletonSkull("heart_skeleton_skull_item").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		
		//heart_wart = new ItemMod("heart_wart").setCreativeTab(HeartofEnder.CREATIVE_TAB_ITEMS);
		//black_arrow = (BlackArrow) new BlackArrow("black_arrow");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(dead_eye);
		event.getRegistry().registerAll(heart_ender_piece);
		event.getRegistry().registerAll(diamond_apple);
		event.getRegistry().registerAll(iron_apple);
		event.getRegistry().registerAll(lapis_apple);
		event.getRegistry().registerAll(redstone_apple);
		event.getRegistry().registerAll(azurium_ingot);
		event.getRegistry().registerAll(azurium_nuggets);
		event.getRegistry().registerAll(azurium_helmet);
		event.getRegistry().registerAll(azurium_chestplate);
		event.getRegistry().registerAll(azurium_leggings);
		event.getRegistry().registerAll(azurium_boots);
		event.getRegistry().registerAll(azurium_sword);
		event.getRegistry().registerAll(azurium_pickaxe);
		event.getRegistry().registerAll(azurium_axe);
		event.getRegistry().registerAll(azurium_spade);
		event.getRegistry().registerAll(black_rod);
		event.getRegistry().registerAll(azurium_bow);
		event.getRegistry().registerAll(flint_and_azurium);
		event.getRegistry().registerAll(purple_glowstone_dust);
		event.getRegistry().registerAll(milathium);
		event.getRegistry().registerAll(milathium_ingot);
		event.getRegistry().registerAll(blue_magma_cream);
		event.getRegistry().registerAll(milathium_helmet);
		event.getRegistry().registerAll(milathium_chestplate);
		event.getRegistry().registerAll(milathium_leggings);
		event.getRegistry().registerAll(milathium_boots);
		event.getRegistry().registerAll(milathium_sword);
		event.getRegistry().registerAll(milathium_pickaxe);
		event.getRegistry().registerAll(milathium_axe);
		event.getRegistry().registerAll(milathium_shovel);
		event.getRegistry().registerAll(heart_skeleton_skull_item);

		//event.getRegistry().registerAll(heart_wart);
		//event.getRegistry().registerAll(black_arrow);
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
		registerRender(heart_skeleton_skull_item);

		//registerRender(heart_wart);
		//registerRender(black_arrow);
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
		
	public static final ItemArmor.ArmorMaterial azuriumMat = EnumHelper.addArmorMaterial("azuriumMat", References.MODID + ":azurium_armor", 250, new int[] {8, 9, 12, 10}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	public static final ItemArmor.ArmorMaterial milathiumMat = EnumHelper.addArmorMaterial("milathiumMat", References.MODID + ":milathium_armor", 500, new int[] {11, 12, 19, 18}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0F);
	public static final ItemTool.ToolMaterial toolazuSword = EnumHelper.addToolMaterial("toolazuSword", 3, 3000, 30.0F, 14.0F, 40);
	public static final ItemTool.ToolMaterial toolazuSpade = EnumHelper.addToolMaterial("toolazuSpade", 3, 3000, 30.0F, 4.0F, 40);
	public static final ItemTool.ToolMaterial toolazuPickaxe = EnumHelper.addToolMaterial("toolazuPickaxe", 3, 3000, 30.0F, 4.0F, 40);
	public static final ItemTool.ToolMaterial toolazuAxe = EnumHelper.addToolMaterial("toolazuAxe", 3, 3000, 30.0F, 16.0F, 40);
	
	public static final ItemTool.ToolMaterial toolmilaSword = EnumHelper.addToolMaterial("toolmilaSword", 6, 6000, 50.0F, 22.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaSpade = EnumHelper.addToolMaterial("toolmilaSpade", 6, 6000, 50.0F, 12.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaPickaxe = EnumHelper.addToolMaterial("toolmilaPickaxe", 6, 6000, 50.0F, 12.0F, 20);
	public static final ItemTool.ToolMaterial toolmilaAxe = EnumHelper.addToolMaterial("toolmilaAxe", 6, 6000, 50.0F, 24.0F, 20);
	
	public static final ItemBow.ToolMaterial toolazuBow = EnumHelper.addToolMaterial("toolazuBow", 3, 3000, 30.0F, 14.0F, 40);
	public static final ItemTool.ToolMaterial toolboneBow = EnumHelper.addToolMaterial("toolboneBow", 3, 3000, 30.0F, 6.0F, 10);
}