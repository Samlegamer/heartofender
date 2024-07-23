package fr.samlegamer.heartofender.data.tags;

import java.util.concurrent.CompletableFuture;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class HoeItemsTagsProvider extends ItemTagsProvider
{
    public HoeItemsTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,  BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, provider.contentsGetter(), HeartofEnder.MODID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(HoeItemsRegistry.AZURIUM_INGOT.get()).add(HoeItemsRegistry.MILATHIUM_INGOT.get());
    }
}
