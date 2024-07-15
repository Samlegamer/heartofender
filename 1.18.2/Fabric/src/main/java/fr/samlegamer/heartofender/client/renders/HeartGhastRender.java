package fr.samlegamer.heartofender.client.renders;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartGhastEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GhastEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class HeartGhastRender extends MobEntityRenderer<HeartGhastEntity, GhastEntityModel<HeartGhastEntity>>
{
    private static final Identifier TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast.png");
    private static final Identifier ANGRY_TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heartghast/heart_ghast_shooting.png");

    public HeartGhastRender(EntityRendererFactory.Context context) {
        super(context, new GhastEntityModel(context.getPart(EntityModelLayers.GHAST)), 1.5f);
    }

    @Override
    public Identifier getTexture(HeartGhastEntity ghastEntity) {
        if (ghastEntity.isShooting()) {
            return ANGRY_TEXTURE;
        }
        return TEXTURE;
    }

    @Override
    protected void scale(HeartGhastEntity ghastEntity, MatrixStack matrixStack, float f) {
        float g = 1.0f;
        float h = 4.5f;
        float i = 4.5f;
        matrixStack.scale(4.5f, 4.5f, 4.5f);
    }
}