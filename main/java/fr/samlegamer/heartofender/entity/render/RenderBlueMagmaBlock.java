package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityBlueMagmaBlock;
import fr.samlegamer.heartofender.entity.models.ModelBlueMagmaBlock;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlueMagmaBlock extends RenderLiving<EntityBlueMagmaBlock>
{
    private static final ResourceLocation HEART_MAGMA_CUBE_TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/heartmagmablock/heart_magma_block.png");

    public RenderBlueMagmaBlock(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBlueMagmaBlock(), 0.25F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBlueMagmaBlock entity)
    {
        return HEART_MAGMA_CUBE_TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityBlueMagmaBlock entitylivingbaseIn, float partialTickTime)
    {
        int i = entitylivingbaseIn.getSlimeSize();
        float f = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        GlStateManager.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }
}