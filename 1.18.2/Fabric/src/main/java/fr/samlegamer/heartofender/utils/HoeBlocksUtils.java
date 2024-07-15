package fr.samlegamer.heartofender.utils;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class HoeBlocksUtils
{
	public static final AbstractBlock.Settings STONE_BASE = AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).requiresTool();
	public static final AbstractBlock.Settings METAL_BASE = AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.METAL).requiresTool();
	public static final AbstractBlock.Settings GLOWSTONE_BASE = AbstractBlock.Settings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(0.3F);
	public static final AbstractBlock.Settings FIRE_BASE = AbstractBlock.Settings.of(Material.FIRE).breakInstantly().noCollision().sounds(BlockSoundGroup.WOOL).dropsNothing();
	public static final AbstractBlock.Settings CAMPFIRES = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD).nonOpaque();
	public static final AbstractBlock.Settings TORCH_BASE = AbstractBlock.Settings.of(Material.DECORATION).noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD);
	public static final AbstractBlock.Settings WALL_TORCH_BASE = AbstractBlock.Settings.of(Material.DECORATION).noCollision().sounds(BlockSoundGroup.WOOD).breakInstantly();
	public static final AbstractBlock.Settings LANTERNS = AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).nonOpaque();

	public static final AbstractBlock.Settings DARK_FENCE = AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(3.5F).requiresTool();
	public static final AbstractBlock.Settings DARK_SLAB = AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(3.5f, 15f).requiresTool();
	public static final AbstractBlock.Settings DARK_PLATE = AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(0.5F).requiresTool();
	public static final AbstractBlock.Settings DARK_BUTTON = AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(0.5F).requiresTool();

	public static final AbstractBlock.Settings STEM_BASE = AbstractBlock.Settings.of(Material.NETHER_WOOD).strength(2.0F).sounds(BlockSoundGroup.STEM);
	public static final AbstractBlock.Settings WOOD_BASE = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD);
	public static final AbstractBlock.Settings WART = AbstractBlock.Settings.of(Material.PLANT).strength(1.0F).sounds(BlockSoundGroup.WART_BLOCK);
	public static final AbstractBlock.Settings PLANKS_BASE = AbstractBlock.Settings.of(Material.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
	public static final AbstractBlock.Settings PLANKS_PLATE = AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.5F);
	
	
    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

	/*
	   public static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
		      return (boolean)true;
		   }

	   public static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
		      return true;
		   }*/
}