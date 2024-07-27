package fr.samlegamer.heartofender.data.loots;

import java.util.Set;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class HoeBlockLootTables extends BlockLootSubProvider
{
    protected HoeBlockLootTables(HolderLookup.Provider p_344943_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), p_344943_);
    }

    @Override
    protected void generate()
    {
        dropSelf(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE.get());
        dropSelf(HoeBlocksRegistry.BLUE_MAGMA_BLOCK.get());
        dropSelf(HoeBlocksRegistry.SOUL_SHROOMLIGHT.get());
        dropSelf(HoeBlocksRegistry.LILAC_SHROOMLIGHT.get());
        dropSelf(HoeBlocksRegistry.AZURIUM_BLOCK.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK_FENCE.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK_PRESSURE_PLATE.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK_SLAB.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BRICK_STAIRS.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_BUTTON.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_FENCE.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_PRESSURE_PLATE.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_SLAB.get());
        dropSelf(HoeBlocksRegistry.DARK_END_STONE_STAIRS.get());
        dropSelf(HoeBlocksRegistry.DEAD_SOUL_SAND.get());
        dropSelf(HoeBlocksRegistry.DEAD_SOUL_SOIL.get());
        dropSelf(HoeBlocksRegistry.GREEN_LANTERN.get());
        dropSelf(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get());
        dropSelf(HoeBlocksRegistry.HEROBRINE_HEAD.get());
        dropSelf(HoeBlocksRegistry.LEAFY_BUTTON.get());
        dropSelf(HoeBlocksRegistry.LEAFY_FENCE.get());
        dropSelf(HoeBlocksRegistry.LEAFY_FENCE_GATE.get());
        dropSelf(HoeBlocksRegistry.LILAC_FENCE.get());
        dropSelf(HoeBlocksRegistry.LILAC_FENCE_GATE.get());
        dropSelf(HoeBlocksRegistry.PURPLE_LANTERN.get());
        dropSelf(HoeBlocksRegistry.LEAFY_HYPHAE.get());
        dropSelf(HoeBlocksRegistry.LILAC_HYPHAE.get());
        dropSelf(HoeBlocksRegistry.LEAFY_PLANKS.get());
        dropSelf(HoeBlocksRegistry.LILAC_PLANKS.get());
        dropSelf(HoeBlocksRegistry.LEAFY_PRESSURE_PLATE.get());
        dropSelf(HoeBlocksRegistry.LILAC_PRESSURE_PLATE.get());
        dropSelf(HoeBlocksRegistry.LEAFY_ROOTS.get());
        dropSelf(HoeBlocksRegistry.LILAC_ROOTS.get());
        dropSelf(HoeBlocksRegistry.LEAFY_SLAB.get());
        dropSelf(HoeBlocksRegistry.LILAC_SLAB.get());
        dropSelf(HoeBlocksRegistry.LEAFY_STAIRS.get());
        dropSelf(HoeBlocksRegistry.LILAC_STAIRS.get());
        dropSelf(HoeBlocksRegistry.LEAFY_STEM.get());
        dropSelf(HoeBlocksRegistry.LILAC_STEM.get());
        dropSelf(HoeBlocksRegistry.LEAFY_TRAPDOOR.get());
        dropSelf(HoeBlocksRegistry.LILAC_TRAPDOOR.get());
        dropSelf(HoeBlocksRegistry.LEAFY_TWISTING_VINES.get());
        dropSelf(HoeBlocksRegistry.LEAFY_WART_BLOCK.get());
        dropSelf(HoeBlocksRegistry.LILAC_WART_BLOCK.get());
        dropSelf(HoeBlocksRegistry.LILAC_BUTTON.get());
        dropSelf(HoeBlocksRegistry.LILAC_WEEPING_VINES.get());
        dropSelf(HoeBlocksRegistry.MILATHIUM_BLOCK.get());
        dropSelf(HoeBlocksRegistry.MILATHIUM_ORE.get());
        dropSelf(HoeBlocksRegistry.STRIPPED_LEAFY_STEM.get());
        dropSelf(HoeBlocksRegistry.STRIPPED_LILAC_STEM.get());
        dropSelf(HoeBlocksRegistry.STRIPPED_LILAC_HYPHAE.get());
        dropSelf(HoeBlocksRegistry.STRIPPED_LEAFY_HYPHAE.get());
        dropOther(HoeBlocksRegistry.LEAFY_TWISTING_VINES_PLANT.get(), HoeBlocksRegistry.LEAFY_TWISTING_VINES.get());
        dropOther(HoeBlocksRegistry.LILAC_WEEPING_VINES_PLANT.get(), HoeBlocksRegistry.LILAC_WEEPING_VINES.get());
        add(HoeBlocksRegistry.LILAC_DOOR.get(), createDoorTable(HoeBlocksRegistry.LILAC_DOOR.get()));
        add(HoeBlocksRegistry.LEAFY_DOOR.get(), createDoorTable(HoeBlocksRegistry.LEAFY_DOOR.get()));
        add(HoeBlocksRegistry.LEAFY_NYLIUM.get(), createSingleItemTableWithSilkTouch(HoeBlocksRegistry.LEAFY_NYLIUM.get(), HoeBlocksRegistry.DARK_END_STONE.get()));
        add(HoeBlocksRegistry.LILAC_NYLIUM.get(), createSingleItemTableWithSilkTouch(HoeBlocksRegistry.LILAC_NYLIUM.get(), HoeBlocksRegistry.DARK_END_STONE.get()));
        add(HoeBlocksRegistry.PURPLE_GLOWSTONE.get(), createOreDrop(HoeBlocksRegistry.PURPLE_GLOWSTONE.get(), HoeItemsRegistry.PURPLE_GLOWSTONE_DUST.get()));
        add(HoeBlocksRegistry.GREEN_CAMPFIRE.get(), createSingleItemTableWithSilkTouch(HoeBlocksRegistry.GREEN_CAMPFIRE.get(), Items.CHARCOAL));
        add(HoeBlocksRegistry.PURPLE_CAMPFIRE.get(), createSingleItemTableWithSilkTouch(HoeBlocksRegistry.PURPLE_CAMPFIRE.get(), Items.CHARCOAL));
        add(HoeBlocksRegistry.AZURIUM_ORE.get(), createOreDrop(HoeBlocksRegistry.AZURIUM_ORE.get(), HoeItemsRegistry.AZURIUM_NUGGET.get()));
        add(HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get(), createOreDrop(HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get(), HoeItemsRegistry.AZURIUM_NUGGET.get()));
        add(HoeBlocksRegistry.GREEN_FIRE.get(), noDrop());
        add(HoeBlocksRegistry.PURPLE_FIRE.get(), noDrop());
    }
    
    @Override
    protected Iterable<Block> getKnownBlocks() {
        // The contents of our DeferredRegister.
        return HoeBlocksRegistry.REGISTRY_BLOCKS.getEntries()
                .stream()
                // Cast to Block here, otherwise it will be a ? extends Block and Java will complain.
                .map(e -> (Block) e.value())
                .toList();
    }

}