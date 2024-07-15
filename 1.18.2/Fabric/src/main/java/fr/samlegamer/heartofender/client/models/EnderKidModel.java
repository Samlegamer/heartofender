package fr.samlegamer.heartofender.client.models;

import fr.samlegamer.heartofender.entity.EnderKidEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;

@Environment(EnvType.CLIENT)
public class EnderKidModel extends BipedEntityModel<EnderKidEntity>
{
	   public static float p_170683_;
		
	   public EnderKidModel(ModelPart p_170677_)
	   {
		   super(p_170677_);
	   }

	   public static TexturedModelData getTexturedModelData()
	   {
		   ModelData meshdefinition = new ModelData();
		   ModelPartData partdefinition = meshdefinition.getRoot();
		      partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, Dilation.NONE), ModelTransform.rotation(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addChild("hat", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, Dilation.NONE.add(0.5F)), ModelTransform.rotation(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, Dilation.NONE), ModelTransform.rotation(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, Dilation.NONE), ModelTransform.rotation(-5.0F, 2.0F + p_170683_, 0.0F));
		      partdefinition.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, Dilation.NONE), ModelTransform.rotation(5.0F, 2.0F + p_170683_, 0.0F));
		      partdefinition.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, Dilation.NONE), ModelTransform.rotation(-1.9F, 12.0F + p_170683_, 0.0F));
		      partdefinition.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, Dilation.NONE), ModelTransform.rotation(1.9F, 12.0F + p_170683_, 0.0F));
		      return TexturedModelData.of(meshdefinition, 64 , 64);
	   }
	   
	   public boolean isAngry(EnderKidEntity p_212850_1_)
	   {
		   return p_212850_1_.isAngry();
	   }
}