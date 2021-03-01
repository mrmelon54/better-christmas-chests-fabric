package net.onpointcoding.betterchristmaschests.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import net.onpointcoding.betterchristmaschests.enums.ChristmasChestsEnabled;

@SuppressWarnings("unused")
@Config(name = "betterchristmaschests")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public
class ConfigStructure implements ConfigData {
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public ChristmasChestsEnabled christmasChestsEnabled = ChristmasChestsEnabled.AT_CHRISTMAS;
}