package fr.samlegamer.heartofender.structure.ship;

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
 * Thanks for help Dungeons Plus
 * https://gitlab.com/modding-legacy/dungeons-plus/-/blob/1.18.x/src/main/java/com/legacy/dungeons_plus/structures/SoulPrisonStructure.java
 */
public class HeartEnderShipStructure extends GelConfigStructure<NoneFeatureConfiguration>
{
	private static final ResourceLocation SHIP_STRUCT = HeartofEnder.location("heart_ender_ship");


	public HeartEnderShipStructure(Codec<NoneFeatureConfiguration> codec, StructureConfig config)
	{
		super(codec, config, PieceGeneratorSupplier.simple(context -> context.validBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG) && isValidPos(context), HeartEnderShipStructure::generatePieces));
	}

	private static void generatePieces(StructurePiecesBuilder builder, PieceGenerator.Context<NoneFeatureConfiguration> context)
	{
		ChunkPos chunkPos = context.chunkPos();
		Random rand = context.random();
		assemble(context.structureManager(), new BlockPos((chunkPos.x << 4) + 9, 80, (chunkPos.z << 4) + 9), Rotation.getRandom(rand), builder, rand);
		//SoulPrisonPieces.assemble(context.structureManager(), new BlockPos((chunkPos.x << 4) + 9, 29, (chunkPos.z << 4) + 9), Rotation.getRandom(rand), builder, rand);
	}

	private static boolean isValidPos(PieceGeneratorSupplier.Context<NoneFeatureConfiguration> context)
	{
		ChunkGenerator chunkGen = context.chunkGenerator();
		ChunkPos chunkPos = context.chunkPos();
		NoiseColumn minCorner = chunkGen.getBaseColumn(chunkPos.getMinBlockX() + 3, chunkPos.getMinBlockZ() + 3, context.heightAccessor());
		NoiseColumn maxCorner = chunkGen.getBaseColumn(chunkPos.getMinBlockX() + 22, chunkPos.getMinBlockZ() + 22, context.heightAccessor());
		return minCorner.getBlock(29).getBlock() == HoeFluidsRegistry.GREEN_LAVA_BLOCK.get() && maxCorner.getBlock(29).getBlock() == HoeFluidsRegistry.GREEN_LAVA_BLOCK.get();
	}
	
	public static void assemble(StructureManager structureManager, BlockPos pos, Rotation rotation, StructurePiecesBuilder builder, Random rand)
	{
		pos = pos.offset(-12, 0, -12);
		builder.addPiece(new Piece(structureManager, SHIP_STRUCT, pos, rotation));
	}

	
	public static class Piece extends GelTemplateStructurePiece
	{
		public Piece(StructureManager structureManager, ResourceLocation location, BlockPos pos, Rotation rotation, int componentType)
		{
			super(HoeStructureRegistry.Heart_Ender_Ship.getPieceType(), 0, structureManager, location, pos);
			this.rotation = rotation;
			this.setupPlaceSettings(structureManager);
		}

		public Piece(StructureManager structureManager, ResourceLocation location, BlockPos pos, Rotation rotation)
		{
			this(structureManager, location, pos, rotation, 0);
		}

		public Piece(StructurePieceSerializationContext context, CompoundTag tag)
		{
			super(HoeStructureRegistry.Heart_Ender_Ship.getPieceType(), tag, context.structureManager());
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
			//settings.addProcessor(new RandomBlockSwapProcessor(Blocks.QUARTZ_BRICKS, 0.10F, Blocks.CHISELED_QUARTZ_BLOCK));
			//settings.addProcessor(new RandomStateSwapProcessor(Blocks.POLISHED_BASALT.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Axis.Y), 0.55F, Blocks.BASALT.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Axis.Y)));
			//settings.addProcessor(new RuleProcessor(ImmutableList.of(new ProcessorRule(new BlockMatchTest(Blocks.QUARTZ_SLAB), new BlockMatchTest(Blocks.LAVA), Blocks.LAVA.defaultBlockState()))));
			//settings.addProcessor(new RandomBlockSwapProcessor(Blocks.ORANGE_STAINED_GLASS, Blocks.LAVA));

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