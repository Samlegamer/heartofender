package fr.samlegamer.heartofender.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class HoeConfigsRegistry
{
	public static final ForgeConfigSpec SERVER_CONFIG;

    public static final HoeServerConfig SERVER;

    static
    {
        {
            final Pair<HoeServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(HoeServerConfig::new);
            SERVER = specPair.getLeft();
            SERVER_CONFIG = specPair.getRight();
        }
    }

}