package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPOI
{
	public static final DeferredRegister<PointOfInterestType> POI_REGISTRY = DeferredRegister.create(ForgeRegistries.POI_TYPES, HeartofEnder.MODID);

    public static final RegistryObject<PointOfInterestType> HEART_OF_ENDER_PORTAL = POI_REGISTRY.register("heart_of_ender_portal", () -> new PointOfInterestType("heart_of_ender_portal", PointOfInterestType.getBlockStates(ModBlocks.HEART_OF_ENDER_PORTAL.get()), 0, 1));
}