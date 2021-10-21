package fr.samlegamer.heartofender.inits;

import java.util.Random;

import fr.samlegamer.heartofender.world.structures.StructureHeartFortress;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenStructures implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		
			case -1:
				GenerateNether(world, chunkX * 16, chunkZ * 16, random);
				break;
				
			case 0:
				GenerateOverWorld(world, chunkX * 16, chunkZ * 16, random);
				break;
			
			case 1:	
				GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
				break;
				
			case 2:	
				GenerateHeartEnder(world, chunkX * 16, chunkZ * 16, random);
				break;
		}
	}

	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minV, int maxV, int spawnChance)
	{
		for(int i = 0; i < spawnChance; i++)
		{
			int defaultChunkSize = 16;
			int Xpos = posX + random.nextInt(defaultChunkSize);
			int Ypos = minY + random.nextInt(maxY - minY);
			int Zpos = posZ + random.nextInt(defaultChunkSize);
			
			IBlockState state = block.getDefaultState();
			BlockPos blockPos = new BlockPos(Xpos, Ypos, Zpos);
			
			new WorldGenMinable(state, maxV).generate(world, random, blockPos);
		}
	}
	
	private void GenerateNether(World world, int i, int j, Random random)
	{
	}
	
	private void GenerateOverWorld(World world, int i, int j, Random random)
	{		
		int Xpos = i + random.nextInt(64);
		int Ypos = random.nextInt(128);
		int Zpos = j + random.nextInt(64);
				
			
		
	}

	private void GenerateEnd(World world, int i, int j, Random random)
	{
		
	}
	
	private void GenerateHeartEnder(World world, int i, int j, Random random)
	{		
		int Xpos = i + random.nextInt(96);
		int Ypos = random.nextInt(128);
		int Zpos = j + random.nextInt(96);
		
		
		new StructureHeartFortress().generate(world, random, new BlockPos(Xpos, Ypos, Zpos), 35);
	}
}