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
    public ChristmasChestsEnabled christmasModeEnabled = ChristmasChestsEnabled.AT_CHRISTMAS;

    // Enable horse types separately
    // The normal, zombie and skeleton variants of the Christmas horse chests can't be seen in vanilla
    public boolean christmasHorseEnabled;
    public boolean christmasZombieHorseEnabled;
    public boolean christmasDonkeyEnabled;

    // Enable chest types separately
    public boolean christmasChestEnabled;
    public boolean christmasTrappedChestEnabled;
    public boolean christmasEnderChestEnabled;

    // Enable minecart with chest type separately
    public boolean christmasMinecartWithChestEnabled;
}