package xyz.mrmelon54.BetterChristmasChests.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.mrmelon54.BetterChristmasChests.client.BetterChristmasChestsClient;

@Mixin(BoatEntityRenderer.class)
public abstract class MixinBoatEntityRenderer {
    @Redirect(method = "render(Lnet/minecraft/entity/vehicle/BoatEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "INVOKE", target = "Lcom/mojang/datafixers/util/Pair;getFirst()Ljava/lang/Object;"))
    private Object injectedRender(Pair<Identifier, BoatEntityModel> instance) {
        Identifier first = instance.getFirst();
        String p = first.getPath();
        int i = p.lastIndexOf('/');
        if (p.contains("chest_boat/") && BetterChristmasChestsClient.getInstance().isChristmas() && BetterChristmasChestsClient.getInstance().enableChristmasChestBoat())
            return new Identifier("better-christmas-chests", "textures/entity/chest_boat/christmas_" + p.substring(i + 1));
        return first;
    }
}
