package net.onpointcoding.betterchristmaschests.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "betterchristmaschests")
public
class ConfigStructure implements ConfigData {
    public ChristmasChestsEnabled christmasChestsEnabled = ChristmasChestsEnabled.AT_CHRISTMAS;
}