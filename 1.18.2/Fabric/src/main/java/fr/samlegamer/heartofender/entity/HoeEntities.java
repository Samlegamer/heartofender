package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.HeartofEnder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class HoeEntities
{	
	public static void AttributeInit()
	{
		FabricDefaultAttributeRegistry.register(HeartofEnder.HEART_BLAZE, HeartBlazeEntity.createBlazeAttributes());
		FabricDefaultAttributeRegistry.register(HeartofEnder.ENDER_KID, EnderKidEntity.createEndermanAttributes());
		FabricDefaultAttributeRegistry.register(HeartofEnder.HEART_GHAST, HeartGhastEntity.createGhastAttributes());
		FabricDefaultAttributeRegistry.register(HeartofEnder.BLUE_MAGMA_CUBE, BlueMagmaCubeEntity.createMagmaCubeAttributes());
		FabricDefaultAttributeRegistry.register(HeartofEnder.HEART_STRIDER, HeartStriderEntity.createStriderAttributes());

	}	
}