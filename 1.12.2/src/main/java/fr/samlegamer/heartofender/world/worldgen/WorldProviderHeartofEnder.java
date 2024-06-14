package fr.samlegamer.heartofender.world.worldgen;

import fr.samlegamer.heartofender.inits.BiomesMod;
import fr.samlegamer.heartofender.inits.DimensionsMod;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderHeartofEnder extends WorldProvider
{
    public void init()
    {
        this.biomeProvider = new BiomeProviderSingle(BiomesMod.BIOME_DARK);
        this.doesWaterVaporize = true;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_)
    {
        return new Vec3d(0.1803921568627451, 0.0313725490196078, 0.3294117647058824);
    }
    
    protected void generateLightBrightnessTable()
    {
        float f = 0.1F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 0.9F + 0.1F;
        }
    }

    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorHeartofEnder(this.world, this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getSeed());
    }
    
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return false;
    }

    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5F;
    }
    
    public boolean canRespawnHere()
    {
        return false;
    }
    
    public boolean isSurfaceWorld()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return true;
    }

    public WorldBorder createWorldBorder()
    {
        return new WorldBorder()
        {
            public double getCenterX()
            {
                return super.getCenterX() / 8.0D;
            }
            public double getCenterZ()
            {
                return super.getCenterZ() / 8.0D;
            }
        };
    }

    public DimensionType getDimensionType()
    {
        return DimensionsMod.HEART_OF_ENDER;
    }
}