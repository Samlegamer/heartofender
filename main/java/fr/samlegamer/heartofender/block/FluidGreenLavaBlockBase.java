package fr.samlegamer.heartofender.block;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class FluidGreenLavaBlockBase extends FlowingFluidBlock
{
	public FluidGreenLavaBlockBase(Supplier<? extends FlowingFluid> fluidSupplier, Properties properties)
	{
        super(fluidSupplier, properties);
	}
	
	@Override
    public void neighborChanged(BlockState blockState, World world, BlockPos blockPos, Block neighborBlock, BlockPos neighborBlockPos, boolean someBoolean) {
	    super.neighborChanged(blockState, world, blockPos, neighborBlock, neighborBlockPos, someBoolean);
		if (neighborBlock == this) {
	        return;
        }
        BlockState neighborBlockState = world.getBlockState(neighborBlockPos);
		if (neighborBlockState.getBlock() == this) {
		    return;
        }
        if (this.shouldSpreadLiquid(world, neighborBlockPos, blockState)) {
            world.getLiquidTicks().scheduleTick(blockPos, blockState.getFluidState().getType(), this.getFluid().getTickDelay(world));
        }
    }

    public boolean shouldSpreadLiquid(World world, BlockPos neighborBlockPos, BlockState blockState) {
        BlockState neighborBlockState = world.getBlockState(neighborBlockPos);
        if (neighborBlockState.getMaterial().isLiquid()) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void entityInside(BlockState blockState, World world, BlockPos pos, Entity entity) {
        super.entityInside(blockState, world, pos, entity);
    }

	/** Client side animation and sounds. **/
    @SuppressWarnings("unused")
	@OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		super.animateTick(state, world, pos, random);
    }
}