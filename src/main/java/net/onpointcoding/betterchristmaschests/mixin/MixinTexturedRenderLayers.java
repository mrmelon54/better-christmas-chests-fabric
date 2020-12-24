package net.onpointcoding.betterchristmaschests.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

import static net.minecraft.client.render.TexturedRenderLayers.CHEST_ATLAS_TEXTURE;

@Mixin(TexturedRenderLayers.class)
public abstract class MixinTexturedRenderLayers {
    private static final SpriteIdentifier ENDER_CHRISTMAS;
    private static final SpriteIdentifier TRAPPED_CHRISTMAS;
    private static final SpriteIdentifier TRAPPED_CHRISTMAS_LEFT;
    private static final SpriteIdentifier TRAPPED_CHRISTMAS_RIGHT;

    static {
        ENDER_CHRISTMAS = getChristmasChestTextureId("ender_christmas");
        TRAPPED_CHRISTMAS = getChristmasChestTextureId("trapped_christmas");
        TRAPPED_CHRISTMAS_LEFT = getChristmasChestTextureId("trapped_christmas_left");
        TRAPPED_CHRISTMAS_RIGHT = getChristmasChestTextureId("trapped_christmas_right");
    }

    private static SpriteIdentifier getChristmasChestTextureId(String variant) {
        return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier("betterchristmaschests:entity/chest/" + variant));
    }

    @Inject(at = @At("RETURN"), method = "addDefaultTextures")
    private static void addDefaultTextures(Consumer<SpriteIdentifier> adder, CallbackInfo info) {
        adder.accept(ENDER_CHRISTMAS);
        adder.accept(TRAPPED_CHRISTMAS);
        adder.accept(TRAPPED_CHRISTMAS_LEFT);
        adder.accept(TRAPPED_CHRISTMAS_RIGHT);
    }

    @Inject(at = @At("HEAD"), method = "getChestTexture(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", cancellable = true)
    private static void getChestTexture(BlockEntity blockEntity, ChestType type, boolean christmas, CallbackInfoReturnable<SpriteIdentifier> info) {
        if (christmas) {
            if (blockEntity instanceof TrappedChestBlockEntity) {
                SpriteIdentifier trapped_christmas_chest;
                switch (type) {
                    case LEFT:
                        trapped_christmas_chest = TRAPPED_CHRISTMAS_LEFT;
                        break;
                    case RIGHT:
                        trapped_christmas_chest = TRAPPED_CHRISTMAS_RIGHT;
                        break;
                    case SINGLE:
                    default:
                        trapped_christmas_chest = TRAPPED_CHRISTMAS;
                        break;
                }
                info.setReturnValue(trapped_christmas_chest);
            } else if (blockEntity instanceof EnderChestBlockEntity) {
                info.setReturnValue(ENDER_CHRISTMAS);
            }
        }
    }
}
