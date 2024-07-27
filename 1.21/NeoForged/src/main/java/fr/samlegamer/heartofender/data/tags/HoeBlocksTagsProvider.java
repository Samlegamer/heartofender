package fr.samlegamer.heartofender.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;
import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;

public class HoeBlocksTagsProvider extends BlockTagsProvider
{
	public HoeBlocksTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
        super(output, lookupProvider, HeartofEnder.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        tag(BlockTags.PLANKS).add(HoeBlocksRegistry.LILAC_PLANKS.get()).add(HoeBlocksRegistry.LEAFY_PLANKS.get());
        tag(BlockTags.FENCE_GATES).add(HoeBlocksRegistry.LILAC_FENCE_GATE.get()).add(HoeBlocksRegistry.LEAFY_FENCE_GATE.get());
        tag(BlockTags.FENCES).add(HoeBlocksRegistry.DARK_END_STONE_FENCE.get()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_FENCE.get());
        tag(BlockTags.WOODEN_FENCES).add(HoeBlocksRegistry.LILAC_FENCE.get()).add(HoeBlocksRegistry.LEAFY_FENCE.get());
        tag(BlockTags.BEACON_BASE_BLOCKS).add(HoeBlocksRegistry.AZURIUM_BLOCK.get()).add(HoeBlocksRegistry.MILATHIUM_BLOCK.get());
        tag(BlockTags.STONE_BUTTONS).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON.get()).add(HoeBlocksRegistry.DARK_END_STONE_BUTTON.get());
        tag(BlockTags.WOODEN_BUTTONS).add(HoeBlocksRegistry.LILAC_BUTTON.get()).add(HoeBlocksRegistry.LEAFY_BUTTON.get());
        tag(BlockTags.NYLIUM).add(HoeBlocksRegistry.LILAC_NYLIUM.get()).add(HoeBlocksRegistry.LEAFY_NYLIUM.get());
        tag(BlockTags.STONE_PRESSURE_PLATES).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_PRESSURE_PLATE.get()).add(HoeBlocksRegistry.DARK_END_STONE_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(HoeBlocksRegistry.LILAC_PRESSURE_PLATE.get()).add(HoeBlocksRegistry.LEAFY_PRESSURE_PLATE.get());
        tag(BlockTags.CLIMBABLE).add(HoeBlocksRegistry.LILAC_WEEPING_VINES.get()).add(HoeBlocksRegistry.LILAC_WEEPING_VINES_PLANT.get())
        .add(HoeBlocksRegistry.LEAFY_TWISTING_VINES.get()).add(HoeBlocksRegistry.LEAFY_TWISTING_VINES_PLANT.get());
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(HoeBlocksRegistry.LILAC_NYLIUM.get()).add(HoeBlocksRegistry.LEAFY_NYLIUM.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get()).add(HoeBlocksRegistry.AZURIUM_ORE.get())
        .add(HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get()).add(HoeBlocksRegistry.BLUE_MAGMA_BLOCK.get()).add(HoeBlocksRegistry.HEROBRINE_HEAD.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(HoeBlocksRegistry.MILATHIUM_BLOCK.get()).add(HoeBlocksRegistry.MILATHIUM_ORE.get());
        tag(BlockTags.CAMPFIRES).add(HoeBlocksRegistry.GREEN_CAMPFIRE.get()).add(HoeBlocksRegistry.PURPLE_CAMPFIRE.get());
        tag(BlockTags.SOUL_SPEED_BLOCKS).add(HoeBlocksRegistry.DEAD_SOUL_SAND.get()).add(HoeBlocksRegistry.DEAD_SOUL_SOIL.get());
        
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get()).add(HoeBlocksRegistry.DARK_END_STONE.get())
        .add(HoeBlocksRegistry.AZURIUM_ORE.get()).add(HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get()).add(HoeBlocksRegistry.AZURIUM_BLOCK.get())
        .add(HoeBlocksRegistry.DARK_END_STONE_BRICK.get()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_STAIRS.get()).add(HoeBlocksRegistry.DARK_END_STONE_STAIRS.get())
        .add(HoeBlocksRegistry.PURPLE_GLOWSTONE.get()).add(HoeBlocksRegistry.MILATHIUM_BLOCK.get()).add(HoeBlocksRegistry.MILATHIUM_ORE.get())
        .add(HoeBlocksRegistry.DARK_END_STONE_FENCE.get()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_FENCE.get()).add(HoeBlocksRegistry.DARK_END_STONE_SLAB.get())
        .add(HoeBlocksRegistry.DARK_END_STONE_BRICK_SLAB.get()).add(HoeBlocksRegistry.DARK_END_STONE_PRESSURE_PLATE.get()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_PRESSURE_PLATE.get())
        .add(HoeBlocksRegistry.DARK_END_STONE_BUTTON.get()).add(HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON.get()).add(HoeBlocksRegistry.BLUE_MAGMA_BLOCK.get())
        .add(HoeBlocksRegistry.HEROBRINE_HEAD.get()).add(HoeBlocksRegistry.GREEN_LANTERN.get()).add(HoeBlocksRegistry.LILAC_NYLIUM.get()).add(HoeBlocksRegistry.LEAFY_NYLIUM.get())
        .add(HoeBlocksRegistry.SOUL_SHROOMLIGHT.get()).add(HoeBlocksRegistry.LILAC_SHROOMLIGHT.get()).add(HoeBlocksRegistry.PURPLE_LANTERN.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(HoeBlocksRegistry.LEAFY_WART_BLOCK.get()).add(HoeBlocksRegistry.LILAC_WART_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(HoeBlocksRegistry.DEAD_SOUL_SAND.get()).add(HoeBlocksRegistry.DEAD_SOUL_SOIL.get());
        
        tag(BlockTags.MINEABLE_WITH_AXE).add(HoeBlocksRegistry.GREEN_CAMPFIRE.get()).add(HoeBlocksRegistry.LILAC_STEM.get()).add(HoeBlocksRegistry.LEAFY_STEM.get())
        .add(HoeBlocksRegistry.STRIPPED_LILAC_STEM.get()).add(HoeBlocksRegistry.STRIPPED_LEAFY_STEM.get()).add(HoeBlocksRegistry.STRIPPED_LEAFY_HYPHAE.get()).add(HoeBlocksRegistry.STRIPPED_LILAC_HYPHAE.get())
        .add(HoeBlocksRegistry.LEAFY_HYPHAE.get()).add(HoeBlocksRegistry.LILAC_HYPHAE.get()).add(HoeBlocksRegistry.LILAC_PLANKS.get()).add(HoeBlocksRegistry.LEAFY_PLANKS.get())
        .add(HoeBlocksRegistry.LEAFY_STAIRS.get()).add(HoeBlocksRegistry.LILAC_STAIRS.get()).add(HoeBlocksRegistry.LEAFY_FENCE.get()).add(HoeBlocksRegistry.LILAC_FENCE.get())
        .add(HoeBlocksRegistry.LEAFY_FENCE_GATE.get()).add(HoeBlocksRegistry.LILAC_FENCE_GATE.get()).add(HoeBlocksRegistry.LEAFY_SLAB.get()).add(HoeBlocksRegistry.LILAC_SLAB.get())
        .add(HoeBlocksRegistry.LEAFY_PRESSURE_PLATE.get()).add(HoeBlocksRegistry.LILAC_PRESSURE_PLATE.get()).add(HoeBlocksRegistry.LEAFY_BUTTON.get())
        .add(HoeBlocksRegistry.LILAC_BUTTON.get()).add(HoeBlocksRegistry.LILAC_DOOR.get()).add(HoeBlocksRegistry.LEAFY_DOOR.get()).add(HoeBlocksRegistry.LILAC_TRAPDOOR.get())
        .add(HoeBlocksRegistry.LEAFY_TRAPDOOR.get()).add(HoeBlocksRegistry.PURPLE_CAMPFIRE.get());
    }
}