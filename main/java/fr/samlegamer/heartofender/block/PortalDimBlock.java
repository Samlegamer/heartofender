package fr.samlegamer.heartofender.block;

import java.util.Random;

import javax.annotation.Nullable;

import fr.samlegamer.heartofender.inits.ModBlocks;
import fr.samlegamer.heartofender.inits.ModDimension;
import fr.samlegamer.heartofender.world.dim.TeleporterHeartofEnder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class PortalDimBlock extends Block
{
	   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	   protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	   protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	   
	   public PortalDimBlock(AbstractBlock.Properties p_i48352_1_)
	   {
	      super(p_i48352_1_);
	      this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	   }
	   
	   @Override
	   public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_)
	   {
		   if (p_196262_2_ instanceof ServerWorld && !p_196262_4_.isPassenger() && !p_196262_4_.isVehicle() && p_196262_4_.canChangeDimensions() && VoxelShapes.joinIsNotEmpty(VoxelShapes.create(p_196262_4_.getBoundingBox().move((double)(-p_196262_3_.getX()), (double)(-p_196262_3_.getY()), (double)(-p_196262_3_.getZ()))), p_196262_1_.getShape(p_196262_2_, p_196262_3_), IBooleanFunction.AND))
		   {
		         RegistryKey<World> registrykey = p_196262_2_.dimension() == ModDimension.HEART_OF_ENDER ? World.OVERWORLD : ModDimension.HEART_OF_ENDER;
		         ServerWorld serverworld = ((ServerWorld)p_196262_2_).getServer().getLevel(registrykey);
		         if (serverworld == null)
		         {
		            return;
		         }
		         p_196262_4_.changeDimension(serverworld, new TeleporterHeartofEnder(serverworld));
		      }
	   }
	     
	@Override
	public boolean isPortalFrame(BlockState state, IBlockReader world, BlockPos pos)
	{
		return state.is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get());
	}
		   
	   @Override
	   public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
	      switch((Direction.Axis)p_220053_1_.getValue(AXIS))
	      {
	      		case Z:
	      			return Z_AXIS_AABB;
	      		case X:
	      		default:
	      			return X_AXIS_AABB;
	      }
	   }

	   @Override
	   public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
	      if (p_225542_2_.dimensionType().natural() && p_225542_2_.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && p_225542_4_.nextInt(2000) < p_225542_2_.getDifficulty().getId()) {
	         while(p_225542_2_.getBlockState(p_225542_3_).is(this)) {
	            p_225542_3_ = p_225542_3_.below();
	         }

	         if (p_225542_2_.getBlockState(p_225542_3_).isValidSpawn(p_225542_2_, p_225542_3_, EntityType.ZOMBIFIED_PIGLIN)) {
	            Entity entity = EntityType.ZOMBIFIED_PIGLIN.spawn(p_225542_2_, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, p_225542_3_.above(), SpawnReason.STRUCTURE, false, false);
	            if (entity != null) {
	               entity.setPortalCooldown();
	            }
	         }
	      }
	   }
	
	public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
	      Direction.Axis direction$axis = p_196271_2_.getAxis();
	      Direction.Axis direction$axis1 = p_196271_1_.getValue(AXIS);
	      boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
	      return !flag && !p_196271_3_.is(this) && !(new PortalDimBlock.Size(p_196271_4_, p_196271_5_, direction$axis1)).validatePortal() ? Blocks.AIR.defaultBlockState() : updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
	   }
	   
    public boolean trySpawnPortal(IWorld worldIn, BlockPos pos) {
        PortalDimBlock.Size UndergardenPortalBlock$size = this.isPortal(worldIn, pos);
        if (UndergardenPortalBlock$size != null && !onTrySpawnPortal(worldIn, pos, UndergardenPortalBlock$size)) {
            UndergardenPortalBlock$size.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    public static boolean onTrySpawnPortal(IWorld world, BlockPos pos, PortalDimBlock.Size size) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final PortalDimBlock.Size size;

        public PortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, PortalDimBlock.Size size) {
            super(world, pos, state);
            this.size = size;
        }

        public PortalDimBlock.Size getPortalSize()
        {
            return size;
        }
    }

    @Nullable
    public PortalDimBlock.Size isPortal(IWorld worldIn, BlockPos pos) {
    	PortalDimBlock.Size UndergardenPortalBlock$size = new PortalDimBlock.Size(worldIn, pos, Direction.Axis.X);
        if (UndergardenPortalBlock$size.isValid() && UndergardenPortalBlock$size.portalBlockCount == 0) {
            return UndergardenPortalBlock$size;
        } else {
        	PortalDimBlock.Size UndergardenPortalBlock$size1 = new PortalDimBlock.Size(worldIn, pos, Direction.Axis.Z);
            return UndergardenPortalBlock$size1.isValid() && UndergardenPortalBlock$size1.portalBlockCount == 0 ? UndergardenPortalBlock$size1 : null;
        }
    }


	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
	      if (p_180655_4_.nextInt(100) == 0) {
	         p_180655_2_.playLocalSound((double)p_180655_3_.getX() + 0.5D, (double)p_180655_3_.getY() + 0.5D, (double)p_180655_3_.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, p_180655_4_.nextFloat() * 0.4F + 0.8F, false);
	      }

	      for(int i = 0; i < 4; ++i) {
	         double d0 = (double)p_180655_3_.getX() + p_180655_4_.nextDouble();
	         double d1 = (double)p_180655_3_.getY() + p_180655_4_.nextDouble();
	         double d2 = (double)p_180655_3_.getZ() + p_180655_4_.nextDouble();
	         double d3 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
	         double d4 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
	         double d5 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
	         int j = p_180655_4_.nextInt(2) * 2 - 1;
	         if (!p_180655_2_.getBlockState(p_180655_3_.west()).is(this) && !p_180655_2_.getBlockState(p_180655_3_.east()).is(this)) {
	            d0 = (double)p_180655_3_.getX() + 0.5D + 0.25D * (double)j;
	            d3 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
	         } else {
	            d2 = (double)p_180655_3_.getZ() + 0.5D + 0.25D * (double)j;
	            d5 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)j);
	         }

	         p_180655_2_.addParticle(ParticleTypes.END_ROD, d0, d1, d2, d3, d4, d5);
	      }

	   }

	   public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
	      return ItemStack.EMPTY;
	   }

	   public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
	      switch(p_185499_2_) {
	      case COUNTERCLOCKWISE_90:
	      case CLOCKWISE_90:
	         switch((Direction.Axis)p_185499_1_.getValue(AXIS)) {
	         case Z:
	            return p_185499_1_.setValue(AXIS, Direction.Axis.X);
	         case X:
	            return p_185499_1_.setValue(AXIS, Direction.Axis.Z);
	         default:
	            return p_185499_1_;
	         }
	      default:
	         return p_185499_1_;
	      }
	   }

	   protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
	      p_206840_1_.add(AXIS);
	   }
	   
	    public static class Size {
	        private final IWorld world;
	        private final Direction.Axis axis;
	        private final Direction rightDir;
	        private final Direction leftDir;
	        private int portalBlockCount;
	        @Nullable
	        private BlockPos bottomLeft;
	        private int height;
	        private int width;

	        public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
	            this.world = worldIn;
	            this.axis = axisIn;
	            if (axisIn == Direction.Axis.X) {
	                this.leftDir = Direction.EAST;
	                this.rightDir = Direction.WEST;
	            } else {
	                this.leftDir = Direction.NORTH;
	                this.rightDir = Direction.SOUTH;
	            }

	            for(BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(worldIn.getBlockState(pos.below())); pos = pos.below()) {
	                ;
	            }

	            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
	            if (i >= 0) {
	                this.bottomLeft = pos.relative(this.leftDir, i);
	                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
	                if (this.width < 2 || this.width > 21) {
	                    this.bottomLeft = null;
	                    this.width = 0;
	                }
	            }

	            if (this.bottomLeft != null) {
	                this.height = this.calculatePortalHeight();
	            }

	        }

	        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
	            int i;
	            for(i = 0; i < 22; ++i) {
	                BlockPos blockpos = pos.relative(directionIn, i);
	                if (!this.canConnect(this.world.getBlockState(blockpos)) || !(this.world.getBlockState(blockpos.below()).getBlock().is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get()))) {
	                    break;
	                }
	            }

	            BlockPos framePos = pos.relative(directionIn, i);
	            return this.world.getBlockState(framePos).getBlock().is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get()) ? i : 0;
	        }

	        public int getHeight() {
	            return this.height;
	        }

	        public int getWidth() {
	            return this.width;
	        }

	        protected int calculatePortalHeight() {
	            label56:
	            for(this.height = 0; this.height < 21; ++this.height) {
	                for(int i = 0; i < this.width; ++i) {
	                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
	                    BlockState blockstate = this.world.getBlockState(blockpos);
	                    if (!this.canConnect(blockstate)) {
	                        break label56;
	                    }

	                    Block block = blockstate.getBlock();
	                    if (block == ModBlocks.HEART_OF_ENDER_PORTAL.get()) {
	                        ++this.portalBlockCount;
	                    }

	                    if (i == 0) {
	                        BlockPos framePos = blockpos.relative(this.leftDir);
	                        if (!(this.world.getBlockState(framePos).getBlock().is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get()))) {
	                            break label56;
	                        }
	                    } else if (i == this.width - 1) {
	                        BlockPos framePos = blockpos.relative(this.rightDir);
	                        if (!(this.world.getBlockState(framePos).getBlock().is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get()))) {
	                            break label56;
	                        }
	                    }
	                }
	            }

	            for(int j = 0; j < this.width; ++j) {
	                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
	                if (!(this.world.getBlockState(framePos).getBlock().is(ModBlocks.HEART_ENDER_PORTAL_BLOCK.get()))) {
	                    this.height = 0;
	                    break;
	                }
	            }

	            if (this.height <= 21 && this.height >= 3) {
	                return this.height;
	            } else {
	                this.bottomLeft = null;
	                this.width = 0;
	                this.height = 0;
	                return 0;
	            }
	        }

	        protected boolean canConnect(BlockState pos) {
	            Block block = pos.getBlock();
	            return pos.isAir() || block == ModBlocks.HEART_OF_ENDER_PORTAL.get();
	        }

	        public boolean isValid() {
	            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
	        }

	        public void placePortalBlocks() {
	            for(int i = 0; i < this.width; ++i) {
	                BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);

	                for(int j = 0; j < this.height; ++j) {
	                    this.world.setBlock(blockpos.above(j), ModBlocks.HEART_OF_ENDER_PORTAL.get().defaultBlockState().setValue(PortalDimBlock.AXIS, this.axis), 18);
	                }
	            }

	        }

	        private boolean isPortalCountValidForSize() {
	            return this.portalBlockCount >= this.width * this.height;
	        }

	        public boolean validatePortal() {
	            return this.isValid() && this.isPortalCountValidForSize();
	        }
	    }

}