package fr.samlegamer.heartofender.fluids;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.fluids.LavaGreenFluidProperties.Flowing;
import fr.samlegamer.heartofender.fluids.LavaGreenFluidProperties.Source;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeFluidsRegistry
{
	public static final ResourceLocation GREEN_LAVA_STILL_RL = ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "blocks/green_lava_still");
	public static final ResourceLocation GREEN_LAVA_FLOW_RL = ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "blocks/green_lava_flow");
	public static final ResourceLocation GREEN_LAVA_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(HeartofEnder.MODID, "blocks/green_lava_overlay");

    public static final DeferredRegister<Fluid> REGISTRY_FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, HeartofEnder.MODID);
	
	public static final DeferredHolder<Fluid, Source> GREEN_LAVA = REGISTRY_FLUIDS.register("green_lava", () -> new LavaGreenFluidProperties.Source(HoeFluidsRegistry.GREEN_LAVA_PROPERTIES));
	public static final DeferredHolder<Fluid, Flowing> GREEN_LAVA_FLOW = REGISTRY_FLUIDS.register("green_lava_flow", () -> new LavaGreenFluidProperties.Flowing(HoeFluidsRegistry.GREEN_LAVA_PROPERTIES));

	public static final LavaGreenFluidProperties.Properties GREEN_LAVA_PROPERTIES = new LavaGreenFluidProperties.Properties(() -> GREEN_LAVA.get().getFluidType(), () -> GREEN_LAVA.get(), () -> GREEN_LAVA_FLOW.get());

	public static final DeferredBlock<Block> GREEN_LAVA_BLOCK = HoeBlocksRegistry.REGISTRY_BLOCKS.register("green_lava_block", () -> new LiquidBlock(HoeFluidsRegistry.GREEN_LAVA_FLOW.get(), BlockBehaviour.Properties.of().replaceable()
            .noCollission()
            .randomTicks()
            .strength(100.0F).lightLevel(p_50755_ -> 30)
            .pushReaction(PushReaction.DESTROY)
            .noLootTable()
            .liquid()
            .sound(SoundType.EMPTY)));

	public static final DeferredItem<BucketItem> GREEN_LAVA_BUCKET = HoeItemsRegistry.REGISTRY_ITEMS.register("green_lava_bucket", () -> new BucketItem(HoeFluidsRegistry.GREEN_LAVA.get(), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));//() -> , );

}