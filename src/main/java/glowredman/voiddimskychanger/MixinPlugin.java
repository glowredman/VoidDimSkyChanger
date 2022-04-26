package glowredman.voiddimskychanger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.client.IRenderHandler;
import ru.timeconqueror.spongemixins.MinecraftURLClassPath;

public class MixinPlugin implements IMixinConfigPlugin {
    
    public static final String MODID = "voiddimskychanger";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static IRenderHandler skyRenderer, cloudRenderer, weatherRenderer;

    @Override
    public void onLoad(String mixinPackage) {
        ConfigHandler.init();
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        if(((boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment") && MinecraftURLClassPath.findJarInClassPath("utilityworlds")) || loadUW()) {
            LOGGER.info("Found Utility Worlds!");
        }
        
        List<String> mixins = new ArrayList<>();
        for(Mixins mixin : Mixins.values()) {
            if(mixin.shouldLoad) {
                mixins.add(mixin.mixinClass);
                LOGGER.info(mixin.message);
            }
        }
        return mixins;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if(mixinInfo.getName().equals("MixinUW_WorldProviderVoid")) {
            skyRenderer = getRenderer(ConfigHandler.skyRenderer, "sky");
            cloudRenderer = getRenderer(ConfigHandler.cloudRenderer, "cloud");
            weatherRenderer = getRenderer(ConfigHandler.weatherRenderer, "weather");
        }
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    
    private IRenderHandler getRenderer(String clazz, String rendererName) {
        if(!clazz.isEmpty()) {
            try {
                IRenderHandler renderer = (IRenderHandler) Class.forName(clazz).getConstructor().newInstance();
                LOGGER.info("Applied " + clazz + " as " + rendererName + " renderer.");
                return renderer;
            } catch (Exception e) {
                LOGGER.error("Failed to apply " + clazz + " as " + rendererName + " renderer!");
                e.printStackTrace();
            }
        } else {
            LOGGER.info("Applied default " + rendererName + " renderer.");
        }
        return null;
    }
    
    private boolean loadUW() {
        try {
            File jar = MinecraftURLClassPath.getJarInModPath("utilityworlds");
            if(jar == null) {
                LOGGER.error("Could not find the Utility Worlds jar!");
                return false;
            }
            LOGGER.info("Attempting to add " + jar + " to the URL Class Path");
            if(!jar.exists()) {
                throw new FileNotFoundException(jar.toString());
            }
            MinecraftURLClassPath.addJar(jar);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
