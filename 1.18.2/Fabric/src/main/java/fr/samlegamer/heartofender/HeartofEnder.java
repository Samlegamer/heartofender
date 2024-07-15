package fr.samlegamer.heartofender;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.samlegamer.heartofender.block.HoeBlocks;
import fr.samlegamer.heartofender.entity.BlueMagmaCubeEntity;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import fr.samlegamer.heartofender.entity.HeartBlazeEntity;
import fr.samlegamer.heartofender.entity.HeartGhastEntity;
import fr.samlegamer.heartofender.entity.HeartStriderEntity;
import fr.samlegamer.heartofender.entity.HoeEntities;
import fr.samlegamer.heartofender.features.HoeFeatures;
import fr.samlegamer.heartofender.fluid.HoeFluids;
import fr.samlegamer.heartofender.item.HoeItems;
import fr.samlegamer.heartofender.world.HoeOreGen;

public class HeartofEnder implements ModInitializer
{
	public static final String MODID = "heartofender";
	public static final Logger LOGGER = LoggerFactory.getLogger("heartofender");

	public static final ItemGroup TAB_ITEMS = FabricItemGroupBuilder.build(new Identifier("heartofender_items"), () -> new ItemStack(HoeItems.DIAMOND_APPLE));
	public static final ItemGroup TAB_BLOCKS = FabricItemGroupBuilder.build(new Identifier("heartofender_blocks"), () -> new ItemStack(HoeBlocks.HEART_ENDER_PORTAL_BLOCK));
	
	public static final EntityType<HeartBlazeEntity> HEART_BLAZE = Registry.register(Registry.ENTITY_TYPE, new Identifier(HeartofEnder.MODID, "heart_blaze"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HeartBlazeEntity::new).fireImmune().trackRangeBlocks(128).dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());
			  
	public static final EntityType<EnderKidEntity> ENDER_KID = Registry.register(Registry.ENTITY_TYPE, new Identifier(HeartofEnder.MODID, "ender_kid"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnderKidEntity::new).fireImmune().trackRangeBlocks(128).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
	
	public static final EntityType<HeartGhastEntity> HEART_GHAST = Registry.register(Registry.ENTITY_TYPE, new Identifier(HeartofEnder.MODID, "heart_ghast"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HeartGhastEntity::new).fireImmune().trackRangeBlocks(128).dimensions(EntityDimensions.fixed(4.0F, 4.0F)).build());

	public static final EntityType<BlueMagmaCubeEntity> BLUE_MAGMA_CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier(HeartofEnder.MODID, "blue_magma_cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BlueMagmaCubeEntity::new).fireImmune().trackRangeBlocks(8).dimensions(EntityDimensions.fixed(2.04F, 2.04F)).build());
	
	public static final EntityType<HeartStriderEntity> HEART_STRIDER = Registry.register(Registry.ENTITY_TYPE, new Identifier(HeartofEnder.MODID, "heart_strider"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, HeartStriderEntity::new).fireImmune().trackRangeBlocks(10).dimensions(EntityDimensions.fixed(0.9F, 1.7F)).build());

	@Override
	public void onInitialize()
	{
		HoeItems.initItems();
		HoeItems.registryAll();
		HoeBlocks.registryAll();
		HoeEntities.AttributeInit();
		HoeFeatures.registry();
		HoeOreGen.InitOres();
		HoeFluids.registryFluids();
	}
	
	/*
	public static final EntityType<HeartSkeleton> HEART_SKELETON = registerEntity(EntityType.Builder.of(HeartSkeleton::new, MobCategory.MONSTER).fireImmune().sized(0.7F, 2.4F).clientTrackingRange(8).setCustomClientFactory(HeartSkeleton::new).canSpawnFarFromPlayer(), "heart_skeleton");
	public static final EntityType<Herobrine> HEROBRINE = registerEntity(EntityType.Builder.of(Herobrine::new, MobCategory.CREATURE).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(128).setCustomClientFactory(Herobrine::new).canSpawnFarFromPlayer(), "herobrine");
	 */
}