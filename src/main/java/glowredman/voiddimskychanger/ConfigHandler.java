package glowredman.voiddimskychanger;

import java.io.File;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

    // use superclass methods?
    public static boolean getMoonPhase, calcSunriseSunsetColors, getFogColor, getCloudHeight, getWorldHasVoidParticles,
            getVoidFogYFactor, isDaytime, getSunBrightnessFactor, getSunBrightness, getSkyColor, drawClouds,
            getStarBrightness, getWorldTime, getHorizon;

    // values
    public static boolean hasNoSky, surfaceWorld, skyColored, voidParticles, daytime, XZShowFog;
    public static double voidFogYFactor, horizon, sunRadius, innerFlareRadius, outerFlareRadius;
    public static double[] fogColor, skyColor, cloudColor;
    public static float cloudHeight, sunBrightnessFactor, sunBrightness, starBrightness;
    public static float[] sunriseAndSunsetColor = new float[4], sunRGBA = new float[4];
    public static int moonPhase;
    public static long worldTime;
    public static String skyRenderer, cloudRenderer, weatherRenderer, sunTexture;

    private static final String VALUES = "values", METHODS = "method_switches", SKY = "sky_provider";

    public static void init() {
        Configuration config = new Configuration(new File(Launch.minecraftHome, "config/" + MixinPlugin.MODID + ".cfg"));

        config.load();
        
        config.setCategoryComment(SKY, "Define your own sky renderer based on GalaxySpace's SkyProviderBase. To use this, set skyRenderer=glowredman.voiddimskychanger.SkyProviderGS or skyRenderer=glowredman.voiddimskychanger.SkyProviderGS$WithoutHorizon");
        
        getMoonPhase = config.getBoolean("getMoonPhase", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        calcSunriseSunsetColors = config.getBoolean("calcSunriseSunsetColors", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getFogColor = config.getBoolean("getFogColor", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getCloudHeight = config.getBoolean("getCloudHeight", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getWorldHasVoidParticles = config.getBoolean("getWorldHasVoidParticles", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getVoidFogYFactor = config.getBoolean("getVoidFogYFactor", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        isDaytime = config.getBoolean("isDaytime", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getSunBrightnessFactor = config.getBoolean("getSunBrightnessFactor", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getSunBrightness = config.getBoolean("getSunBrightness", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getSkyColor = config.getBoolean("getSkyColor", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        drawClouds = config.getBoolean("drawClouds", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getStarBrightness = config.getBoolean("getStarBrightness", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getWorldTime = config.getBoolean("getWorldTime", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");
        getHorizon = config.getBoolean("getHorizon", METHODS, false, "Set to 'true' to use the default methods in WorldProvider");

        hasNoSky = config.getBoolean("hasNoSky", VALUES, false, "A boolean that tells if a world does not have a sky. Used in calculating weather and skylight");
        surfaceWorld = config.getBoolean("surfaceWorld", VALUES, true, "What 'isSurfaceWorld()' should return");
        skyColored = config.getBoolean("skyColored", VALUES, true, "What 'isSkyColored()' should return");
        voidParticles = config.getBoolean("voidParticles", VALUES, false, "What 'getWorldHasVoidParticles()' should return (ignored if getWorldHasVoidParticles is set to true)");
        daytime = config.getBoolean("daytime", VALUES, true, "What 'isDaytime()' should return (ignored if isDaytime is set to true)");
        XZShowFog = config.getBoolean("XZShowFog", VALUES, false, "What 'doesXZShowFog()' should return");
        voidFogYFactor = config.get(VALUES, "voidFogYFactor", 0.0, "What 'getVoidFogYFactor()' should return (ignored if getVoidFogYFactor is set to true) [range: 0.0 ~ 1.0, default: 0.0]", 0.0, 1.0).getDouble();
        horizon = config.get(VALUES, "horizon", 0.0, "What 'getHorizon()' should return (ignored if getHorizon is set to true) [range: " + -Double.MAX_VALUE + " ~ " + Double.MAX_VALUE + ", default: 0.0]", -Double.MAX_VALUE, Double.MAX_VALUE).getDouble();
        fogColor = config.get(VALUES, "fogColor", new double[3], "What 'getFogColor()' should return (ignored if getFogColor is set to true) [range: 0.0 ~ 1.0, default: [0.0, 0.0, 0.0]]", 0.0, 1.0, true, 3).getDoubleList();
        skyColor = config.get(VALUES, "skyColor", new double[3], "What 'getSkyColor()' should return (ignored if getSkyColor is set to true) [range: 0.0 ~ 1.0, default: [0.0, 0.0, 0.0]]", 0.0, 1.0, true, 3).getDoubleList();
        cloudColor = config.get(VALUES, "cloudColor", new double[3], "What 'drawClouds()' should return (ignored if drawClouds is set to true) [range: 0.0 ~ 1.0, default: [0.0, 0.0, 0.0]]", 0.0, 1.0, true, 3).getDoubleList();
        cloudHeight = config.getFloat("cloudHeight", VALUES, 128.0f, -Float.MAX_VALUE, Float.MAX_VALUE, "What 'getCloudHeight()' should return (ignored if getCloudHeight is set to true)");
        sunBrightnessFactor = config.getFloat("sunBrightnessFactor", VALUES, 1.0f, 0.0f, 1.0f, "What 'sunBrightnessFactor()' should return (ignored if getSunBrightnessFactor is set to true)");
        sunBrightness = config.getFloat("sunBrightness", VALUES, 1.0f, 0.0f, 1.0f, "What 'getSunBrightness()' should return (ignored if getSunBrightness is set to true)");
        starBrightness = config.getFloat("starBrightness", VALUES, 0.5f, 0.0f, 1.0f, "What 'getStarBrightness()' should return (ignored if getStarBrightness is set to true)");
        double[] d = config.get(VALUES, "sunriseAndSunsetColor", new double [4], "What 'calcSunriseSunsetColors()' should return (ignored if calcSunriseSunsetColors is set to true) [range: 0.0 ~ 1.0, default: [0.0, 0.0, 0.0, 0.0]]", 0.0, 1.0, true, 4).getDoubleList();
        for(int i = 0; i < d.length; i++) {sunriseAndSunsetColor[i] = (float) d[i];}
        moonPhase = config.getInt("moonPhase", VALUES, 0, 0, 8, "What 'getMoonPhase()' should return (ignored if getMoonPhase is set to true)");
        worldTime = Math.round(config.get(VALUES, "worldTime", 6000.0, "What 'getWorldTime()' should return (ignored if getWorldTime is set to true) [range: 0 ~ " + Long.MAX_VALUE + ", default: 6000]", 0, Long.MAX_VALUE).getDouble());
        skyRenderer = config.getString("skyProviderClass", VALUES, "", "The sky renderer's fully qualified class name. The sky provider must have a public constructor with no parameters. Leave empty to use the default renderer.");
        cloudRenderer = config.getString("cloudRenderer", VALUES, "zarkov.utilityworlds.UW_CloudRenderer", "The cloud renderer's fully qualified class name. The sky provider must have a public constructor with no parameters. Leave empty to use the default renderer.");
        weatherRenderer = config.getString("weatherRenderer", VALUES, "zarkov.utilityworlds.UW_CloudRenderer", "The weather renderer's fully qualified class name. The sky provider must have a public constructor with no parameters. Leave empty to use the default renderer.");

        double[] d2 = config.get(SKY, "sunRGBA", new double [] {1.0, 0.7607843, 0.7058824, 0.3}, "Sun color as Red, Green, Blue, Alpha [range: 0.0 ~ 1.0, default: [1.0, 0.7607843, 0.7058824, 0.3]]", 0.0, 1.0, true, 4).getDoubleList();
        for(int i = 0; i < d2.length; i++) {sunRGBA[i] = (float) d2[i];}
        sunRadius = config.get(SKY, "sunRadius", 10.5, "The radius of the sunTexture [range: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE + ", default: 10.5]", Double.MIN_VALUE, Double.MAX_VALUE).getDouble();
        innerFlareRadius = Math.max(sunRadius, config.get(SKY, "innerFlareRadius", 20.0, "Must be larger than sunRadius [range: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE + ", default: 20.0]", Double.MIN_VALUE, Double.MAX_VALUE).getDouble());
        outerFlareRadius = Math.max(innerFlareRadius, config.get(SKY, "outerFlareRadius", 40.0, "Must be larger than innerFlareRadius [range: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE + ", default: 40.0]", Double.MIN_VALUE, Double.MAX_VALUE).getDouble());
        sunTexture = config.getString("sunTexture", SKY, "", "Leave empty to use the vanilla sun texture, otherwise specify a resource location to provide a texture.");
        
        if (config.hasChanged()) {
            config.save();
        }
    }

}
