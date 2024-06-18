package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DiamondAppleItem extends Item
{	
	public DiamondAppleItem()
	{
		super(new Item.Properties().tab(HeartofEnder.TAB_ITEMS)
		.food(new FoodProperties.Builder().nutrition(10).saturationMod(15.0F)
		.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100 * 30, 4), 1.0f)
		.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 125 * 30, 5), 1.0f)
		.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 125 * 30, 1), 1.0f)
		.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50 * 30, 4), 1.0f)
		.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100 * 30, 2), 1.0f).build()));
	}
	
	@Override
	public boolean isFoil(ItemStack p_41453_)
	{
		return HoeConfig.FoilDiamondApple;
	}
}