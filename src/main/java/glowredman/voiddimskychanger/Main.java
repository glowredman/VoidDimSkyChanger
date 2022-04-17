package glowredman.voiddimskychanger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*",
    dependencies = "required-after:GalaxySpace@[1.1.12-GTNH,);required-after:utilityworlds",
    modid = "voiddimskychanger",
    name = "Void Dimension Sky Changer",
    version = "GRADLETOKEN_VERSION")
public class Main {
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new SkyHandler());
    }

}
