package fr.samlegamer.heartofender.block;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.cache.LoadingCache;

import fr.samlegamer.heartofender.inits.BlocksMod;
import fr.samlegamer.heartofender.inits.DimensionsMod;
import fr.samlegamer.heartofender.world.worldgen.TeleporterHeartofEnder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockPattern.PatternHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.world.GetCollisionBoxesEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TpHeartofEnderDim  extends BlockBreakable
{
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
	protected static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D);
    protected static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);
    protected static final AxisAlignedBB Y_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);
	
	public TpHeartofEnderDim(String name) {
		super(Material.PORTAL, false);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.X));
		this.setTickRandomly(true);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing.Axis)state.getValue(AXIS))
        {
            case X:
                return X_AABB;
            case Y:
            default:
                return Y_AABB;
            case Z:
                return Z_AABB;
        }
    }
	
	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
	
	public static int getMetaForAxis(EnumFacing.Axis axis) {
		return axis == EnumFacing.Axis.X ? 1 : (axis == EnumFacing.Axis.Z ? 2 : 0);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	public boolean trySpawnPortal(World world, BlockPos pos) {
		Size size = new Size(world, pos, EnumFacing.Axis.X);
		
		if(size.isValid() && size.portalBlockCount == 0) {
			size.placePortalBlocks();
			return true;
		} else {
			Size size1 = new Size(world, pos, EnumFacing.Axis.Z);
			if(size1.isValid() && size1.portalBlockCount == 0) {
				size1.placePortalBlocks();
				return true;
			}
			return false;
		}
	}
	
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		Axis axis = (Axis) state.getValue(AXIS);
		
		if(axis == Axis.X) {
			Size size = new Size(worldIn, pos, EnumFacing.Axis.X);
			
			if(!size.isValid() || size.portalBlockCount < size.width * size.height) worldIn.setBlockToAir(pos);
		} else if(axis == Axis.Z) {
			Size size = new Size(worldIn, pos, EnumFacing.Axis.Z);
			
			if(!size.isValid() || size.portalBlockCount < size.width * size.height) worldIn.setBlockToAir(pos);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		pos = pos.offset(side);
		Axis axis = null;
		
		if(blockState == this) {
			axis = (Axis) blockState.getValue(AXIS);
			
			if(axis == null) return false;
			if(axis == Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST) return false;
			if(axis == Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH) return false;
		}
		
		boolean flag = blockAccess.getBlockState(pos.west()).getBlock() == this && blockAccess.getBlockState(pos.west(2)).getBlock() != this,
				flag1 = blockAccess.getBlockState(pos.east()).getBlock() == this && blockAccess.getBlockState(pos.east(2)).getBlock() != this,
				flag2 = blockAccess.getBlockState(pos.north()).getBlock() == this && blockAccess.getBlockState(pos.north(2)).getBlock() != this,
				flag3 = blockAccess.getBlockState(pos.south()).getBlock() == this && blockAccess.getBlockState(pos.south(2)).getBlock() != this,
				flag4 = flag || flag1 || axis == Axis.X,
				flag5 = flag2 || flag3 || axis == Axis.Z;
		
		if(flag4 && side == EnumFacing.WEST) return true;
		else if(flag4 && side == EnumFacing.EAST) return true;
		else if(flag5 && side == EnumFacing.NORTH) return true;
		else return flag5 && side == EnumFacing.SOUTH;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && entityIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) entityIn;
			player.setPortal(pos);
			if(player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != DimensionsMod.HEART_OF_ENDER.getId()) {
				player.timeUntilPortal = 10;
				player.mcServer.getPlayerList().transferPlayerToDimension(player, DimensionsMod.HEART_OF_ENDER.getId(), new TeleporterHeartofEnder(player.mcServer.getWorld(DimensionsMod.HEART_OF_ENDER.getId())));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer.getPlayerList().transferPlayerToDimension(player, 0, new TeleporterHeartofEnder(player.mcServer.getWorld(0)));
			}
		}
	}
	
	
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return ItemStack.EMPTY;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? Axis.Z : Axis.X);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (rand.nextInt(100) == 0)
		{
			worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int i = 0; i < 4; ++i)
		{
			double d0 = (double)((float)pos.getX() + rand.nextFloat());
			double d1 = (double)((float)pos.getY() + rand.nextFloat());
			double d2 = (double)((float)pos.getZ() + rand.nextFloat());
			double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			int j = rand.nextInt(2) * 2 - 1;

			if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this)
			{
				d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
				d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
			}
			else
			{
				d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
				d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
			}

			worldIn.spawnParticle(EnumParticleTypes.END_ROD, d0, d1, d2, d3, d4, d5);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return getMetaForAxis((Axis)state.getValue(AXIS));
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch(rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch((Axis)state.getValue(AXIS)) {
			case X:
				return state.withProperty(AXIS, Axis.Z);
			case Z:
				return state.withProperty(AXIS, Axis.X);
			default:
				return state;
			}
		default:
			return state;
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS});
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
		return BlockFaceShape.UNDEFINED;
	}
	
	public BlockPattern.PatternHelper createPatternHelper(World world, BlockPos pos) {
		Axis axis = Axis.Z;
		Size size = new Size(world, pos, Axis.X);
		LoadingCache<BlockPos, BlockWorldState> cache = BlockPattern.createLoadingCache(world, true);
		
		if(!size.isValid()) {
			axis = Axis.X;
			size = new Size(world, pos, Axis.Z);
		}
		
		if(!size.isValid()) return new BlockPattern.PatternHelper(pos, EnumFacing.NORTH, EnumFacing.UP, cache, 1, 1, 1);
		
		else {
			int[] aint = new int[AxisDirection.values().length];
			EnumFacing facing = size.rightDir.rotateYCCW();
			BlockPos blockpos = size.bottomLeft.up(size.getHeight() - 1);
			
			for(AxisDirection direction : AxisDirection.values()) {
				BlockPattern.PatternHelper helper = new PatternHelper(facing.getAxisDirection() == direction ? blockpos : blockpos.offset(size.rightDir, size.getWidth() - 1), EnumFacing.getFacingFromAxis(direction, axis), EnumFacing.UP, cache, size.getWidth(), size.getHeight(), 1);
				
				for(int i = 0; i < size.getWidth(); ++i) {
					for(int j = 0; j < size.getHeight(); ++j) {
						BlockWorldState state = helper.translateOffset(i, j, 1);
						
						if(state.getBlockState() != null && state.getBlockState().getMaterial() != Material.AIR) ++aint[direction.ordinal()];
					}
				}
			}
			
			AxisDirection direction1 = AxisDirection.POSITIVE;
			
			for(AxisDirection direction2 : AxisDirection.values()) {
				if(aint[direction2.ordinal()] < aint[direction1.ordinal()]) direction1 = direction2;
			}
			
			return new PatternHelper(facing.getAxisDirection() == direction1 ? blockpos : blockpos.offset(size.rightDir, size.getWidth() - 1), EnumFacing.getFacingFromAxis(direction1, axis), EnumFacing.UP, cache, size.getWidth(), size.getHeight(), 1);
		}
	}
	
	public static class Size
    {
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing rightDir;
        private final EnumFacing leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_)
        {
            this.world = worldIn;
            this.axis = p_i45694_3_;

            if (p_i45694_3_ == EnumFacing.Axis.X)
            {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            }
            else
            {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = p_i45694_2_; p_i45694_2_.getY() > blockpos.getY() - 21 && p_i45694_2_.getY() > 0 && this.isEmptyBlock(worldIn.getBlockState(p_i45694_2_.down()).getBlock()); p_i45694_2_ = p_i45694_2_.down())
            {
                ;
            }

            int i = this.getDistanceUntilEdge(p_i45694_2_, this.leftDir) - 1;

            if (i >= 0)
            {
                this.bottomLeft = p_i45694_2_.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);

                if (this.width < 2 || this.width > 21)
                {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null)
            {
                this.height = this.calculatePortalHeight();
            }
        }
		
		protected int getDistanceUntilEdge(BlockPos p_180120_1_, EnumFacing p_180120_2_)
        {
            int i;

            for (i = 0; i < 22; ++i)
            {
                BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);

                if (!this.isEmptyBlock(this.world.getBlockState(blockpos).getBlock()) || this.world.getBlockState(blockpos.down()).getBlock() != BlocksMod.heart_ender_portal_block)
                {
                    break;
                }
            }

            net.minecraft.block.Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
            return block == BlocksMod.heart_ender_portal_block ? i : 0;
        }

        public int getHeight()
        {
            return this.height;
        }

        public int getWidth()
        {
            return this.width;
        }
		
		protected int calculatePortalHeight()
        {
            label56:

            for (this.height = 0; this.height < 21; ++this.height)
            {
                for (int i = 0; i < this.width; ++i)
                {
                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    net.minecraft.block.Block block = this.world.getBlockState(blockpos).getBlock();

                    if (!this.isEmptyBlock(block))
                    {
                        break label56;
                    }

                    if (block == BlocksMod.portal_dim)
                    {
                        ++this.portalBlockCount;
                    }

                    if (i == 0)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();

                        if (block != BlocksMod.heart_ender_portal_block)
                        {
                            break label56;
                        }
                    }
                    else if (i == this.width - 1)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();

                        if (block != BlocksMod.heart_ender_portal_block)
                        {
                            break label56;
                        }
                    }
                }
            }

            for (int j = 0; j < this.width; ++j)
            {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).getBlock() != BlocksMod.heart_ender_portal_block)
                {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3)
            {
                return this.height;
            }
            else
            {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }
		
		protected boolean isEmptyBlock(Block block) {
			return block.getDefaultState().getMaterial() == Material.AIR || block == BlocksMod.green_fire || block == BlocksMod.portal_dim;
		}
		
		public boolean isValid() {
			return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <=21;
		}
		
		public void placePortalBlocks() {
			for(int i = 0; i < this.width; ++i) {
				BlockPos pos = this.bottomLeft.offset(this.rightDir, i);
				
				for(int j = 0; j < this.height; ++j) this.world.setBlockState(pos.up(j), BlocksMod.portal_dim.getDefaultState().withProperty(TpHeartofEnderDim.AXIS, this.axis), 2);
			}
		}
	}
}