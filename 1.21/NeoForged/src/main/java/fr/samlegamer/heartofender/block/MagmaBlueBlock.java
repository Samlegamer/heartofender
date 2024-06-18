package fr.samlegamer.heartofender.block;

import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MagmaBlueBlock extends MagmaBlock
{
	public MagmaBlueBlock(float hardness, float resistance, SoundType sound)
	{
        super(BlockBehaviour.Properties.of().sound(sound).strength(hardness, resistance).requiresCorrectToolForDrops());
	}
}