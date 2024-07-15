package fr.samlegamer.heartofender.fluids;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HoeFluidsRegistry
{
	public static final ResourceLocation GREEN_LAVA_STILL_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_still");
	public static final ResourceLocation GREEN_LAVA_FLOW_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_flow");
	public static final ResourceLocation GREEN_LAVA_OVERLAY_RL = new ResourceLocation(HeartofEnder.MODID, "blocks/green_lava_overlay");

    public static final DeferredRegister<Fluid> REGISTRY_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, HeartofEnder.MODID);
	
	public static final RegistryObject<FlowingFluid> GREEN_LAVA = REGISTRY_FLUIDS.register("green_lava", () -> new LavaGreenFluidProperties.Source(HoeFluidsRegistry.GREEN_LAVA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> GREEN_LAVA_FLOW = REGISTRY_FLUIDS.register("green_lava_flow", () -> new LavaGreenFluidProperties.Flowing(HoeFluidsRegistry.GREEN_LAVA_PROPERTIES));

	public static final LavaGreenFluidProperties.Properties GREEN_LAVA_PROPERTIES = new LavaGreenFluidProperties.Properties(() -> GREEN_LAVA.get(), () -> GREEN_LAVA_FLOW.get(), FluidAttributes.builder(GREEN_LAVA_STILL_RL, GREEN_LAVA_FLOW_RL).density(10).luminosity(25).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA).temperature(25).overlay(GREEN_LAVA_OVERLAY_RL)).bucket(() -> HoeFluidsRegistry.GREEN_LAVA_BUCKET.get()).block(() -> HoeFluidsRegistry.GREEN_LAVA_BLOCK.get());

	public static final RegistryObject<LiquidBlock> GREEN_LAVA_BLOCK = HoeBlocksRegistry.REGISTRY_BLOCKS.register("green_lava_block", () -> new LiquidBlock(() -> HoeFluidsRegistry.GREEN_LAVA.get(), BlockBehaviour.Properties.of(Material.LAVA).lightLevel((p_235468_0_) -> {return 30;}).randomTicks().strength(100.0F).noDrops()));

	public static final RegistryObject<BucketItem> GREEN_LAVA_BUCKET = HoeItemsRegistry.REGISTRY_ITEMS.register("green_lava_bucket", () -> new BucketItem(() -> HoeFluidsRegistry.GREEN_LAVA.get(), new Item.Properties().tab(HeartofEnder.TAB_ITEMS).stacksTo(1).craftRemainder(Items.BUCKET)));
}