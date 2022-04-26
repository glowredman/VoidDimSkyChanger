package glowredman.voiddimskychanger.mixins.value;

import org.spongepowered.asm.mixin.Mixin;

import glowredman.voiddimskychanger.ConfigHandler;
import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidCloudHeight extends WorldProvider {

    @Override
    public float getCloudHeight() {
        return ConfigHandler.cloudHeight;
    }
    
}
