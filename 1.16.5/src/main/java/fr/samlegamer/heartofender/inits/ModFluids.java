package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.fluids.LavaGreenFluidProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
//import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids
{
	public static final ResourceLocation GREEN_LAVA_STILL_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_still");
	public static final ResourceLocation GREEN_LAVA_FLOW_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_flow");
	public static final ResourceLocation GREEN_LAVA_OVERLAY_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_overlay");

    public static final DeferredRegister<Fluid> FLUIDS_REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, HeartofEnder.MODID);
	
	public static final RegistryObject<FlowingFluid> GREEN_LAVA = FLUIDS_REGISTRY.register("green_lava", () -> new LavaGreenFluidProperties.Source(ModFluids.GREEN_LAVA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> GREEN_LAVA_FLOW = FLUIDS_REGISTRY.register("green_lava_flow", () -> new LavaGreenFluidProperties.Flowing(ModFluids.GREEN_LAVA_PROPERTIES));

	public static final LavaGreenFluidProperties.Properties GREEN_LAVA_PROPERTIES = new LavaGreenFluidProperties.Properties(() -> GREEN_LAVA.get(), () -> GREEN_LAVA_FLOW.get(), FluidAttributes.builder(GREEN_LAVA_STILL_RL, GREEN_LAVA_FLOW_RL).density(10).luminosity(25).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA).temperature(25).overlay(GREEN_LAVA_OVERLAY_RL)).bucket(() -> ModFluids.GREEN_LAVA_BUCKET.get()).block(() -> ModFluids.GREEN_LAVA_BLOCK.get());

	public static final RegistryObject<FlowingFluidBlock> GREEN_LAVA_BLOCK = ModBlocks.BLOCKS_REGISTRY.register("green_lava_block", () -> new FlowingFluidBlock(() -> ModFluids.GREEN_LAVA.get(), AbstractBlock.Properties.of(Material.LAVA).lightLevel((p_235468_0_) -> {return 30;}).randomTicks().noCollission().strength(100.0F).noDrops()));

	public static final RegistryObject<BucketItem> GREEN_LAVA_BUCKET = ModItems.ITEMS_REGISTRY.register("green_lava_bucket", () -> new BucketItem(() -> ModFluids.GREEN_LAVA.get(), new Item.Properties().tab(HeartofEnder.CREATIVE_TAB_ITEMS).stacksTo(1).craftRemainder(Items.BUCKET)));
}