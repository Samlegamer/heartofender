package fr.samlegamer.heartofender.client.renders;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.entity.BlueMagmaCubeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.MagmaCubeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

@Environment(value=EnvType.CLIENT)
public class BlueMagmaCubeRender extends MobEntityRenderer<BlueMagmaCubeEntity, MagmaCubeEntityModel<BlueMagmaCubeEntity>>
{
    private static final Identifier TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heartmagmablock/heart_magma_block.png");

    public BlueMagmaCubeRender(EntityRendererFactory.Context context)
    {
        super(context, new MagmaCubeEntityModel(context.getPart(EntityModelLayers.MAGMA_CUBE)), 0.25f);
    }

    @Override
    protected int getBlockLight(BlueMagmaCubeEntity magmaCubeEntity, BlockPos blockPos)
    {
        return 15;
    }

    @Override
    public Identifier getTexture(BlueMagmaCubeEntity magmaCubeEntity)
    {
        return TEXTURE;
    }

    @Override
    protected void scale(BlueMagmaCubeEntity magmaCubeEntity, MatrixStack matrixStack, float f)
    {
        int i = magmaCubeEntity.getSize();
        float g = MathHelper.lerp(f, magmaCubeEntity.lastStretch, magmaCubeEntity.stretch) / ((float)i * 0.5f + 1.0f);
        float h = 1.0f / (g + 1.0f);
        matrixStack.scale(h * (float)i, 1.0f / h * (float)i, h * (float)i);
    }
}

