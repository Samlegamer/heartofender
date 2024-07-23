package fr.samlegamer.heartofender.data.tags;

import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class HoeFluidsTagsProvider extends FluidTagsProvider
{
	public HoeFluidsTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
        super(output, lookupProvider, HeartofEnder.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        tag(FluidTags.LAVA).add(HoeFluidsRegistry.GREEN_LAVA_FLOW.get()).add(HoeFluidsRegistry.GREEN_LAVA.get());
    }

}