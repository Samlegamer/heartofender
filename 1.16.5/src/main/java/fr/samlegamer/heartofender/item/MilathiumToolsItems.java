package fr.samlegamer.heartofender.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.inits.ModItems;


public enum MilathiumToolsItems implements IItemTier {
    MILATHIUM_TOOLS(6, HoeConfig.MilathiumToolDurability, 50.0F, 22.0F, HoeConfig.MilathiumToolEnchantability, new LazyValue<>(() -> {return Ingredient.of(ModItems.MILATHIUM_INGOT.get());}));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    MilathiumToolsItems(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, LazyValue<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}