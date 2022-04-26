package glowredman.voiddimskychanger.mixins.value;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import glowredman.voiddimskychanger.ConfigHandler;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidDrawClouds extends WorldProvider {

    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(remap = false)
    public Vec3 drawClouds(float partialTicks) {
        return Vec3.createVectorHelper(ConfigHandler.cloudColor[0], ConfigHandler.cloudColor[1], ConfigHandler.cloudColor[2]);
    }
    
}
