package net.onpointcoding.betterchristmaschests.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.ZombieHorseEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.util.Identifier;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

// Well zombie and skeleton horses can't actually have chests equipped but I added it anyway incase a mod enables it

@Mixin(ZombieHorseEntityRenderer.class)
public class MixinZombieHorseEntityRenderer {
    // A map for Christmas textures for each horse type
    private static final Map<EntityType<?>, Identifier> CHRISTMAS_TEXTURES = Maps.newHashMap(ImmutableMap.of(EntityType.ZOMBIE_HORSE, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_zombie.png"), EntityType.SKELETON_HORSE, new Identifier("betterchristmaschests:textures/entity/horse/christmas_horse_skeleton.png")));

    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
    public void getTexture(HorseBaseEntity horseBaseEntity, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if (BetterChristmasChests.getInstance().isChristmas() && BetterChristmasChests.getInstance().enableChristmasZombieHorse())
            callbackInfoReturnable.setReturnValue(CHRISTMAS_TEXTURES.get(horseBaseEntity.getType()));
    }
}
