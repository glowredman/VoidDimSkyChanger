package glowredman.voiddimskychanger;

import galaxyspace.BarnardsSystem.planets.barnardaC.dimension.sky.SkyProviderBarnardaC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

public class SkyProviderUWVoid extends SkyProviderBarnardaC {
    
    @Override
    protected void renderCelestialBodies(float partialTicks, WorldClient world, Minecraft mc) {
        // this is not *actually* Barnarda C, so don't render it's texture at the bottom of the skybox
    }

}
