package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartSkeletonRender extends WitherSkeletonRenderer
{
	private static final ResourceLocation HEART_SKELETON_TEXTURE = ResourceLocation.withDefaultNamespace(HeartofEnder.MODID + ":textures/entity/heartskeleton/heart_skeleton.png");

   public HeartSkeletonRender(EntityRendererProvider.Context p_174447_) {
      super(p_174447_);
   }

   public ResourceLocation getTextureLocation(WitherSkeleton p_116458_) {
      return HEART_SKELETON_TEXTURE;
   }

   protected void scale(AbstractSkeleton p_116460_, PoseStack p_116461_, float p_116462_) {
      p_116461_.scale(1.2F, 1.2F, 1.2F);
   }
}