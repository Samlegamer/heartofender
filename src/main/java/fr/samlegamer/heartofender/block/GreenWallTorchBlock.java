package fr.samlegamer.heartofender.block;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GreenWallTorchBlock extends GreenTorchBlock
{
	   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	   private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.box(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.box(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.box(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));

	   public GreenWallTorchBlock(BlockBehaviour.Properties p_i241193_1_) {
	      super(p_i241193_1_);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	   }

	   public String getDescriptionId() {
	      return this.asItem().getDescriptionId();
	   }

	   public VoxelShape getShape(BlockState p_220053_1_, LevelReader p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
	      return getShape(p_220053_1_);
	   }

	   public static VoxelShape getShape(BlockState p_220289_0_) {
	      return AABBS.get(p_220289_0_.getValue(FACING));
	   }

	   public boolean canSurvive(BlockState p_196260_1_, LevelReader p_196260_2_, BlockPos p_196260_3_) {
	      Direction direction = p_196260_1_.getValue(FACING);
	      BlockPos blockpos = p_196260_3_.relative(direction.getOpposite());
	      BlockState blockstate = p_196260_2_.getBlockState(blockpos);
	      return blockstate.isFaceSturdy(p_196260_2_, blockpos, direction);
	   }

	   @Nullable
	   public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
	      BlockState blockstate = this.defaultBlockState();
	      LevelReader iworldreader = p_196258_1_.getLevel();
	      BlockPos blockpos = p_196258_1_.getClickedPos();
	      Direction[] adirection = p_196258_1_.getNearestLookingDirections();

	      for(Direction direction : adirection) {
	         if (direction.getAxis().isHorizontal()) {
	            Direction direction1 = direction.getOpposite();
	            blockstate = blockstate.setValue(FACING, direction1);
	            if (blockstate.canSurvive(iworldreader, blockpos)) {
	               return blockstate;
	            }
	         }
	      }

	      return null;
	   }

	   public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, LevelAccessor p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
	      return p_196271_2_.getOpposite() == p_196271_1_.getValue(FACING) && !p_196271_1_.canSurvive(p_196271_4_, p_196271_5_) ? Blocks.AIR.defaultBlockState() : p_196271_1_;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState p_180655_1_, Level p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
	      Direction direction = p_180655_1_.getValue(FACING);
	      double d0 = (double)p_180655_3_.getX() + 0.5D;
	      double d1 = (double)p_180655_3_.getY() + 0.7D;
	      double d2 = (double)p_180655_3_.getZ() + 0.5D;
	      double d3 = 0.22D;
	      double d4 = 0.27D;
	      Direction direction1 = direction.getOpposite();
	      p_180655_2_.addParticle(ParticleTypes.SMOKE, d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
	      p_180655_2_.addParticle(HoeParticleRegistry.GREEN_FLAME.get(), d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
	   }

	   public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
	      return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
	   }

	   public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
	      return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
	   }

	   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
	      p_206840_1_.add(FACING);
	   }
	}