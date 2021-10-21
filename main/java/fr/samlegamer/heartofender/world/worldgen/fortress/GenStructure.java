package fr.samlegamer.heartofender.world.worldgen.fortress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.world.biomes.DarkBiome;
import fr.samlegamer.heartofender.world.structures.StructureHeartFortress;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenStructure implements IWorldGenerator
{
	//public static final StructureHeartFortress HEART_FORTRESS = new StructureHeartFortress("heart_fortress");
	//public static final TestStructure ARMOURY = new TestStructure("heartfortress");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case 2:
			break;
		case 1:
			break;
		case 0:
			//generateStructure(ARMOURY, world, random, chunkX, chunkZ, 20, Blocks.SAND, BiomeDesert.class);

			//generateStructure(HEART_FORTRESS, world, random, chunkX, chunkZ, 75, Blocks.GRASS, BiomePlains.class);
			break;
	
		case -1:
	
			break;
		}
	}
	
	public void generateStructure(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>...classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + rand.nextInt(126);
		int z = (chunkZ * 16) + rand.nextInt(126);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}