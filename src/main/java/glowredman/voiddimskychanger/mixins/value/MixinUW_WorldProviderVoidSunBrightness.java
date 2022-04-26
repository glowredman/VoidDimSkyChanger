package glowredman.voiddimskychanger.mixins.value;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidSunBrightness extends WorldProvider {

    @Override
    public float getSunBrightness(float par1) {
        return super.getSunBrightness(par1);
    }
    
}
