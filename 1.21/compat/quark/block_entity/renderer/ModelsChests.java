package fr.samlegamer.heartofender.compat.quark.block_entity.renderer;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = HeartofEnder.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModelsChests
{
	  public static final ResourceLocation LILAC_CHEST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/normal");
	  public static final ResourceLocation LILAC_CHEST_LEFT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/left");
	  public static final ResourceLocation LILAC_CHEST_RIGHT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/right");

	  public static final ResourceLocation LEAFY_CHEST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/normal");
	  public static final ResourceLocation LEAFY_CHEST_LEFT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/left");
	  public static final ResourceLocation LEAFY_CHEST_RIGHT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/right");

	  public static final ResourceLocation TRAPPED_LILAC_CHEST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/trap");
	  public static final ResourceLocation TRAPPED_LILAC_CHEST_LEFT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/trap_left");
	  public static final ResourceLocation TRAPPED_LILAC_CHEST_RIGHT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_lilac/trap_right");
	  
	  public static final ResourceLocation TRAPPED_LEAFY_CHEST_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/trap");
	  public static final ResourceLocation TRAPPED_LEAFY_CHEST_LEFT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/trap_left");
	  public static final ResourceLocation TRAPPED_LEAFY_CHEST_RIGHT_LOCATION = new ResourceLocation(HeartofEnder.MODID, "entity/chest_leafy/trap_right");

	  public static final ResourceLocation VANILLA_CHEST_LOCATION = new ResourceLocation("entity/chest/normal");
	  public static final ResourceLocation TRAPPED_VANILLA_CHEST_LOCATION = new ResourceLocation("entity/chest/trapped");

	  public static ResourceLocation chooseChestTexture(EnumChestsTypes type, boolean trapped) {
	    if (trapped)
	      return switch (type) {
	        case TLILAC -> TRAPPED_LILAC_CHEST_LOCATION;
	        case TLILAC_LEFT -> TRAPPED_LILAC_CHEST_LEFT_LOCATION;
	        case TLILAC_RIGHT -> TRAPPED_LILAC_CHEST_RIGHT_LOCATION;
	        case TLEAFY -> TRAPPED_LEAFY_CHEST_LOCATION;
	        case TLEAFY_LEFT -> TRAPPED_LEAFY_CHEST_LEFT_LOCATION;
	        case TLEAFY_RIGHT -> TRAPPED_LEAFY_CHEST_RIGHT_LOCATION;
	        default -> TRAPPED_VANILLA_CHEST_LOCATION;
	      };
	    else
	      return switch (type) {
	        case LILAC -> LILAC_CHEST_LOCATION;
	        case LILAC_LEFT -> LILAC_CHEST_LEFT_LOCATION;
	        case LILAC_RIGHT -> LILAC_CHEST_RIGHT_LOCATION;
	        case LEAFY -> LEAFY_CHEST_LOCATION;
	        case LEAFY_LEFT -> LEAFY_CHEST_LEFT_LOCATION;
	        case LEAFY_RIGHT -> LEAFY_CHEST_RIGHT_LOCATION;
	        default -> VANILLA_CHEST_LOCATION;
	      };
	  }

	  @SubscribeEvent
	  public static void onStitch(TextureStitchEvent.Pre event) {
	    if (!event.getAtlas().location().equals(Sheets.CHEST_SHEET)) {
	      return;
	    }

	    event.addSprite(LILAC_CHEST_LOCATION);
	    event.addSprite(LILAC_CHEST_LEFT_LOCATION);
	    event.addSprite(LILAC_CHEST_RIGHT_LOCATION);
	    event.addSprite(LEAFY_CHEST_LOCATION);
	    event.addSprite(LEAFY_CHEST_LEFT_LOCATION);
	    event.addSprite(LEAFY_CHEST_RIGHT_LOCATION);
	    
	    event.addSprite(TRAPPED_LILAC_CHEST_LOCATION);
	    event.addSprite(TRAPPED_LILAC_CHEST_LEFT_LOCATION);
	    event.addSprite(TRAPPED_LILAC_CHEST_RIGHT_LOCATION);
	    event.addSprite(TRAPPED_LEAFY_CHEST_LOCATION);
	    event.addSprite(TRAPPED_LEAFY_CHEST_LEFT_LOCATION);
	    event.addSprite(TRAPPED_LEAFY_CHEST_RIGHT_LOCATION);
	  }
}