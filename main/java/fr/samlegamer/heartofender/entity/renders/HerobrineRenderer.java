package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HerobrineEntity;
import fr.samlegamer.heartofender.entity.models.HerobrineModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HerobrineRenderer extends MobRenderer<HerobrineEntity, HerobrineModel<HerobrineEntity>>
{
	private static final ResourceLocation HEROBRINE_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/herobrine/mob_herobrine.png");

	   @SuppressWarnings({ "rawtypes" })
	public HerobrineRenderer(EntityRendererManager manag) {
	      super(manag, new HerobrineModel(0.0F, false), 0.5F);
	   }

	   @Override
	   public ResourceLocation getTextureLocation(HerobrineEntity p_110775_1_)
	   {
	      return HEROBRINE_LOCATION;
	   }
}