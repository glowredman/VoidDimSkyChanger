package glowredman.voiddimskychanger.mixins.value;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidSunBrightnessFactor extends WorldProvider {

    @Override
    public float getSunBrightnessFactor(float par1) {
        return super.getSunBrightnessFactor(par1);
    }
    
}
