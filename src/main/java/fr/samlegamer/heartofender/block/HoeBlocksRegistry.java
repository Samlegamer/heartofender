package fr.samlegamer.heartofender.block;

import com.google.common.base.Supplier;
import com.legacy.structure_gel.api.block.GelPortalBlock;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.dimension.HoeDimensionRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import fr.samlegamer.heartofender.poi.HoePOI;
import fr.samlegamer.heartofender.utils.HoeBlocksUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StoneButtonBlock;
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
    public static final RegistryObject<Block> DARK_END_STONE_FENCE = createBlock("dark_end_stone_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_FENCE = createBlock("dark_end_stone_brick_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DARK_END_STONE_SLAB = createBlock("dark_end_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_SLAB = createBlock("dark_end_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_PRESSURE_PLATE = createBlock("dark_end_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_PRESSURE_PLATE = createBlock("dark_end_stone_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BUTTON = createBlock("dark_end_stone_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_BUTTON = createBlock("dark_end_stone_brick_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPLE_GLOWSTONE = createBlock("purple_glowstone", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_PURPLE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_50872_) -> {return 30;})));
    public static final RegistryObject<Block> BLUE_MAGMA_BLOCK = createBlock("blue_magma_block", () -> new MagmaBlueBlock(Material.STONE, 4, 13, SoundType.STONE));
    public static final RegistryObject<Block> DEAD_SOUL_SAND = createBlock("dead_sand", () -> new SandDeadBlock(Material.SAND, 2, 3, SoundType.SOUL_SAND));
    public static final RegistryObject<Block> DEAD_SOUL_SOIL = createBlock("dead_soul_soil", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(2f, 3f).sound(SoundType.SOUL_SOIL)));
    public static final RegistryObject<Block> GREEN_LANTERN = createBlock("green_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235443_0_) -> {return 20;}).noOcclusion()));
    public static final RegistryObject<Block> GREEN_CAMPFIRE = createBlock("green_campfire", () -> new GreenCampfire(true, 3, BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD).lightLevel((p_235468_0_) ->{return 15;}).noOcclusion()));
    public static final RegistryObject<Block> HEART_OF_ENDER_WART_BLOCK = createBlock("heart_of_ender_wart_block", () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(1.0F).sound(SoundType.WART_BLOCK)));
    
    public static final RegistryObject<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> DEEPSLATE_AZURIUM_ORE = createBlock("deepslate_azurium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(6.5F, 15F)));
    public static final RegistryObject<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(HoeBlocksUtils.METAL_BASE.strength(5f, 15f)));
    public static final RegistryObject<Block> MILATHIUM_ORE = createBlock("milathium_ore", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(6f, 15f)));
    public static final RegistryObject<Block> MILATHIUM_BLOCK = createBlock("milathium_block", () -> new Block(HoeBlocksUtils.STONE_BASE.strength(6f, 15f)));

    public static final RegistryObject<Block> HEROBRINE_HEAD = createBlock("herobrine_head", () -> new HerobrineHeadBlock(Material.STONE, 2, 7, 17, SoundType.STONE));
    
    public static final RegistryObject<HeartWartBlock> HEART_ENDER_WART_BLOCK = REGISTRY_BLOCKS.register("heart_ender_wart_block", () -> new HeartWartBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART)));
    public static final RegistryObject<GreenFireBlock> GREEN_FIRE = REGISTRY_BLOCKS.register("green_fire", () -> new GreenFireBlock(HoeBlocksUtils.FIRE_BASE));   
    public static final RegistryObject<Block> HOE_PORTAL = REGISTRY_BLOCKS.register("heart_of_ender_portal", () -> new HOEPortal(() -> Level.OVERWORLD, HoeDimensionRegistry::HoeKey, () -> HoePOI.HEART_OF_ENDER_PORTAL.get(), () -> (GelPortalBlock) HoeBlocksRegistry.HOE_PORTAL.get(), () -> HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Block> GREEN_TORCH = REGISTRY_BLOCKS.register("green_torch", () -> new GreenTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235470_0_) -> {return 14;})));
    public static final RegistryObject<Block> GREEN_TORCH_WALL = REGISTRY_BLOCKS.register("green_torch_wall", () -> new GreenWallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD).instabreak().dropsLike(HoeBlocksRegistry.GREEN_TORCH.get()).lightLevel((p_235470_0_) -> {return 14;})));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = REGISTRY_BLOCKS.register(name, supplier);
        HoeItemsRegistry.REGISTRY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.TAB_BLOCKS)));
        return block;
    }
}