package fr.samlegamer.heartofender.world.biomes.setgreenfire;

import java.util.Random;

import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MapGenGreenFire extends WorldGenerator
{
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() == BlocksMod.dark_end_stone)
            {
                worldIn.setBlockState(blockpos, BlocksMod.green_fire.getDefaultState(), 2);
            }
        }

        return true;
    }
}