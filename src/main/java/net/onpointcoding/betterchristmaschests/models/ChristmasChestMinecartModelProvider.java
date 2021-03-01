package net.onpointcoding.betterchristmaschests.models;

import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import net.onpointcoding.betterchristmaschests.config.ConfigStructure;
import net.onpointcoding.betterchristmaschests.enums.ChristmasChestsEnabled;

import java.util.Calendar;

public class ChristmasChestMinecartModelProvider implements ModelPredicateProvider {
    @Override
    public float call(ItemStack stack, ClientWorld world, LivingEntity entity) {
        if (stack != null && stack.getItem() == Items.CHEST_MINECART) {
            Calendar calendar = Calendar.getInstance();
            boolean christmasDate = (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && calendar.get(Calendar.DATE) >= 24 && calendar.get(Calendar.DATE) <= 26);

            BetterChristmasChests instance = BetterChristmasChests.getInstance();
            ConfigStructure config = instance.getConfig();
            boolean christmas = config.christmasChestsEnabled == ChristmasChestsEnabled.ALWAYS || (config.christmasChestsEnabled == ChristmasChestsEnabled.AT_CHRISTMAS && christmasDate);

            if (stack.getItem() == Items.CHEST_MINECART && christmas) return 1;
        }
        return 0;
    }
}
