package fr.samlegamer.heartofender.utils.tab;

import fr.samlegamer.heartofender.block.HoeBlocksRegistry;
import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.fluids.HoeFluidsRegistry;
import fr.samlegamer.heartofender.item.HoeItemsRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeTabs
{
	public static final DeferredRegister<CreativeModeTab> REGISTRY_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HeartofEnder.MODID);
	
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS = REGISTRY_TABS.register("heartofender_items", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.heartofender.heartofender_items")).icon(()-> new ItemStack(HoeItemsRegistry.DIAMOND_APPLE.get())).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS = REGISTRY_TABS.register("heartofender_blocks", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.heartofender.heartofender_blocks")).icon(()-> new ItemStack(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get())).build());
    
	public static void addToTab(BuildCreativeModeTabContentsEvent event)
    {
		if (event.getTab() == HoeTabs.ITEMS.get())
		{
			event.accept(HoeItemsRegistry.DEAD_EYE.get());
			event.accept(HoeItemsRegistry.HEART_ENDER_PORTAL_PIECE.get());
			event.accept(HoeItemsRegistry.AZURIUM_INGOT.get());
			event.accept(HoeItemsRegistry.AZURIUM_NUGGET.get());
			event.accept(HoeItemsRegistry.BLACK_ROD.get());
			event.accept(HoeItemsRegistry.FLINT_AND_AZURIUM.get());
			//event.accept(HoeItemsRegistry.GREEN_TORCH_ITEM.get());
			//event.accept(HoeItemsRegistry.HEART_ENDER_WART_ITEM.get());
			event.accept(HoeItemsRegistry.DIAMOND_APPLE.get());
			event.accept(HoeItemsRegistry.IRON_APPLE.get());
			event.accept(HoeItemsRegistry.LAPIS_APPLE.get());
			event.accept(HoeItemsRegistry.REDSTONE_APPLE.get());
			event.accept(HoeItemsRegistry.PURPLE_GLOWSTONE_DUST.get());
			event.accept(HoeFluidsRegistry.GREEN_LAVA_BUCKET.get());
			event.accept(HoeItemsRegistry.MILATHIUM.get());
			event.accept(HoeItemsRegistry.MILATHIUM_INGOT.get());
			event.accept(HoeItemsRegistry.BLUE_MAGMA_CREAM.get());
			event.accept(HoeItemsRegistry.HEART_BONE.get());
			event.accept(HoeItemsRegistry.GREEN_FIRE_CHARGE.get());
			event.accept(HoeItemsRegistry.FLINT_AND_MILATHIUM.get());
			event.accept(HoeItemsRegistry.AZURIUM_HELMET.get());
			event.accept(HoeItemsRegistry.AZURIUM_CHESTPLATE.get());
			event.accept(HoeItemsRegistry.AZURIUM_LEGGINGS.get());
			event.accept(HoeItemsRegistry.AZURIUM_BOOTS.get());
			event.accept(HoeItemsRegistry.MILATHIUM_HELMET.get());
			event.accept(HoeItemsRegistry.MILATHIUM_CHESTPLATE.get());
			event.accept(HoeItemsRegistry.MILATHIUM_LEGGINGS.get());
			event.accept(HoeItemsRegistry.MILATHIUM_BOOTS.get());
			event.accept(HoeItemsRegistry.AZURIUM_SWORD.get());
			event.accept(HoeItemsRegistry.AZURIUM_PICKAXE.get());
			event.accept(HoeItemsRegistry.AZURIUM_AXE.get());
			event.accept(HoeItemsRegistry.AZURIUM_SHOVEL.get());
			event.accept(HoeItemsRegistry.MILATHIUM_SWORD.get());
			event.accept(HoeItemsRegistry.MILATHIUM_PICKAXE.get());
			event.accept(HoeItemsRegistry.MILATHIUM_AXE.get());
			event.accept(HoeItemsRegistry.MILATHIUM_SHOVEL.get());
			event.accept(HoeItemsRegistry.HEART_BONE_SWORD.get());
			event.accept(HoeItemsRegistry.ENDER_KID_EGG_SPAWN.get());
			event.accept(HoeItemsRegistry.HEART_BLAZE_EGG_SPAWN.get());
			event.accept(HoeItemsRegistry.HEART_GHAST_EGG_SPAWN.get());
			event.accept(HoeItemsRegistry.BLUE_MAGMA_CUBE_EGG_SPAWN.get());
			event.accept(HoeItemsRegistry.HEART_SKELETON_EGG_SPAWN.get());
		}
		
		if (event.getTab() == HoeTabs.BLOCKS.get())
		{
			event.accept(HoeBlocksRegistry.HEART_ENDER_PORTAL_BLOCK.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK_STAIRS.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_STAIRS.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_FENCE.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK_FENCE.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_SLAB.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK_SLAB.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_PRESSURE_PLATE.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK_PRESSURE_PLATE.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BUTTON.get());
			event.accept(HoeBlocksRegistry.DARK_END_STONE_BRICK_BUTTON.get());
			event.accept(HoeBlocksRegistry.PURPLE_GLOWSTONE.get());
			event.accept(HoeBlocksRegistry.BLUE_MAGMA_BLOCK.get());
			event.accept(HoeBlocksRegistry.DEAD_SOUL_SAND.get());
			event.accept(HoeBlocksRegistry.DEAD_SOUL_SOIL.get());
			event.accept(HoeBlocksRegistry.GREEN_LANTERN.get());
			event.accept(HoeBlocksRegistry.GREEN_CAMPFIRE.get());
			event.accept(HoeBlocksRegistry.AZURIUM_ORE.get());
			event.accept(HoeBlocksRegistry.DEEPSLATE_AZURIUM_ORE.get());
			event.accept(HoeBlocksRegistry.AZURIUM_BLOCK.get());
			event.accept(HoeBlocksRegistry.MILATHIUM_ORE.get());
			event.accept(HoeBlocksRegistry.MILATHIUM_BLOCK.get());
			event.accept(HoeBlocksRegistry.HEROBRINE_HEAD.get());
			event.accept(HoeBlocksRegistry.LILAC_STEM.get());
			event.accept(HoeBlocksRegistry.LEAFY_STEM.get());
			event.accept(HoeBlocksRegistry.STRIPPED_LILAC_STEM.get());
			event.accept(HoeBlocksRegistry.STRIPPED_LEAFY_STEM.get());
			event.accept(HoeBlocksRegistry.LILAC_HYPHAE.get());
			event.accept(HoeBlocksRegistry.LEAFY_HYPHAE.get());
			event.accept(HoeBlocksRegistry.STRIPPED_LILAC_HYPHAE.get());
			event.accept(HoeBlocksRegistry.STRIPPED_LEAFY_HYPHAE.get());
			event.accept(HoeBlocksRegistry.LILAC_WART_BLOCK.get());
			event.accept(HoeBlocksRegistry.LEAFY_WART_BLOCK.get());
			event.accept(HoeBlocksRegistry.LILAC_PLANKS.get());
			event.accept(HoeBlocksRegistry.LEAFY_PLANKS.get());
			event.accept(HoeBlocksRegistry.LILAC_STAIRS.get());
			event.accept(HoeBlocksRegistry.LEAFY_STAIRS.get());
			event.accept(HoeBlocksRegistry.LILAC_FENCE.get());
			event.accept(HoeBlocksRegistry.LEAFY_FENCE.get());
			event.accept(HoeBlocksRegistry.LILAC_FENCE_GATE.get());
			event.accept(HoeBlocksRegistry.LEAFY_FENCE_GATE.get());
			event.accept(HoeBlocksRegistry.LILAC_SLAB.get());
			event.accept(HoeBlocksRegistry.LEAFY_SLAB.get());
			event.accept(HoeBlocksRegistry.LILAC_PRESSURE_PLATE.get());
			event.accept(HoeBlocksRegistry.LEAFY_PRESSURE_PLATE.get());
			event.accept(HoeBlocksRegistry.LILAC_BUTTON.get());
			event.accept(HoeBlocksRegistry.LEAFY_BUTTON.get());
			event.accept(HoeBlocksRegistry.LILAC_DOOR.get());
			event.accept(HoeBlocksRegistry.LEAFY_DOOR.get());
			event.accept(HoeBlocksRegistry.LILAC_TRAPDOOR.get());
			event.accept(HoeBlocksRegistry.LEAFY_TRAPDOOR.get());
			event.accept(HoeBlocksRegistry.LILAC_NYLIUM.get());
			event.accept(HoeBlocksRegistry.LEAFY_NYLIUM.get());
			//event.accept(HoeBlocksRegistry.LEAFY_FUNGUS.get());
			event.accept(HoeBlocksRegistry.LEAFY_ROOTS.get());
			event.accept(HoeBlocksRegistry.HEART_OF_ENDER_SPROUTS.get());
			//event.accept(HoeBlocksRegistry.LILAC_FUNGUS.get());
			event.accept(HoeBlocksRegistry.LILAC_WEEPING_VINES.get());
			event.accept(HoeBlocksRegistry.LEAFY_TWISTING_VINES.get());
			event.accept(HoeBlocksRegistry.LILAC_ROOTS.get());
			event.accept(HoeBlocksRegistry.SOUL_SHROOMLIGHT.get());
			event.accept(HoeBlocksRegistry.LILAC_SHROOMLIGHT.get());
			event.accept(HoeBlocksRegistry.PURPLE_LANTERN.get());
			event.accept(HoeBlocksRegistry.PURPLE_CAMPFIRE.get());
		}
	}
}
