package fr.samlegamer.heartofender.entity.render;

import fr.samlegamer.heartofender.core.References;
import fr.samlegamer.heartofender.entity.EntityEnderKid;
import fr.samlegamer.heartofender.entity.models.ModelEnderKid;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEnderKid extends RenderLiving<EntityEnderKid> {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/enderkid/ender_kid.png");
	
	public RenderEnderKid(RenderManager manager)
    {
        super(manager, new ModelEnderKid(), 0.5F);
    }

    public ModelEnderKid getMainModel()
    {
        return (ModelEnderKid)super.getMainModel();
    }
    
    public void doRender(EntityEnderKid entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderKid entity)
    {
        return TEXTURES;
    }

}