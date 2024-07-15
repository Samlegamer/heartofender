package fr.samlegamer.heartofender.item;

import java.util.function.Supplier;

import fr.samlegamer.heartofender.HeartofEnder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum HoeArmors implements ArmorMaterial
{
	AZURIUM_ARMOR(HeartofEnder.MODID + ":azurium_armor", 250, new int[]{8, 9, 12, 10}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0f, 0.0f, () -> {
        return Ingredient.ofItems(HoeItems.AZURIUM_INGOT);
    }),
    MILATHIUM_ARMOR(HeartofEnder.MODID + ":milathium_armor", 500, new int[]{11, 12, 19, 18}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0f, 0.0f, () -> {
        return Ingredient.ofItems(HoeItems.MILATHIUM_INGOT);});
        
        private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final float knockbackResistance;
        private final Lazy<Ingredient> repairMaterial;

        HoeArmors(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairMaterial = new Lazy<>(repairMaterial);
        }

        @Override
        public int getDurability(EquipmentSlot slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getEntitySlotId()] * this.maxDamageFactor;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slotIn) {
            return this.damageReductionAmountArray[slotIn.getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairMaterial.get();
        }

        @Override
        public String getName() {
            return this.name;
        }

        public float getToughness() {
            return this.toughness;
        }
        
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
}


