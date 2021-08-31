package fr.samlegamer.heartofender.world.structures;

import java.util.Random;

import fr.samlegamer.heartofender.core.References;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class HeartFortressInNBT extends WorldGenerator
{
    public EnumFacing facing;
    private static final ResourceLocation P1 = new ResourceLocation(References.MODID, "heart_fortress1");
    private static final ResourceLocation P2 = new ResourceLocation(References.MODID, "heart_fortress2");
    private static final ResourceLocation P3 = new ResourceLocation(References.MODID, "heart_fortress3");
    private static final ResourceLocation P4 = new ResourceLocation(References.MODID, "heart_fortress4");
    private static final ResourceLocation P5 = new ResourceLocation(References.MODID, "heart_fortress5");
    private static final ResourceLocation P6 = new ResourceLocation(References.MODID, "heart_fortress6");
    private static final ResourceLocation P7 = new ResourceLocation(References.MODID, "heart_fortress7");

    
    public static Rotation getRotationFromFacing(EnumFacing facing) {
        switch (facing) {
            case EAST:
                return Rotation.CLOCKWISE_90;
            case SOUTH:
                return Rotation.CLOCKWISE_180;
            case WEST:
                return Rotation.COUNTERCLOCKWISE_90;
            default:
                return Rotation.NONE;
        }
    }

    public static BlockPos getGround(BlockPos pos, World world) {
        return getGround(pos.getX(), pos.getZ(), world);
    }
    
    public static BlockPos getGround(int x, int z, World world) {
        BlockPos skyPos = new BlockPos(x, world.getHeight(), z);
        while ((!world.getBlockState(skyPos).isOpaqueCube() || canHeightSkipBlock(skyPos, world)) && skyPos.getY() > 1) {
            skyPos = skyPos.down();
        }
        return skyPos;
    }
    
    private static boolean canHeightSkipBlock(BlockPos pos, World world) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock() instanceof BlockLog || state.getBlock() instanceof BlockLeaves || state.getBlock() instanceof BlockLiquid;
    }

    
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
        position = position.add(rand.nextInt(8) - 4, 1, rand.nextInt(8) - 4);
        MinecraftServer server = world.getMinecraftServer();
        BlockPos height = getGround(position, world);
        IBlockState dirt = world.getBlockState(height.down(2));
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        Template template = templateManager.getTemplate(world.getMinecraftServer(), P1);

        PlacementSettings PLA1 = (new PlacementSettings()).setRotation(Rotation.NONE).setIgnoreEntities(true).setIgnoreStructureBlock(true);
        PlacementSettings PLA2 = (new PlacementSettings()).setRotation(Rotation.CLOCKWISE_90).setIgnoreEntities(true).setIgnoreStructureBlock(true);
        PlacementSettings PLA3 = (new PlacementSettings()).setRotation(Rotation.CLOCKWISE_180).setIgnoreEntities(true).setIgnoreStructureBlock(true);
        PlacementSettings PLA4 = (new PlacementSettings()).setRotation(Rotation.COUNTERCLOCKWISE_90).setIgnoreEntities(true).setIgnoreStructureBlock(true);    

        //template.addBlocksToWorld(world, height.east(28).north(7).down(), P1);
        //template.addBlocksToWorldChunk(world, height.south(28).east(7).down(), P2);
        //template.addBlocksToWorldChunk(world, height.west(28).south(7).down(), P3);
        //template.addBlocksToWorldChunk(world, height.north(28).west(7).down(), P4);

        

        
        
		return true;
	}
	
	
	/*
    Template template = this.templateManager.get(this.world.getMinecraftServer(), new ResourceLocation(SilverGamesMod.MOD_ID, "feast/tower_0"));

	
    template.addBlocksToWorldChunk(this.world, this.centerPos.east(28).north(7).down(), PS0);
    template.addBlocksToWorldChunk(this.world, this.centerPos.south(28).east(7).down(), PS90);
    template.addBlocksToWorldChunk(this.world, this.centerPos.west(28).south(7).down(), PS180);
    template.addBlocksToWorldChunk(this.world, this.centerPos.north(28).west(7).down(), PS270);
	 */
	
}