package fr.samlegamer.heartofender.entity.renders;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import fr.samlegamer.heartofender.entity.models.EnderKidModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EnderKidRender extends MobRenderer<EnderKidEntity, EnderKidModel<EnderKidEntity>>
{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(HeartofEnder.MODID, "textures/entity/enderkid/ender_kid.png");
	
	public EnderKidRender(EntityRendererManager manager) {
		super(manager, new EnderKidModel<>(0.0F, false), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderKidEntity p_110775_1_)
	{
		return TEXTURE;
	}
}