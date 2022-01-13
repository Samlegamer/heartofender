package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.HashMap;

/*
 * Inspired by Ice and Fire 
 */
@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HoeEntityRegistry
{
	public static final EntityType<EnderKid> ENDER_KID = registerEntity(EntityType.Builder.of(EnderKid::new, MobCategory.MONSTER).sized(0.6F, 1.8F).fireImmune().setCustomClientFactory(EnderKid::new).canSpawnFarFromPlayer(), "ender_kid");
	public static final EntityType<HeartBlaze> HEART_BLAZE = registerEntity(EntityType.Builder.of(HeartBlaze::new, MobCategory.MONSTER).fireImmune().sized(1.0f, 2.0f).setCustomClientFactory(HeartBlaze::new).canSpawnFarFromPlayer(), "heart_blaze");
	//public static final EntityType<HeartGhastEntity> HEART_GHAST = registerEntity(EntityType.Builder.of(HeartGhastEntity::new, EntityClassification.MONSTER).fireImmune().sized(4.0F, 4.0F).setCustomClientFactory(HeartGhastEntity::new).canSpawnFarFromPlayer(), "heart_ghast");
	//public static final EntityType<BlueMagmaCubeEntity> BLUE_MAGMA_CUBE = registerEntity(EntityType.Builder.of(BlueMagmaCubeEntity::new, EntityClassification.MONSTER).fireImmune().sized(2.04F, 2.04F).clientTrackingRange(8).setCustomClientFactory(BlueMagmaCubeEntity::new).canSpawnFarFromPlayer(), "blue_magma_cube");
	//public static final EntityType<HeartSkeletonEntity> HEART_SKELETON = registerEntity(EntityType.Builder.of(HeartSkeletonEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.7F, 2.4F).clientTrackingRange(8).setCustomClientFactory(HeartSkeletonEntity::new).canSpawnFarFromPlayer(), "heart_skeleton");
	//public static final EntityType<HerobrineEntity> HEROBRINE = registerEntity(EntityType.Builder.of(HerobrineEntity::new, EntityClassification.CREATURE).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(128).setCustomClientFactory(HerobrineEntity::new).canSpawnFarFromPlayer(), "herobrine");

	@SuppressWarnings("rawtypes")
	private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        ResourceLocation nameLoc = new ResourceLocation(HeartofEnder.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }
	
	@SuppressWarnings("rawtypes")
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
	{
		try {
        for (Field f : HoeEntityRegistry.class.getDeclaredFields()) {
            Object obj = f.get(null);
            if (obj instanceof EntityType) {
                event.getRegistry().register((EntityType) obj);
            } else if (obj instanceof EntityType[]) {
                for (EntityType type : (EntityType[]) obj) {
                    event.getRegistry().register(type);

                }
            }
        }
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}

    public static HashMap<String, Boolean> LOADED_ENTITIES;
    static {
    	LOADED_ENTITIES = new HashMap<String, Boolean>();
    }
	
    @SubscribeEvent
    public static void bakeAttributes(EntityAttributeCreationEvent creationEvent)
    {
        creationEvent.put(ENDER_KID, EnderKid.createAttributes().build());
        creationEvent.put(HEART_BLAZE, HeartBlaze.createAttributes().build());

    }
}