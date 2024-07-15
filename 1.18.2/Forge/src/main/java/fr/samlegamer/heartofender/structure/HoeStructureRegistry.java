package fr.samlegamer.heartofender.structure;

import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import fr.samlegamer.heartofender.config.HoeConfigsRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.dimension.HoeDimensionRegistry;
import fr.samlegamer.heartofender.structure.struct.HeartEnderShipStructure;
import fr.samlegamer.heartofender.structure.struct.HeartofEnderFortressStructure;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HoeStructureRegistry
{	
    public static final StructureRegistrar<NoneFeatureConfiguration, HeartEnderShipStructure> Heart_Ender_Ship = StructureRegistrar.builder(HeartofEnder.location("heart_ender_ship"), () -> new HeartEnderShipStructure(NoneFeatureConfiguration.CODEC, HoeConfigsRegistry.SERVER.HeartEnderShip)).addPiece(HeartEnderShipStructure.Piece::new).pushConfigured(NoneFeatureConfiguration.INSTANCE).biomes(HoeConfigsRegistry.SERVER.HeartEnderShip.getConfigured()).dimensions(HoeDimensionRegistry.HEART_OF_ENDER).popConfigured().build();
    public static final StructureRegistrar<NoneFeatureConfiguration, HeartofEnderFortressStructure> Heart_of_Ender_Fortress = StructureRegistrar.builder(HeartofEnder.location("heart_of_ender_fortress"), () -> new HeartofEnderFortressStructure(NoneFeatureConfiguration.CODEC, HoeConfigsRegistry.SERVER.HeartofEnderFortress)).addPiece(HeartofEnderFortressStructure.Piece::new).pushConfigured(NoneFeatureConfiguration.INSTANCE).biomes(HoeConfigsRegistry.SERVER.HeartofEnderFortress.getConfigured()).dimensions(HoeDimensionRegistry.HEART_OF_ENDER).popConfigured().build();

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<StructureFeature<?>> event)
    {
        IForgeRegistry<StructureFeature<?>> registry = event.getRegistry();

        Heart_Ender_Ship.handleForge(registry);
        Heart_of_Ender_Fortress.handleForge(registry);
    }
}