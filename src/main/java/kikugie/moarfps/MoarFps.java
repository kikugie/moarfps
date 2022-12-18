package kikugie.moarfps;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoarFps implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("moarfps");

    @Override
    public void onInitialize() {
        LOGGER.info("Giving you more fps!");
    }
}
