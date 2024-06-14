package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartGhastEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.GhastModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartGhastRenderer extends MobRenderer<HeartGhastEntity, GhastModel<HeartGhastEntity>>
{
	   private static final ResourceLocation GHAST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast.png");
	   private static final ResourceLocation GHAST_SHOOTING_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast_shooting.png");

	   public HeartGhastRenderer(EntityRendererManager manag) {
	      super(manag, new GhastModel<>(), 1.5F);
	   }

	   public ResourceLocation getTextureLocation(HeartGhastEntity entity) {
	      return entity.isCharging() ? GHAST_SHOOTING_LOCATION : GHAST_LOCATION;
	   }

	   @SuppressWarnings("unused")
	protected void scale(HeartGhastEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      float f = 1.0F;
	      float f1 = 4.5F;
	      float f2 = 4.5F;
	      p_225620_2_.scale(4.5F, 4.5F, 4.5F);
	   }
	}