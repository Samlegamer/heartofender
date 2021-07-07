package fr.samlegamer.heartofender.world.worldgen.fortress;

import java.util.Random;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.utils.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.common.DimensionManager;

public class WorldGenHeartFortress extends WorldGenerator implements IStructure
{
	public static String name;
	
	public WorldGenHeartFortress(String name)
	{
		this.name = name;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		this.generateStructure(worldIn, position);
		return true;
	}
	
	public static void generateStructure(World worldIn, BlockPos pos)
	{
		MinecraftServer mcServer = worldIn.getMinecraftServer();
		TemplateManager mana = worldserv.getStructureTemplateManager();
		ResourceLocation rl = new ResourceLocation(References.MODID, name);
		Template temp = mana.get(mcServer, rl);
		
		WorldServer serv = DimensionManager.getWorld(2);;
		Random random = new Random();
		int id = random.nextInt(7) + 1;
		Template structure = mana.get(serv.getMinecraftServer(), new ResourceLocation(References.MODID, "structures/heart_fortress" + id));

		
		if(temp != null)
		{
			IBlockState state = worldIn.getBlockState(pos);
			worldIn.notifyBlockUpdate(pos, state, state, 3);
			temp.addBlocksToWorldChunk(worldIn, pos, set);
		}
	}
}
