package fr.samlegamer.heartofender.block_entity;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeBlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY_BLOCK_ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, HeartofEnder.MODID);
																																																																						/*PURPLE*/
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenCampfireBlockEntity>> GREEN_CAMPFIRE_TILE = REGISTRY_BLOCK_ENTITY.register("hoe_campfire", () -> BlockEntityType.Builder.of(GreenCampfireBlockEntity::new, HoeBlocksRegistry.GREEN_CAMPFIRE.get(), HoeBlocksRegistry.PURPLE_CAMPFIRE.get()).build(null));
}