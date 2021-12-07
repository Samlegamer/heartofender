package fr.samlegamer.heartofender.inits;

import fr.samlegamer.heartofender.core.HeartofEnder;
import fr.samlegamer.heartofender.world.biome.HeartofEnderSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSurfacesBuilders {

	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, HeartofEnder.MODID);

	public static final RegistryObject<HeartofEnderSurfaceBuilder> HEARTOFENDER = SURFACE_BUILDERS.register("heartofender", () -> new HeartofEnderSurfaceBuilder(SurfaceBuilderConfig.CODEC));

	public static RegistryObject<HeartofEnderSurfaceBuilder> getHeartofender() {
		return HEARTOFENDER;
	}
}
