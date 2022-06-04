package xyz.mrmelon54.BetterChristmasChests.mixin;

import net.minecraft.client.render.entity.DonkeyEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.mrmelon54.BetterChristmasChests.client.BetterChristmasChestsClient;

import java.util.HashMap;
import java.util.Map;

// Donkeys and mules can have chests attached to them

@Mixin(DonkeyEntityRenderer.class)
public class MixinDonkeyEntityRenderer {
    // A map for Christmas textures for each horse type
    private static final Map<EntityType<?>, Identifier> CHRISTMAS_TEXTURES = Util.make(new HashMap<>(), hashMap -> {
        hashMap.put(EntityType.DONKEY, new Identifier("better-christmas-chests:textures/entity/horse/christmas_donkey.png"));
        hashMap.put(EntityType.MULE, new Identifier("better-christmas-chests:textures/entity/horse/christmas_mule.png"));
    });

    @Inject(at = @At("HEAD"), method = "getTexture*", cancellable = true)
    public void getTexture(AbstractDonkeyEntity abstractDonkeyEntity, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if (BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasDonkey())
            callbackInfoReturnable.setReturnValue(CHRISTMAS_TEXTURES.get(abstractDonkeyEntity.getType()));
    }
}
