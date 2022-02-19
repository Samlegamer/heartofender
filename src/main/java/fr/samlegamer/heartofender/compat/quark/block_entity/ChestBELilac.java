package fr.samlegamer.heartofender.compat.quark.block_entity;

import fr.samlegamer.heartofender.compat.HoeCompats;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChestBELilac extends ChestBlockEntity
{
	   protected ChestBELilac(BlockEntityType<?> p_155327_, BlockPos p_155328_, BlockState p_155329_) {
		      super(p_155327_, p_155328_, p_155329_);
		   }

		   public ChestBELilac(BlockPos p_155331_, BlockState p_155332_) {
		      this(HoeCompats.Quark.lilac_chest_be.get(), p_155331_, p_155332_);
		   }

}
