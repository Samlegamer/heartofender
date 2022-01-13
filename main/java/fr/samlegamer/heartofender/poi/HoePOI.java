package fr.samlegamer.heartofender.poi;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoePOI
{
	public static final DeferredRegister<PoiType> REGISTRY_POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, HeartofEnder.MODID);

    public static final RegistryObject<PoiType> HEART_OF_ENDER_PORTAL = REGISTRY_POI.register("heart_of_ender_portal", () -> new PoiType("heart_of_ender_portal", PoiType.getBlockStates(HoeBlocksRegistry.HOE_PORTAL.get()), 0, 1));
}