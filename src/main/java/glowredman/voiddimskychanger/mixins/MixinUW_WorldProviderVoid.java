package glowredman.voiddimskychanger.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import glowredman.voiddimskychanger.ConfigHandler;
import glowredman.voiddimskychanger.MixinPlugin;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;
import zarkov.utilityworlds.UW_WorldProviderVoid;

@Mixin(UW_WorldProviderVoid.class)
public abstract class MixinUW_WorldProviderVoid extends WorldProvider {
    
    @Inject(at = @At("RETURN"), method = "<init>()V", remap = false)
    private void hasNoSky(CallbackInfo ci) {
        this.hasNoSky = ConfigHandler.hasNoSky;
    }
    
    /**
     * Returns {@code true} if in the "main surface world", but {@code false} if in the Nether or End dimensions.
     * @author glowredman
     * @reason make this property configurable
     */
    @Overwrite(aliases = "func_76569_d")
    public boolean isSurfaceWorld() {
        return ConfigHandler.surfaceWorld;
    }
    
    /**
     * @author glowredman
     * @reason make this property configurable
     */
    @Overwrite(aliases = "func_76561_g")
    public boolean isSkyColored() {
        return ConfigHandler.skyColored;
    }
    
    /**
     * @author glowredman
     * @reason make this property configurable
     */
    @Overwrite(remap = false)
    public IRenderHandler getCloudRenderer() {
        return MixinPlugin.cloudRenderer;
    }
    
    /**
     * @author glowredman
     * @reason make this property configurable
     */
    @Overwrite(remap = false)
    public IRenderHandler getWeatherRenderer() {
        return MixinPlugin.weatherRenderer;
    }
    
    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     * @param x the X coordinate
     * @param z the Z coordinate
     */
    @Override
    public boolean doesXZShowFog(int x, int z) {
        return ConfigHandler.XZShowFog;
    }
    
    @Override
    public IRenderHandler getSkyRenderer() {
        return MixinPlugin.skyRenderer;
    }

}
