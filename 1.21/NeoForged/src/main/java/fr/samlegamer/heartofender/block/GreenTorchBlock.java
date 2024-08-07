package fr.samlegamer.heartofender.block;

import java.util.Random;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.samlegamer.heartofender.particle.HoeParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseTorchBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class GreenTorchBlock extends BaseTorchBlock {
    protected static final MapCodec<SimpleParticleType> PARTICLE_OPTIONS_FIELD = BuiltInRegistries.PARTICLE_TYPE
            .byNameCodec()
            .comapFlatMap(
                p_304958_ -> p_304958_ instanceof SimpleParticleType simpleparticletype
                        ? DataResult.success(simpleparticletype)
                        : DataResult.error(() -> "Not a SimpleParticleType: " + p_304958_),
                p_304720_ -> (ParticleType<?>)p_304720_
            )
            .fieldOf("particle_options");
        public static final MapCodec<GreenTorchBlock> CODEC = RecordCodecBuilder.mapCodec(
            p_308842_ -> p_308842_.group(PARTICLE_OPTIONS_FIELD.forGetter(p_304762_ -> p_304762_.flameParticle), propertiesCodec())
                    .apply(p_308842_, GreenTorchBlock::new)
        );
        protected final SimpleParticleType flameParticle;

        @Override
        public MapCodec<? extends GreenTorchBlock> codec() {
            return CODEC;
        }

        public GreenTorchBlock(SimpleParticleType p_304940_, BlockBehaviour.Properties p_57491_) {
            super(p_57491_);
            this.flameParticle = p_304940_;
        }

        /**
         * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
         */
        @Override
        public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
            double d0 = (double)pPos.getX() + 0.5;
            double d1 = (double)pPos.getY() + 0.7;
            double d2 = (double)pPos.getZ() + 0.5;
            pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0, 0.0, 0.0);
            pLevel.addParticle(this.flameParticle, d0, d1, d2, 0.0, 0.0, 0.0);
        }
    }