package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnderKidRenderer extends MobRenderer<EnderKidEntity, EnderKidModel<EnderKidEntity>> {
	   private static final ResourceLocation ENDER_KID_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/enderkid/ender_kid.png");

	   @SuppressWarnings({ "unchecked", "rawtypes" })
	public EnderKidRenderer(EntityRendererManager manag) {
	      super(manag, new EnderKidModel(0.0F, false), 0.5F);
	   }

	   @Override
	   public ResourceLocation getTextureLocation(EnderKidEntity p_110775_1_)
	   {
	      return ENDER_KID_LOCATION;
	   }
}