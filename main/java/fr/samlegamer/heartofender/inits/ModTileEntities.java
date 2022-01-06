package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.tile.GreenCampfireTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities
{
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES_REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, HeartofEnder.MODID);
	
	public static final RegistryObject<TileEntityType<GreenCampfireTileEntity>> GREEN_CAMPFIRE_TILE = TILE_ENTITIES_REGISTRY.register("green_campfire", () -> TileEntityType.Builder.of(GreenCampfireTileEntity::new, ModBlocks.GREEN_CAMPFIRE.get()).build(null));
}