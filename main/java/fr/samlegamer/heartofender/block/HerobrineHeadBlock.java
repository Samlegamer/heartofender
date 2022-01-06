package fr.samlegamer.heartofender.block;

import javax.annotation.Nullable;

import fr.samlegamer.heartofender.entity.HerobrineEntity;
import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HerobrineHeadBlock extends HorizontalBlock
{	
	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	
	@Nullable
	private BlockPattern HerobrineBase;
	@Nullable
	private BlockPattern HerobrineFull;
	
    public HerobrineHeadBlock(Material materialIn, int toolStrength, float hardness, float resistance, SoundType sound) {
        super(AbstractBlock.Properties
    			.of(materialIn)
    			.sound(sound)
    			.strength(hardness, resistance)
    			.harvestTool(ToolType.PICKAXE)
    			.harvestLevel(toolStrength)
    			.requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }  
    
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (!p_220082_4_.is(p_220082_1_.getBlock())) {
           this.trySpawnHerobrine(p_220082_2_, p_220082_3_);
        }
     }
    
    public void trySpawnHerobrine(World p_196358_1_, BlockPos p_196358_2_)
    {
        BlockPattern.PatternHelper blockpattern$patternhelper = this.getOrCreateHerobrineFull().find(p_196358_1_, p_196358_2_);
        if (blockpattern$patternhelper != null) {
            for(int j = 0; j < this.getOrCreateHerobrineFull().getWidth(); ++j) {
               for(int k = 0; k < this.getOrCreateHerobrineFull().getHeight(); ++k) {
                  CachedBlockInfo cachedblockinfo2 = blockpattern$patternhelper.getBlock(j, k, 0);
                  p_196358_1_.setBlock(cachedblockinfo2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                  p_196358_1_.levelEvent(2001, cachedblockinfo2.getPos(), Block.getId(cachedblockinfo2.getState()));
               }
            }

            BlockPos blockpos = blockpattern$patternhelper.getBlock(1, 2, 0).getPos();
            HerobrineEntity irongolementity = new HerobrineEntity(p_196358_1_);
            irongolementity.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            p_196358_1_.addFreshEntity(irongolementity);

            for(ServerPlayerEntity serverplayerentity1 : p_196358_1_.getEntitiesOfClass(ServerPlayerEntity.class, irongolementity.getBoundingBox().inflate(5.0D))) {
               CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, irongolementity);
            }

            for(int i1 = 0; i1 < this.getOrCreateHerobrineFull().getWidth(); ++i1) {
               for(int j1 = 0; j1 < this.getOrCreateHerobrineFull().getHeight(); ++j1) {
                  CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.getBlock(i1, j1, 0);
                  p_196358_1_.blockUpdated(cachedblockinfo1.getPos(), Blocks.AIR);
               }
            }
         }
    }
    
    @SuppressWarnings("unused")
	private BlockPattern getOrCreateHerobrineBase() {
        if (this.HerobrineBase == null) {
           this.HerobrineBase = BlockPatternBuilder.start().aisle("~ ~", "###", "~=~").where('=', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(ModBlocks.AZURIUM_BLOCK.get()))).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.DIAMOND_BLOCK))).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.HerobrineBase;
     }

     private BlockPattern getOrCreateHerobrineFull() {
        if (this.HerobrineFull == null) {
           this.HerobrineFull = BlockPatternBuilder.start().aisle("~^~", "###", "~=~").where('=', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(ModBlocks.AZURIUM_BLOCK.get()))).where('^', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(ModBlocks.HEROBRINE_HEAD.get()))).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.DIAMOND_BLOCK))).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return this.HerobrineFull;
     }
    
     public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
         return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
      }

      protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
         p_206840_1_.add(FACING);
      }
}