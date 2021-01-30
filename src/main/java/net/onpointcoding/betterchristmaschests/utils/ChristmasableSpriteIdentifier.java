package net.onpointcoding.betterchristmaschests.utils;

import net.minecraft.client.util.SpriteIdentifier;

public class ChristmasableSpriteIdentifier {
    private final SpriteIdentifier normal;
    private final SpriteIdentifier christmas;

    public ChristmasableSpriteIdentifier(SpriteIdentifier normal, SpriteIdentifier christmas) {
        this.normal = normal;
        this.christmas = christmas;
    }

    public SpriteIdentifier getNormal() {
        return normal;
    }

    public SpriteIdentifier getChristmas() {
        return christmas;
    }
}
