package fr.samlegamer.heartofender.utils;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class HoeItemUtils
{
	public static final Item.Properties BASE = new Item.Properties().stacksTo(64);
	public static final Item.Properties ARMORS = new Item.Properties().stacksTo(1);
	public static final Item.Properties TOOLS = new Item.Properties().stacksTo(1);
	
	public static final Item.Properties IRON_APPLE = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationModifier(4.0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 75 * 30, 0), 1.0f).build());
	
	public static final Item.Properties LAPIS_APPLE = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationModifier(4.0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 150 * 30, 0), 1.0f).build());

	public static final Item.Properties REDSTONE_APPLE = new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationModifier(4.0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150 * 30, 0), 1.0f).build());
}