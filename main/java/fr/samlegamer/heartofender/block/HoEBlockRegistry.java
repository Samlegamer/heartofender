package fr.samlegamer.heartofender.block;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HoEBlockRegistry
{
	public static final DeferredRegister<Block> REGISTRY_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, HeartofEnder.MODID);

	public static final RegistryObject<Block> HEART_ENDER_PORTAL_BLOCK = createBlock("heart_ender_portal_block", () -> new Block(Properties.of(Material.STONE).strength(10f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DARK_END_STONE = createBlock("dark_end_stone", () -> new Block(Properties.of(Material.STONE).strength(4f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> AZURIUM_ORE = createBlock("azurium_ore", () -> new Block(Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> AZURIUM_BLOCK = createBlock("azurium_block", () -> new Block(Properties.of(Material.METAL).sound(SoundType.METAL).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DARK_END_STONE_BRICK = createBlock("dark_end_stone_brick", () -> new Block(Properties.of(Material.STONE).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));

	public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = REGISTRY_BLOCK.register(name, supplier);
        HoeItemsRegistry.REGISTRY_ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_BLOCKS)));
        return block;
    }
}