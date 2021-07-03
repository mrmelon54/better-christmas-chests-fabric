package net.onpointcoding.betterchristmaschests.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.onpointcoding.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import svenhjol.charm.module.variant_chests.VariantChestBlockEntity;
import svenhjol.charm.module.variant_chests.VariantChestBlockEntityRenderer;
import svenhjol.charm.module.variant_chests.VariantTrappedChestBlockEntity;

import static net.minecraft.client.render.TexturedRenderLayers.*;

@Pseudo
@Environment(value = EnvType.CLIENT)
@Mixin(value = VariantChestBlockEntityRenderer.class, remap = false)
public class MixinCharmVariantChestBlockEntityRenderer {
    private static final SpriteIdentifier CHRISTMAS_TRAPPED = getChristmasChestTextureId("trapped_christmas");
    private static final SpriteIdentifier CHRISTMAS_TRAPPED_LEFT = getChristmasChestTextureId("trapped_christmas_left");
    private static final SpriteIdentifier CHRISTMAS_TRAPPED_RIGHT = getChristmasChestTextureId("trapped_christmas_right");

    private static SpriteIdentifier getChristmasChestTextureId(String variant) {
        return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier("betterchristmaschests:entity/chest/" + variant));
    }

    @Inject(method = "getMaterial", at = @At("HEAD"), cancellable = true)
    private static void overrideMaterialTextures(BlockEntity blockEntity, ChestType chestType, CallbackInfoReturnable<SpriteIdentifier> cir) {
        if (!(blockEntity instanceof VariantChestBlockEntity))
            cir.setReturnValue(null);

        BetterChristmasChests betterChristmasChests = BetterChristmasChests.getInstance();
        if (betterChristmasChests.isChristmas() && betterChristmasChests.enableCharmPresents())
            if (blockEntity instanceof VariantTrappedChestBlockEntity) cir.setReturnValue(switch (chestType) {
                case SINGLE -> CHRISTMAS_TRAPPED;
                case LEFT -> CHRISTMAS_TRAPPED_LEFT;
                case RIGHT -> CHRISTMAS_TRAPPED_RIGHT;
            });
            else cir.setReturnValue(switch (chestType) {
                case SINGLE -> CHRISTMAS;
                case LEFT -> CHRISTMAS_LEFT;
                case RIGHT -> CHRISTMAS_RIGHT;
            });
    }
}
