package fr.samlegamer.heartofender.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MilathiumArmor extends ArmorItem
{
	public MilathiumArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties)
	{
		super(pMaterial, pType, pProperties);
	}

	@Override
	public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
		MobEffectInstance EFF = new MobEffectInstance(MobEffects.FIRE_RESISTANCE,  10 * 15, 0);
		if(!pLivingEntity.hasEffect(EFF.getEffect()))
		{
			pLivingEntity.addEffect(EFF);
		}
		
		if(pLivingEntity.isOnFire())
        {
			pLivingEntity.clearFire();
        }
	}
}