package fr.samlegamer.heartofender.block;

import java.util.Random;

import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class GreenLavaFluidBlock extends FluidGreenLavaBlockBase
{	
	public GreenLavaFluidBlock(Fluid fluid, Material material)
	{
		super(fluid, AbstractBlock.Properties.of(material));
	}

	@Override
	public boolean shouldSpreadLiquid(World world, BlockPos neighborBlockPos, BlockState blockState)
	{
		BlockState neighborBlockState = world.getBlockState(neighborBlockPos);

	if (neighborBlockState.getMaterial() == Material.WATER) {
		world.setBlock(neighborBlockPos, ModBlocks.DARK_END_STONE.get().defaultBlockState(), 2);
		return false;
    }

		return super.shouldSpreadLiquid(world, neighborBlockPos, blockState);
	}

	@Override
	public void entityInside(BlockState blockState, World world, BlockPos pos, Entity entity)
	{
		if(entity instanceof ItemEntity)
		entity.hurt(DamageSource.LAVA, 90F);
		super.entityInside(blockState, world, pos, entity);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World world, BlockPos pos, Random random)
	{
		float f;
		float f1;
		float f2;

		if (random.nextInt(100) == 0)
		{
			f = (float)pos.getX() + random.nextFloat();
			f1 = (float)pos.getY() + random.nextFloat() * 0.5F;
			f2 = (float)pos.getZ() + random.nextFloat();
			world.addParticle(ParticleTypes.LAVA, (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
		}
		super.animateTick(state, world, pos, random);
	}
}