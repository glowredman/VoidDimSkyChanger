package glowredman.voiddimskychanger.mixins.value;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import glowredman.voiddimskychanger.ConfigHandler;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoidFogColor extends WorldProvider {

    /**
     * @author glowredman
     * @reason Use super method
     */
    @Overwrite(aliases = "func_76562_b")
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
        return Vec3.createVectorHelper(ConfigHandler.fogColor[0], ConfigHandler.fogColor[1], ConfigHandler.fogColor[2]);
    }
    
}
