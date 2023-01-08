package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.core.HoeClient;
import fr.samlegamer.heartofender.entity.Herobrine;
import fr.samlegamer.heartofender.entity.models.HerobrineModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HerobrineRender extends HumanoidMobRenderer<Herobrine, HerobrineModel>
{
	private static final ResourceLocation HEROBRINE_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/herobrine/mob_herobrine.png");
	    
	    public HerobrineRender(Context p_173931_)
	    {
	    	super(p_173931_, new HerobrineModel(p_173931_.bakeLayer(HoeClient.HEROBRINE_MODEL)), 0.5F);
	    }
	    
	   @Override
	   public ResourceLocation getTextureLocation(Herobrine p_110775_1_)
	   {
	      return HEROBRINE_LOCATION;
	   }
}