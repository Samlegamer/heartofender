package fr.samlegamer.heartofender.entity;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeEntityRegistry
{
	public static final DeferredRegister<EntityType<?>> REGISTRY_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, HeartofEnder.MODID);
	
    public static final RegistryObject<EntityType<EnderKid>> ENDER_KID = REGISTRY_ENTITIES.register("ender_kid",
            () -> EntityType.Builder.of(EnderKid::new, MobCategory.MONSTER).sized(0.6F, 1.8F).build(HeartofEnder.MODID + ":ender_kid"));

    public static final RegistryObject<EntityType<HeartBlaze>> HEART_BLAZE = REGISTRY_ENTITIES.register("heart_blaze",
            () -> EntityType.Builder.of(HeartBlaze::new, MobCategory.MONSTER).sized(1.0f, 2.0f).build(HeartofEnder.MODID + ":heart_blaze"));

    public static final RegistryObject<EntityType<HeartGhast>> HEART_GHAST = REGISTRY_ENTITIES.register("heart_ghast",
            () -> EntityType.Builder.of(HeartGhast::new, MobCategory.MONSTER).sized(4.0F, 4.0F).build(HeartofEnder.MODID + ":heart_ghast"));

    public static final RegistryObject<EntityType<BlueMagmaCube>> BLUE_MAGMA_CUBE = REGISTRY_ENTITIES.register("blue_magma_cube",
            () -> EntityType.Builder.of(BlueMagmaCube::new, MobCategory.MONSTER).sized(2.04F, 2.04F).build(HeartofEnder.MODID + ":blue_magma_cube"));

    public static final RegistryObject<EntityType<HeartSkeleton>> HEART_SKELETON = REGISTRY_ENTITIES.register("heart_skeleton",
            () -> EntityType.Builder.of(HeartSkeleton::new, MobCategory.MONSTER).sized(0.7F, 2.4F).build(HeartofEnder.MODID + ":heart_skeleton"));

    public static final RegistryObject<EntityType<Herobrine>> HEROBRINE = REGISTRY_ENTITIES.register("herobrine",
            () -> EntityType.Builder.of(Herobrine::new, MobCategory.MONSTER).sized(0.6F, 1.8F).build(HeartofEnder.MODID + ":herobrine"));

	/*
	public static final EntityType<EnderKid> ENDER_KID = registerEntity(EntityType.Builder.of(EnderKid::new, MobCategory.MONSTER).sized(0.6F, 1.8F).fireImmune().setCustomClientFactory(EnderKid::new).canSpawnFarFromPlayer(), "ender_kid");
	public static final EntityType<HeartBlaze> HEART_BLAZE = registerEntity(EntityType.Builder.of(HeartBlaze::new, MobCategory.MONSTER).fireImmune().sized(1.0f, 2.0f).setCustomClientFactory(HeartBlaze::new).canSpawnFarFromPlayer(), "heart_blaze");
	public static final EntityType<HeartGhast> HEART_GHAST = registerEntity(EntityType.Builder.of(HeartGhast::new, MobCategory.MONSTER).fireImmune().sized(4.0F, 4.0F).setCustomClientFactory(HeartGhast::new).canSpawnFarFromPlayer(), "heart_ghast");
	public static final EntityType<BlueMagmaCube> BLUE_MAGMA_CUBE = registerEntity(EntityType.Builder.of(BlueMagmaCube::new, MobCategory.MONSTER).fireImmune().sized(2.04F, 2.04F).clientTrackingRange(8).setCustomClientFactory(BlueMagmaCube::new).canSpawnFarFromPlayer(), "blue_magma_cube");
	public static final EntityType<HeartSkeleton> HEART_SKELETON = registerEntity(EntityType.Builder.of(HeartSkeleton::new, MobCategory.MONSTER).fireImmune().sized(0.7F, 2.4F).clientTrackingRange(8).setCustomClientFactory(HeartSkeleton::new).canSpawnFarFromPlayer(), "heart_skeleton");
	public static final EntityType<Herobrine> HEROBRINE = registerEntity(EntityType.Builder.of(Herobrine::new, MobCategory.CREATURE).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(128).setCustomClientFactory(Herobrine::new).canSpawnFarFromPlayer(), "herobrine");
    */
}