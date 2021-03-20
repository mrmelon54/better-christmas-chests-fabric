package net.onpointcoding.betterchristmaschests.enums;

public enum ChristmasChestsEnabled {
    ALWAYS("Always"),
    AT_CHRISTMAS("At Christmas"),
    NEVER("Never");

    private final String name;

    ChristmasChestsEnabled(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
