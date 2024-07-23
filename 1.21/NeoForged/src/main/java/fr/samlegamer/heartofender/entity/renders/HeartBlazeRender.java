package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.client.model.BlazeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Blaze;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartBlazeRender extends MobRenderer<Blaze, BlazeModel<Blaze>>
{
	   private static final ResourceLocation HEART_BLAZE_LOCATION = ResourceLocation.withDefaultNamespace(HeartofEnder.MODID + ":textures/entity/heartblaze/heart_blaze.png");

	   public HeartBlazeRender(EntityRendererProvider.Context p_173933_)
	   {
	      super(p_173933_, new BlazeModel<>(p_173933_.bakeLayer(ModelLayers.BLAZE)), 0.5F);
	   }

	   protected int getBlockLightLevel(Blaze p_113910_, BlockPos p_113911_) {
	      return 15;
	   }

	   public ResourceLocation getTextureLocation(Blaze p_113908_) {
	      return HEART_BLAZE_LOCATION;
	   }
}