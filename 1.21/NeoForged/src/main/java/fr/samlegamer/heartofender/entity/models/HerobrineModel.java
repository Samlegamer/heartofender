package fr.samlegamer.heartofender.entity.models;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.entity.Herobrine;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/*
 * I used a lot of help from Meet Your Fight for the models
 * https://github.com/Lykrast/MeetYourFight/blob/master/src/main/java/lykrast/meetyourfight/renderer/DameFortunaModel.java
 */
@OnlyIn(Dist.CLIENT)
public class HerobrineModel extends HumanoidModel<Herobrine>
{
	public static final ModelLayerLocation MODEL = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "ender_kid"), "main");
	   public static float p_170683_;
		
	   public HerobrineModel(ModelPart p_170677_)
	   {
		   super(p_170677_);
	   }

	   public static LayerDefinition createLayer()
	   {
		      MeshDefinition meshdefinition = new MeshDefinition();
		      PartDefinition partdefinition = meshdefinition.getRoot();
		      partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 0.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-5.0F, 2.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(5.0F, 2.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-1.9F, 12.0F + p_170683_, 0.0F));
		      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(1.9F, 12.0F + p_170683_, 0.0F));
		      return LayerDefinition.create(meshdefinition, 64 , 64);
	   }
	   
	   public boolean isAggressive(Herobrine p_212850_1_)
	   {
		   return p_212850_1_.isAggressive();
	   }
}