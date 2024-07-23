package fr.samlegamer.heartofender.config;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.ConfigSpec;

import net.neoforged.neoforge.common.ModConfigSpec;

public class HoeConfigsRegistry
{
	public static final ModConfigSpec SERVER_CONFIG;

    public static final HoeServerConfig SERVER;

    static
    {
        {
            Pair<HoeServerConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(HoeServerConfig::new);
            SERVER = pair.getLeft();
            SERVER_CONFIG = pair.getRight();
        }
    }

}