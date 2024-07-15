package fr.samlegamer.heartofender.block;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.features.HoeFeatures;
import fr.samlegamer.heartofender.utils.HoeBlocksUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HoeBlocks
{
	public static final Block HEART_ENDER_PORTAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).strength(10f, 15f).requiresTool());
	public static final Block DARK_END_STONE = new Block(AbstractBlock.Settings.of(Material.STONE).strength(4f, 15f).requiresTool());
	public static final Block DARK_END_STONE_BRICK = new Block(AbstractBlock.Settings.of(Material.STONE).strength(5f, 15f).requiresTool());
	public static final Block DARK_END_STONE_STAIRS = new HoeStairs(DARK_END_STONE.getDefaultState(), AbstractBlock.Settings.copy(DARK_END_STONE));
	public static final Block DARK_END_STONE_BRICK_STAIRS = new HoeStairs(DARK_END_STONE_BRICK.getDefaultState(), AbstractBlock.Settings.copy(DARK_END_STONE_BRICK));
	public static final Block DARK_END_STONE_FENCE = new FenceBlock(AbstractBlock.Settings.copy(DARK_END_STONE));
	public static final Block DARK_END_STONE_BRICK_FENCE = new FenceBlock(AbstractBlock.Settings.copy(DARK_END_STONE_BRICK));
	public static final Block DARK_END_STONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(DARK_END_STONE));
	public static final Block DARK_END_STONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(DARK_END_STONE_BRICK));
	public static final Block DARK_END_STONE_PRESSURE_PLATE = new HoePressurePlateBlock(ActivationRule.MOBS, AbstractBlock.Settings.copy(DARK_END_STONE));
	public static final Block DARK_END_STONE_BRICK_PRESSURE_PLATE = new HoePressurePlateBlock(ActivationRule.MOBS, AbstractBlock.Settings.copy(DARK_END_STONE_BRICK));
	public static final Block DARK_END_STONE_BUTTON = new HoeStoneButtonBlock(AbstractBlock.Settings.of(Material.STONE).strength(0.5F).requiresTool());
	public static final Block DARK_END_STONE_BRICK_BUTTON = new HoeStoneButtonBlock(AbstractBlock.Settings.of(Material.STONE).strength(0.6F).requiresTool());
	public static final Block PURPLE_GLOWSTONE = new Block(AbstractBlock.Settings.of(Material.GLASS).strength(1f, 10f).sounds(BlockSoundGroup.GLASS).luminance(state -> 20));
	public static final Block BLUE_MAGMA_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.MAGMA_BLOCK).luminance(state -> 6));
	public static final Block DEAD_SOUL_SAND = new SoulSandBlock(AbstractBlock.Settings.copy(Blocks.SOUL_SAND));
	public static final Block DEAD_SOUL_SOIL = new Block(AbstractBlock.Settings.copy(Blocks.SOUL_SOIL));

	public static final Block AZURIUM_ORE = new Block(AbstractBlock.Settings.of(Material.STONE).strength(5f, 15f).requiresTool());
	public static final Block DEEPSLATE_AZURIUM_ORE = new Block(AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(6.5F, 15F));
	public static final GreenFireBlock GREEN_FIRE = new GreenFireBlock(AbstractBlock.Settings.of(Material.FIRE, MapColor.GREEN).breakInstantly().noCollision().luminance((p_235468_0_) -> {return 30;}).sounds(BlockSoundGroup.WOOL).dropsNothing());

	public static final Block AZURIUM_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(5f, 15f).requiresTool());
	public static final Block MILATHIUM_ORE = new Block(AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(6f, 15f).requiresTool());
	public static final Block MILATHIUM_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(6f, 15f).requiresTool());
	public static final Block GREEN_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(state -> 20).nonOpaque());
	
	//A Changer #HerobrineHeadBlock
	public static final Block HEROBRINE_HEAD = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(7F, 17F).sounds(BlockSoundGroup.STONE));

	public static final Block LILAC_STEM = new PillarBlock(HoeBlocksUtils.STEM_BASE);
    public static final Block LEAFY_STEM = new PillarBlock(HoeBlocksUtils.STEM_BASE);
    public static final Block STRIPPED_LILAC_STEM = new PillarBlock(HoeBlocksUtils.WOOD_BASE);
    public static final Block STRIPPED_LEAFY_STEM = new PillarBlock(HoeBlocksUtils.WOOD_BASE);
    public static final Block LILAC_HYPHAE = new PillarBlock(HoeBlocksUtils.STEM_BASE);
    public static final Block LEAFY_HYPHAE = new PillarBlock(HoeBlocksUtils.STEM_BASE);
    public static final Block STRIPPED_LILAC_HYPHAE = new PillarBlock(HoeBlocksUtils.WOOD_BASE);
    public static final Block STRIPPED_LEAFY_HYPHAE = new PillarBlock(HoeBlocksUtils.WOOD_BASE);
    public static final Block LILAC_WART_BLOCK = new Block(HoeBlocksUtils.WART);
    public static final Block LEAFY_WART_BLOCK = new Block(HoeBlocksUtils.WART);
    public static final Block LILAC_PLANKS = new Block(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LEAFY_PLANKS = new Block(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LILAC_STAIRS = new HoeStairs(HoeBlocks.LILAC_PLANKS.getDefaultState(), HoeBlocksUtils.PLANKS_BASE);
    public static final Block LEAFY_STAIRS = new HoeStairs(HoeBlocks.LEAFY_PLANKS.getDefaultState(), HoeBlocksUtils.PLANKS_BASE);
    public static final Block LILAC_FENCE = new FenceBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LEAFY_FENCE = new FenceBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LILAC_FENCE_GATE = new FenceGateBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LEAFY_FENCE_GATE = new FenceGateBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LILAC_SLAB = new SlabBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LEAFY_SLAB = new SlabBlock(HoeBlocksUtils.PLANKS_BASE);
    public static final Block LILAC_PRESSURE_PLATE = new HoePressurePlateBlock(ActivationRule.EVERYTHING, HoeBlocksUtils.PLANKS_PLATE);
    public static final Block LEAFY_PRESSURE_PLATE = new HoePressurePlateBlock(ActivationRule.EVERYTHING, HoeBlocksUtils.PLANKS_PLATE);
    public static final Block LILAC_BUTTON = new HoeWoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD));
    public static final Block LEAFY_BUTTON = new HoeWoodButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD));
    public static final Block LILAC_DOOR = new HoeDoorBlock(AbstractBlock.Settings.of(Material.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block LEAFY_DOOR = new HoeDoorBlock(AbstractBlock.Settings.of(Material.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block LILAC_TRAPDOOR = new HoeTrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(HoeBlocksUtils::never));
    public static final Block LEAFY_TRAPDOOR = new HoeTrapDoorBlock(AbstractBlock.Settings.of(Material.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(HoeBlocksUtils::never));
    public static final Block LILAC_NYLIUM = new NyliumBlockHoe(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM).sounds(BlockSoundGroup.STONE));
    public static final Block LEAFY_NYLIUM = new NyliumBlockHoe(AbstractBlock.Settings.copy(Blocks.CRIMSON_NYLIUM).sounds(BlockSoundGroup.STONE));
    public static final Block LEAFY_FUNGUS = new HoeFungusBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS),()->{return HoeFeatures.Tree.LEAFY_FUNGUS_PLANTED;});
    public static final Block LEAFY_ROOTS = new HoeRootsBlock(AbstractBlock.Settings.of(Material.NETHER_SHOOTS).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS));
    public static final Block HEART_OF_ENDER_SPROUTS = new HoeSproutsBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS));
    public static final Block LILAC_FUNGUS = new HoeFungusBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS),()->{return HoeFeatures.Tree.LILAC_FUNGUS_PLANTED;});
    public static final Block LILAC_WEEPING_VINES = new HoeWeepingVinesBlock(AbstractBlock.Settings.of(Material.PLANT).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES));
    public static final Block LEAFY_TWISTING_VINES = new HoeTwistingVinesBlock(AbstractBlock.Settings.of(Material.PLANT).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES));
    public static final Block LILAC_ROOTS = new HoeRootsBlock(AbstractBlock.Settings.of(Material.NETHER_SHOOTS).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS));
    public static final Block SOUL_SHROOMLIGHT = new Block(AbstractBlock.Settings.of(Material.PLANT).strength(1.0F).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(state -> 20));
    public static final Block LILAC_SHROOMLIGHT = new Block(AbstractBlock.Settings.of(Material.PLANT).strength(1.0F).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(state -> 20));

    public static final Block LEAFY_TWISTING_VINES_PLANT = new HoeTwistingVinesPlantBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES));
    public static final Block LILAC_WEEPING_VINES_PLANT = new HoeWeepingVinesPlantBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES));

	/*
    
    public static final RegistryObject<Block> PURPLE_LANTERN = createBlock("purple_lantern", () -> new LanternBlock(HoeBlocksUtils.LANTERNS.lightLevel((p_235443_0_) -> {return 35;})));
    public static final RegistryObject<Block> PURPLE_CAMPFIRE = createBlock("purple_campfire", () -> new GreenCampfire(false, 5, HoeBlocksUtils.CAMPFIRES.lightLevel((p_235468_0_) ->{return 20;})));
	 
    public static final RegistryObject<Block>  = createBlock("green_campfire", () -> new GreenCampfireBlock(true, 3, AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(2.0F).sound(SoundType.WOOD).lightLevel((p_235468_0_) ->{return 15;}).noOcclusion()));
    
    public static final RegistryObject<Block>  = BLOCKS_REGISTRY.register("heart_ender_wart_block", () -> new HeartWartCropMod(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART)));
    public static final RegistryObject<GreenFireBlock>  = BLOCKS_REGISTRY.register("green_fire", () -> new GreenFireBlock(
    public static final RegistryObject<Block> HEART_OF_ENDER_PORTAL = createBlockNotVisible("heart_of_ender_portal", () -> new HeartofEnderPortal(() -> World.OVERWORLD, ModDimension::HoeKey, () -> ModPOI.HEART_OF_ENDER_PORTAL.get(), () -> (GelPortalBlock) ModBlocks.HEART_OF_ENDER_PORTAL.get(), () -> ModBlocks.HEART_ENDER_PORTAL_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Block>  = BLOCKS_REGISTRY.register("green_torch", () -> new GreenTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().sound(SoundType.WOOD).lightLevel((p_235470_0_) -> {return 14;})));
    public static final RegistryObject<Block>  = BLOCKS_REGISTRY.register("green_torch_wall", () -> new GreenWallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD).instabreak().dropsLike(ModBlocks.GREEN_TORCH.get()).lightLevel((p_235470_0_) -> {return 14;})));
	*/
	
    
    public static void registryAll()
    {
    	add("heart_ender_portal_block", HEART_ENDER_PORTAL_BLOCK);
    	add("dark_end_stone", DARK_END_STONE);
    	add("dark_end_stone_brick", DARK_END_STONE_BRICK);
    	add("dark_end_stone_stairs", DARK_END_STONE_STAIRS);
    	add("dark_end_stone_brick_stairs", DARK_END_STONE_BRICK_STAIRS);
    	add("dark_end_stone_fence", DARK_END_STONE_FENCE);
    	add("dark_end_stone_brick_fence", DARK_END_STONE_BRICK_FENCE);
    	add("dark_end_stone_slab", DARK_END_STONE_SLAB);
    	add("dark_end_stone_brick_slab", DARK_END_STONE_BRICK_SLAB);
    	add("dark_end_stone_pressure_plate", DARK_END_STONE_PRESSURE_PLATE);
    	add("dark_end_stone_brick_pressure_plate", DARK_END_STONE_BRICK_PRESSURE_PLATE);
    	add("dark_end_stone_button", DARK_END_STONE_BUTTON);
    	add("dark_end_stone_brick_button", DARK_END_STONE_BRICK_BUTTON);
    	add("purple_glowstone", PURPLE_GLOWSTONE);
    	add("blue_magma_block", BLUE_MAGMA_BLOCK);
    	add("dead_sand", DEAD_SOUL_SAND);
    	add("dead_soul_soil", DEAD_SOUL_SOIL);
    	add("azurium_ore", AZURIUM_ORE);
    	add("deepslate_azurium_ore", DEEPSLATE_AZURIUM_ORE);
    	add("azurium_block", AZURIUM_BLOCK);
    	add("milathium_ore", MILATHIUM_ORE);
    	add("milathium_block", MILATHIUM_BLOCK);
    	add("green_lantern", GREEN_LANTERN);
    	add("herobrine_head", HEROBRINE_HEAD);
    	add("lilac_stem", LILAC_STEM);
    	add("leafy_stem", LEAFY_STEM);
    	add("stripped_lilac_stem", STRIPPED_LILAC_STEM);
    	add("stripped_leafy_stem", STRIPPED_LEAFY_STEM);
    	add("lilac_hyphae", LILAC_HYPHAE);	
    	add("leafy_hyphae", LEAFY_HYPHAE);
    	add("stripped_lilac_hyphae", STRIPPED_LILAC_HYPHAE);	
    	add("stripped_leafy_hyphae", STRIPPED_LEAFY_HYPHAE);	
    	add("leafy_wart_block", LEAFY_WART_BLOCK);
    	add("lilac_wart_block", LILAC_WART_BLOCK);
    	add("lilac_planks", LILAC_PLANKS);
    	add("leafy_planks", LEAFY_PLANKS);
    	add("lilac_stairs", LILAC_STAIRS);
    	add("leafy_stairs", LEAFY_STAIRS);
    	add("lilac_fence", LILAC_FENCE);
    	add("leafy_fence", LEAFY_FENCE);
    	add("lilac_fence_gate", LILAC_FENCE_GATE);
    	add("leafy_fence_gate", LEAFY_FENCE_GATE);
    	add("lilac_slab", LILAC_SLAB);
    	add("leafy_slab", LEAFY_SLAB);
    	add("lilac_pressure_plate", LILAC_PRESSURE_PLATE);
    	add("leafy_pressure_plate", LEAFY_PRESSURE_PLATE);
    	add("lilac_button", LILAC_BUTTON);
    	add("leafy_button", LEAFY_BUTTON);
    	add("lilac_door", LILAC_DOOR);
    	add("leafy_door", LEAFY_DOOR);
    	add("lilac_trapdoor", LILAC_TRAPDOOR);
    	add("leafy_trapdoor", LEAFY_TRAPDOOR);
    	add("lilac_nylium", LILAC_NYLIUM);
    	add("leafy_nylium", LEAFY_NYLIUM);
    	add("leafy_fungus", LEAFY_FUNGUS);
    	add("leafy_roots", LEAFY_ROOTS);
    	add("heart_of_ender_sprouts", HEART_OF_ENDER_SPROUTS);
    	add("lilac_fungus", LILAC_FUNGUS);
    	add("lilac_weeping_vines", LILAC_WEEPING_VINES);
    	add("leafy_twisting_vines", LEAFY_TWISTING_VINES);
    	add("lilac_roots", LILAC_ROOTS);
    	add("soul_shroomlight", SOUL_SHROOMLIGHT);
    	add("lilac_shroomlight", LILAC_SHROOMLIGHT);
    	
    	Registry.register(Registry.BLOCK, new Identifier(HeartofEnder.MODID, "green_fire"), GREEN_FIRE);
    	Registry.register(Registry.BLOCK, new Identifier(HeartofEnder.MODID, "leafy_twisting_vines_plant"), LEAFY_TWISTING_VINES_PLANT);
    	Registry.register(Registry.BLOCK, new Identifier(HeartofEnder.MODID, "lilac_weeping_vines_plant"), LILAC_WEEPING_VINES_PLANT);
    }
    
    private static void add(String name, Block b)
    {
    	Registry.register(Registry.BLOCK, new Identifier(HeartofEnder.MODID, name), b);
    	blockItem(b, name);
	}
    
    private static void blockItem(Block b, String n)
    {
        Registry.register(Registry.ITEM, new Identifier(HeartofEnder.MODID, n), new BlockItem(b, new Item.Settings().group(HeartofEnder.TAB_BLOCKS)));
    }
}