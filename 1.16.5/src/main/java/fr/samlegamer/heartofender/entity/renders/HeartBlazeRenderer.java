package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartBlazeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.BlazeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartBlazeRenderer extends MobRenderer<HeartBlazeEntity, BlazeModel<HeartBlazeEntity>> {
	   private static final ResourceLocation HEART_BLAZE_LOCATION = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartblaze/heart_blaze.png");

	   public HeartBlazeRenderer(EntityRendererManager manag) {
	      super(manag, new BlazeModel<>(), 0.5F);
	   }

	   protected int getBlockLightLevel(HeartBlazeEntity p_225624_1_, BlockPos p_225624_2_)
	   {
	      return 15;
	   }

	   public ResourceLocation getTextureLocation(HeartBlazeEntity p_110775_1_)
	   {
	      return HEART_BLAZE_LOCATION;
	   }
	}