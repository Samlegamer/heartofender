package fr.samlegamer.heartofender.structure.struct;

import java.util.Random;
import javax.annotation.Nullable;
import com.legacy.structure_gel.api.config.StructureConfig;
import com.legacy.structure_gel.api.structure.GelConfigStructure;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import com.mojang.serialization.Codec;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.structure.HoeStructureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.material.Material;

/*
 * 30 nbt WoW
 */
public class HeartofEnderFortressStructure extends GelConfigStructure<NoneFeatureConfiguration>
{
	private static final ResourceLocation HF1 = HeartofEnder.location("heart_fortress/fortress1");
	private static final ResourceLocation HF2 = HeartofEnder.location("heart_fortress/fortress2");
	private static final ResourceLocation HF3 = HeartofEnder.location("heart_fortress/fortress3");
	private static final ResourceLocation HF4 = HeartofEnder.location("heart_fortress/fortress4");
	private static final ResourceLocation HF5 = HeartofEnder.location("heart_fortress/fortress5");
	private static final ResourceLocation HF6 = HeartofEnder.location("heart_fortress/fortress6");
	private static final ResourceLocation HF7 = HeartofEnder.location("heart_fortress/fortress7");
	private static final ResourceLocation HF8 = HeartofEnder.location("heart_fortress/fortress8");
	private static final ResourceLocation HF9 = HeartofEnder.location("heart_fortress/fortress9");
	private static final ResourceLocation HF10 = HeartofEnder.location("heart_fortress/fortress10");
	private static final ResourceLocation HF11 = HeartofEnder.location("heart_fortress/fortress11");
	private static final ResourceLocation HF12 = HeartofEnder.location("heart_fortress/fortress12");
	private static final ResourceLocation HF13 = HeartofEnder.location("heart_fortress/fortress13");
	private static final ResourceLocation HF14 = HeartofEnder.location("heart_fortress/fortress14");
	private static final ResourceLocation HF15 = HeartofEnder.location("heart_fortress/fortress15");
	private static final ResourceLocation HF16 = HeartofEnder.location("heart_fortress/fortress16");
	private static final ResourceLocation HF17 = HeartofEnder.location("heart_fortress/fortress17");
	private static final ResourceLocation HF18 = HeartofEnder.location("heart_fortress/fortress18");
	private static final ResourceLocation HF19 = HeartofEnder.location("heart_fortress/fortress19");
	private static final ResourceLocation HF20 = HeartofEnder.location("heart_fortress/fortress20");
	private static final ResourceLocation HF21 = HeartofEnder.location("heart_fortress/fortress21");
	private static final ResourceLocation HF22 = HeartofEnder.location("heart_fortress/fortress22");
	private static final ResourceLocation HF23 = HeartofEnder.location("heart_fortress/fortress23");
	private static final ResourceLocation HF24 = HeartofEnder.location("heart_fortress/fortress24");
	private static final ResourceLocation HF25 = HeartofEnder.location("heart_fortress/fortress25");
	private static final ResourceLocation HF26 = HeartofEnder.location("heart_fortress/fortress26");
	private static final ResourceLocation HF27 = HeartofEnder.location("heart_fortress/fortress27");
	private static final ResourceLocation HF28 = HeartofEnder.location("heart_fortress/fortress28");
	private static final ResourceLocation HF29 = HeartofEnder.location("heart_fortress/fortress29");
	private static final ResourceLocation HF30 = HeartofEnder.location("heart_fortress/fortress30");

