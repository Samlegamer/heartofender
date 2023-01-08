package fr.samlegamer.heartofender.core;

import com.google.common.collect.ImmutableList;
import com.legacy.structure_gel.api.dimension.portal.GelPortalLogic;
import fr.samlegamer.heartofender.block.HOEPortal;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.item.FlintAndAzuriumItem;
import fr.samlegamer.heartofender.item.FlintAndMilathiumItem;
import fr.samlegamer.heartofender.item.GreenFireChargeItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HoeEvents
{
	@SubscribeEvent
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
	}
}