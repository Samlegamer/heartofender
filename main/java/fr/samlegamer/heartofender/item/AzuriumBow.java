package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.utils.config.HoeConfig;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class AzuriumBow extends ItemBow
{
	public AzuriumBow(String name, ToolMaterial toolBow)
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		this.maxStackSize = 1;
        this.setMaxDamage(HoeConfig.azuriumToolDurability);
	}
}