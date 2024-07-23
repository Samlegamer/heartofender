package fr.samlegamer.heartofender.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleFire extends BaseHoeFireBlock
{
    public static final MapCodec<PurpleFire> CODEC = simpleCodec(PurpleFire::new);

    @Override
    public MapCodec<PurpleFire> codec() {
        return CODEC;
    }

    public PurpleFire(BlockBehaviour.Properties p_56653_) {
        super(p_56653_, 4.0F);
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return this.canSurvive(pState, pLevel, pCurrentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return canSurviveOnBlock(pLevel.getBlockState(pPos.below()));
    }

    public static boolean canSurviveOnBlock(BlockState p_154651_) {
	      return p_154651_.is(HoeBlocksRegistry.DEAD_SOUL_SOIL.get()) || p_154651_.is(HoeBlocksRegistry.DEAD_SOUL_SAND.get());
	   }

    @Override
    protected boolean canBurn(BlockState pState) {
        return true;
    }
}