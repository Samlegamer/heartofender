package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityEnderKid;
import fr.samlegamer.heartofender.entity.EntityHeartSkeleton;
import fr.samlegamer.heartofender.entity.models.ModelEnderKid;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderWitherSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHeartSkeleton extends RenderSkeleton
{
    private static final ResourceLocation HEART_SKELETON_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/heartskeleton/heart_skeleton.png");

    public RenderHeartSkeleton(RenderManager render)
    {
        super(render);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity)
    {
        return HEART_SKELETON_TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(AbstractSkeleton entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }
}