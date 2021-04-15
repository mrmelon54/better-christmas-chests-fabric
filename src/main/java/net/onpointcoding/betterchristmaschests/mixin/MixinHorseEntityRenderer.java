package net.onpointcoding.betterchristmaschests.mixin;

import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.HorseEntityRenderer;
import net.minecraft.entity.passive.HorseColor;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

// Well horses can't actually have chests equipped but I added it anyway incase a mod enables it

@Mixin(HorseEntityRenderer.class)
public class MixinHorseEntityRenderer {
    // A map for Christmas textures for each horse color
    private static final Map<HorseColor, Identifier> CHRISTMAS_TEXTURES = Util.make(Maps.newEnumMap(HorseColor.class), (enumMap) -> {
        enumMap.put(HorseColor.WHITE, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_white.png"));
        enumMap.put(HorseColor.CREAMY, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_creamy.png"));
        enumMap.put(HorseColor.CHESTNUT, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_chestnut.png"));
        enumMap.put(HorseColor.BROWN, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_brown.png"));
        enumMap.put(HorseColor.BLACK, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_black.png"));
        enumMap.put(HorseColor.GRAY, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_gray.png"));
        enumMap.put(HorseColor.DARKBROWN, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_darkbrown.png"));
    });

    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
    public void getTexture(HorseEntity horseEntity, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if (BetterChristmasChests.getInstance().isChristmas() && BetterChristmasChests.getInstance().enableChristmasHorse())
            callbackInfoReturnable.setReturnValue(CHRISTMAS_TEXTURES.get(horseEntity.getColor()));
    }
}
