package fr.samlegamer.heartofender.core;

import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.entity.*;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

//@EventBusSubscriber(modid = HeartofEnder.MODID, bus = Bus.MOD)
public class HoeEvents
{
	
	/*@SubscribeEvent
	public static void mkPortal(RightClickBlock event)
	{		
		if(!event.getItemStack().isEmpty() && event.getItemStack().getItem() instanceof FlintAndAzuriumItem)
		{
			if(GelPortalLogic.fillPortal(event.getWorld(), event.getPos().relative(event.getFace()), (HOEPortal) HoeBlocksRegistry.HOE_PORTAL.get(), ImmutableList.of(Blocks.AIR)))
			{
				ItemStack item = event.getItemStack();
				Player player = event.getPlayer();

				event.setCanceled(true);
				player.playSound(SoundEvents.FLINTANDSTEEL_USE, 1.0F, 1.0F);
				player.swing(event.getHand());
				
				
				
				if(!player.isCreative())
				{
					if(item.getItem() instanceof FlintAndAzuriumItem)
					{
						item.setDamageValue(1);
					}
				}
			}
		}
		
		if(!event.getItemStack().isEmpty() && event.getItemStack().getItem() instanceof GreenFireChargeItem)
		{
			if(GelPortalLogic.fillPortal(event.getWorld(), event.getPos().relative(event.getFace()), (HOEPortal) HoeBlocksRegistry.HOE_PORTAL.get(), ImmutableList.of(Blocks.AIR)))
			{
				ItemStack item = event.getItemStack();
				Player player = event.getPlayer();

				event.setCanceled(true);
				player.playSound(SoundEvents.FIRE_AMBIENT, 1.0F, 1.0F);
				player.swing(event.getHand());
				
				if(!player.isCreative())
				{
					if(item.getItem() instanceof GreenFireChargeItem)
					{
						item.isEmpty();
					}
				}
			}
		}
		
		if(!event.getItemStack().isEmpty() && event.getItemStack().getItem() instanceof FlintAndMilathiumItem)
		{
			if(GelPortalLogic.fillPortal(event.getWorld(), event.getPos().relative(event.getFace()), (HOEPortal) HoeBlocksRegistry.HOE_PORTAL.get(), ImmutableList.of(Blocks.AIR)))
			{
				ItemStack item = event.getItemStack();
				Player player = event.getPlayer();

				event.setCanceled(true);
				player.playSound(SoundEvents.FLINTANDSTEEL_USE, 1.0F, 1.0F);
				player.swing(event.getHand());
				
				
				
				if(!player.isCreative())
				{
					if(item.getItem() instanceof FlintAndMilathiumItem)
					{
						item.setDamageValue(1);
					}
				}
			}
		}
	}*/
}