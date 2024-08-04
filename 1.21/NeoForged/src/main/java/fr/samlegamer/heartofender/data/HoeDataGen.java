package fr.samlegamer.heartofender.data;

import java.util.concurrent.CompletableFuture;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.data.advancement.HoeAdvancementProvider;
import fr.samlegamer.heartofender.data.loots.HoeLoot;
import fr.samlegamer.heartofender.data.recipe.HoeRecipeProvider;
import fr.samlegamer.heartofender.data.tags.HoeBlocksTagsProvider;
import fr.samlegamer.heartofender.data.tags.HoeFluidsTagsProvider;
import fr.samlegamer.heartofender.data.tags.HoeItemsTagsProvider;
import fr.samlegamer.heartofender.data.worldgen.HoeWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = HeartofEnder.MODID)
public class HoeDataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        try {
	        DataGenerator generator = event.getGenerator();
	        PackOutput output = generator.getPackOutput();
	        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
	        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
	
	        generator.addProvider(event.includeServer(), new HoeRecipeProvider(output, lookupProvider));
	        generator.addProvider(event.includeServer(), new HoeAdvancementProvider(output, lookupProvider, existingFileHelper));
	        HoeBlocksTagsProvider modBlockTagsProvider = new HoeBlocksTagsProvider(output, event.getLookupProvider(), existingFileHelper);
	        generator.addProvider(event.includeServer(), modBlockTagsProvider);
	        generator.addProvider(event.includeServer(), new HoeItemsTagsProvider(output, event.getLookupProvider(), modBlockTagsProvider, existingFileHelper));
	        generator.addProvider(event.includeServer(), new HoeFluidsTagsProvider(output, event.getLookupProvider(), existingFileHelper));
	        generator.addProvider(event.includeServer(), new HoeLoot(output, event.getLookupProvider()));
	        generator.addProvider(event.includeServer(), new HoeWorldGenProvider(output, event.getLookupProvider()));
        } catch (RuntimeException e) {
            HeartofEnder.LOGGER.error("Failed to gather data", e);
        }
    }

}
