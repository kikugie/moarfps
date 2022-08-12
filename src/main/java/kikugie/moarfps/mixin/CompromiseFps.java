package kikugie.moarfps.mixin;

import kikugie.moarfps.config.ModConfig;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MinecraftClient.class)
public class CompromiseFps {
    @Shadow
    private int fpsCounter;

    @ModifyVariable(
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;fpsCounter:I"),
            method = "render(Z)V",
            index = 1,
            argsOnly = true
    )
    private boolean modifyFpsCounter(boolean value) {
        if (!ModConfig.getInstance().enable) {
            return false;
        }
        this.fpsCounter = ModConfig.getInstance().fakeFps;
        if (ModConfig.getInstance().fluctuate) {
            this.fpsCounter += (int) (Math.random() * ModConfig.getInstance().fluctuateAmount * 2) - ModConfig.getInstance().fluctuateAmount;
        }
        return true;
    }
}