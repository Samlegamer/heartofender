package fr.samlegamer.heartofender.block;

import javax.annotation.Nullable;
import fr.samlegamer.heartofender.entity.Herobrine;
import fr.samlegamer.heartofender.entity.HoeEntityRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class HerobrineHeadBlock extends CarvedPumpkinBlock
{	
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	
	@Nullable
	private BlockPattern HerobrineBase;
	@Nullable
	private BlockPattern HerobrineFull;
	
    public HerobrineHeadBlock(float hardness, float resistance, SoundType sound) {
        super(BlockBehaviour.Properties
    			.of()
    			.sound(sound)
    			.strength(hardness, resistance)
    			.requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }  
    
    public void onPlace(BlockState p_220082_1_, Level p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (!p_220082_4_.is(p_220082_1_.getBlock())) {
           this.trySpawnHerobrine(p_220082_2_, p_220082_3_);
        }
     }
    
    public void trySpawnHerobrine(Level p_196358_1_, BlockPos p_196358_2_)
    {
        BlockPattern.BlockPatternMatch blockpattern$patternhelper = this.getOrCreateHerobrineFull().find(p_196358_1_, p_196358_2_);
        if (blockpattern$patternhelper != null) {
            for(int j = 0; j < this.getOrCreateHerobrineFull().getWidth(); ++j) {
               for(int k = 0; k < this.getOrCreateHerobrineFull().getHeight(); ++k) {
            	   BlockInWorld cachedblockinfo2 = blockpattern$patternhelper.getBlock(j, k, 0);
                  p_196358_1_.setBlock(cachedblockinfo2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                  p_196358_1_.levelEvent(2001, cachedblockinfo2.getPos(), Block.getId(cachedblockinfo2.getState()));
               }
            }

            BlockPos blockpos = blockpattern$patternhelper.getBlock(1, 2, 0).getPos();
            Herobrine irongolementity = HoeEntityRegistry.HEROBRINE.get().create(p_196358_1_);//new Herobrine(p_196358_1_);
            irongolementity.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            p_196358_1_.addFreshEntity(irongolementity);

            for(ServerPlayer serverplayerentity1 : p_196358_1_.getEntitiesOfClass(ServerPlayer.class, irongolementity.getBoundingBox().inflate(5.0D))) {
               CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, irongolementity);
            }

            for(int i1 = 0; i1 < this.getOrCreateHerobrineFull().getWidth(); ++i1) {
               for(int j1 = 0; j1 < this.getOrCreateHerobrineFull().getHeight(); ++j1) {
            	   BlockInWorld cachedblockinfo1 = blockpattern$patternhelper.getBlock(i1, j1, 0);
                  p_196358_1_.blockUpdated(cachedblockinfo1.getPos(), Blocks.AIR);
               }
            }
         }
    }
    
	/*private BlockPattern getOrCreateHerobrineBase() {
        if (this.HerobrineBase == null) {
           this.HerobrineBase = BlockPatternBuilder.start().aisle("~ ~", "###", "~=~").where('=', BlockInWorld.hasState(BlockStatePredicate.forBlock(HoeBlocksRegistry.AZURIUM_BLOCK.get()))).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.DIAMOND_BLOCK))).where('~', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.AIR))).build();
        }

        return this.HerobrineBase;
     }*/

     private BlockPattern getOrCreateHerobrineFull() {
        if (this.HerobrineFull == null) {
           this.HerobrineFull = BlockPatternBuilder.start().aisle("~^~", "###", "~=~").where('=', BlockInWorld.hasState(BlockStatePredicate.forBlock(HoeBlocksRegistry.AZURIUM_BLOCK.get()))).where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(HoeBlocksRegistry.HEROBRINE_HEAD.get()))).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.DIAMOND_BLOCK))).where('~', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.AIR))).build();
        }

        return this.HerobrineFull;
     }
    
     public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
         return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
      }

      protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
         p_206840_1_.add(FACING);
      }
}