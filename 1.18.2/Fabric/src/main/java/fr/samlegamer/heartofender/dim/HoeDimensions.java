package fr.samlegamer.heartofender.dim;

import fr.samlegamer.heartofender.HeartofEnder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class HoeDimensions
{
	public static final RegistryKey<World> HEART_OF_ENDER = RegistryKey.of(Registry.WORLD_KEY, new Identifier(HeartofEnder.MODID, "heartofender"));
}