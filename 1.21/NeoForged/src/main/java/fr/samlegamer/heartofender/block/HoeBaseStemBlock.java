package fr.samlegamer.heartofender.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class HoeBaseStemBlock extends RotatedPillarBlock
{
	public HoeBaseStemBlock(Properties p_55926_)
	{
		super(p_55926_);
	}

	@Override
	public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate)
	{
		if (ItemAbilities.AXE_STRIP == itemAbility && state == HoeBlocksRegistry.LILAC_STEM.get().defaultBlockState())
		{
            return AxeItem.getAxeStrippingState(state);
        }
		return super.getToolModifiedState(state, context, itemAbility, simulate);
	}
}