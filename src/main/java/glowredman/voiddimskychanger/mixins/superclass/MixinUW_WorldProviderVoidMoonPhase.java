package glowredman.voiddimskychanger.mixins.superclass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidMoonPhase extends WorldProvider {
    
    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(aliases = "func_76559_b")
    public int getMoonPhase(long worldTime) {
        return super.getMoonPhase(worldTime);
    }

}
