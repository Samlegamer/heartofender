package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityHeartGhast;
import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHeartGhast extends RenderLiving<EntityHeartGhast>
{
    private static final ResourceLocation HEART_GHAST_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/heartghast/heart_ghast.png");
    private static final ResourceLocation HEART_GHAST_SHOOTING_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/heartghast/heart_ghast_shooting.png");

    public RenderHeartGhast(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelGhast(), 0.5F);
    }
    
    protected ResourceLocation getEntityTexture(EntityHeartGhast entity)
    {
        return entity.isAttacking() ? HEART_GHAST_SHOOTING_TEXTURES : HEART_GHAST_TEXTURES;
    }
    
    protected void preRenderCallback(EntityHeartGhast entitylivingbaseIn, float partialTickTime)
    {
        float f = 1.0F;
        float f1 = 4.5F;
        float f2 = 4.5F;
        GlStateManager.scale(4.5F, 4.5F, 4.5F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}