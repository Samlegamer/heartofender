package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class GreenTorchBlock extends Block
{
	   protected static final VoxelShape AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);

	   public GreenTorchBlock(BlockBehaviour.Properties p_i241189_1_)
	   {
	      super(p_i241189_1_);
	   }
	   
	   public VoxelShape getShape(BlockState p_57510_, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_)
	   {
		      return AABB;
	   }

	   public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, LevelAccessor p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
	      return p_196271_2_ == Direction.DOWN && !this.canSurvive(p_196271_1_, p_196271_4_, p_196271_5_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
	   }

	   public boolean canSurvive(BlockState p_196260_1_, LevelReader p_196260_2_, BlockPos p_196260_3_) {
	      return canSupportCenter(p_196260_2_, p_196260_3_.below(), Direction.UP);
	   }

	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState p_180655_1_, Level p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
	      double d0 = (double)p_180655_3_.getX() + 0.5D;
	      double d1 = (double)p_180655_3_.getY() + 0.7D;
	      double d2 = (double)p_180655_3_.getZ() + 0.5D;
	      p_180655_2_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	      p_180655_2_.addParticle(HoeParticleRegistry.GREEN_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	   }
	}