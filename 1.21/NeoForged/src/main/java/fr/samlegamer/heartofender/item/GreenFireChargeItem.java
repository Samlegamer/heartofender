package fr.samlegamer.heartofender.item;

import fr.samlegamer.heartofender.block.BaseHoeFireBlock;
import fr.samlegamer.heartofender.block.GreenCampfire;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

public class GreenFireChargeItem extends FireChargeItem
{
	public GreenFireChargeItem(Properties p_41202_)
	{
		super(p_41202_);
	}

	 @Override
     public InteractionResult useOn(UseOnContext pContext) {
         Level level = pContext.getLevel();
         BlockPos blockpos = pContext.getClickedPos();
         BlockState blockstate = level.getBlockState(blockpos);
         boolean flag = false;
         if (!GreenCampfire.canLight(blockstate) && !CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
             blockpos = blockpos.relative(pContext.getClickedFace());
             if (BaseHoeFireBlock.canBePlacedAt(level, blockpos, pContext.getHorizontalDirection())) {
                 this.playSound(level, blockpos);
                 level.setBlockAndUpdate(blockpos, BaseHoeFireBlock.getState(level, blockpos));
                 level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_PLACE, blockpos);
                 flag = true;
             }
         } else {
             this.playSound(level, blockpos);
             level.setBlockAndUpdate(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)));
             level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
             flag = true;
         }

         if (flag) {
             pContext.getItemInHand().shrink(1);
             return InteractionResult.sidedSuccess(level.isClientSide);
         } else {
             return InteractionResult.FAIL;
         }
     }
     
     private void playSound(Level pLevel, BlockPos pPos) {
         RandomSource randomsource = pLevel.getRandom();
         pLevel.playSound(
             null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (randomsource.nextFloat() - randomsource.nextFloat()) * 0.2F + 1.0F
         );
     }
}