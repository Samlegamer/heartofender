package fr.samlegamer.heartofender.client.renders;

import fr.samlegamer.heartofender.HeartofEnder;
import fr.samlegamer.heartofender.client.HoeClient;
import fr.samlegamer.heartofender.client.models.EnderKidModel;
import fr.samlegamer.heartofender.entity.EnderKidEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.*;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class EnderKidRender extends MobEntityRenderer<EnderKidEntity, EnderKidModel>
{
    private static final Identifier TEXTURE = new Identifier(HeartofEnder.MODID, "textures/entity/enderkid/ender_kid.png");

    public EnderKidRender(EntityRendererFactory.Context context) {
        super(context, new EnderKidModel(context.getPart(HoeClient.ENDER_KID)), 0.5f);
    }

    @Override
    public Identifier getTexture(EnderKidEntity blazeEntity) {
        return TEXTURE;
    }
}