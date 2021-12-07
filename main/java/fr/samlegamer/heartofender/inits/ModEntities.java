package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.BlueMagmaCubeEntity;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import fr.samlegamer.heartofender.entity.HeartBlazeEntity;
import fr.samlegamer.heartofender.entity.HeartGhastEntity;
import fr.samlegamer.heartofender.entity.HeartSkeletonEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities
{
	@SuppressWarnings("unchecked")
	public static final EntityType<HeartBlazeEntity> HEART_BLAZE = registerEntity(EntityType.Builder.of(HeartBlazeEntity::new, EntityClassification.MONSTER).fireImmune().sized(1.0f, 2.0f).setCustomClientFactory(HeartBlazeEntity::new).canSpawnFarFromPlayer(), "heart_blaze");
	@SuppressWarnings("unchecked")
	public static final EntityType<EnderKidEntity> ENDER_KID = registerEntity(EntityType.Builder.of(EnderKidEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).setCustomClientFactory(EnderKidEntity::new).canSpawnFarFromPlayer(), "ender_kid");
	@SuppressWarnings("unchecked")
	public static final EntityType<HeartGhastEntity> HEART_GHAST = registerEntity(EntityType.Builder.of(HeartGhastEntity::new, EntityClassification.MONSTER).fireImmune().sized(4.0F, 4.0F).setCustomClientFactory(HeartGhastEntity::new).canSpawnFarFromPlayer(), "heart_ghast");
	@SuppressWarnings("unchecked")
	public static final EntityType<BlueMagmaCubeEntity> BLUE_MAGMA_CUBE = registerEntity(EntityType.Builder.of(BlueMagmaCubeEntity::new, EntityClassification.MONSTER).fireImmune().sized(2.04F, 2.04F).clientTrackingRange(8).setCustomClientFactory(BlueMagmaCubeEntity::new).canSpawnFarFromPlayer(), "blue_magma_cube");
	@SuppressWarnings("unchecked")
	public static final EntityType<HeartSkeletonEntity> HEART_SKELETON = registerEntity(EntityType.Builder.of(HeartSkeletonEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.7F, 2.4F).clientTrackingRange(8).setCustomClientFactory(HeartSkeletonEntity::new).canSpawnFarFromPlayer(), "heart_skeleton");
	
	@SuppressWarnings("rawtypes")
	private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        ResourceLocation nameLoc = new ResourceLocation(HeartofEnder.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }
	
	@SuppressWarnings("rawtypes")
	@SubscribeEvent
public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
    try {
        for (Field f : ModEntities.class.getDeclaredFields()) {
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
    //bakeAttributes();
}

    public static HashMap<String, Boolean> LOADED_ENTITIES;
    static {
    	LOADED_ENTITIES = new HashMap<String, Boolean>();
    }
	
    @SubscribeEvent
    public static void bakeAttributes(EntityAttributeCreationEvent creationEvent)
    {
        creationEvent.put(HEART_BLAZE, HeartBlazeEntity.createAttributes().build());
        creationEvent.put(ENDER_KID, EnderKidEntity.createAttributes().build());
        creationEvent.put(HEART_GHAST, HeartGhastEntity.createAttributes().build());
        creationEvent.put(BLUE_MAGMA_CUBE, BlueMagmaCubeEntity.createAttributes().build());
        creationEvent.put(HEART_SKELETON, HeartSkeletonEntity.createAttributes().build());

    }
    
/*

	public static final DeferredRegister<EntityType<?>> ENTITIES_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, HeartofEnder.MODID);

	public static final RegistryObject<EntityType<EnderKidEntity>> EXAMPLE = ENTITIES_REGISTRY.register("enderkid",
			() -> EntityType.Builder.of(EnderKidEntity::new, EntityClassification.MONSTER).sized(1.0f, 1.0f)
					.build(new ResourceLocation(HeartofEnder.MODID, "enderkid").toString()));
	*/
}