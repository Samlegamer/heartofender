package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.BlueMagmaCube;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlueMagmaCubeRender extends MagmaCubeRenderer
{
	   private static final ResourceLocation MAGMACUBE_LOCATION = ResourceLocation.withDefaultNamespace(HeartofEnder.MODID + ":textures/entity/heartmagmablock/heart_magma_block.png");

	   public BlueMagmaCubeRender(EntityRendererProvider.Context p_174298_) {
	      super(p_174298_);
	   }

	   protected int getBlockLightLevel(BlueMagmaCube p_115399_, BlockPos p_115400_) {
	      return 15;
	   }

	   public ResourceLocation getTextureLocation(BlueMagmaCube p_115393_) {
	      return MAGMACUBE_LOCATION;
	   }

	   protected void scale(BlueMagmaCube p_115395_, PoseStack p_115396_, float p_115397_) {
	      int i = p_115395_.getSize();
	      float f = Mth.lerp(p_115397_, p_115395_.oSquish, p_115395_.squish) / ((float)i * 0.5F + 1.0F);
	      float f1 = 1.0F / (f + 1.0F);
	      p_115396_.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
	   }
}