package glowredman.voiddimskychanger.mixins.superclass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidDaytime extends WorldProvider {

    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(remap = false)
    public boolean isDaytime() {
        return super.isDaytime();
    }
    
}
