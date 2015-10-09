package mcjty.sculpt.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {

//    private Configuration mainConfig;

    public void preInit(FMLPreInitializationEvent e) {
//        mainConfig = Sculpt.config;
//        readMainConfig();

//        ModItems.init();
//        ModBlocks.init();
//        ModCrafting.init();
//
//        PacketHandler.registerMessages("gearswapper");
    }

//    private void readMainConfig() {
//        Configuration cfg = mainConfig;
//        try {
//            cfg.load();
//            cfg.addCustomCategoryComment(Config.CATEGORY_GEARSWAP, "General configuration");
//            cfg.addCustomCategoryComment(Config.CATEGORY_RULES, "Rules that help decide if two items are considered equal. Every rule contains a list of tags that have to match");
//            Config.init(cfg);
//        } catch (Exception e1) {
//            GearSwap.logger.log(Level.ERROR, "Problem loading config file!", e1);
//        } finally {
//            if (mainConfig.hasChanged()) {
//                mainConfig.save();
//            }
//        }
//    }
//
    public void init(FMLInitializationEvent e) {
//        NetworkRegistry.INSTANCE.registerGuiHandler(Sculpt.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
//        if (mainConfig.hasChanged()) {
//            mainConfig.save();
//        }
//        mainConfig = null;
    }

}
