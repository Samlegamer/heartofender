package fr.samlegamer.heartofender.world.worldgen.fortress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import fr.samlegamer.heartofender.inits.BlocksMod;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenStructure implements IWorldGenerator
{
	public static final WorldGenHeartFortress HEART_FORTRESS = new WorldGenHeartFortress("heartfortress");
    
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case 2:
			
			generateStructure(HEART_FORTRESS, world, random, chunkX, 25, chunkZ, BlocksMod.dark_end_stone);
			
			break;
			
		case 1:
			
			break;
		case 0:
	
			break;
	
		case -1:
	
			break;
		}
	}
	
	private void generateStructure(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>...classes)
	{
		ArrayList<Class<?>> classeList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = genHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classeList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					gen.generate(world, rand, pos);
				}
			}
		}
	}
	
	private static int genHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean ground = false;
		
		while(!ground && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			ground = block == topBlock;
		}
		return y;
	}
}