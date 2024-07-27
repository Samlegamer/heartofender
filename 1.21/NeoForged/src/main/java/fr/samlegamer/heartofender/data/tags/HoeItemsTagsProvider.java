package fr.samlegamer.heartofender.data.tags;

import java.util.concurrent.CompletableFuture;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
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
        tag(ItemTags.FENCE_GATES).add(HoeBlocksRegistry.LILAC_FENCE_GATE.get().asItem()).add(HoeBlocksRegistry.LEAFY_FENCE_GATE.get().asItem());
        tag(ItemTags.FENCES).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_FENCE.get().asItem()).add(HoeBlocksRegistry.DARK_END_STONE_FENCE.get().asItem());
        tag(ItemTags.WOODEN_FENCES).add(HoeBlocksRegistry.LILAC_FENCE.get().asItem()).add(HoeBlocksRegistry.LEAFY_FENCE.get().asItem());
        tag(ItemTags.PLANKS).add(HoeBlocksRegistry.LILAC_PLANKS.get().asItem()).add(HoeBlocksRegistry.LEAFY_PLANKS.get().asItem());
        tag(ItemTags.LOGS).add(HoeBlocksRegistry.LILAC_STEM.get().asItem()).add(HoeBlocksRegistry.LEAFY_STEM.get().asItem());
        tag(ItemTags.WOODEN_DOORS).add(HoeBlocksRegistry.LILAC_DOOR.get().asItem()).add(HoeBlocksRegistry.LEAFY_DOOR.get().asItem());
        tag(ItemTags.WOODEN_BUTTONS).add(HoeBlocksRegistry.LILAC_BUTTON.get().asItem()).add(HoeBlocksRegistry.LEAFY_BUTTON.get().asItem());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(HoeBlocksRegistry.LILAC_PRESSURE_PLATE.get().asItem()).add(HoeBlocksRegistry.LEAFY_PRESSURE_PLATE.get().asItem());
        tag(ItemTags.WOODEN_SLABS).add(HoeBlocksRegistry.LILAC_SLAB.get().asItem()).add(HoeBlocksRegistry.LEAFY_SLAB.get().asItem());
        tag(ItemTags.WOODEN_STAIRS).add(HoeBlocksRegistry.LILAC_STAIRS.get().asItem()).add(HoeBlocksRegistry.LEAFY_STAIRS.get().asItem());
        tag(ItemTags.WOODEN_TRAPDOORS).add(HoeBlocksRegistry.LILAC_TRAPDOOR.get().asItem()).add(HoeBlocksRegistry.LEAFY_TRAPDOOR.get().asItem());
        tag(ItemTags.STONE_BUTTONS).add(HoeBlocksRegistry.DARK_END_STONE_BUTTON.get().asItem()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON.get().asItem());
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(HoeBlocksRegistry.DARK_END_STONE.get().asItem());
        tag(ItemTags.STONE_TOOL_MATERIALS).add(HoeBlocksRegistry.DARK_END_STONE.get().asItem());
        tag(ItemTags.STAIRS).add(HoeBlocksRegistry.DARK_END_STONE_STAIRS.get().asItem()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_STAIRS.get().asItem());
        tag(ItemTags.SWORDS).add(HoeItemsRegistry.AZURIUM_SWORD.get().asItem()).add(HoeItemsRegistry.MILATHIUM_SWORD.get().asItem()).add(HoeItemsRegistry.HEART_BONE_SWORD.get().asItem());
        tag(ItemTags.PICKAXES).add(HoeItemsRegistry.AZURIUM_PICKAXE.get().asItem()).add(HoeItemsRegistry.MILATHIUM_PICKAXE.get().asItem());
        tag(ItemTags.AXES).add(HoeItemsRegistry.AZURIUM_AXE.get().asItem()).add(HoeItemsRegistry.MILATHIUM_AXE.get().asItem());
        tag(ItemTags.SHOVELS).add(HoeItemsRegistry.AZURIUM_SHOVEL.get().asItem()).add(HoeItemsRegistry.MILATHIUM_SHOVEL.get().asItem());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(HoeItemsRegistry.AZURIUM_PICKAXE.get().asItem()).add(HoeItemsRegistry.MILATHIUM_PICKAXE.get().asItem());
    }
}
