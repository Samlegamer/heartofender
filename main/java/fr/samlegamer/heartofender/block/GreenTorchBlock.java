package fr.samlegamer.heartofender.block;

import net.minecraft.block.TorchBlock;
import net.minecraft.particles.IParticleData;

public class GreenTorchBlock extends TorchBlock
{
	protected final IParticleData flameParticle;

	public GreenTorchBlock(Properties p_i241189_1_, IParticleData p_i241189_2_)
	{
		super(p_i241189_1_, p_i241189_2_);
	    this.flameParticle = p_i241189_2_;
	}
}
