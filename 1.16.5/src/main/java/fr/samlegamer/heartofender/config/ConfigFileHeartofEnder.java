package fr.samlegamer.heartofender.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigFileHeartofEnder
{
	public static final ForgeConfigSpec SERVER_CONFIG;

    public static final ServerConfig SERVER;

    static
    {
        {
            final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
            SERVER = specPair.getLeft();
            SERVER_CONFIG = specPair.getRight();
        }
    }
}