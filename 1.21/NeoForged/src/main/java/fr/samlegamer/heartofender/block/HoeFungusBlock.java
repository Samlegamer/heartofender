package fr.samlegamer.heartofender.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class HoeFungusBlock extends FungusBlock
{
	public static final MapCodec<FungusBlock> CODEC = RecordCodecBuilder.mapCodec(
	        p_344656_ -> p_344656_.group(
	                    ResourceKey.codec(Registries.CONFIGURED_FEATURE).fieldOf("feature").forGetter(p_304367_ -> HoeFungusBlock.feature),
	                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("grows_on").forGetter(p_304365_ -> HoeFungusBlock.requiredBlock),
	                    propertiesCodec()
	                )
	                .apply(p_344656_, HoeFungusBlock::new)
	    );
    private static Block requiredBlock;
    private static ResourceKey<ConfiguredFeature<?, ?>> feature;

    @Override
    public MapCodec<FungusBlock> codec() {
        return CODEC;
    }
    
	public HoeFungusBlock(ResourceKey<ConfiguredFeature<?, ?>> p_259087_, Block p_260223_, Properties p_259749_)
	{
		super(p_259087_, p_260223_, p_259749_);
        this.feature = p_259087_;
        this.requiredBlock = p_260223_;
	}
	
	@Override
	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos)
	{
		return pState.is(BlockTags.NYLIUM) || pState.is(HoeBlocksRegistry.DEAD_SOUL_SOIL) || super.mayPlaceOn(pState, pLevel, pPos);
	}
}