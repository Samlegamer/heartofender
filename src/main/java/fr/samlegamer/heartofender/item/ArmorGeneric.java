package fr.samlegamer.heartofender.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorGeneric extends ItemArmor
{
	public final Item Ingot;
	
	public ArmorGeneric(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, Item item)
	{
		super(materialIn, materialIn.getDamageReductionAmount(equipmentSlotIn), equipmentSlotIn);
		Ingot = item;
		setRegistryName(name);
		setUnlocalizedName(name);
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == Ingot)
        {
            return true;
        }
        return false;
    }
}