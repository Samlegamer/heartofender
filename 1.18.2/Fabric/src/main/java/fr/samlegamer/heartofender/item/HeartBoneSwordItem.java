package fr.samlegamer.heartofender.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class HeartBoneSwordItem extends SwordItem
{
	public HeartBoneSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings)
	{
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
	{
		if(super.postHit(stack, target, attacker))
		{
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 3, false, true));
		}
		return false;
	}
}