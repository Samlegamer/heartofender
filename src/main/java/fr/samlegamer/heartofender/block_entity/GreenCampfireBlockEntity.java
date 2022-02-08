package fr.samlegamer.heartofender.block_entity;

import java.util.Random;

import fr.samlegamer.heartofender.block.GreenCampfire;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GreenCampfireBlockEntity extends CampfireBlockEntity
{
	private final NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

	public GreenCampfireBlockEntity(BlockPos p_155301_, BlockState p_155302_)
	{
		super(p_155301_, p_155302_);
	}

	   public static void particleTick(Level p_155319_, BlockPos p_155320_, BlockState p_155321_, GreenCampfireBlockEntity p_155322_) {
		      Random random = p_155319_.random;
		      if (random.nextFloat() < 0.11F) {
		         for(int i = 0; i < random.nextInt(2) + 2; ++i) {
		            GreenCampfire.makeParticles(p_155319_, p_155320_, p_155321_.getValue(GreenCampfire.SIGNAL_FIRE), false);
		         }
		      }

		      int l = p_155321_.getValue(GreenCampfire.FACING).get2DDataValue();

		      for(int j = 0; j < p_155322_.items.size(); ++j) {
		         if (!p_155322_.items.get(j).isEmpty() && random.nextFloat() < 0.2F) {
		            Direction direction = Direction.from2DDataValue(Math.floorMod(j + l, 4));
		            float f = 0.3125F;
		            double d0 = (double)p_155320_.getX() + 0.5D - (double)((float)direction.getStepX() * 0.3125F) + (double)((float)direction.getClockWise().getStepX() * 0.3125F);
		            double d1 = (double)p_155320_.getY() + 0.5D;
		            double d2 = (double)p_155320_.getZ() + 0.5D - (double)((float)direction.getStepZ() * 0.3125F) + (double)((float)direction.getClockWise().getStepZ() * 0.3125F);

		            for(int k = 0; k < 4; ++k) {
		               p_155319_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 5.0E-4D, 0.0D);
		            }
		         }
		      }

		   }
}