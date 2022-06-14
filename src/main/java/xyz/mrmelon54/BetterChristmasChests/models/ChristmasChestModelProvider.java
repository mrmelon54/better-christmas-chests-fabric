package xyz.mrmelon54.BetterChristmasChests.models;

import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import xyz.mrmelon54.BetterChristmasChests.client.BetterChristmasChestsClient;
import xyz.mrmelon54.BetterChristmasChests.utils.ChestBoatArray;

import java.util.Arrays;

public class ChristmasChestModelProvider implements UnclampedModelPredicateProvider {
    @Override
    public float unclampedCall(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity, int seed) {
        if (stack == null) return 0;
        if (stack.getItem() == Items.CHEST_MINECART)
            if (BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasMinecartWithChest())
                return 1;
        if (Arrays.stream(ChestBoatArray.ChestBoats).anyMatch(item -> stack.getItem() == item))
            if (BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasChestBoat())
                return 1;
        return 0;
    }
}
