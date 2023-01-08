package fr.samlegamer.heartofender.compat.quark.block;

import fr.samlegamer.heartofender.compat.HoeCompats;
import fr.samlegamer.heartofender.compat.quark.block_entity.ChestBELilac;
import fr.samlegamer.heartofender.compat.quark.block_entity.TrappedChestBELilac;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrappedChestBlockLilac extends ChestBlockHoe.Lilac
{
	public TrappedChestBlockLilac(Properties p_51490_) {super(p_51490_,()->{return HoeCompats.Quark.trapped_lilac_chest_be.get();});}

	   public BlockEntity newBlockEntity(BlockPos p_154834_, BlockState p_154835_) {
	      return new TrappedChestBELilac(p_154834_, p_154835_);
	   }

	   protected Stat<ResourceLocation> getOpenChestStat() {
	      return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
	   }

	   public boolean isSignalSource(BlockState p_57587_) {
	      return true;
	   }

	   public int getSignal(BlockState p_57577_, BlockGetter p_57578_, BlockPos p_57579_, Direction p_57580_) {
	      return Mth.clamp(ChestBELilac.getOpenCount(p_57578_, p_57579_), 0, 15);
	   }

	   public int getDirectSignal(BlockState p_57582_, BlockGetter p_57583_, BlockPos p_57584_, Direction p_57585_) {
	      return p_57585_ == Direction.UP ? p_57582_.getSignal(p_57583_, p_57584_, p_57585_) : 0;
	   }
}