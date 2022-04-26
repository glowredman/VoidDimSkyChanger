package glowredman.voiddimskychanger;

public enum Mixins {
    GENERAL("MixinUW_WorldProviderVoid", true, "General mixins applied."),
    
    DAYTIME_SC("superclass.MixinUW_WorldProviderVoidDaytime", ConfigHandler.isDaytime, "'isDaytime' mixin applied."),
    CLOUDS_SC("superclass.MixinUW_WorldProviderVoidDrawClouds", ConfigHandler.drawClouds, "'drawClouds' mixin applied."),
    FOG_SC("superclass.MixinUW_WorldProviderVoidFogColor", ConfigHandler.getFogColor, "'getFogColor' mixin applied."),
    HORIZON_SC("superclass.MixinUW_WorldProviderVoidHorizon", ConfigHandler.getHorizon, "'getHorizon' mixin applied."),
    MOON_SC("superclass.MixinUW_WorldProviderVoidMoonPhase", ConfigHandler.getMoonPhase, "'getMoonPhase' mixin applied."),
    SKY_SC("superclass.MixinUW_WorldProviderVoidSkyColor", ConfigHandler.getSkyColor, "'getSkyColor' mixin applied."),
    STARS_SC("superclass.MixinUW_WorldProviderVoidStarBrightness", ConfigHandler.getStarBrightness, "'getStarBrightness' mixin applied."),
    SUN_SC("superclass.MixinUW_WorldProviderVoidSunriseAndSunsetColor", ConfigHandler.calcSunriseSunsetColors, "'calcSunriseSunsetColors' mixin applied."),
    VOIDFOG_SC("superclass.MixinUW_WorldProviderVoidVoidFogYFactor", ConfigHandler.getVoidFogYFactor, "'getVoidFogYFactor' mixin applied."),
    VOIDPARTICLES_SC("superclass.MixinUW_WorldProviderVoidWorldHasVoidParticles", ConfigHandler.getWorldHasVoidParticles, "'getWorldHasVoidParticles' mixin applied."),
    TIME_SC("superclass.MixinUW_WorldProviderVoidWorldTime", ConfigHandler.getWorldTime, "'getWorldTime' mixin applied."),
    
    CLOUDHEIGHT_V("value.MixinUW_WorldProviderVoidCloudHeight", !ConfigHandler.getCloudHeight, "'getCloudHeight' mixin applied."),
    DAYTIME_V("value.MixinUW_WorldProviderVoidDaytime", !ConfigHandler.isDaytime, "'isDaytime' mixin applied."),
    CLOUDS_V("value.MixinUW_WorldProviderVoidDrawClouds", !ConfigHandler.drawClouds, "'drawClouds' mixin applied."),
    FOG_V("value.MixinUW_WorldProviderVoidFogColor", !ConfigHandler.getFogColor, "'getFogColor' mixin applied."),
    HORIZON_V("value.MixinUW_WorldProviderVoidHorizon", !ConfigHandler.getHorizon, "'getHorizon' mixin applied."),
    MOON_V("value.MixinUW_WorldProviderVoidMoonPhase", !ConfigHandler.getMoonPhase, "'getMoonPhase' mixin applied."),
    SKY_V("value.MixinUW_WorldProviderVoidSkyColor", !ConfigHandler.getSkyColor, "'getSkyColor' mixin applied."),
    STARS_V("value.MixinUW_WorldProviderVoidStarBrightness", !ConfigHandler.getStarBrightness, "'getStarBrightness' mixin applied."),
    SUNBRIGHTNESS_V("value.MixinUW_WorldProviderVoidSunBrightness", !ConfigHandler.getSunBrightness, "'getSunBrightness' mixin applied."),
    SUNBRIGHTNESSFACTOR_V("value.MixinUW_WorldProviderVoidSunBrightnessFactor", !ConfigHandler.getSunBrightnessFactor, "'getSunBrightnessFactor' mixin applied."),
    SUN_V("value.MixinUW_WorldProviderVoidSunriseAndSunsetColor", !ConfigHandler.calcSunriseSunsetColors, "'calcSunriseSunsetColors' mixin applied."),
    VOIDFOG_V("value.MixinUW_WorldProviderVoidVoidFogYFactor", !ConfigHandler.getVoidFogYFactor, "'getVoidFogYFactor' mixin applied."),
    VOIDPARTICLES_V("value.MixinUW_WorldProviderVoidWorldHasVoidParticles", !ConfigHandler.getWorldHasVoidParticles, "'getWorldHasVoidParticles' mixin applied."),
    TIME_V("value.MixinUW_WorldProviderVoidWorldTime", !ConfigHandler.getWorldTime, "'getWorldTime' mixin applied.");
    
    public final String mixinClass;
    public final boolean shouldLoad;
    public final String message;
    
    private Mixins(String mixinClass, boolean shouldLoad, String message) {
        this.mixinClass = mixinClass;
        this.shouldLoad = shouldLoad;
        this.message = message;
    }

}
