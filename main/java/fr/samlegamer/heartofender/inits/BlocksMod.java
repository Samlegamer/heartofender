package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.block.BlockAzurium;
import fr.samlegamer.heartofender.block.BlockBlueMagmaBlock;
import fr.samlegamer.heartofender.block.BlockDeadSandMod;
import fr.samlegamer.heartofender.block.BlockFluidMod;
import fr.samlegamer.heartofender.block.BlockGreenFire;
import fr.samlegamer.heartofender.block.BlockHeartSkeletonSkull;
import fr.samlegamer.heartofender.block.BlockHeartWart;
import fr.samlegamer.heartofender.block.BlockMilathiumOre;
import fr.samlegamer.heartofender.block.BlockMod;
import fr.samlegamer.heartofender.block.BlockOreAzurium;
import fr.samlegamer.heartofender.block.BlockPurpleGlowstone;
import fr.samlegamer.heartofender.block.BlockStairsMod;
import fr.samlegamer.heartofender.block.HeartFence;
import fr.samlegamer.heartofender.block.HeartFenceGate;
import fr.samlegamer.heartofender.block.HerobrineHeadBlock;
import fr.samlegamer.heartofender.block.TpHeartofEnderDim;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.utils.RendersMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderWitherSkull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlocksMod
{
	public static Block heart_ender_portal_block;
	public static Block dark_end_stone;
	public static BlockAzurium azurium_block;
	public static BlockOreAzurium azurium_ore;
	public static HerobrineHeadBlock herobrine_head;
	public static Block dark_end_stone_brick;
	public static BlockBlueMagmaBlock blue_magma_block;
	public static BlockDeadSandMod dead_sand;
	public static BlockStairsMod dark_end_stone_brick_stairs;
	public static BlockStairsMod dark_end_stone_stairs;
	public static TpHeartofEnderDim portal_dim;
	public static BlockGreenFire green_fire;
	public static BlockPurpleGlowstone purple_glowstone;
	public static BlockMilathiumOre milathium_ore;
	public static BlockAzurium milathium_block;
	public static HeartFence dark_end_stone_brick_fence; 
	public static HeartFenceGate dark_end_stone_brick_fence_gate;
	public static BlockHeartWart heart_wart_block;
	public static BlockHeartSkeletonSkull heart_skeleton_skull;
	
	public static void init()
	{
		heart_ender_portal_block = new BlockMod("heart_ender_portal_block", Material.ROCK).setHardness(10.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone = new BlockMod("dark_end_stone", Material.ROCK).setHardness(5.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		azurium_block = (BlockAzurium) new BlockAzurium("azurium_block", Material.IRON).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(6.0F);
		azurium_ore = (BlockOreAzurium) new BlockOreAzurium("azurium_ore", 2, 1, 5).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(5.0F);
		herobrine_head = (HerobrineHeadBlock) new HerobrineHeadBlock("herobrine_head", Material.ROCK).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(4.0F);
		dark_end_stone_brick = new BlockMod("dark_end_stone_brick", Material.ROCK).setHardness(6.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		blue_magma_block = (BlockBlueMagmaBlock) new BlockBlueMagmaBlock("blue_magma_block").setHardness(7.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dead_sand = (BlockDeadSandMod) new BlockDeadSandMod("dead_sand").setHardness(1.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone_brick_stairs = (BlockStairsMod) new BlockStairsMod("dark_end_stone_brick_stairs", BlocksMod.dark_end_stone_brick.getDefaultState()).setHardness(6.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone_stairs = (BlockStairsMod) new BlockStairsMod("dark_end_stone_stairs", BlocksMod.dark_end_stone.getDefaultState()).setHardness(5.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		
		//update in 2.6
		portal_dim = (TpHeartofEnderDim) new TpHeartofEnderDim("portal_dim").setHardness(100000.0F);
		green_fire = (BlockGreenFire) new BlockGreenFire("green_fire").setHardness(0.0F);
		purple_glowstone = (BlockPurpleGlowstone) new BlockPurpleGlowstone("purple_glowstone", Material.GLASS).setHardness(2.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		milathium_ore = (BlockMilathiumOre) new BlockMilathiumOre("milathium_ore", 3, Material.ROCK).setHardness(6.5F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		milathium_block = (BlockAzurium) new BlockAzurium("milathium_block", Material.IRON).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS).setHardness(7.0F);
		dark_end_stone_brick_fence = (HeartFence) new HeartFence("dark_end_stone_brick_fence", 6.0F, 9.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		dark_end_stone_brick_fence_gate = (HeartFenceGate) new HeartFenceGate("dark_end_stone_brick_fence_gate", 6.0F, 9.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		heart_wart_block = (BlockHeartWart) new BlockHeartWart("heart_wart_block").setHardness(0.0F).setCreativeTab(HeartofEnder.CREATIVE_TAB_BLOCKS);
		
		//update 2.7
		heart_skeleton_skull = (BlockHeartSkeletonSkull) new BlockHeartSkeletonSkull("heart_skeleton_skull").setHardness(4.0F);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(heart_ender_portal_block);
		event.getRegistry().registerAll(dark_end_stone);
		event.getRegistry().registerAll(azurium_block);
		event.getRegistry().registerAll(azurium_ore);
		event.getRegistry().registerAll(herobrine_head);
		event.getRegistry().registerAll(dark_end_stone_brick);
		event.getRegistry().registerAll(blue_magma_block);
		event.getRegistry().registerAll(dead_sand);
		event.getRegistry().registerAll(dark_end_stone_brick_stairs);
		event.getRegistry().registerAll(dark_end_stone_stairs);
		
		//update in 2.6
		event.getRegistry().registerAll(portal_dim);
		event.getRegistry().registerAll(green_fire);
		event.getRegistry().registerAll(purple_glowstone);
		event.getRegistry().registerAll(milathium_ore);
		event.getRegistry().registerAll(milathium_block);
		event.getRegistry().registerAll(dark_end_stone_brick_fence);
		event.getRegistry().registerAll(dark_end_stone_brick_fence_gate);
		event.getRegistry().registerAll(heart_wart_block);
		event.getRegistry().registerAll(heart_skeleton_skull);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				new ItemBlock(heart_ender_portal_block).setRegistryName(heart_ender_portal_block.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone).setRegistryName(dark_end_stone.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(azurium_block).setRegistryName(azurium_block.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(azurium_ore).setRegistryName(azurium_ore.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(herobrine_head).setRegistryName(herobrine_head.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone_brick).setRegistryName(dark_end_stone_brick.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(blue_magma_block).setRegistryName(blue_magma_block.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dead_sand).setRegistryName(dead_sand.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone_brick_stairs).setRegistryName(dark_end_stone_brick_stairs.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone_stairs).setRegistryName(dark_end_stone_stairs.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(portal_dim).setRegistryName(portal_dim.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(green_fire).setRegistryName(green_fire.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(purple_glowstone).setRegistryName(purple_glowstone.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(milathium_ore).setRegistryName(milathium_ore.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(milathium_block).setRegistryName(milathium_block.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone_brick_fence).setRegistryName(dark_end_stone_brick_fence.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(dark_end_stone_brick_fence_gate).setRegistryName(dark_end_stone_brick_fence_gate.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(heart_wart_block).setRegistryName(heart_wart_block.getRegistryName()));
		event.getRegistry().registerAll(
				new ItemBlock(heart_skeleton_skull).setRegistryName(heart_skeleton_skull.getRegistryName()));
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
		registerRender(Item.getItemFromBlock(dark_end_stone_brick_fence));
		registerRender(Item.getItemFromBlock(dark_end_stone_brick_fence_gate));
		registerRender(Item.getItemFromBlock(heart_wart_block));
		registerRender(Item.getItemFromBlock(heart_skeleton_skull));
	}
		
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
}