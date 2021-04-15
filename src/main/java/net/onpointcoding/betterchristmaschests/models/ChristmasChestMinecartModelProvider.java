package net.onpointcoding.betterchristmaschests.models;

import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;

public class ChristmasChestMinecartModelProvider implements ModelPredicateProvider {
    @Override
    public float call(ItemStack stack, ClientWorld world, LivingEntity entity) {
        if (stack != null && stack.getItem() == Items.CHEST_MINECART) {
            if (BetterChristmasChests.getInstance().isChristmas() && BetterChristmasChests.getInstance().enableChristmasMinecartWithChest())
                return 1;
        }
        return 0;
    }
}
