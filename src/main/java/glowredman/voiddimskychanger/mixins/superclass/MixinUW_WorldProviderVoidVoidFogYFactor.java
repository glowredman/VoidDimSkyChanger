package glowredman.voiddimskychanger.mixins.superclass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidVoidFogYFactor extends WorldProvider {

    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(aliases = "func_76565_k")
    public double getVoidFogYFactor() {
        return super.getVoidFogYFactor();
    }
    
}
