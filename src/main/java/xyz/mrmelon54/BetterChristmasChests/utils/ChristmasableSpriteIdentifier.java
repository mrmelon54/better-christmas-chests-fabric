package xyz.mrmelon54.BetterChristmasChests.utils;

import net.minecraft.client.util.SpriteIdentifier;

public class ChristmasableSpriteIdentifier {
    private final SpriteIdentifier normal;
    private final SpriteIdentifier christmas;
    private final boolean featureEnabled;

    public ChristmasableSpriteIdentifier(SpriteIdentifier normal, SpriteIdentifier christmas, boolean featureEnabled) {
        this.normal = normal;
        this.christmas = christmas;
        this.featureEnabled = featureEnabled;
    }

    public SpriteIdentifier getNormal() {
        return normal;
    }

    public SpriteIdentifier getChristmas() {
        return christmas;
    }

    public boolean isFeatureEnabled() {
        return featureEnabled;
    }
}
