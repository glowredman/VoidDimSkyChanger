package glowredman.voiddimskychanger;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.WorldProvider;
import zarkov.utilityworlds.UW_WorldProviderVoid;

public class SkyHandler {
    
    @SubscribeEvent
    public void onSkyRenderTick(ClientTickEvent event) {
        WorldClient world = FMLClientHandler.instance().getWorldClient();
        
        if(world == null) return;
        
        WorldProvider provider = world.provider;
        
        if(provider instanceof UW_WorldProviderVoid && !(provider.getSkyRenderer() instanceof SkyProviderUWVoid)) {
            provider.setSkyRenderer(new SkyProviderUWVoid());
        }
    }

}
