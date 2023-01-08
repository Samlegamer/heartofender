package fr.samlegamer.heartofender.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MilathiumArmor extends ArmorItem
{
	public MilathiumArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties)
	{
		super(pMaterial, pSlot, pProperties);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player)
	{
		MobEffectInstance EFF = new MobEffectInstance(MobEffects.FIRE_RESISTANCE,  10 * 15, 0);
		if(!player.hasEffect(EFF.getEffect()))
		{
			player.addEffect(EFF);
		}
		
		if(player.isOnFire())
        {
			player.clearFire();
        }
	}
}