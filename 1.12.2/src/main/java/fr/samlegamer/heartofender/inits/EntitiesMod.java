package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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