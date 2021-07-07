package fr.samlegamer.heartofender.inits;

import java.util.ArrayList;
import java.util.List;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityBlueMagmaBlock;
import fr.samlegamer.heartofender.entity.EntityEnderKid;
import fr.samlegamer.heartofender.entity.EntityHeartBlaze;
import fr.samlegamer.heartofender.entity.EntityHeartGhast;
import fr.samlegamer.heartofender.entity.EntityHeartSkeleton;
import fr.samlegamer.heartofender.entity.EntityHerobrine;
import fr.samlegamer.heartofender.entity.render.RenderEnderKid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitiesMod
{
	public static void registerEntities()
	{
		registerEntity("enderkid", EntityEnderKid.class, References.ENDER_KID, 50, 1447468, 657930);
		registerEntity("herobrine", EntityHerobrine.class, References.HEROBRINE, 20, 3741696, 16777215);
		registerEntity("heartghast", EntityHeartGhast.class, References.HEART_GHAST, 100, 11979231, 27616);
		registerEntity("heartblaze", EntityHeartBlaze.class, References.HEART_BLAZE, 50, 20224, 5120);
		registerEntity("bluemagmablock", EntityBlueMagmaBlock.class, References.BLUE_MAGMA_BLOCK, 30, 18342, 819);
		registerEntity("heartskeleton", EntityHeartSkeleton.class, References.HEART_SKELETON, 50, 7674912, 3939360);
	}
	
	 private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int firstcolor, int secondcolor)
	 {
		 EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name), entity, name, id, HeartofEnder.instance, range, 1, true, firstcolor, secondcolor);
	 }
}