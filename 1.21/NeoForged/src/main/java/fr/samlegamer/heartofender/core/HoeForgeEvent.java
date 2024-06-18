package fr.samlegamer.heartofender.core;

import java.util.List;
import java.util.function.Supplier;

import com.legacy.structure_gel.api.events.AddStructureToBiomeEvent;

import fr.samlegamer.heartofender.structure.HoeStructureRegistry;
import fr.samlegamer.heartofender.world.HoeOreGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HeartofEnder.MODID, bus = Bus.FORGE)
public class HoeForgeEvent
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {
        final List<Supplier<PlacedFeature>> features = event.getGeneration()
                .getFeatures(Decoration.UNDERGROUND_ORES);

        switch (event.getCategory()) {
            case NETHER -> HoeOreGenerator.NETHER_ORES.forEach(ore -> features.add(() -> ore));
            case THEEND -> HoeOreGenerator.END_ORES.forEach(ore -> features.add(() -> ore));
            default -> HoeOreGenerator.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
        }
    }
    
	@SubscribeEvent
	protected static void addStructureToBiome(final AddStructureToBiomeEvent event)
	{
		event.register(HoeStructureRegistry.Heart_Ender_Ship);
		event.register(HoeStructureRegistry.Heart_of_Ender_Fortress);
	}
}