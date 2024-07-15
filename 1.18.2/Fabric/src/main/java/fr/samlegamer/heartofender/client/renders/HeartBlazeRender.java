package fr.samlegamer.heartofender.client.renders;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.entity.HeartBlazeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.model.BlazeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(value=EnvType.CLIENT)
public class HeartBlazeRender extends MobEntityRenderer<HeartBlazeEntity, BlazeEntityModel<HeartBlazeEntity>>
{
    private static final Identifier TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/heartblaze/heart_blaze.png");

    public HeartBlazeRender(EntityRendererFactory.Context context) {
        super(context, new BlazeEntityModel(context.getPart(EntityModelLayers.BLAZE)), 0.5f);
    }

    @Override
    protected int getBlockLight(HeartBlazeEntity blazeEntity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public Identifier getTexture(HeartBlazeEntity blazeEntity) {
        return TEXTURE;
    }
}