package fr.samlegamer.heartofender.compat;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.compat.aquaculture.FilletKnifeHoe;
import fr.samlegamer.heartofender.compat.charm.block.BarrelBlockHoe;
import fr.samlegamer.heartofender.compat.charm.block_entity.BarrelBlockEntityHoe;
import fr.samlegamer.heartofender.compat.mctb.CraftTable;
import fr.samlegamer.heartofender.compat.quark.block.*;
import fr.samlegamer.heartofender.compat.quark.block_entity.*;
import fr.samlegamer.heartofender.config.HoeConfig;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.item.HoeTiers;
import fr.samlegamer.heartofender.utils.HoeBlocksUtils;
import static fr.samlegamer.heartofender.item.HoeItemsRegistry.REGISTRY_ITEMS;
import static fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry.REGISTRY_BLOCK_ENTITY;

public class HoeCompats
{
	public static class Quark
	{
		public static RegistryObject<Block> dead_soul_sandstone, dead_soul_sandstone_bricks, cut_dead_soul_sandstone, chiseled_dead_soul_sandstone,
		smooth_dead_soul_sandstone, smooth_dead_soul_sandstone_slab, cut_dead_soul_sandstone_slab, dead_soul_sandstone_bricks_slab, dead_soul_sandstone_slab,
		dead_soul_sandstone_stairs,dead_soul_sandstone_bricks_stairs,smooth_dead_soul_sandstone_stairs,dead_soul_sandstone_wall,dead_soul_sandstone_bricks_wall
		,lilac_ladder, leafy_ladder, lilac_bookshelf, leafy_bookshelf, lilac_chest, leafy_chest, trapped_lilac_chest, trapped_leafy_chest;
		
		public static RegistryObject<BlockEntityType<ChestBELilac>> lilac_chest_be;
		public static RegistryObject<BlockEntityType<ChestBELeafy>> leafy_chest_be;
		public static RegistryObject<BlockEntityType<TrappedChestBELilac>> trapped_lilac_chest_be;
		public static RegistryObject<BlockEntityType<TrappedChestBELeafy>> trapped_leafy_chest_be;
		
