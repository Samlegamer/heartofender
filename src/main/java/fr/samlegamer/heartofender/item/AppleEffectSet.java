package fr.samlegamer.heartofender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AppleEffectSet extends ItemFood
{	
	public final int multiplier;
	public final int effectID;
	
	public AppleEffectSet(String name, int amount, float saturation, int multi, int idEffect)
	{
		super(amount, false);
		setRegistryName(name);
		setUnlocalizedName(name);
		multiplier = multi;
		effectID = idEffect;
		setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(effectID), itemUseDuration *multiplier, 0));
	}
}