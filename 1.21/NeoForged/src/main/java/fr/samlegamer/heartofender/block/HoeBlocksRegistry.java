package fr.samlegamer.heartofender.block;

import java.util.function.Supplier;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.features.hoe.HoeFeatures;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.utils.HoeBlocksUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeBlocksRegistry
{
	public static final DeferredRegister.Blocks REGISTRY_BLOCKS = DeferredRegister.createBlocks(HeartofEnder.MODID);

    public static final DeferredBlock<Block> HEART_ENDER_PORTAL_BLOCK = createBlock("heart_ender_portal_block", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(10f, 15f)));
    public static final DeferredBlock<Block> DARK_END_STONE = createBlock("dark_end_stone", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(4f, 15f)));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK = createBlock("dark_end_stone_brick", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK_STAIRS = createBlock("dark_end_stone_brick_stairs", () -> new StairBlock(HoeBlocksRegistry.DARK_END_STONE_BRICK.get().defaultBlockState(), HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final DeferredBlock<Block> DARK_END_STONE_STAIRS = createBlock("dark_end_stone_stairs", () -> new StairBlock(HoeBlocksRegistry.DARK_END_STONE.get().defaultBlockState(), HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final DeferredBlock<Block> DARK_END_STONE_FENCE = createBlock("dark_end_stone_fence", () -> new FenceBlock(HoeBlocksUtils.DARK_FENCE));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK_FENCE = createBlock("dark_end_stone_brick_fence", () -> new FenceBlock(HoeBlocksUtils.DARK_FENCE));
    public static final DeferredBlock<Block> DARK_END_STONE_SLAB = createBlock("dark_end_stone_slab", () -> new SlabBlock(HoeBlocksUtils.DARK_SLAB));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK_SLAB = createBlock("dark_end_stone_brick_slab", () -> new SlabBlock(HoeBlocksUtils.DARK_SLAB));
    public static final DeferredBlock<Block> DARK_END_STONE_PRESSURE_PLATE = createBlock("dark_end_stone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, HoeBlocksUtils.DARK_PLATE));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK_PRESSURE_PLATE = createBlock("dark_end_stone_brick_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, HoeBlocksUtils.DARK_PLATE));
    public static final DeferredBlock<Block> DARK_END_STONE_BUTTON = createBlock("dark_end_stone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, HoeBlocksUtils.DARK_BUTTON));
    public static final DeferredBlock<Block> DARK_END_STONE_BRICK_BUTTON = createBlock("dark_end_stone_brick_button", () -> new ButtonBlock(BlockSetType.STONE, 20, HoeBlocksUtils.DARK_BUTTON));
    public static final DeferredBlock<Block> PURPLE_GLOWSTONE = createBlock("purple_glowstone", () -> new Block(HoeBlocksUtils.GLOWSTONE_BASE.lightLevel((p_235468_0_) -> { return 20; })));
    public static final DeferredBlock<Block> BLUE_MAGMA_BLOCK = createBlock("blue_magma_block", () -> new MagmaBlock(BlockBehaviour.Properties.of().strength(4f, 13f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEAD_SOUL_SAND = createBlock("dead_sand", () -> new SoulSandBlock(BlockBehaviour.Properties.of().strength(2f, 3f).sound(SoundType.SOUL_SAND).speedFactor(0.4F).isValidSpawn(HoeBlocksUtils::always).isRedstoneConductor(HoeBlocksUtils::always).isViewBlocking(HoeBlocksUtils::always).isSuffocating(HoeBlocksUtils::always)));
    public static final DeferredBlock<Block> DEAD_SOUL_SOIL = createBlock("dead_soul_soil", () -> new Block(BlockBehaviour.Properties.of().strength(2f, 3f).sound(SoundType.SOUL_SOIL)));
    
    public static final DeferredBlock<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final DeferredBlock<Block> DEEPSLATE_AZURIUM_ORE = createBlock("deepslate_azurium_ore", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(6.5F, 15F)));
    public static final DeferredBlock<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(HoeBlocksUtils.METAL_BASE.strength(5f, 15f)));
    public static final DeferredBlock<Block> MILATHIUM_ORE = createBlock("milathium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(6f, 15f)));
    public static final DeferredBlock<Block> MILATHIUM_BLOCK = createBlock("milathium_block", () -> new Block(HoeBlocksUtils.METAL_BASE.strength(6f, 15f)));
    
    public static final DeferredBlock<Block> HEROBRINE_HEAD = createBlock("herobrine_head", () -> new HerobrineHeadBlock(7, 17, SoundType.STONE));

    public static final DeferredBlock<Block> LILAC_STEM = createBlock("lilac_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final DeferredBlock<Block> LEAFY_STEM = createBlock("leafy_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final DeferredBlock<Block> STRIPPED_LILAC_STEM = createBlock("stripped_lilac_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final DeferredBlock<Block> STRIPPED_LEAFY_STEM = createBlock("stripped_leafy_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final DeferredBlock<Block> LILAC_HYPHAE = createBlock("lilac_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final DeferredBlock<Block> LEAFY_HYPHAE = createBlock("leafy_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final DeferredBlock<Block> STRIPPED_LILAC_HYPHAE = createBlock("stripped_lilac_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final DeferredBlock<Block> STRIPPED_LEAFY_HYPHAE = createBlock("stripped_leafy_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final DeferredBlock<Block> LILAC_WART_BLOCK = createBlock("lilac_wart_block", () -> new Block(HoeBlocksUtils.WART));
    public static final DeferredBlock<Block> LEAFY_WART_BLOCK = createBlock("leafy_wart_block", () -> new Block(HoeBlocksUtils.WART));
    public static final DeferredBlock<Block> LILAC_PLANKS = createBlock("lilac_planks", () -> new Block(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LEAFY_PLANKS = createBlock("leafy_planks", () -> new Block(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LILAC_STAIRS = createBlock("lilac_stairs", () -> new StairBlock(HoeBlocksRegistry.LILAC_PLANKS.get().defaultBlockState(), HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LEAFY_STAIRS = createBlock("leafy_stairs", () -> new StairBlock(HoeBlocksRegistry.LEAFY_PLANKS.get().defaultBlockState(), HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LILAC_FENCE = createBlock("lilac_fence", () -> new FenceBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LEAFY_FENCE = createBlock("leafy_fence", () -> new FenceBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LILAC_FENCE_GATE = createBlock("lilac_fence_gate", () -> new FenceGateBlock(WoodType.CRIMSON, HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LEAFY_FENCE_GATE = createBlock("leafy_fence_gate", () -> new FenceGateBlock(WoodType.WARPED, HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LILAC_SLAB = createBlock("lilac_slab", () -> new SlabBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LEAFY_SLAB = createBlock("leafy_slab", () -> new SlabBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final DeferredBlock<Block> LILAC_PRESSURE_PLATE = createBlock("lilac_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CRIMSON, HoeBlocksUtils.PLANKS_PLATE));
    public static final DeferredBlock<Block> LEAFY_PRESSURE_PLATE = createBlock("leafy_pressure_plate", () -> new PressurePlateBlock(BlockSetType.WARPED, HoeBlocksUtils.PLANKS_PLATE));
    public static final DeferredBlock<Block> LILAC_BUTTON = createBlock("lilac_button", () -> new ButtonBlock(BlockSetType.CRIMSON, 30, HoeBlocksUtils.DARK_BUTTON));
    public static final DeferredBlock<Block> LEAFY_BUTTON = createBlock("leafy_button", () -> new ButtonBlock(BlockSetType.WARPED, 30, HoeBlocksUtils.DARK_BUTTON));
    public static final DeferredBlock<Block> LILAC_DOOR = createBlock("lilac_door", () -> new DoorBlock(BlockSetType.CRIMSON, BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<Block> LEAFY_DOOR = createBlock("leafy_door", () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<Block> LILAC_TRAPDOOR = createBlock("lilac_trapdoor", () -> new TrapDoorBlock(BlockSetType.CRIMSON, BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(HoeBlocksUtils::never)));
    public static final DeferredBlock<Block> LEAFY_TRAPDOOR = createBlock("leafy_trapdoor", () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(HoeBlocksUtils::never)));
    public static final DeferredBlock<Block> LILAC_NYLIUM = createBlock("lilac_nylium", () -> new NyliumBlockHoe(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_NYLIUM).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LEAFY_NYLIUM = createBlock("leafy_nylium", () -> new NyliumBlockHoe(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_NYLIUM).sound(SoundType.STONE)));
   // public static final DeferredBlock<Block> LEAFY_FUNGUS = createBlock("leafy_fungus", () -> new HoeFungusBlock(HoeFeatures.LEAFY_FUNGUS_PLANTED, LEAFY_NYLIUM.get(), BlockBehaviour.Properties.of().instabreak().noCollission().sound(SoundType.FUNGUS)));
    public static final DeferredBlock<Block> LEAFY_ROOTS = createBlock("leafy_roots", () -> new HoeRootsBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.ROOTS)));
    public static final DeferredBlock<Block> HEART_OF_ENDER_SPROUTS = createBlock("heart_of_ender_sprouts", () -> new HoeSproutsBlock(BlockBehaviour.Properties.of().instabreak().noCollission().sound(SoundType.FUNGUS)));
    //public static final DeferredBlock<Block> LILAC_FUNGUS = createBlock("lilac_fungus", () -> new HoeFungusBlock(HoeFeatures.LILAC_FUNGUS_PLANTED, LILAC_NYLIUM.get(), BlockBehaviour.Properties.of().instabreak().noCollission().sound(SoundType.FUNGUS)));
    public static final DeferredBlock<Block> LILAC_WEEPING_VINES = createBlock("lilac_weeping_vines", () -> new HoeWeepingVinesBlock(BlockBehaviour.Properties.of().randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final DeferredBlock<Block> LEAFY_TWISTING_VINES = createBlock("leafy_twisting_vines", () -> new HoeTwistingVinesBlock(BlockBehaviour.Properties.of().randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final DeferredBlock<Block> LILAC_ROOTS = createBlock("lilac_roots", () -> new HoeRootsBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.ROOTS)));
    public static final DeferredBlock<Block> SOUL_SHROOMLIGHT = createBlock("soul_shroomlight", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_152663_) -> {return 20;})));
    public static final DeferredBlock<Block> LILAC_SHROOMLIGHT = createBlock("lilac_shroomlight", () -> new Block(BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_152663_) -> {return 20;})));
    
    public static final DeferredBlock<Block> GREEN_LANTERN = createBlock("green_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 20;})));
    public static final DeferredBlock<Block> GREEN_CAMPFIRE = createBlock("green_campfire", () -> new GreenCampfire(true, 3, HoeBlocksUtils.CAMPFIRES.lightLevel((p_235468_0_) ->{return 15;})));
    public static final DeferredBlock<Block> PURPLE_LANTERN = createBlock("purple_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 35;})));
    public static final DeferredBlock<Block> PURPLE_CAMPFIRE = createBlock("purple_campfire", () -> new GreenCampfire(false, 5, HoeBlocksUtils.CAMPFIRES.lightLevel((p_235468_0_) ->{return 20;})));

    public static final DeferredBlock<Block> LEAFY_TWISTING_VINES_PLANT = REGISTRY_BLOCKS.register("leafy_twisting_vines_plant", () -> new HoeTwistingVinesPlantBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final DeferredBlock<Block> LILAC_WEEPING_VINES_PLANT = REGISTRY_BLOCKS.register("lilac_weeping_vines_plant", () -> new HoeWeepingVinesPlantBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    //public static final DeferredBlock<HeartWartBlock> HEART_ENDER_WART_BLOCK = REGISTRY_BLOCKS.register("heart_ender_wart_block", () -> new HeartWartBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART)));
    public static final DeferredBlock<GreenFire> GREEN_FIRE = REGISTRY_BLOCKS.register("green_fire", () -> new GreenFire(HoeBlocksUtils.FIRE_BASE.lightLevel((p_235468_0_) -> {return 30;})));   
    public static final DeferredBlock<PurpleFire> PURPLE_FIRE = REGISTRY_BLOCKS.register("purple_fire", () -> new PurpleFire(HoeBlocksUtils.FIRE_BASE.lightLevel((p_235468_0_) -> {return 40;})));
    //public static final DeferredBlock<Block> HOE_PORTAL = REGISTRY_BLOCKS.register("heart_of_ender_portal", () -> new HOEPortal(() -> Level.OVERWORLD, HoeDimensionRegistry::HoeKey, () -> HoePOI.HEART_OF_ENDER_PORTAL.get(), () -> (GelPortalBlock) HoeBlocksRegistry.HOE_PORTAL.get(), () -> HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get().defaultBlockState()));
    //public static final DeferredBlock<Block> GREEN_TORCH = REGISTRY_BLOCKS.register("green_torch", () -> new TorchBlock(HoeParticleRegistry.GREEN_FLAME.get(), HoeBlocksUtils.TORCH_BASE.lightLevel(p_50886_ -> 14)));
    //public static final DeferredBlock<Block> GREEN_TORCH_WALL = REGISTRY_BLOCKS.register("green_torch_wall", () -> new WallTorchBlock(HoeParticleRegistry.GREEN_FLAME.get(), HoeBlocksUtils.WALL_TORCH_BASE.lootFrom(() -> HoeBlocksRegistry.GREEN_TORCH.get()).lightLevel(p_50886_ -> 14).lootFrom(GREEN_TORCH)));

    public static DeferredBlock<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        DeferredBlock<Block> block = REGISTRY_BLOCKS.register(name, supplier);
        HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}