package fr.samlegamer.heartofender.data.advancement;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class HoeAdvancementProvider extends AdvancementProvider
{
    public HoeAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, existingFileHelper, List.of(new HoeAdvancementGenerator()));
    }

    private static final class HoeAdvancementGenerator implements AdvancementProvider.AdvancementGenerator
    {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper)
        {
        	Advancement.Builder builder = Advancement.Builder.advancement();
        	//builder.build(ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "core/root"));
        	builder.display(new ItemStack(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK),
        	Component.translatable("titleadvancements.desc"), Component.translatable("description.firstadvancements"), 
        	ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "textures/block/dark_end_stone.png"), AdvancementType.GOAL, false, false, false);
        	builder.addCriterion("heart_ender_portal_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE));
        	builder.save(saver, ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "core/root"), existingFileHelper);


        }
    }
}