package fr.samlegamer.heartofender.entity.renders;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.BlueMagmaCubeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.MagmaCubeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlueMagmaCubeRenderer extends MobRenderer<BlueMagmaCubeEntity, MagmaCubeModel<BlueMagmaCubeEntity>>
{
	   private static final ResourceLocation MOB_TEXTURE = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartmagmablock/heart_magma_block.png");

	   public BlueMagmaCubeRenderer(EntityRendererManager p_i46159_1_) {
	      super(p_i46159_1_, new MagmaCubeModel<>(), 0.25F);
	   }

	   protected int getBlockLightLevel(BlueMagmaCubeEntity p_225624_1_, BlockPos p_225624_2_) {
	      return 25;
	   }

	   public ResourceLocation getTextureLocation(BlueMagmaCubeEntity p_110775_1_) {
	      return MOB_TEXTURE;
	   }

	   protected void scale(BlueMagmaCubeEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
	      int i = p_225620_1_.getSize();
	      float f = MathHelper.lerp(p_225620_3_, p_225620_1_.oSquish, p_225620_1_.squish) / ((float)i * 0.5F + 1.0F);
	      float f1 = 1.0F / (f + 1.0F);
	      p_225620_2_.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
	   }
	}