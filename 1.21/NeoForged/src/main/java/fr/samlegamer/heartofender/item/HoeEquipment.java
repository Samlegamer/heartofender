package fr.samlegamer.heartofender.item;

import java.util.EnumMap;
import java.util.List;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeEquipment
{
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, HeartofEnder.MODID);
	
	public static final Tier AZURIUM_TOOLS = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 3000, 30.0F, 14.0F, 40, () -> {return Ingredient.of(HoeItemsRegistry.AZURIUM_INGOT.get());});
	public static final Tier MILATHIUM_TOOLS = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 6000, 50.0F, 22.0F, 20, () -> {return Ingredient.of(HoeItemsRegistry.MILATHIUM_INGOT.get());});
	public static final Tier HEART_BONE_TOOLS = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1000, 8.0F, 3.0F, 10, () -> {return Ingredient.of(HoeItemsRegistry.HEART_BONE.get());});

	public static final Holder<ArmorMaterial> AZURIUM_ARMOR = ARMOR_MATERIALS.register("azurium", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		            map.put(ArmorItem.Type.BOOTS, 8);
		            map.put(ArmorItem.Type.LEGGINGS, 9);
		            map.put(ArmorItem.Type.CHESTPLATE, 12);
		            map.put(ArmorItem.Type.HELMET, 10);
		            map.put(ArmorItem.Type.BODY, 22);}),
		        50,
		        SoundEvents.ARMOR_EQUIP_DIAMOND,
		        () -> Ingredient.of(HoeItemsRegistry.AZURIUM_INGOT.get()),
		        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "azurium_armor"))),4.0f, 0.1f));
	
	public static final Holder<ArmorMaterial> MILATHIUM_ARMOR = ARMOR_MATERIALS.register("milathium", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 11);
        map.put(ArmorItem.Type.LEGGINGS, 12);
        map.put(ArmorItem.Type.CHESTPLATE, 19);
        map.put(ArmorItem.Type.HELMET, 18);
        map.put(ArmorItem.Type.BODY, 37);}),
	40,
    SoundEvents.ARMOR_EQUIP_GOLD,
    () -> Ingredient.of(HoeItemsRegistry.MILATHIUM_INGOT.get()),
    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "milathium_armor"))), 8.0f, 0.2f));
}