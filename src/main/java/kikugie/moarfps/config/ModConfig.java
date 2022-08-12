package kikugie.moarfps.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

@Config(name = "moarfps")
public class ModConfig implements ConfigData {

    public boolean enable = true;
    public int fakeFps = 1000;
    public boolean fluctuate = true;
    public int fluctuateAmount = 50;

    @ConfigEntry.Gui.Excluded
    private static ModConfig INSTANCE;

    public static void init() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static ModConfig getInstance() {
        if (INSTANCE == null) {
            init();
        }
        return INSTANCE;
    }


}

