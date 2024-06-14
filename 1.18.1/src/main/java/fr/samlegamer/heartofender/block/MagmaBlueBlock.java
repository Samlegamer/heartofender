package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class MagmaBlueBlock extends MagmaBlock
{
	public MagmaBlueBlock(Material materialIn, float hardness, float resistance, SoundType sound)
	{
        super(BlockBehaviour.Properties.of(materialIn).sound(sound).strength(hardness, resistance).requiresCorrectToolForDrops());
	}
}