package fr.samlegamer.heartofender.compat.quark.block;

import fr.samlegamer.heartofender.compat.HoeCompats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BookshelvesHoe
{
	public static class Lilac extends Block
	{
		public Lilac(Properties p_49795_)
		{
			super(p_49795_);
		}

		@Override
		public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos)
		{
			return state.is(HoeCompats.Quark.lilac_bookshelf.get()) ? 1: 0;
		}
	}
	
	public static class Leafy extends Block
	{
		public Leafy(Properties p_49795_)
		{
			super(p_49795_);
		}

		@Override
		public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos)
		{
			return state.is(HoeCompats.Quark.leafy_bookshelf.get()) ? 1: 0;
		}
	}
}