package fr.samlegamer.heartofender.block_entity;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeBlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY_BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, HeartofEnder.MODID);
	
	public static final RegistryObject<BlockEntityType<GreenCampfireBlockEntity>> GREEN_CAMPFIRE_TILE = REGISTRY_BLOCK_ENTITY.register("green_campfire", () -> BlockEntityType.Builder.of(GreenCampfireBlockEntity::new, HoeBlocksRegistry.GREEN_CAMPFIRE.get(), HoeBlocksRegistry.PURPLE_CAMPFIRE.get()).build(null));
}