package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.block.*;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod
{
	public static Block heart_ender_portal_block, dark_end_stone, dark_end_stone_brick;

	public static BlockStairsMod dark_end_stone_brick_stairs, dark_end_stone_stairs;

	public static BlockMetalGeneric azurium_block, milathium_block;

	public static BlockOreAzurium azurium_ore;
	public static HerobrineHeadBlock herobrine_head;
	public static BlockBlueMagmaBlock blue_magma_block;
	public static BlockDeadSandMod dead_sand;
	public static TpHeartofEnderDim portal_dim;
	public static BlockGreenFire green_fire;
	public static BlockPurpleGlowstone purple_glowstone;
	public static BlockMilathiumOre milathium_ore;
	
	public static void init()
	{
		heart_ender_portal_block = new BlockMod("heart_ender_portal_block", Material.ROCK).setHardness(10.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone = new BlockMod("dark_end_stone", Material.ROCK).setHardness(5.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		azurium_block = (BlockMetalGeneric) new BlockMetalGeneric("azurium_block", Material.IRON).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(6.0F);
		azurium_ore = (BlockOreAzurium) new BlockOreAzurium("azurium_ore", 2, 1, 5).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(5.0F);
		herobrine_head = (HerobrineHeadBlock) new HerobrineHeadBlock("herobrine_head", Material.ROCK).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(4.0F);
		dark_end_stone_brick = new BlockMod("dark_end_stone_brick", Material.ROCK).setHardness(6.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		blue_magma_block = (BlockBlueMagmaBlock) new BlockBlueMagmaBlock("blue_magma_block").setHardness(7.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dead_sand = (BlockDeadSandMod) new BlockDeadSandMod("dead_sand").setHardness(1.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone_brick_stairs = (BlockStairsMod) new BlockStairsMod("dark_end_stone_brick_stairs", BlocksMod.dark_end_stone_brick.getDefaultState()).setHardness(6.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone_stairs = (BlockStairsMod) new BlockStairsMod("dark_end_stone_stairs", BlocksMod.dark_end_stone.getDefaultState()).setHardness(5.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		portal_dim = (TpHeartofEnderDim) new TpHeartofEnderDim("portal_dim").setHardness(-1.0F).setLightLevel(0.75F);
		green_fire = (BlockGreenFire) new BlockGreenFire("green_fire").setHardness(0.0F).setLightLevel(1.0F);
		purple_glowstone = (BlockPurpleGlowstone) new BlockPurpleGlowstone("purple_glowstone", Material.GLASS).setHardness(2.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		milathium_ore = (BlockMilathiumOre) new BlockMilathiumOre("milathium_ore", 3, Material.ROCK).setHardness(6.5F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		milathium_block = (BlockMetalGeneric) new BlockMetalGeneric("milathium_block", Material.IRON).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(7.0F);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(heart_ender_portal_block, dark_end_stone, azurium_block, azurium_ore, herobrine_head, dark_end_stone_brick, blue_magma_block, dead_sand, 
		dark_end_stone_brick_stairs, dark_end_stone_stairs, portal_dim, green_fire, purple_glowstone, milathium_ore, milathium_block);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		registryItemBlock(event, heart_ender_portal_block);
		registryItemBlock(event, dark_end_stone);
		registryItemBlock(event, azurium_block);
		registryItemBlock(event, azurium_ore);
		registryItemBlock(event, herobrine_head);
		registryItemBlock(event, dark_end_stone_brick);
		registryItemBlock(event, blue_magma_block);
		registryItemBlock(event, dead_sand);
		registryItemBlock(event, dark_end_stone_brick_stairs);
		registryItemBlock(event, dark_end_stone_stairs);
		registryItemBlock(event, portal_dim);
		registryItemBlock(event, green_fire);
		registryItemBlock(event, purple_glowstone);
		registryItemBlock(event, milathium_ore);
		registryItemBlock(event, milathium_block);
	} 
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(heart_ender_portal_block));
		registerRender(Item.getItemFromBlock(dark_end_stone));
		registerRender(Item.getItemFromBlock(azurium_block));
		registerRender(Item.getItemFromBlock(azurium_ore));
		registerRender(Item.getItemFromBlock(herobrine_head));
		registerRender(Item.getItemFromBlock(dark_end_stone_brick));
		registerRender(Item.getItemFromBlock(blue_magma_block));
		registerRender(Item.getItemFromBlock(dead_sand));
		registerRender(Item.getItemFromBlock(dark_end_stone_brick_stairs));
		registerRender(Item.getItemFromBlock(dark_end_stone_stairs));
		registerRender(Item.getItemFromBlock(portal_dim));
		registerRender(Item.getItemFromBlock(green_fire));
		registerRender(Item.getItemFromBlock(purple_glowstone));
		registerRender(Item.getItemFromBlock(milathium_ore));
		registerRender(Item.getItemFromBlock(milathium_block));
	}
		
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
	
	private static void registryItemBlock(RegistryEvent.Register<Item> event, Block block)
	{
		event.getRegistry().registerAll(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
}