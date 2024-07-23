package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.HoeClient;
import fr.samlegamer.heartofender.entity.EnderKid;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnderKidRender extends HumanoidMobRenderer<EnderKid, EnderKidModel>
{
		private static final ResourceLocation ENDER_KID_LOCATION = ResourceLocation.withDefaultNamespace(HeartofEnder.MODID + ":textures/entity/enderkid/ender_kid.png");
	    
	    public EnderKidRender(Context p_173931_)
	    {
	    	super(p_173931_, new EnderKidModel(p_173931_.bakeLayer(HoeClient.ENDER_KID_MODEL)), 0.5F);
	    }

	   @Override
	   public ResourceLocation getTextureLocation(EnderKid p_110775_1_)
	   {
	      return ENDER_KID_LOCATION;
	   }
}
