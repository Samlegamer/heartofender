package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityHeartBlaze;
import fr.samlegamer.heartofender.entity.models.ModelHeartBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderHeartBlaze extends RenderLiving<EntityHeartBlaze>
{
    private static final ResourceLocation HEART_BLAZE_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/heartblaze/heart_blaze.png");

    public RenderHeartBlaze(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelHeartBlaze(), 0.5F);
    }
    
    protected ResourceLocation getEntityTexture(EntityHeartBlaze entity)
    {
        return HEART_BLAZE_TEXTURES;
    }
}