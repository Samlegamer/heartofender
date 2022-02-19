package fr.samlegamer.heartofender.compat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import static fr.samlegamer.heartofender.block.HoeBlocksRegistry.createBlock;
import static fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry.REGISTRY_BLOCK_ENTITY;

import fr.samlegamer.heartofender.compat.quark.block.ChestBlockHoe;
import fr.samlegamer.heartofender.compat.quark.block.TrappedChestBlockLeafy;
import fr.samlegamer.heartofender.compat.quark.block.TrappedChestBlockLilac;
import fr.samlegamer.heartofender.compat.quark.block_entity.ChestBELeafy;
import fr.samlegamer.heartofender.compat.quark.block_entity.ChestBELilac;
import fr.samlegamer.heartofender.compat.quark.block_entity.TrappedChestBELeafy;
import fr.samlegamer.heartofender.compat.quark.block_entity.TrappedChestBELilac;

public class HoeCompats
{
	public static class Quark
	{
		public static RegistryObject<Block> dead_soul_sandstone, dead_soul_sandstone_bricks, cut_dead_soul_sandstone, chiseled_dead_soul_sandstone,
		lilac_ladder, leafy_ladder, lilac_bookshelf, leafy_bookshelf, lilac_chest, leafy_chest, trapped_lilac_chest, trapped_leafy_chest;
		
		public static RegistryObject<BlockEntityType<ChestBELilac>> lilac_chest_be;
		public static RegistryObject<BlockEntityType<ChestBELeafy>> leafy_chest_be;
		public static RegistryObject<BlockEntityType<TrappedChestBELilac>> trapped_lilac_chest_be;
		public static RegistryObject<BlockEntityType<TrappedChestBELeafy>> trapped_leafy_chest_be;
		
		public static void InitQuark()
		{
			if(ModList.get().isLoaded("quark"))
			{
				lilac_chest_be = REGISTRY_BLOCK_ENTITY.register("lilac_chest", () -> BlockEntityType.Builder.of(ChestBELilac::new, Quark.lilac_chest.get()).build(null));
				leafy_chest_be = REGISTRY_BLOCK_ENTITY.register("leafy_chest", () -> BlockEntityType.Builder.of(ChestBELeafy::new, Quark.leafy_chest.get()).build(null));
				trapped_lilac_chest_be = REGISTRY_BLOCK_ENTITY.register("trapped_lilac_chest", () -> BlockEntityType.Builder.of(TrappedChestBELilac::new, Quark.trapped_lilac_chest.get()).build(null));
				trapped_leafy_chest_be = REGISTRY_BLOCK_ENTITY.register("trapped_leafy_chest", () -> BlockEntityType.Builder.of(TrappedChestBELeafy::new, Quark.trapped_leafy_chest.get()).build(null));
				
				dead_soul_sandstone = createBlock("dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
				dead_soul_sandstone_bricks = createBlock("dead_soul_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
				cut_dead_soul_sandstone = createBlock("cut_dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE)));
				chiseled_dead_soul_sandstone = createBlock("chiseled_dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE)));
				lilac_ladder =  createBlock("lilac_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
				leafy_ladder =  createBlock("leafy_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
				lilac_bookshelf =  createBlock("lilac_bookshelf", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
				leafy_bookshelf =  createBlock("leafy_bookshelf", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
				lilac_chest =  createBlock("lilac_chest", () -> new ChestBlockHoe(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return Quark.lilac_chest_be.get();}));
				leafy_chest =  createBlock("leafy_chest", () -> new ChestBlockHoe(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return Quark.leafy_chest_be.get();}));
				trapped_lilac_chest =  createBlock("trapped_lilac_chest", () -> new TrappedChestBlockLilac(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
				trapped_leafy_chest =  createBlock("trapped_leafy_chest", () -> new TrappedChestBlockLeafy(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
			}
		}
	}
}