package kikugie.moarfps.config;

import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.TickBoxController;
import dev.isxander.yacl.gui.controllers.string.number.IntegerFieldController;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModConfig {
    private static ModConfig INSTANCE;
    public boolean enable = true;
    public int fakeFps = 1000;
    public boolean fluctuate = true;
    public int fluctuateAmount = 50;

    public static ModConfig getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new ModConfig();
        return INSTANCE;
    }

    public static void save() {
    }

    public Screen createGui(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.of("Moar FPS"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("config.moarfps.title"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.translatable("config.moarfps.option.enable"))
                                .binding(
                                        true,
                                        () -> enable,
                                        newValue -> this.enable = newValue
                                )
                                .controller(TickBoxController::new)
                                .build())
                        .option(Option.createBuilder(Integer.class)
                                .name(Text.translatable("config.moarfps.option.fakeFps"))
                                .binding(
                                        1000,
                                        () -> fakeFps,
                                        newValue -> this.fakeFps = newValue
                                )
                                .controller(IntegerFieldController::new)
                                .build())
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.translatable("config.moarfps.option.fluctuate"))
                                .binding(
                                        true,
                                        () -> fluctuate,
                                        newValue -> this.fluctuate = newValue
                                )
                                .controller(TickBoxController::new)
                                .build())
                        .option(Option.createBuilder(Integer.class)
                                .name(Text.translatable("config.moarfps.option.fluctuateAmount"))
                                .binding(
                                        50,
                                        () -> fluctuateAmount,
                                        newValue -> this.fluctuateAmount = newValue
                                )
                                .controller(IntegerFieldController::new)
                                .build())
                        .build())
                .save(ModConfig::save)
                .build()
                .generateScreen(parent);
    }
}
