package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/*
 * Used Deferred
 */
public class HoeEntityRegistry
{
	public static final DeferredRegister<EntityType<?>> REGISTRY_ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, HeartofEnder.MODID);
	
    public static final DeferredHolder<EntityType<?>, EntityType<EnderKid>> ENDER_KID = REGISTRY_ENTITIES.register("ender_kid",
            () -> EntityType.Builder.of(EnderKid::new, MobCategory.MONSTER).sized(0.6F, 1.8F).build(HeartofEnder.MODID + ":ender_kid"));

    public static final DeferredHolder<EntityType<?>, EntityType<HeartBlaze>> HEART_BLAZE = REGISTRY_ENTITIES.register("heart_blaze",
            () -> EntityType.Builder.of(HeartBlaze::new, MobCategory.MONSTER).sized(1.0f, 2.0f).build(HeartofEnder.MODID + ":heart_blaze"));

    public static final DeferredHolder<EntityType<?>, EntityType<HeartGhast>> HEART_GHAST = REGISTRY_ENTITIES.register("heart_ghast",
            () -> EntityType.Builder.of(HeartGhast::new, MobCategory.MONSTER).sized(4.0F, 4.0F).build(HeartofEnder.MODID + ":heart_ghast"));

    public static final DeferredHolder<EntityType<?>, EntityType<BlueMagmaCube>> BLUE_MAGMA_CUBE = REGISTRY_ENTITIES.register("blue_magma_cube",
            () -> EntityType.Builder.of(BlueMagmaCube::new, MobCategory.MONSTER).sized(2.04F, 2.04F).build(HeartofEnder.MODID + ":blue_magma_cube"));

    public static final DeferredHolder<EntityType<?>, EntityType<HeartSkeleton>> HEART_SKELETON = REGISTRY_ENTITIES.register("heart_skeleton",
            () -> EntityType.Builder.of(HeartSkeleton::new, MobCategory.MONSTER).sized(0.7F, 2.4F).build(HeartofEnder.MODID + ":heart_skeleton"));

    public static final DeferredHolder<EntityType<?>, EntityType<Herobrine>> HEROBRINE = REGISTRY_ENTITIES.register("herobrine",
            () -> EntityType.Builder.of(Herobrine::new, MobCategory.MONSTER).sized(0.6F, 1.8F).build(HeartofEnder.MODID + ":herobrine"));
}