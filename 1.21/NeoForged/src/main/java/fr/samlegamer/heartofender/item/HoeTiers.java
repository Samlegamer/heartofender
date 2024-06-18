package fr.samlegamer.heartofender.item;

import java.util.function.Supplier;

import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum HoeTiers implements Tier
{
    AZURIUM_TOOLS(5, 3000, 30.0F, 14.0F, 40, () -> {return Ingredient.of(HoeItemsRegistry.AZURIUM_INGOT.get());}),
    MILATHIUM_TOOLS(6, 6000, 50.0F, 22.0F, 20, () -> {return Ingredient.of(HoeItemsRegistry.MILATHIUM_INGOT.get());}),
    HEART_BONE(4, 1000, 8.0F, 3.0F, 10, () -> {return Ingredient.of(HoeItemsRegistry.HEART_BONE.get());});

	   private final int level;
	   private final int uses;
	   private final float speed;
	   private final float damage;
	   private final int enchantmentValue;
	   private final LazyLoadedValue<Ingredient> repairIngredient;

	   private HoeTiers(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
	      this.level = p_43332_;
	      this.uses = p_43333_;
	      this.speed = p_43334_;
	      this.damage = p_43335_;
	      this.enchantmentValue = p_43336_;
	      this.repairIngredient = new LazyLoadedValue<>(p_43337_);
	   }

	   public int getUses() {
		      return this.uses;
		   }

		   public float getSpeed() {
		      return this.speed;
		   }

		   public float getAttackDamageBonus() {
		      return this.damage;
		   }

		   public int getLevel() {
		      return this.level;
		   }

		   public int getEnchantmentValue() {
		      return this.enchantmentValue;
		   }

		   public Ingredient getRepairIngredient() {
		      return this.repairIngredient.get();
		   }

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			// TODO Auto-generated method stub
			return null;
		}
}