		public static void InitQuark()
		{
			if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat)
			{
				HeartofEnder.msg("Quark Compability Is Charged !");
				dead_soul_sandstone = addCompat("dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_bricks = addCompat("dead_soul_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				cut_dead_soul_sandstone = addCompat("cut_dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				chiseled_dead_soul_sandstone = addCompat("chiseled_dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				smooth_dead_soul_sandstone = addCompat("smooth_dead_soul_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_slab = addCompat("dead_soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_bricks_slab = addCompat("dead_soul_sandstone_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				cut_dead_soul_sandstone_slab = addCompat("cut_dead_soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				smooth_dead_soul_sandstone_slab = addCompat("smooth_dead_soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_stairs = addCompat("dead_soul_sandstone_stairs", () -> new StairBlock(dead_soul_sandstone.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_bricks_stairs = addCompat("dead_soul_sandstone_bricks_stairs", () -> new StairBlock(dead_soul_sandstone_bricks.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				smooth_dead_soul_sandstone_stairs = addCompat("smooth_dead_soul_sandstone_stairs", () -> new StairBlock(smooth_dead_soul_sandstone.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_wall = addCompat("dead_soul_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);
				dead_soul_sandstone_bricks_wall = addCompat("dead_soul_sandstone_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)), "quark", HoeConfig.quarkCompat);

				lilac_ladder =  addCompat("lilac_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), "quark", HoeConfig.quarkCompat);
				leafy_ladder =  addCompat("leafy_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), "quark", HoeConfig.quarkCompat);
				lilac_bookshelf =  addCompat("lilac_bookshelf", () -> new BookshelvesHoe.Lilac(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), "quark", HoeConfig.quarkCompat);
				leafy_bookshelf =  addCompat("leafy_bookshelf", () -> new BookshelvesHoe.Leafy(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)), "quark", HoeConfig.quarkCompat);
				
				if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat && HoeConfig.quarkChestModule)
				{
					lilac_chest_be = REGISTRY_BLOCK_ENTITY.register("lilac_chest", () -> BlockEntityType.Builder.of(ChestBELilac::new, Quark.lilac_chest.get()).build(null));
					leafy_chest_be = REGISTRY_BLOCK_ENTITY.register("leafy_chest", () -> BlockEntityType.Builder.of(ChestBELeafy::new, Quark.leafy_chest.get()).build(null));
					trapped_lilac_chest_be = REGISTRY_BLOCK_ENTITY.register("trapped_lilac_chest", () -> BlockEntityType.Builder.of(TrappedChestBELilac::new, Quark.trapped_lilac_chest.get()).build(null));
					trapped_leafy_chest_be = REGISTRY_BLOCK_ENTITY.register("trapped_leafy_chest", () -> BlockEntityType.Builder.of(TrappedChestBELeafy::new, Quark.trapped_leafy_chest.get()).build(null));
				}
				
				lilac_chest =  addCompatForDbl("lilac_chest", () -> new ChestBlockHoe.Lilac(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return Quark.lilac_chest_be.get();}), "quark", HoeConfig.quarkCompat, HoeConfig.quarkChestModule);
				leafy_chest =  addCompatForDbl("leafy_chest", () -> new ChestBlockHoe.Leafy(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return Quark.leafy_chest_be.get();}), "quark", HoeConfig.quarkCompat, HoeConfig.quarkChestModule);
				trapped_lilac_chest =  addCompatForDbl("trapped_lilac_chest", () -> new TrappedChestBlockLilac(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "quark", HoeConfig.quarkCompat, HoeConfig.quarkChestModule);
				trapped_leafy_chest =  addCompatForDbl("trapped_leafy_chest", () -> new TrappedChestBlockLeafy(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "quark", HoeConfig.quarkCompat, HoeConfig.quarkChestModule);
			}
		}
	}
	
	public static class Charm
	{
		public static RegistryObject<Block> green_gold_lantern, purple_gold_lantern, lilac_barrel, leafy_barrel;
		
		public static RegistryObject<BlockEntityType<BarrelBlockEntityHoe.Lilac>> lilac_barrel_be;
		public static RegistryObject<BlockEntityType<BarrelBlockEntityHoe.Leafy>> leafy_barrel_be;

		public static void InitCharm()
		{
				HeartofEnder.msg("Charm Compability Is Charged !");
				green_gold_lantern = addCompat("green_gold_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 20;})), "charm", HoeConfig.charmCompat);
				purple_gold_lantern = addCompat("purple_gold_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 30;})), "charm", HoeConfig.charmCompat);
				
				if(ModList.get().isLoaded("charm") && HoeConfig.charmCompat && HoeConfig.charmBarrelModule)
				{
					lilac_barrel_be = REGISTRY_BLOCK_ENTITY.register("lilac_barrel", () -> BlockEntityType.Builder.of(BarrelBlockEntityHoe.Lilac::new, Charm.lilac_barrel.get()).build(null));
					leafy_barrel_be = REGISTRY_BLOCK_ENTITY.register("leafy_barrel", () -> BlockEntityType.Builder.of(BarrelBlockEntityHoe.Leafy::new, Charm.leafy_barrel.get()).build(null));
				}
				lilac_barrel = addCompatForDbl("lilac_barrel", () -> new BarrelBlockHoe.Lilac(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "charm", HoeConfig.charmCompat, HoeConfig.charmBarrelModule);
				leafy_barrel = addCompatForDbl("leafy_barrel", () -> new BarrelBlockHoe.Leafy(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "charm", HoeConfig.charmCompat, HoeConfig.charmBarrelModule);
		}
	}
	
	public static class Aquaculture
	{
		public static RegistryObject<Item> azurium_fillet_knife, milathium_fillet_knife;
		
		public static void InitAquaculture()
		{
			if(ModList.get().isLoaded("aquaculture") && HoeConfig.aquacultureCompat)
			{
				HeartofEnder.msg("Aquaculture Compability Is Charged !");
				azurium_fillet_knife = REGISTRY_ITEMS.register("azurium_fillet_knife", () -> new FilletKnifeHoe(HoeTiers.AZURIUM_TOOLS));
				milathium_fillet_knife = REGISTRY_ITEMS.register("milathium_fillet_knife", () -> new FilletKnifeHoe(HoeTiers.MILATHIUM_TOOLS));
			}
		}
	}
	
	public static class MoreCraftingTables
	{
		public static RegistryObject<Block> lilac_crafting_table, leafy_crafting_table;
		
		public static void InitMoreCraftingTables()
		{
	        if(ModList.get().isLoaded("mctb") && HoeConfig.MoreCraftingTablesCompat)
	        {
				HeartofEnder.msg("More Crafting Tables Compability Is Charged !");
	        }
			lilac_crafting_table = addCompat("lilac_crafting_table", () -> new CraftTable.Lilac(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "mctb", HoeConfig.MoreCraftingTablesCompat);
			leafy_crafting_table = addCompat("leafy_crafting_table", () -> new CraftTable.Leafy(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)), "mctb", HoeConfig.MoreCraftingTablesCompat);
		}
	}
	
	public static class NoTreePunching
	{
		/* For 1.18.2 Port */
		public static RegistryObject<Item> azurium_knife, azurium_mattock, azurium_saw, milathium_knife, milathium_mattock, milathium_saw;
		
		public static void InitNoTreePunching()
		{
	        if(ModList.get().isLoaded("notreepunching") && HoeConfig.NoTreePunchingCompat)
	        {
				HeartofEnder.msg("No Tree Punching Compability Is Charged !");
	        }
		}
	}
	
	public static RegistryObject<Block> addCompat(String name, Supplier<? extends Block> supplier, String Modid, boolean CfgEnb)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded(Modid) && CfgEnb)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }
	
	public static RegistryObject<Block> addCompatForDbl(String name, Supplier<? extends Block> supplier, String Modid, boolean CfgEnb1, boolean CfgEnb2)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded(Modid) && CfgEnb1 && CfgEnb2)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }
	
	/*public static RegistryObject<Block> addMoreCraftingTables(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded("mctb") && HoeConfig.MoreCraftingTablesCompat)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }

    public static RegistryObject<Block> addQuark(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }
    
    public static RegistryObject<Block> addQuarkChests(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded("quark") && HoeConfig.quarkCompat && HoeConfig.quarkChestModule)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }*/
    
    /*public static RegistryObject<Block> addCharm(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded("charm") && HoeConfig.charmCompat)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }
    
    public static RegistryObject<Block> addCharmBarrels(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = HoeBlocksRegistry.REGISTRY_BLOCKS.register(name, supplier);
        if(ModList.get().isLoaded("charm") && HoeConfig.charmCompat && HoeConfig.charmBarrelModule)
        {
            HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        }
        return block;
    }*/
}