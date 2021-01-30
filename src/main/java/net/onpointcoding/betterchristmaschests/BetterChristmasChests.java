package net.onpointcoding.betterchristmaschests;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.onpointcoding.betterchristmaschests.config.ConfigStructure;

public class BetterChristmasChests implements ModInitializer {
    private static BetterChristmasChests instance;
    private ConfigStructure config;

    @Override
    public void onInitialize() {
        instance = this;

        AutoConfig.register(ConfigStructure.class, JanksonConfigSerializer::new);

        config = AutoConfig.getConfigHolder(ConfigStructure.class).getConfig();
    }

    public static BetterChristmasChests getInstance() {
        return instance;
    }

    public ConfigStructure getConfig() {
        return config;
    }
}
