package fr.samlegamer.heartofender.compat.aquaculture;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import fr.samlegamer.heartofender.utils.HoeItemUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import javax.annotation.Nonnull;

/*
 * Aquaculture Knifes (for Azurium and Milathium)
 * https://github.com/TeamMetallurgy/Aquaculture/blob/master/src/main/java/com/teammetallurgy/aquaculture/item/ItemFilletKnife.java
 */
public class FilletKnifeHoe extends SwordItem
{
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> attributes;

    public FilletKnifeHoe(Tier material)
    {
        super(material, 0, 0.0F, HoeItemUtils.TOOLS);
        this.attackDamage = material.getAttackDamageBonus() / 2;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.2F, AttributeModifier.Operation.ADDITION));
        this.attributes = builder.build();
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack, Enchantment enchantment)
    {
        return super.canApplyAtEnchantingTable(stack, enchantment) && canApplyEnchantment(enchantment);
    }

    private boolean canApplyEnchantment(Enchantment enchantment)
    {
        return enchantment != Enchantments.MOB_LOOTING && enchantment != Enchantments.SWEEPING_EDGE;
    }

    @Override
    public float getDamage()
    {
        return this.attackDamage;
    }

    @Override
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlot slotType)
    {
        return slotType == EquipmentSlot.MAINHAND ? this.attributes : ImmutableMultimap.of();
    }
}