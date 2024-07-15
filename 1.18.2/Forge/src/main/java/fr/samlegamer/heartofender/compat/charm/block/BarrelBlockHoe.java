package fr.samlegamer.heartofender.compat.charm.block;

import java.util.Random;
import javax.annotation.Nullable;

import fr.samlegamer.heartofender.compat.charm.block_entity.BarrelBlockEntityHoe;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BarrelBlockHoe
{
	public static class Lilac extends BarrelBlock
	{
		public Lilac(Properties p_49046_) { super(p_49046_); }
		
		public InteractionResult use(BlockState p_49069_, Level p_49070_, BlockPos p_49071_, Player p_49072_, InteractionHand p_49073_, BlockHitResult p_49074_) {
		      if (p_49070_.isClientSide) {
		         return InteractionResult.SUCCESS;
		      } else {
		         BlockEntity blockentity = p_49070_.getBlockEntity(p_49071_);
		         if (blockentity instanceof BarrelBlockEntityHoe.Lilac) {
		            p_49072_.openMenu((BarrelBlockEntityHoe.Lilac)blockentity);
		            p_49072_.awardStat(Stats.OPEN_BARREL);
		            PiglinAi.angerNearbyPiglins(p_49072_, true);
		         }
		         return InteractionResult.CONSUME;
		      }
		   }
		
		public void tick(BlockState p_49060_, ServerLevel p_49061_, BlockPos p_49062_, Random p_49063_) {
		      BlockEntity blockentity = p_49061_.getBlockEntity(p_49062_);
		      if (blockentity instanceof BarrelBlockEntityHoe.Lilac) {
		         ((BarrelBlockEntityHoe.Lilac)blockentity).recheckOpen();
		      }

		   }

		   @Nullable
		   public BlockEntity newBlockEntity(BlockPos p_152102_, BlockState p_152103_) {
		      return new BarrelBlockEntityHoe.Lilac(p_152102_, p_152103_);
		   }

		   public void setPlacedBy(Level p_49052_, BlockPos p_49053_, BlockState p_49054_, @Nullable LivingEntity p_49055_, ItemStack p_49056_) {
		      if (p_49056_.hasCustomHoverName()) {
		         BlockEntity blockentity = p_49052_.getBlockEntity(p_49053_);
		         if (blockentity instanceof BarrelBlockEntityHoe.Lilac) {
		            ((BarrelBlockEntityHoe.Lilac)blockentity).setCustomName(p_49056_.getHoverName());
		         }
		      }

		   }

	}
	
	public static class Leafy extends BarrelBlock
	{
		public Leafy(Properties p_49046_) { super(p_49046_); }
		
		public InteractionResult use(BlockState p_49069_, Level p_49070_, BlockPos p_49071_, Player p_49072_, InteractionHand p_49073_, BlockHitResult p_49074_) {
		      if (p_49070_.isClientSide) {
		         return InteractionResult.SUCCESS;
		      } else {
		         BlockEntity blockentity = p_49070_.getBlockEntity(p_49071_);
		         if (blockentity instanceof BarrelBlockEntityHoe.Leafy) {
		            p_49072_.openMenu((BarrelBlockEntityHoe.Leafy)blockentity);
		            p_49072_.awardStat(Stats.OPEN_BARREL);
		            PiglinAi.angerNearbyPiglins(p_49072_, true);
		         }
		         return InteractionResult.CONSUME;
		      }
		   }
		
		public void tick(BlockState p_49060_, ServerLevel p_49061_, BlockPos p_49062_, Random p_49063_) {
		      BlockEntity blockentity = p_49061_.getBlockEntity(p_49062_);
		      if (blockentity instanceof BarrelBlockEntityHoe.Leafy) {
		         ((BarrelBlockEntityHoe.Leafy)blockentity).recheckOpen();
		      }

		   }

		   @Nullable
		   public BlockEntity newBlockEntity(BlockPos p_152102_, BlockState p_152103_) {
		      return new BarrelBlockEntityHoe.Leafy(p_152102_, p_152103_);
		   }

		   public void setPlacedBy(Level p_49052_, BlockPos p_49053_, BlockState p_49054_, @Nullable LivingEntity p_49055_, ItemStack p_49056_) {
		      if (p_49056_.hasCustomHoverName()) {
		         BlockEntity blockentity = p_49052_.getBlockEntity(p_49053_);
		         if (blockentity instanceof BarrelBlockEntityHoe.Leafy) {
		            ((BarrelBlockEntityHoe.Leafy)blockentity).setCustomName(p_49056_.getHoverName());
		         }
		      }
		   }
	}
}