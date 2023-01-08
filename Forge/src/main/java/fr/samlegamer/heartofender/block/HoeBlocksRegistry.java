package fr.samlegamer.heartofender.block;

import com.google.common.base.Supplier;
import com.legacy.structure_gel.api.block.GelPortalBlock;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.dimension.HoeDimensionRegistry;
import fr.samlegamer.heartofender.features.hoe.HoeFeatures;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.poi.HoePOI;
import fr.samlegamer.heartofender.utils.HoeBlocksUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeBlocksRegistry
{
	public static final DeferredRegister<Block> REGISTRY_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HeartofEnder.MODID);

    public static final RegistryObject<Block> HEART_ENDER_PORTAL_BLOCK = createBlock("heart_ender_portal_block", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(10f, 15f)));
    public static final RegistryObject<Block> DARK_END_STONE = createBlock("dark_end_stone", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(4f, 15f)));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK = createBlock("dark_end_stone_brick", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_STAIRS = createBlock("dark_end_stone_brick_stairs", () -> new StairBlock(HoeBlocksRegistry.DARK_END_STONE_BRICK.get().defaultBlockState(), HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> DARK_END_STONE_STAIRS = createBlock("dark_end_stone_stairs", () -> new StairBlock(HoeBlocksRegistry.DARK_END_STONE.get().defaultBlockState(), HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> DARK_END_STONE_FENCE = createBlock("dark_end_stone_fence", () -> new FenceBlock(HoeBlocksUtils.DARK_FENCE));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_FENCE = createBlock("dark_end_stone_brick_fence", () -> new FenceBlock(HoeBlocksUtils.DARK_FENCE));
    public static final RegistryObject<Block> DARK_END_STONE_SLAB = createBlock("dark_end_stone_slab", () -> new SlabBlock(HoeBlocksUtils.DARK_SLAB));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_SLAB = createBlock("dark_end_stone_brick_slab", () -> new SlabBlock(HoeBlocksUtils.DARK_SLAB));
    public static final RegistryObject<Block> DARK_END_STONE_PRESSURE_PLATE = createBlock("dark_end_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, HoeBlocksUtils.DARK_PLATE));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_PRESSURE_PLATE = createBlock("dark_end_stone_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, HoeBlocksUtils.DARK_PLATE));
    public static final RegistryObject<Block> DARK_END_STONE_BUTTON = createBlock("dark_end_stone_button", () -> new StoneButtonBlock(HoeBlocksUtils.DARK_BUTTON));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_BUTTON = createBlock("dark_end_stone_brick_button", () -> new StoneButtonBlock(HoeBlocksUtils.DARK_BUTTON));
    public static final RegistryObject<Block> PURPLE_GLOWSTONE = createBlock("purple_glowstone", () -> new Block(HoeBlocksUtils.GLOWSTONE_BASE.lightLevel((p_235468_0_) -> { return 20; })));
    public static final RegistryObject<Block> BLUE_MAGMA_BLOCK = createBlock("blue_magma_block", () -> new MagmaBlueBlock(Material.STONE, 4, 13, SoundType.STONE));
    public static final RegistryObject<Block> DEAD_SOUL_SAND = createBlock("dead_sand", () -> new SandDeadBlock(BlockBehaviour.Properties.of(Material.SAND).strength(2f, 3f).sound(SoundType.SOUL_SAND).speedFactor(0.4F).isValidSpawn(HoeBlocksUtils::always).isRedstoneConductor(HoeBlocksUtils::always).isViewBlocking(HoeBlocksUtils::always).isSuffocating(HoeBlocksUtils::always)));
    public static final RegistryObject<Block> DEAD_SOUL_SOIL = createBlock("dead_soul_soil", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(2f, 3f).sound(SoundType.SOUL_SOIL)));
    public static final RegistryObject<Block> GREEN_LANTERN = createBlock("green_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 20;})));
    public static final RegistryObject<Block> GREEN_CAMPFIRE = createBlock("green_campfire", () -> new GreenCampfire(true, 3, HoeBlocksUtils.CAMPFIRES.lightLevel((p_235468_0_) ->{return 15;})));
    
    public static final RegistryObject<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> DEEPSLATE_AZURIUM_ORE = createBlock("deepslate_azurium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(6.5F, 15F)));
    public static final RegistryObject<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(HoeBlocksUtils.METAL_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> MILATHIUM_ORE = createBlock("milathium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(6f, 15f)));
    public static final RegistryObject<Block> MILATHIUM_BLOCK = createBlock("milathium_block", () -> new Block(HoeBlocksUtils.METAL_BASE.strength(6f, 15f)));
    
    public static final RegistryObject<Block> HEROBRINE_HEAD = createBlock("herobrine_head", () -> new HerobrineHeadBlock(Material.STONE, 7, 17, SoundType.STONE));

    public static final RegistryObject<Block> LILAC_STEM = createBlock("lilac_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final RegistryObject<Block> LEAFY_STEM = createBlock("leafy_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final RegistryObject<Block> STRIPPED_LILAC_STEM = createBlock("stripped_lilac_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final RegistryObject<Block> STRIPPED_LEAFY_STEM = createBlock("stripped_leafy_stem", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final RegistryObject<Block> LILAC_HYPHAE = createBlock("lilac_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final RegistryObject<Block> LEAFY_HYPHAE = createBlock("leafy_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.STEM_BASE));
    public static final RegistryObject<Block> STRIPPED_LILAC_HYPHAE = createBlock("stripped_lilac_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final RegistryObject<Block> STRIPPED_LEAFY_HYPHAE = createBlock("stripped_leafy_hyphae", () -> new RotatedPillarBlock(HoeBlocksUtils.WOOD_BASE));
    public static final RegistryObject<Block> LILAC_WART_BLOCK = createBlock("lilac_wart_block", () -> new Block(HoeBlocksUtils.WART));
    public static final RegistryObject<Block> LEAFY_WART_BLOCK = createBlock("leafy_wart_block", () -> new Block(HoeBlocksUtils.WART));
    public static final RegistryObject<Block> LILAC_PLANKS = createBlock("lilac_planks", () -> new Block(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LEAFY_PLANKS = createBlock("leafy_planks", () -> new Block(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LILAC_STAIRS = createBlock("lilac_stairs", () -> new StairBlock(HoeBlocksRegistry.LILAC_PLANKS.get().defaultBlockState(), HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LEAFY_STAIRS = createBlock("leafy_stairs", () -> new StairBlock(HoeBlocksRegistry.LEAFY_PLANKS.get().defaultBlockState(), HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LILAC_FENCE = createBlock("lilac_fence", () -> new FenceBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LEAFY_FENCE = createBlock("leafy_fence", () -> new FenceBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LILAC_FENCE_GATE = createBlock("lilac_fence_gate", () -> new FenceGateBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LEAFY_FENCE_GATE = createBlock("leafy_fence_gate", () -> new FenceGateBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LILAC_SLAB = createBlock("lilac_slab", () -> new SlabBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LEAFY_SLAB = createBlock("leafy_slab", () -> new SlabBlock(HoeBlocksUtils.PLANKS_BASE));
    public static final RegistryObject<Block> LILAC_PRESSURE_PLATE = createBlock("lilac_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HoeBlocksUtils.PLANKS_PLATE));
    public static final RegistryObject<Block> LEAFY_PRESSURE_PLATE = createBlock("leafy_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HoeBlocksUtils.PLANKS_PLATE));
    public static final RegistryObject<Block> LILAC_BUTTON = createBlock("lilac_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEAFY_BUTTON = createBlock("leafy_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LILAC_DOOR = createBlock("lilac_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, LILAC_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> LEAFY_DOOR = createBlock("leafy_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, LEAFY_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> LILAC_TRAPDOOR = createBlock("lilac_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(HoeBlocksUtils::never)));
    public static final RegistryObject<Block> LEAFY_TRAPDOOR = createBlock("leafy_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(HoeBlocksUtils::never)));
    public static final RegistryObject<Block> LILAC_NYLIUM = createBlock("lilac_nylium", () -> new NyliumBlockHoe(BlockBehaviour.Properties.copy(Blocks.CRIMSON_NYLIUM).sound(SoundType.STONE)));
    public static final RegistryObject<Block> LEAFY_NYLIUM = createBlock("leafy_nylium", () -> new NyliumBlockHoe(BlockBehaviour.Properties.copy(Blocks.CRIMSON_NYLIUM).sound(SoundType.STONE)));
    public static final RegistryObject<Block> LEAFY_FUNGUS = createBlock("leafy_fungus", () -> new HoeFungusBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().noCollission().sound(SoundType.FUNGUS),()->{return HoeFeatures.Tree.LEAFY_FUNGUS_PLANTED;}));
    public static final RegistryObject<Block> LEAFY_ROOTS = createBlock("leafy_roots", () -> new HoeRootsBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).noCollission().instabreak().sound(SoundType.ROOTS)));
    public static final RegistryObject<Block> HEART_OF_ENDER_SPROUTS = createBlock("heart_of_ender_sprouts", () -> new HoeSproutsBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().noCollission().sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> LILAC_FUNGUS = createBlock("lilac_fungus", () -> new HoeFungusBlock(BlockBehaviour.Properties.of(Material.PLANT).instabreak().noCollission().sound(SoundType.FUNGUS),()->{return HoeFeatures.Tree.LILAC_FUNGUS_PLANTED;}));
    public static final RegistryObject<Block> LILAC_WEEPING_VINES = createBlock("lilac_weeping_vines", () -> new HoeWeepingVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final RegistryObject<Block> LEAFY_TWISTING_VINES = createBlock("leafy_twisting_vines", () -> new HoeTwistingVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final RegistryObject<Block> LILAC_ROOTS = createBlock("lilac_roots", () -> new HoeRootsBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).noCollission().instabreak().sound(SoundType.ROOTS)));
    public static final RegistryObject<Block> SOUL_SHROOMLIGHT = createBlock("soul_shroomlight", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_152663_) -> {return 20;})));
    public static final RegistryObject<Block> LILAC_SHROOMLIGHT = createBlock("lilac_shroomlight", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_RED).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_152663_) -> {return 20;})));
    
    public static final RegistryObject<Block> PURPLE_LANTERN = createBlock("purple_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 35;})));
    public static final RegistryObject<Block> PURPLE_CAMPFIRE = createBlock("purple_campfire", () -> new GreenCampfire(false, 5, HoeBlocksUtils.CAMPFIRES.lightLevel((p_235468_0_) ->{return 20;})));

    public static final RegistryObject<Block> LEAFY_TWISTING_VINES_PLANT = REGISTRY_BLOCKS.register("leafy_twisting_vines_plant", () -> new HoeTwistingVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final RegistryObject<Block> LILAC_WEEPING_VINES_PLANT = REGISTRY_BLOCKS.register("lilac_weeping_vines_plant", () -> new HoeWeepingVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.WEEPING_VINES)));
    public static final RegistryObject<HeartWartBlock> HEART_ENDER_WART_BLOCK = REGISTRY_BLOCKS.register("heart_ender_wart_block", () -> new HeartWartBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART)));
    public static final RegistryObject<GreenFireBlock> GREEN_FIRE = REGISTRY_BLOCKS.register("green_fire", () -> new GreenFireBlock(HoeBlocksUtils.FIRE_BASE.lightLevel((p_235468_0_) -> {return 30;})));   
    public static final RegistryObject<PurpleFireBlock> PURPLE_FIRE = REGISTRY_BLOCKS.register("purple_fire", () -> new PurpleFireBlock(HoeBlocksUtils.FIRE_BASE.lightLevel((p_235468_0_) -> {return 40;})));
    public static final RegistryObject<Block> HOE_PORTAL = REGISTRY_BLOCKS.register("heart_of_ender_portal", () -> new HOEPortal(() -> Level.OVERWORLD, HoeDimensionRegistry::HoeKey, () -> HoePOI.HEART_OF_ENDER_PORTAL.get(), () -> (GelPortalBlock) HoeBlocksRegistry.HOE_PORTAL.get(), () -> HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Block> GREEN_TORCH = REGISTRY_BLOCKS.register("green_torch", () -> new GreenTorchBlock(HoeBlocksUtils.TORCH_BASE.lightLevel((p_235470_0_) -> {return 14;})));
    public static final RegistryObject<Block> GREEN_TORCH_WALL = REGISTRY_BLOCKS.register("green_torch_wall", () -> new GreenWallTorchBlock(HoeBlocksUtils.WALL_TORCH_BASE.dropsLike(HoeBlocksRegistry.GREEN_TORCH.get()).lightLevel((p_235470_0_) -> {return 14;})));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = REGISTRY_BLOCKS.register(name, supplier);
        HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        return block;
    }
}