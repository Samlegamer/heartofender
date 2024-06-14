package fr.samlegamer.heartofender.block;

import com.google.common.base.Supplier;
import com.legacy.structure_gel.blocks.GelPortalBlock;
import com.legacy.structure_gel.util.GelTeleporter;
import com.legacy.structure_gel.util.GelTeleporter.CreatePortalBehavior;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.village.PointOfInterestType;

public class HeartofEnderPortal extends GelPortalBlock
{
	public HeartofEnderPortal(Supplier<RegistryKey<World>> startingDimensionIn, Supplier<RegistryKey<World>> endpointDimensionIn, Supplier<PointOfInterestType> portalPOI, Supplier<GelPortalBlock> portalBlockIn, Supplier<BlockState> frameBlockIn)
	{
		super(AbstractBlock.Properties.copy(Blocks.NETHER_PORTAL), (world) -> new GelTeleporter(world, startingDimensionIn, endpointDimensionIn, portalPOI, portalBlockIn, frameBlockIn, CreatePortalBehavior.NETHER));
	}
	
	/*
	public MoolandPortalBlock(Supplier<RegistryKey<World>> startingDimensionIn, Supplier<RegistryKey<World>> endpointDimensionIn, Supplier<PointOfInterestType> portalPOI, Supplier<GelPortalBlock> portalBlockIn, Supplier<BlockState> frameBlockIn)
	{
		super(Block.Properties.copy(Blocks.NETHER_PORTAL), (world) -> new GelTeleporter(world, startingDimensionIn, endpointDimensionIn, portalPOI, portalBlockIn, frameBlockIn, CreatePortalBehavior.NETHER));
	}
	*/
}