package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodsPropertiesHoe
{
	public static final Item.Properties DIAMOND_APPLE = new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)
			.food(new Food.Builder().nutrition(10).saturationMod(15.0F)
			.effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 100 * 30, 4), 1.0f)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 125 * 30, 5), 1.0f)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 125 * 30, 1), 1.0f)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 50 * 30, 4), 1.0f)
            .effect(() -> new EffectInstance(Effects.DIG_SPEED, 100 * 30, 2), 1.0f).build());
	
	public static final Item.Properties IRON_APPLE = new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)
            .food(new Food.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 75 * 30, 0), 1.0f).build());
	
	public static final Item.Properties LAPIS_APPLE = new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)
            .food(new Food.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 150 * 30, 0), 1.0f).build());

	public static final Item.Properties REDSTONE_APPLE = new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS)
            .food(new Food.Builder().nutrition(6).saturationMod(4.0F).alwaysEat()
            .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 150 * 30, 0), 1.0f).build());
}