package kikugie.moarfps.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.gui.ConfigScreenProvider;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigScreenProvider<ModConfig> supplier = (ConfigScreenProvider<ModConfig>) AutoConfig.getConfigScreen(ModConfig.class, parent);
            return supplier.get();
        };
    }
}
