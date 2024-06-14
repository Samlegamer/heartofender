package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartGhast;
import net.minecraft.client.model.GhastModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartGhastRender  extends MobRenderer<HeartGhast, GhastModel<HeartGhast>>
{
	   private static final ResourceLocation GHAST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast.png");
	   private static final ResourceLocation GHAST_SHOOTING_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast_shooting.png");

	   public HeartGhastRender(EntityRendererProvider.Context p_174129_) {
	      super(p_174129_, new GhastModel<>(p_174129_.bakeLayer(ModelLayers.GHAST)), 1.5F);
	   }

	   public ResourceLocation getTextureLocation(HeartGhast p_114755_) {
	      return p_114755_.isCharging() ? GHAST_SHOOTING_LOCATION : GHAST_LOCATION;
	   }

	   protected void scale(HeartGhast p_114757_, PoseStack p_114758_, float p_114759_) {
	      float f = 1.0F;
	      float f1 = 4.5F;
	      float f2 = 4.5F;
	      p_114758_.scale(4.5F, 4.5F, 4.5F);
	   }
}