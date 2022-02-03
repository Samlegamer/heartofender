package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.utils.config.HoeConfig;
import net.minecraft.item.ItemBow;

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