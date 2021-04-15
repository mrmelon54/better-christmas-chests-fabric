package net.onpointcoding.betterchristmaschests.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.DonkeyEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.util.Identifier;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

// Donkeys and mules can have chests attached to them

@Mixin(DonkeyEntityRenderer.class)
public class MixinDonkeyEntityRenderer {
    // A map for Christmas textures for each horse type
    private static final Map<EntityType<?>, Identifier> CHRISTMAS_TEXTURES = Maps.newHashMap(ImmutableMap.of(EntityType.DONKEY, new Identifier("betterchristmaschests:textures/entity/horse/christmas_donkey.png"), EntityType.MULE, new Identifier("betterchristmaschests:textures/entity/horse/christmas_mule.png")));

    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
    public void getTexture(AbstractDonkeyEntity abstractDonkeyEntity, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if (BetterChristmasChests.getInstance().isChristmas() && BetterChristmasChests.getInstance().enableChristmasDonkey())
            callbackInfoReturnable.setReturnValue(CHRISTMAS_TEXTURES.get(abstractDonkeyEntity.getType()));
    }
}
