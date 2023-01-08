package fr.samlegamer.heartofender.block;

import com.google.common.base.Supplier;
import com.legacy.structure_gel.api.block.GelPortalBlock;
import com.legacy.structure_gel.api.dimension.portal.GelTeleporter;
import com.legacy.structure_gel.api.dimension.portal.GelTeleporter.CreatePortalBehavior;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class HOEPortal extends GelPortalBlock
{
	public HOEPortal(Supplier<ResourceKey<Level>> startingDimensionIn, Supplier<ResourceKey<Level>> endpointDimensionIn, Supplier<PoiType> portalPOI, Supplier<GelPortalBlock> portalBlockIn, Supplier<BlockState> frameBlockIn)
	{
		super(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noDrops(), (serverLevel, portal) -> new GelTeleporter(serverLevel, startingDimensionIn, endpointDimensionIn, portalPOI, portalBlockIn, frameBlockIn, CreatePortalBehavior.NETHER));
	}
}