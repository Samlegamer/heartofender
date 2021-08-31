package fr.samlegamer.heartofender.inits;

import java.util.function.Supplier;

import fr.samlegamer.heartofender.block.GlowstonePurpleBlock;
import fr.samlegamer.heartofender.block.HeartWartCropMod;
import fr.samlegamer.heartofender.block.HerobrineHeadBlock;
import fr.samlegamer.heartofender.block.MagmaBlueBlock;
import fr.samlegamer.heartofender.block.ModStairs;
import fr.samlegamer.heartofender.block.SandDeadBlock;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HeartofEnder.MODID);

    public static final RegistryObject<Block> HEART_ENDER_PORTAL_BLOCK = createBlock("heart_ender_portal_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(10f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE = createBlock("dark_end_stone", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(4f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_END_STONE_BRICK = createBlock("dark_end_stone_brick", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUE_MAGMA_BLOCK = createBlock("blue_magma_block", () -> new MagmaBlueBlock(Material.STONE, 2, 4, 13, SoundType.STONE));
    public static final RegistryObject<Block> DEAD_SAND = createBlock("dead_sand", () -> new SandDeadBlock(Material.SAND, 2, -4, 3, SoundType.SOUL_SAND));

    public static final RegistryObject<Block> HEROBRINE_HEAD = createBlock("herobrine_head", () -> new HerobrineHeadBlock(Material.STONE, 2, 7, 17, SoundType.STONE));
    
    public static final RegistryObject<Block> DARK_END_STONE_BRICK_STAIRS = createBlock("dark_end_stone_brick_stairs", () -> new ModStairs(ModBlocks.DARK_END_STONE_BRICK.get().defaultBlockState(), 5, 15));
    public static final RegistryObject<Block> DARK_END_STONE_STAIRS = createBlock("dark_end_stone_stairs", () -> new ModStairs(ModBlocks.DARK_END_STONE.get().defaultBlockState(), 5, 15));

    public static final RegistryObject<Block> PURPLE_GLOWSTONE = createBlock("purple_glowstone", () -> new GlowstonePurpleBlock(Material.GLASS, 1, 10, SoundType.GLASS));
    public static final RegistryObject<Block> MILATHIUM_BLOCK = createBlock("milathium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(6f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MILATHIUM_ORE = createBlock("milathium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HEART_ENDER_WART_BLOCK = createBlock("heart_ender_wart_block", () -> new HeartWartCropMod(Material.PLANT, SoundType.NETHER_WART, MaterialColor.COLOR_GREEN));
    
    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS_REGISTRY.register(name, supplier);
        ModItems.ITEMS_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_BLOCKS)));
        return block;
    }
}