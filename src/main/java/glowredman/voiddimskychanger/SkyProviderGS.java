package glowredman.voiddimskychanger;

import java.util.function.Supplier;

import galaxyspace.core.render.sky.SkyProviderBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.ResourceLocation;

public class SkyProviderGS extends SkyProviderBase {
    
    private Supplier<ResourceLocation> sunTexture;
    
    @Override
    protected void setup() {
        this.sunRGBA = ConfigHandler.sunRGBA;
        this.sunRadius = 0;
        this.innerFlareRadius = 0;
        this.outerFlareRadius = 0;
        if(ConfigHandler.sunTexture.isEmpty()) {
            sunTexture = () -> super.getSunTexture();
        } else {
            ResourceLocation rl = new ResourceLocation(ConfigHandler.sunTexture);
            sunTexture = () -> rl;
        }
    }
    
    @Override
    protected ResourceLocation getSunTexture() {
        return this.sunTexture.get();
    }
    
    public static class WithoutHorizon extends SkyProviderGS {
        
        @Override
        public void render(float partialTicks, WorldClient world, Minecraft mc) {
            this.renderDefaultWithoutSkyList2(partialTicks, world, mc);
        }
        
    }

}
