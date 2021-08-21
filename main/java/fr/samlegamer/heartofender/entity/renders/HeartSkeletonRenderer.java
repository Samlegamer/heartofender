package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartSkeletonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;

public class HeartSkeletonRenderer extends MobRenderer<HeartSkeletonEntity, SkeletonModel<HeartSkeletonEntity>>
{

	private static final ResourceLocation HEART_SKELETON_TEXTURE = new ResourceLocation(HeartofEnder.MODID, "textures/entity/heartskeleton/heart_skeleton.png");
	
	
	  @SuppressWarnings({ "unchecked", "rawtypes" })
		public HeartSkeletonRenderer(EntityRendererManager manag) {
		      super(manag, new SkeletonModel(0.0F, false), 0.5F);
		   }

	@Override
	public ResourceLocation getTextureLocation(HeartSkeletonEntity p_110775_1_)
	{
		return HEART_SKELETON_TEXTURE;
	}

}