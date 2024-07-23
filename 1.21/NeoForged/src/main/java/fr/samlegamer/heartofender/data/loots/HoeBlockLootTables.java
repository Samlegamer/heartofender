package fr.samlegamer.heartofender.data.loots;

import java.util.Set;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

public class HoeBlockLootTables extends BlockLootSubProvider
{
    protected HoeBlockLootTables(HolderLookup.Provider p_344943_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), p_344943_);
    }

    @Override
    protected void generate() {
        add(HoeBlocksRegistry.AZURIUM_ORE.get(), createOreDrop(HoeBlocksRegistry.AZURIUM_ORE.get(), HoeItemsRegistry.AZURIUM_NUGGET.get()));
        //add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), ItemInit.RAW_EXAMPLE.get()));

        dropSelf(HoeBlocksRegistry.DARK_END_STONE.get());
    }
}