package fr.samlegamer.heartofender.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;

public class HoeBlocksUtils
{
	public static final BlockBehaviour.Properties STONE_BASE = BlockBehaviour.Properties.of().sound(SoundType.STONE).requiresCorrectToolForDrops();
	public static final BlockBehaviour.Properties METAL_BASE = BlockBehaviour.Properties.of().sound(SoundType.METAL).requiresCorrectToolForDrops();
	public static final BlockBehaviour.Properties GLOWSTONE_BASE = BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.3F);
	public static final BlockBehaviour.Properties FIRE_BASE = BlockBehaviour.Properties.of().instabreak().noCollission().sound(SoundType.WOOL);
	public static final BlockBehaviour.Properties CAMPFIRES = BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion();
	public static final BlockBehaviour.Properties TORCH_BASE = BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WOOD);
	public static final BlockBehaviour.Properties WALL_TORCH_BASE = BlockBehaviour.Properties.of().noCollission().sound(SoundType.WOOD).instabreak();
	public static final BlockBehaviour.Properties LANTERNS = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).noOcclusion();

	public static final BlockBehaviour.Properties DARK_FENCE = BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(3.5F).requiresCorrectToolForDrops();
	public static final BlockBehaviour.Properties DARK_SLAB = BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(3.5f, 15f).requiresCorrectToolForDrops();
	public static final BlockBehaviour.Properties DARK_PLATE = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE);
	public static final BlockBehaviour.Properties DARK_BUTTON = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).requiresCorrectToolForDrops();

	public static final BlockBehaviour.Properties STEM_BASE = BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STEM);
	public static final BlockBehaviour.Properties WOOD_BASE = BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD);
	public static final BlockBehaviour.Properties WART = BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.WART_BLOCK);
	public static final BlockBehaviour.Properties PLANKS_BASE = BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD);
	public static final BlockBehaviour.Properties PLANKS_PLATE = BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.5F);
	
	//Paste Function for Trapdoors
	public static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_)
	{
	      return (boolean)false;
	}
	
	   public static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
		      return (boolean)true;
		   }

	   public static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
		      return true;
		   }

}