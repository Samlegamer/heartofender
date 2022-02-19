package fr.samlegamer.heartofender.compat.quark.block_entity;

import fr.samlegamer.heartofender.compat.HoeCompats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChestBELeafy extends ChestBlockEntity
{
	   protected ChestBELeafy(BlockEntityType<?> p_155327_, BlockPos p_155328_, BlockState p_155329_) {
		      super(p_155327_, p_155328_, p_155329_);
		   }

		   public ChestBELeafy(BlockPos p_155331_, BlockState p_155332_) {
		      this(HoeCompats.Quark.leafy_chest_be.get(), p_155331_, p_155332_);
		   }

}
