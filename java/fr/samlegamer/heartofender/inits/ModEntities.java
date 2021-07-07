package fr.samlegamer.heartofender.inits;


import java.lang.reflect.Field;
import java.util.HashMap;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities
{
    @SuppressWarnings("unchecked")
	public static final EntityType<EnderKidEntity> ENDER_KID = registerEntity(EntityType.Builder.of(EnderKidEntity::new, EntityClassification.CREATURE).sized(0.78F, 1.2F).setTrackingRange(256), "ender_kid");
    
    @SuppressWarnings("rawtypes")
	private static final EntityType registerEntity(EntityType.Builder builder, String entityName)
    {
        ResourceLocation nameLoc = new ResourceLocation(HeartofEnder.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }

    public static HashMap<String, Boolean> LOADED_ENTITIES;
    static {
    	LOADED_ENTITIES = new HashMap<String, Boolean>();
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
}