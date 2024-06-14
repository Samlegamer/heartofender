package fr.samlegamer.heartofender.inits;

import java.util.function.Supplier;

import com.legacy.structure_gel.blocks.GelPortalBlock;

import fr.samlegamer.heartofender.block.*;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HeartofEnder.MODID);

	//Decoration Function Blocks
    public static final RegistryObject<Block> HEART_ENDER_PORTAL_BLOCK = createBlock("heart_ender_portal_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(10f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE = createBlock("dark_end_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(4f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK = createBlock("dark_end_stone_brick", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_STAIRS = createBlock("dark_end_stone_brick_stairs", () -> new ModStairs(ModBlocks.DARK_END_STONE_BRICK.get().defaultBlockState(), 5, 15));
    public static final RegistryObject<Block> DARK_END_STONE_STAIRS = createBlock("dark_end_stone_stairs", () -> new ModStairs(ModBlocks.DARK_END_STONE.get().defaultBlockState(), 5, 15));
    public static final RegistryObject<Block> DARK_END_STONE_FENCE = createBlock("dark_end_stone_fence", () -> new ModFences(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_FENCE = createBlock("dark_end_stone_brick_fence", () -> new ModFences(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DARK_END_STONE_SLAB = createBlock("dark_end_stone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.5f, 15f).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_SLAB = createBlock("dark_end_stone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.5f, 15f).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_PRESSURE_PLATE = createBlock("dark_end_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_PRESSURE_PLATE = createBlock("dark_end_stone_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BUTTON = createBlock("dark_end_stone_button", () -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_BUTTON = createBlock("dark_end_stone_brick_button", () -> new StoneButtonBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5F).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPLE_GLOWSTONE = createBlock("purple_glowstone", () -> new GlowstonePurpleBlock(Material.GLASS, 1, 10, SoundType.GLASS));
    public static final RegistryObject<Block> BLUE_MAGMA_BLOCK = createBlock("blue_magma_block", () -> new MagmaBlueBlock(Material.STONE, 2, 4, 13, SoundType.STONE));
    public static final RegistryObject<Block> DEAD_SOUL_SAND = createBlock("dead_sand", () -> new SandDeadBlock(Material.SAND, 2, 3, SoundType.SOUL_SAND));
    public static final RegistryObject<Block> DEAD_SOUL_SOIL = createBlock("dead_soul_soil", () -> new Block(AbstractBlock.Properties.of(Material.SAND).strength(2f, 3f).harvestTool(ToolType.SHOVEL).sound(SoundType.SOUL_SOIL)));
    public static final RegistryObject<Block> GREEN_CAMPFIRE = createBlock("green_campfire", () -> new GreenCampfireBlock(true, 3, AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD).lightLevel((p_235468_0_) ->{return 15;}).noOcclusion()));
    public static final RegistryObject<Block> GREEN_LANTERN = createBlock("green_lantern", () -> new LanternBlock(AbstractBlock.Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((p_235443_0_) -> {return 20;}).noOcclusion()));
    public static final RegistryObject<Block> HEART_OF_ENDER_WART_BLOCK = createBlock("heart_of_ender_wart_block", () -> new Block(AbstractBlock.Properties.of(Material.GRASS).strength(1.0F).harvestTool(ToolType.HOE).sound(SoundType.WART_BLOCK)));
    
	//Ore and Metal Function Blocks
    public static final RegistryObject<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MILATHIUM_ORE = createBlock("milathium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MILATHIUM_BLOCK = createBlock("milathium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(6f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops()));

	//Boss Function Blocks
    public static final RegistryObject<Block> HEROBRINE_HEAD = createBlock("herobrine_head", () -> new HerobrineHeadBlock(Material.STONE, 2, 7, 17, SoundType.STONE));

	//Not Visible Blocks
    public static final RegistryObject<Block> HEART_ENDER_WART_BLOCK = BLOCKS_REGISTRY.register("heart_ender_wart_block", () -> new HeartWartCropMod(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART)));
    public static final RegistryObject<GreenFireBlock> GREEN_FIRE = BLOCKS_REGISTRY.register("green_fire", () -> new GreenFireBlock(AbstractBlock.Properties.of(Material.FIRE, MaterialColor.COLOR_LIGHT_GREEN).instabreak().noCollission().lightLevel((p_235468_0_) -> {return 30;}).sound(SoundType.WOOL).noDrops()));
    public static final RegistryObject<Block> HEART_OF_ENDER_PORTAL = createBlockNotVisible("heart_of_ender_portal", () -> new HeartofEnderPortal(() -> World.OVERWORLD, ModDimension::HoeKey, () -> ModPOI.HEART_OF_ENDER_PORTAL.get(), () -> (GelPortalBlock) ModBlocks.HEART_OF_ENDER_PORTAL.get(), () -> ModBlocks.HEART_ENDER_PORTAL_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Block> GREEN_TORCH = BLOCKS_REGISTRY.register("green_torch", () -> new GreenTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235470_0_) -> {return 14;})));
    public static final RegistryObject<Block> GREEN_TORCH_WALL = BLOCKS_REGISTRY.register("green_torch_wall", () -> new GreenWallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD).instabreak().dropsLike(ModBlocks.GREEN_TORCH.get()).lightLevel((p_235470_0_) -> {return 14;})));
    
    public static RegistryObject<Block> createBlockNotVisible(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        ModItems.ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        ModItems.ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_BLOCKS)));
        return block;
    }
}