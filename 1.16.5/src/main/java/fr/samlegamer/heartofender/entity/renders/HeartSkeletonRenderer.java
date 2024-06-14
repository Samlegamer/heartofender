package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartSkeletonRenderer extends SkeletonRenderer {
	   private static final ResourceLocation HEART_SKELETON_TEXTURE = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartskeleton/heart_skeleton.png");

	   public HeartSkeletonRenderer(EntityRendererManager p_i47188_1_) {
	      super(p_i47188_1_);
	   }

	   public ResourceLocation getTextureLocation(AbstractSkeletonEntity p_110775_1_) {
	      return HEART_SKELETON_TEXTURE;
	   }

	   protected void scale(AbstractSkeletonEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      p_225620_2_.scale(1.2F, 1.2F, 1.2F);
	   }
}