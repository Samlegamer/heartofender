package fr.samlegamer.heartofender.item;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum HoeTiers implements ToolMaterial
{
    AZURIUM_TOOLS(5, 3000, 30.0F, 14.0F, 40, () -> {return Ingredient.ofItems(HoeItems.AZURIUM_INGOT);}),
    MILATHIUM_TOOLS(6, 6000, 50.0F, 22.0F, 20, () -> {return Ingredient.ofItems(HoeItems.MILATHIUM_INGOT);}),
    HEART_BONE(4, 1000, 8.0F, 3.0F, 10, () -> {return Ingredient.ofItems(HoeItems.HEART_BONE);});

	private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private HoeTiers(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

	   @Override
	    public int getDurability() {
	        return this.itemDurability;
	    }

	    @Override
	    public float getMiningSpeedMultiplier() {
	        return this.miningSpeed;
	    }

	    @Override
	    public float getAttackDamage() {
	        return this.attackDamage;
	    }

	    @Override
	    public int getMiningLevel() {
	        return this.miningLevel;
	    }

	    @Override
	    public int getEnchantability() {
	        return this.enchantability;
	    }

	    @Override
	    public Ingredient getRepairIngredient() {
	        return this.repairIngredient.get();
	    }
}