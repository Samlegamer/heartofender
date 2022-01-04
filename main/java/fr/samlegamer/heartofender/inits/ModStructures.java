package fr.samlegamer.heartofender.inits;

import com.legacy.structure_gel.registrars.GelStructureRegistrar;
import com.legacy.structure_gel.registrars.StructureRegistrar2;
import com.legacy.structure_gel.worldgen.jigsaw.GelConfigJigsawStructure;
import com.legacy.structure_gel.worldgen.structure.GelConfigStructure;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.structures.SimpleStructure;
import fr.samlegamer.heartofender.structures.ship.HeartEnderShipStructure;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModStructures
{
    public static final StructureRegistrar2<NoFeatureConfig, HeartEnderShipStructure> Heart_Ender_Ship = register("heart_ender_ship", new HeartEnderShipStructure(), SimpleStructure.Piece::new);

    @SubscribeEvent
    public static void onRegistry(final RegistryEvent.Register<Structure<?>> event)
    {
        IForgeRegistry<Structure<?>> registry = event.getRegistry();

        Heart_Ender_Ship.handleForge(registry);
    }
    
    private static  <S extends GelConfigStructure<NoFeatureConfig>> StructureRegistrar2<NoFeatureConfig, S> register(String locate, S structure, IStructurePieceType piece){
        return GelStructureRegistrar.of(HeartofEnder.location(locate), structure, piece, NoFeatureConfig.INSTANCE, Decoration.SURFACE_STRUCTURES).handle();
    }
    
    private static  <S extends GelConfigStructure<NoFeatureConfig>> StructureRegistrar2<NoFeatureConfig, S> register(String locate, S structure, IStructurePieceType piece, Decoration decoration){
        return GelStructureRegistrar.of(HeartofEnder.location(locate), structure, piece, NoFeatureConfig.INSTANCE, decoration).handle();
    }

    private static  <S extends GelConfigJigsawStructure> StructureRegistrar2<VillageConfig, S> register(String locate, S structure, JigsawPattern root, IStructurePieceType piece, Decoration decoration){
        return GelStructureRegistrar.of(HeartofEnder.location(locate), structure, piece, new VillageConfig(() -> root, 7), decoration).handle();
    }
}