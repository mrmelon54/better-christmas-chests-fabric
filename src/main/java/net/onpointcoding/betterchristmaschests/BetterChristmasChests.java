package net.onpointcoding.betterchristmaschests;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.onpointcoding.betterchristmaschests.config.ConfigStructure;
import net.onpointcoding.betterchristmaschests.enums.ChristmasChestsEnabled;
import net.onpointcoding.betterchristmaschests.models.ChristmasChestMinecartModelProvider;

import java.util.Calendar;

public class BetterChristmasChests implements ModInitializer {
    private static BetterChristmasChests instance;
    private ConfigStructure config;

    @Override
    public void onInitialize() {
        instance = this;

        AutoConfig.register(ConfigStructure.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ConfigStructure.class).getConfig();

        ChristmasChestMinecartModelProvider christmasChestMinecartModelProvider = new ChristmasChestMinecartModelProvider();
        FabricModelPredicateProviderRegistry.register(Items.CHEST_MINECART, new Identifier("christmas_chest_minecart"), christmasChestMinecartModelProvider);
    }

    public boolean isChristmasDates() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DATE) >= 24 && calendar.get(Calendar.DATE) <= 26);
    }

    public boolean isChristmas() {
        ConfigStructure config = getConfig();
        return config.christmasModeEnabled == ChristmasChestsEnabled.ALWAYS || (config.christmasModeEnabled == ChristmasChestsEnabled.AT_CHRISTMAS && isChristmasDates());
    }

    public boolean enableCharmPresents() {
        return getConfig().charmPresentsEnabled;
    }

    public boolean enableChristmasChest() {
        return getConfig().christmasChestEnabled;
    }

    public boolean enableChristmasTrappedChest() {
        return getConfig().christmasTrappedChestEnabled;
    }

    public boolean enableChristmasEnderChest() {
        return getConfig().christmasEnderChestEnabled;
    }

    public boolean enableChristmasMinecartWithChest() {
        return getConfig().christmasMinecartWithChestEnabled;
    }

    public boolean enableChristmasDonkey() {
        return getConfig().christmasDonkeyEnabled;
    }

    public boolean enableChristmasHorse() {
        return getConfig().christmasHorseEnabled;
    }

    public boolean enableChristmasZombieHorse() {
        return getConfig().christmasZombieHorseEnabled;
    }

    public static BetterChristmasChests getInstance() {
        return instance;
    }

    public ConfigStructure getConfig() {
        return config;
    }
}
