package fr.samlegamer.heartofender.world.structures;

import java.util.Random;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.forfluids.ModBlocks;
import fr.samlegamer.heartofender.utils.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureHeartFortress implements IStructure
{    
	public static String structureName = "heart_fortress";
	
	public StructureHeartFortress() 
	{
		//this.structureName = name;
	}
	
	public boolean generate(World world, Random random, BlockPos pos, int spawnChance)
	{
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for(int i = 0; i < spawnChance; i++);
		
		ResourceLocation location1 = new ResourceLocation(References.MODID, "structures/" + structureName + "1");
		ResourceLocation location2 = new ResourceLocation(References.MODID, "structures/" + structureName + "2");
		ResourceLocation location3 = new ResourceLocation(References.MODID, "structures/" + structureName + "3");
		ResourceLocation location4 = new ResourceLocation(References.MODID, "structures/" + structureName + "4");
		ResourceLocation location5 = new ResourceLocation(References.MODID, "structures/" + structureName + "5");
		ResourceLocation location6 = new ResourceLocation(References.MODID, "structures/" + structureName + "6");
		ResourceLocation location7 = new ResourceLocation(References.MODID, "structures/" + structureName + "7");

		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldserv.getStructureTemplateManager();
		Template template1 = manager.get(mcServer, location1);
		Template template2 = manager.get(mcServer, location2);
		Template template3 = manager.get(mcServer, location3);
		Template template4 = manager.get(mcServer, location4);
		Template template5 = manager.get(mcServer, location5);
		Template template6 = manager.get(mcServer, location6);
		Template template7 = manager.get(mcServer, location7);
	    			
			if(template1 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
			}
			/*
			else if(template2 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template2.addBlocksToWorldChunk(world, pos.east(32), settings);
			}
			else if(template3 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template3.addBlocksToWorldChunk(world, pos.north(32), settings);
			}
			else if(template4 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 12);
				template4.addBlocksToWorldChunk(world, pos.east(64), settings);
			}
			else if(template5 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template5.addBlocksToWorldChunk(world, pos.north(64), settings);
			}
			else if(template6 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template6.addBlocksToWorldChunk(world, pos.east(96), settings);
			}
			else if(template7 != null)
			{
				IBlockState state = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template7.addBlocksToWorldChunk(world, pos.north(96), settings);
			}
			*/
			return true;
		
		//this.generateStructure(world, random, pos);
	}
	
	
	
	public static void generateStructure(World world, Random random, BlockPos pos)
	{	
		
		/*
		switch("template")
		{
			case "1":
				IBlockState state1 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state1, state1, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "2":
				IBlockState state2 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "3":
				IBlockState state3 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "4":
				IBlockState state4 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "5":
				IBlockState state5 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "6":
				IBlockState state6 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
			case "7":
				IBlockState state7 = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, state, state, 3);
				template1.addBlocksToWorldChunk(world, pos, settings);
				break;
		}
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager templateManager = worldserv.getStructureTemplateManager();;
		
		if(templateManager != null)
		{
	        Template template_1 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress1"));
	        Template template_2 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress2"));
	        Template template_3 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress3"));
	        Template template_4 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress4"));
	        Template template_5 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress5"));
	        Template template_6 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress6"));
	        Template template_7 = templateManager.get(world.getMinecraftServer(), new ResourceLocation(References.MODID + ":structures/heart_fortress7"));
			
	        template_1.addBlocksToWorldChunk(world, centerPos.east(28).north(7).down(), set);
	        
	        template_2.addBlocksToWorldChunk(world, centerPos.south(28).east(7).down(), set);
	        template_3.addBlocksToWorldChunk(world, centerPos.west(28).south(7).down(), set);
	        template_4.addBlocksToWorldChunk(world, centerPos.north(28).west(7).down(), set);
	        template_5.addBlocksToWorldChunk(world, centerPos.north(28).west(7).down(), set);
	        template_6.addBlocksToWorldChunk(world, centerPos.north(28).west(7).down(), set);
	        template_7.addBlocksToWorldChunk(world, centerPos.north(28).west(7).down(), set);
			
		}
		*/
	}
}