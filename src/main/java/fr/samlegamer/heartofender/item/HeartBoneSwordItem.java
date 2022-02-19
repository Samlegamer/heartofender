package fr.samlegamer.heartofender.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class HeartBoneSwordItem extends SwordItem
{
	public HeartBoneSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_)
	{
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
	{
		if(super.hurtEnemy(stack, target, attacker))
		{
			target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 3, false, true));
		}
		return false;
	}
}