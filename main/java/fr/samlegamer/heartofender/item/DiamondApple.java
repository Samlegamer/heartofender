package fr.samlegamer.heartofender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DiamondApple extends ItemFood
{
	public DiamondApple(String name, int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		setRegistryName(name).setUnlocalizedName(name);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(22), itemUseDuration *125, 5));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), itemUseDuration *50, 4));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), itemUseDuration *125, 2));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), itemUseDuration *100, 2));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), itemUseDuration *100, 4));
	}
}