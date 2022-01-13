package fr.samlegamer.heartofender.utils;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class HoeItemUtils
{
	public static final Item.Properties BASE = new Item.Properties().stacksTo(64).tab(HeartofEnder.TAB_ITEMS);
	
	public static final Item.Properties ARMORS = new Item.Properties().stacksTo(1).tab(HeartofEnder.TAB_ITEMS);
	public static final Item.Properties TOOLS = new Item.Properties().stacksTo(1).tab(HeartofEnder.TAB_ITEMS);
	
	/*
	public static final Item.Properties DIAMOND_APPLE = new Item.Properties().tab(HeartofEnder.TAB_ITEMS)
			.food(new FoodProperties.Builder().nutrition(10).saturationMod(15.0F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100 * 30, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 125 * 30, 5), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 125 * 30, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50 * 30, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100 * 30, 2), 1.0f).build());
	*/
	
	public static final Item.Properties IRON_APPLE = new Item.Properties().tab(HeartofEnder.TAB_ITEMS)
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75 * 30, 0), 1.0f).build());
	
	public static final Item.Properties LAPIS_APPLE = new Item.Properties().tab(HeartofEnder.TAB_ITEMS)
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 150 * 30, 0), 1.0f).build());

	public static final Item.Properties REDSTONE_APPLE = new Item.Properties().tab(HeartofEnder.TAB_ITEMS)
            .food(new FoodProperties.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150 * 30, 0), 1.0f).build());
}