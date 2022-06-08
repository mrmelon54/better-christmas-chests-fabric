package xyz.mrmelon54.BetterChristmasChests.mixin;

import net.minecraft.client.render.entity.ZombieHorseEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.mrmelon54.BetterChristmasChests.client.BetterChristmasChestsClient;

import java.util.HashMap;
import java.util.Map;

// Well zombie and skeleton horses can't actually have chests equipped but I added it anyway incase a mod enables it

@Mixin(ZombieHorseEntityRenderer.class)
public class MixinZombieHorseEntityRenderer {
    // A map for Christmas textures for each horse type
    private static final Map<EntityType<?>, Identifier> CHRISTMAS_TEXTURES = Util.make(new HashMap<>(), hashMap -> {
        hashMap.put(EntityType.ZOMBIE_HORSE, new Identifier("better-christmas-chests:textures/entity/horse/christmas_horse_zombie.png"));
        hashMap.put(EntityType.SKELETON_HORSE, new Identifier("better-christmas-chests:textures/entity/horse/christmas_horse_skeleton.png"));
    });

    @Inject(at = @At("HEAD"), method = "getTexture*", cancellable = true)
    public void getTexture(AbstractHorseEntity horseBaseEntity, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if (BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasZombieHorse())
            callbackInfoReturnable.setReturnValue(CHRISTMAS_TEXTURES.get(horseBaseEntity.getType()));
    }
}
