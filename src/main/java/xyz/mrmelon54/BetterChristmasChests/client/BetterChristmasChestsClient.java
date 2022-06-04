package xyz.mrmelon54.BetterChristmasChests.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import xyz.mrmelon54.BetterChristmasChests.config.ConfigStructure;
import xyz.mrmelon54.BetterChristmasChests.enums.ChristmasChestsEnabled;
import xyz.mrmelon54.BetterChristmasChests.models.ChristmasChestMinecartModelProvider;

import java.util.Calendar;

public class BetterChristmasChestsClient implements ClientModInitializer {
    private static BetterChristmasChestsClient instance;
    private ConfigStructure config;

    @Override
    public void onInitializeClient() {
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

    public static BetterChristmasChestsClient getInstance() {
        return instance;
    }

    public ConfigStructure getConfig() {
        return config;
    }
}
