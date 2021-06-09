package net.onpointcoding.betterchristmaschests.models;

import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import org.jetbrains.annotations.Nullable;

public class ChristmasChestMinecartModelProvider implements UnclampedModelPredicateProvider {
    @Override
    public float unclampedCall(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity, int seed) {
        if (stack != null && stack.getItem() == Items.CHEST_MINECART) {
            if (BetterChristmasChests.getInstance().isChristmas() && BetterChristmasChests.getInstance().enableChristmasMinecartWithChest())
                return 1;
        }
        return 0;
    }
}
