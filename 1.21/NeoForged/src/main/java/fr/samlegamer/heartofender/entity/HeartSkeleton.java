package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HeartSkeleton extends WitherSkeleton
{
	   public HeartSkeleton(EntityType<HeartSkeleton> typeentity, Level world)
	   {
		   super(typeentity, world);
		   this.xpReward = 16;
	   }
	   
	   public static AttributeSupplier.Builder createAttributes()
	   {
		   return Monster.createMonsterAttributes()
				   .add(Attributes.MAX_HEALTH, 35.0D)
				   .add(Attributes.ARMOR, 13.0D)
				   .add(Attributes.ATTACK_DAMAGE, 15.0D)
				   .add(Attributes.MOVEMENT_SPEED, 0.30000003192092898D)
				   .add(Attributes.FOLLOW_RANGE, 64.0D);
	   }


		   protected void populateDefaultEquipmentSlots(DifficultyInstance p_34172_)
		   {
		      this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(HoeItemsRegistry.AZURIUM_AXE.get()));
		   }

		   public boolean doHurtTarget(Entity p_34169_) {
		      if (!super.doHurtTarget(p_34169_)) {
		         return false;
		      } else {
		         if (p_34169_ instanceof LivingEntity) {
		            ((LivingEntity)p_34169_).addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 2), this);
		         }

		         return true;
		      }
		   }

		   public boolean canBeAffected(MobEffectInstance p_34192_) {
		      return p_34192_.getEffect() == MobEffects.WITHER ? false : super.canBeAffected(p_34192_);
		   }
}