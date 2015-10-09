package mcjty.sculpt;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mcjty.sculpt.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = Sculpt.MODID, name="Sculpt", dependencies =
        "required-after:Forge@["+ Sculpt.MIN_FORGE_VER+",)",
        version = Sculpt.VERSION)
public class Sculpt {
    public static final String MODID = "sculpt";
    public static final String VERSION = "0.1.0";
    public static final String MIN_FORGE_VER = "10.13.2.1291";

    @SidedProxy(clientSide="mcjty.sculpt.proxy.ClientProxy", serverSide="mcjty.sculpt.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance("gearswap")
    public static Sculpt instance;
    public static Logger logger;
//    public static File mainConfigDir;
//    public static File modConfigDir;
//    public static Configuration config;

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and
     * register them with the GameRegistry.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
//        mainConfigDir = e.getModConfigurationDirectory();
//        modConfigDir = new File(mainConfigDir.getPath());
//        config = new Configuration(new File(modConfigDir, "sculpt.cfg"));
        proxy.preInit(e);

//        FMLInterModComms.sendMessage("Waila", "register", "mcjty.gearswap.WailaSupport.load");
    }

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
