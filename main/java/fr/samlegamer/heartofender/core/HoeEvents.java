package fr.samlegamer.heartofender.core;

import com.google.common.collect.ImmutableList;
import com.legacy.structure_gel.blocks.GelPortalBlock;

import fr.samlegamer.heartofender.block.HeartofEnderPortal;
import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.item.FlintandAzuriumItem;
import fr.samlegamer.heartofender.item.GreenFireChargeItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HoeEvents
{	
	@SubscribeEvent
	public static void mkPortal(RightClickBlock event)
	{		
		if(!event.getItemStack().isEmpty() && event.getItemStack().getItem() instanceof FlintandAzuriumItem)
		{
			if(GelPortalBlock.fillPortal(event.getWorld(), event.getPos().relative(event.getFace()), (HeartofEnderPortal) ModBlocks.HEART_OF_ENDER_PORTAL.get(), ImmutableList.of(Blocks.AIR)))
			{
				ItemStack item = event.getItemStack();
				PlayerEntity player = event.getPlayer();

				event.setCanceled(true);
				player.playSound(SoundEvents.FLINTANDSTEEL_USE, 1.0F, 1.0F);
				player.swing(event.getHand());
				
				
				
				if(!player.isCreative())
				{
					if(item.getItem() instanceof FlintandAzuriumItem)
					{
						item.setDamageValue(1);
					}
				}
			}
		}
		
		if(!event.getItemStack().isEmpty() && event.getItemStack().getItem() instanceof GreenFireChargeItem)
		{
			if(GelPortalBlock.fillPortal(event.getWorld(), event.getPos().relative(event.getFace()), (HeartofEnderPortal) ModBlocks.HEART_OF_ENDER_PORTAL.get(), ImmutableList.of(Blocks.AIR)))
			{
				ItemStack item = event.getItemStack();
				PlayerEntity player = event.getPlayer();

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
	}
}