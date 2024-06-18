package fr.samlegamer.heartofender.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.function.Supplier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public enum HoeArmors implements ArmorMaterial
{
    AZURIUM_ARMOR(HeartofEnder.MODID + ":azurium_armor", 250, new int[]{8, 9, 12, 10}, 50, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0f, 0.0f, () -> {
        return Ingredient.of(HoeItemsRegistry.AZURIUM_INGOT.get());
    }),
    MILATHIUM_ARMOR(HeartofEnder.MODID + ":milathium_armor", 500, new int[]{11, 12, 19, 18}, 40, SoundEvents.ARMOR_EQUIP_GOLD, 8.0f, 0.0f, () -> {
        return Ingredient.of(HoeItemsRegistry.MILATHIUM_INGOT.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    HoeArmors(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }

    @OnlyIn(Dist.CLIENT)
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