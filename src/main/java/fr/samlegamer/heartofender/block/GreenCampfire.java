package fr.samlegamer.heartofender.block;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import fr.samlegamer.heartofender.block_entity.GreenCampfireBlockEntity;
import fr.samlegamer.heartofender.block_entity.HoeBlockEntityRegistry;
import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class GreenCampfire extends CampfireBlock
{
	   private final boolean spawnParticles;

	public GreenCampfire(boolean p_51236_, int p_51237_, Properties p_51238_)
	{
		super(p_51236_, p_51237_, p_51238_);
	      this.spawnParticles = p_51236_;
	}

	   public InteractionResult use(BlockState p_51274_, Level p_51275_, BlockPos p_51276_, Player p_51277_, InteractionHand p_51278_, BlockHitResult p_51279_) {
		      BlockEntity blockentity = p_51275_.getBlockEntity(p_51276_);
		      if (blockentity instanceof GreenCampfireBlockEntity) {
		    	  GreenCampfireBlockEntity campfireblockentity = (GreenCampfireBlockEntity)blockentity;
		         ItemStack itemstack = p_51277_.getItemInHand(p_51278_);
		         Optional<CampfireCookingRecipe> optional = campfireblockentity.getCookableRecipe(itemstack);
		         if (optional.isPresent()) {
		            if (!p_51275_.isClientSide && campfireblockentity.placeFood(p_51277_.getAbilities().instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
		               p_51277_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
		               return InteractionResult.SUCCESS;
		            }

		            return InteractionResult.CONSUME;
		         }
		      }

		      return InteractionResult.PASS;
		   }

	   public void onRemove(BlockState p_51281_, Level p_51282_, BlockPos p_51283_, BlockState p_51284_, boolean p_51285_) {
		      if (!p_51281_.is(p_51284_.getBlock())) {
		         BlockEntity blockentity = p_51282_.getBlockEntity(p_51283_);
		         if (blockentity instanceof GreenCampfireBlockEntity) {
		            Containers.dropContents(p_51282_, p_51283_, ((GreenCampfireBlockEntity)blockentity).getItems());
		         }

		         super.onRemove(p_51281_, p_51282_, p_51283_, p_51284_, p_51285_);
		      }
		   }

	   public static void dowse(@Nullable Entity p_152750_, LevelAccessor p_152751_, BlockPos p_152752_, BlockState p_152753_) {
		      if (p_152751_.isClientSide()) {
		         for(int i = 0; i < 20; ++i) {
		            makeParticles((Level)p_152751_, p_152752_, p_152753_.getValue(SIGNAL_FIRE), true);
		         }
		      }

		      BlockEntity blockentity = p_152751_.getBlockEntity(p_152752_);
		      if (blockentity instanceof GreenCampfireBlockEntity) {
		         ((GreenCampfireBlockEntity)blockentity).dowse();
		      }

		      p_152751_.gameEvent(p_152750_, GameEvent.BLOCK_CHANGE, p_152752_);
		   }
	
	   public BlockEntity newBlockEntity(BlockPos p_152759_, BlockState p_152760_) {
		      return new GreenCampfireBlockEntity(p_152759_, p_152760_);
		   }

		   @Nullable
		   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152755_, BlockState p_152756_, BlockEntityType<T> p_152757_) {
		      if (p_152755_.isClientSide) {
		         return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, HoeBlockEntityRegistry.GREEN_CAMPFIRE_TILE.get(), GreenCampfireBlockEntity::particleTick) : null;
		      } else {
		         return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, HoeBlockEntityRegistry.GREEN_CAMPFIRE_TILE.get(), GreenCampfireBlockEntity::cookTick) : createTickerHelper(p_152757_, BlockEntityType.CAMPFIRE, GreenCampfireBlockEntity::cooldownTick);
		      }
		   }

		   public void animateTick(BlockState p_51287_, Level p_51288_, BlockPos p_51289_, Random p_51290_) {
			      if (p_51287_.getValue(LIT)) {
			         if (p_51290_.nextInt(10) == 0) {
			            p_51288_.playLocalSound((double)p_51289_.getX() + 0.5D, (double)p_51289_.getY() + 0.5D, (double)p_51289_.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + p_51290_.nextFloat(), p_51290_.nextFloat() * 0.7F + 0.6F, false);
			         }

			         if (this.spawnParticles && p_51290_.nextInt(5) == 0) {
			            for(int i = 0; i < p_51290_.nextInt(1) + 1; ++i) {
			               p_51288_.addParticle(HoeParticleRegistry.GREEN_LAVA.get(), (double)p_51289_.getX() + 0.5D, (double)p_51289_.getY() + 0.5D, (double)p_51289_.getZ() + 0.5D, (double)(p_51290_.nextFloat() / 2.0F), 5.0E-5D, (double)(p_51290_.nextFloat() / 2.0F));
			            }
			         }

			      }
			   }

}
