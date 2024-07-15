package fr.samlegamer.heartofender.client.renders;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartStriderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.StriderEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class HeartStriderRender extends MobEntityRenderer<HeartStriderEntity, StriderEntityModel<HeartStriderEntity>>
{
    private static final Identifier TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heart_strider/heart_strider.png");
    private static final Identifier COLD_TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heart_strider/heart_strider_cold.png");

    public HeartStriderRender(EntityRendererFactory.Context context)
    {
        super(context, new StriderEntityModel(context.getPart(EntityModelLayers.STRIDER)), 0.5f);
        this.addFeature(new SaddleFeatureRenderer(this, new StriderEntityModel(context.getPart(EntityModelLayers.STRIDER_SADDLE)), new Identifier("textures/entity/strider/strider_saddle.png")));
    }

    @Override
    public Identifier getTexture(HeartStriderEntity striderEntity) {
        return striderEntity.isCold() ? COLD_TEXTURE : TEXTURE;
    }

    @Override
    protected void scale(HeartStriderEntity striderEntity, MatrixStack matrixStack, float f) {
        if (striderEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
            this.shadowRadius = 0.25f;
        } else {
            this.shadowRadius = 0.5f;
        }
    }

    @Override
    protected boolean isShaking(HeartStriderEntity striderEntity) {
        return super.isShaking(striderEntity) || striderEntity.isCold();
    }
}