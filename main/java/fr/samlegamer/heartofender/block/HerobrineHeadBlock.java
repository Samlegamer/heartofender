package fr.samlegamer.heartofender.block;

import javax.annotation.Nullable;

import fr.samlegamer.heartofender.inits.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HerobrineHeadBlock extends Block
{	
    public HerobrineHeadBlock(Material materialIn, int toolStrength, float hardness, float resistance, SoundType sound) {
        super(
    		AbstractBlock.Properties
    			.of(materialIn)
    			.sound(sound)
    			.strength(hardness, resistance)
    			.harvestTool(ToolType.PICKAXE)
    			.harvestLevel(toolStrength)
    			.requiresCorrectToolForDrops()
    			
		);
    }  
    
    //this code require to summon Herobrine Entity
	@Override
    public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
    {
    	BlockState diamond_block = worldIn.getBlockState(pos.below());
		BlockState azurium_block = worldIn.getBlockState(pos.below(2));
		BlockState diamond_block1 = worldIn.getBlockState(pos.below().east());
		BlockState diamond_block2 = worldIn.getBlockState(pos.below().west());
		BlockState diamond_block3 = worldIn.getBlockState(pos.below().north());
		BlockState diamond_block4 = worldIn.getBlockState(pos.below().south());
		
		if(placer instanceof PlayerEntity)
		{
			if(diamond_block.getBlock() != Blocks.AIR && azurium_block.getBlock() != Blocks.AIR)
			{	
				if(diamond_block.getBlock() == Blocks.DIAMOND_BLOCK && azurium_block.getBlock() == ModBlocks.AZURIUM_BLOCK.get()
				&& (diamond_block1.getBlock() == Blocks.DIAMOND_BLOCK ||  diamond_block2.getBlock() == Blocks.DIAMOND_BLOCK) && 
				((diamond_block3.getBlock() == Blocks.DIAMOND_BLOCK ||  diamond_block4.getBlock() == Blocks.DIAMOND_BLOCK)))
				{				
					ZombieEntity herobrine = new ZombieEntity(worldIn);
					
					herobrine.setPos(pos.getX(), pos.getY(), pos.getZ());
					
					worldIn.destroyBlock(pos, false);
					worldIn.destroyBlock(pos.below(), false);
					worldIn.destroyBlock(pos.below(2), false);
					worldIn.destroyBlock(pos.below().east(), false);
					worldIn.destroyBlock(pos.below().west(), false);
					worldIn.destroyBlock(pos.below().north(), false);
					worldIn.destroyBlock(pos.below().south(), false);
					
					worldIn.addFreshEntity(herobrine);
				}
		}
	  }
    }
}