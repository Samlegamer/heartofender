package fr.samlegamer.heartofender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class IronApple extends ItemFood
{
	public IronApple(String name, int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.setAlwaysEdible();
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), itemUseDuration *75, 0));
	}
}