	public HeartofEnderFortressStructure(Codec<NoneFeatureConfiguration> codec, StructureConfig config)
	{
		super(codec, config, PieceGeneratorSupplier.simple(context -> context.validBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG) && isValidPos(context), HeartofEnderFortressStructure::generatePieces));
	}

	private static void generatePieces(StructurePiecesBuilder builder, PieceGenerator.Context<NoneFeatureConfiguration> context)
	{
		ChunkPos chunkPos = context.chunkPos();
		assemble(context.structureManager(), new BlockPos((chunkPos.x << 4) + 9, 30, (chunkPos.z << 4) + 9), Rotation.NONE, builder);
	}

	private static boolean isValidPos(PieceGeneratorSupplier.Context<NoneFeatureConfiguration> context)
	{
		ChunkGenerator chunkGen = context.chunkGenerator();
		ChunkPos chunkPos = context.chunkPos();
		NoiseColumn minCorner = chunkGen.getBaseColumn(chunkPos.getMinBlockX() + 3, chunkPos.getMinBlockZ() + 3, context.heightAccessor());
		NoiseColumn maxCorner = chunkGen.getBaseColumn(chunkPos.getMinBlockX() + 22, chunkPos.getMinBlockZ() + 22, context.heightAccessor());
		return minCorner.getBlock(29).getBlock() == HoeFluidsRegistry.GREEN_LAVA_BLOCK.get() && maxCorner.getBlock(29).getBlock() == HoeFluidsRegistry.GREEN_LAVA_BLOCK.get();
	}
	
	public static void assemble(StructureManager structureManager, BlockPos pos, Rotation rotation, StructurePiecesBuilder builder)
	{
		pos = pos.offset(-12, 0, -12);
		builder.addPiece(new Piece(structureManager, HF1, pos.north(1), rotation));
		builder.addPiece(new Piece(structureManager, HF2, pos.north(6).west(26), rotation));
		builder.addPiece(new Piece(structureManager, HF3, pos.north(6).west(20), rotation));
		builder.addPiece(new Piece(structureManager, HF4, pos.north(6).east(18), rotation));
		builder.addPiece(new Piece(structureManager, HF5, pos.north(6).east(6), rotation));
		builder.addPiece(new Piece(structureManager, HF6, pos.north(17), rotation));
		builder.addPiece(new Piece(structureManager, HF7, pos.north(17).east(22), rotation));
		builder.addPiece(new Piece(structureManager, HF8, pos.north(17).east(6), rotation));
		builder.addPiece(new Piece(structureManager, HF9, pos.north(17).west(26), rotation));
		builder.addPiece(new Piece(structureManager, HF10, pos.north(23).west(52), rotation));
		builder.addPiece(new Piece(structureManager, HF11, pos.north(29).west(52), rotation));
		builder.addPiece(new Piece(structureManager, HF12, pos.north(49).west(26), rotation));
		builder.addPiece(new Piece(structureManager, HF13, pos.north(45).west(79), rotation));
		builder.addPiece(new Piece(structureManager, HF14, pos.north(59).west(52), rotation));
		builder.addPiece(new Piece(structureManager, HF15, pos.north(59).west(46), rotation));
		builder.addPiece(new Piece(structureManager, HF16, pos.north(81).west(41), rotation));
		builder.addPiece(new Piece(structureManager, HF17, pos.north(81).west(26), rotation));
		builder.addPiece(new Piece(structureManager, HF18, pos.north(41).west(20), rotation));
		builder.addPiece(new Piece(structureManager, HF19, pos.north(49), rotation));
		builder.addPiece(new Piece(structureManager, HF20, pos.north(75), rotation));
		builder.addPiece(new Piece(structureManager, HF21, pos.north(81).west(20), rotation));
		builder.addPiece(new Piece(structureManager, HF22, pos.north(81).east(12), rotation));
		builder.addPiece(new Piece(structureManager, HF23, pos.north(81).east(44), rotation));
		builder.addPiece(new Piece(structureManager, HF24, pos.north(81).east(46), rotation));
		builder.addPiece(new Piece(structureManager, HF25, pos.north(66).east(14), rotation));
		builder.addPiece(new Piece(structureManager, HF26, pos.north(66).east(6), rotation));
		builder.addPiece(new Piece(structureManager, HF27, pos.north(60).east(34), rotation));
		builder.addPiece(new Piece(structureManager, HF28, pos.north(46).east(18), rotation));
		builder.addPiece(new Piece(structureManager, HF29, pos.north(60).east(17), rotation));
		builder.addPiece(new Piece(structureManager, HF30, pos.north(28).east(17), rotation));
		
	}

	public static class Piece extends GelTemplateStructurePiece
	{
		public Piece(StructureManager structureManager, ResourceLocation location, BlockPos pos, Rotation rotation, int componentType)
		{
			super(HoeStructureRegistry.Heart_of_Ender_Fortress.getPieceType(), 0, structureManager, location, pos);
			this.rotation = rotation;
			this.mirror = Mirror.NONE;
			this.setupPlaceSettings(structureManager);
		}

		@Override
		public Mirror getMirror()
		{
			return Mirror.NONE;
		}
		
		public Piece(StructureManager structureManager, ResourceLocation location, BlockPos pos, Rotation rotation)
		{
			this(structureManager, location, pos, rotation, 0);
		}

		public Piece(StructurePieceSerializationContext context, CompoundTag tag)
		{
			super(HoeStructureRegistry.Heart_of_Ender_Fortress.getPieceType(), tag, context.structureManager());
			this.setupPlaceSettings(context.structureManager());
		}

		@Override
		protected StructurePlaceSettings getPlaceSettings(StructureManager structureManager)
		{
			StructurePlaceSettings settings = new StructurePlaceSettings();
			Vec3i size = structureManager.get(this.makeTemplateLocation()).get().getSize();
			settings.setKeepLiquids(false);
			settings.setRotationPivot(new BlockPos(size.getX() / 2, 0, size.getZ() / 2));
			settings.addProcessor(RemoveGelStructureProcessor.INSTANCE);
			return settings;
		}
		
		@Override
		@Nullable
		public BlockState modifyState(ServerLevelAccessor world, Random rand, BlockPos pos, BlockState originalState)
		{
			BlockState worldState = world.getBlockState(pos);
			if (this.genDepth == 1 && !(worldState.getBlock() == Blocks.LAVA || worldState.getMaterial() == Material.AIR))
				return null;
			return originalState;
		}
		
		@Override
		protected void handleDataMarker(String p_73683_, BlockPos p_73684_, ServerLevelAccessor lvl, Random p_73686_, BoundingBox p_73687_)
		{
			ServerLevel serverLevel = lvl.getLevel();
		}
	}
}