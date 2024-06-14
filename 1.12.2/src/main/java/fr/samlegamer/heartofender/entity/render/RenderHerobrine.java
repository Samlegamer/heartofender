package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityHerobrine;
import fr.samlegamer.heartofender.entity.models.ModelEnderKid;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHerobrine extends RenderLiving<EntityHerobrine> {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/herobrine/mob_herobrine.png");
	
	public RenderHerobrine(RenderManager manager)
    {
        super(manager, new ModelEnderKid(), 0.5F);
    }

    public ModelEnderKid getMainModel()
    {
        return (ModelEnderKid)super.getMainModel();
    }
    
    public void doRender(EntityHerobrine entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
    @Override
    protected ResourceLocation getEntityTexture(EntityHerobrine entity)
    {
        return TEXTURES;
    }

}