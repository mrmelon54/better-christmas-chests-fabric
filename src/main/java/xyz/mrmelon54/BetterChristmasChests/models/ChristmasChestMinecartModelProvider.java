package xyz.mrmelon54.BetterChristmasChests.models;

import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import xyz.mrmelon54.BetterChristmasChests.client.BetterChristmasChestsClient;
import org.jetbrains.annotations.Nullable;

public class ChristmasChestMinecartModelProvider implements UnclampedModelPredicateProvider {
    @Override
    public float unclampedCall(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity, int seed) {
        if (stack != null && stack.getItem() == Items.CHEST_MINECART) {
            if (BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasMinecartWithChest())
                return 1;
        }
        return 0;
    }
}
