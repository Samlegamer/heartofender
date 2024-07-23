package fr.samlegamer.heartofender.poi;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoePOI
{
	public static final DeferredRegister<PoiType> REGISTRY_POI = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, HeartofEnder.MODID);

    //public static final DeferredHolder<PoiType, PoiType> HEART_OF_ENDER_PORTAL = REGISTRY_POI.register("heart_of_ender_portal", () -> new PoiType("heart_of_ender_portal", PoiType.getBlockStates(HoeBlocksRegistry.HOE_PORTAL.get()), 0, 1));
}