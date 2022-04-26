package glowredman.voiddimskychanger.mixins.superclass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidSunriseAndSunsetColor extends WorldProvider {
    
    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(aliases = "func_76560_a")
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return super.calcSunriseSunsetColors(celestialAngle, partialTicks);
    }

}
