package net.onpointcoding.betterchristmaschests;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.onpointcoding.betterchristmaschests.config.ConfigStructure;
import net.onpointcoding.betterchristmaschests.models.ChristmasChestMinecartModelProvider;

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

    public static BetterChristmasChests getInstance() {
        return instance;
    }

    public ConfigStructure getConfig() {
        return config;
    }
}
