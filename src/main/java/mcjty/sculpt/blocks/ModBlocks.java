package mcjty.sculpt.blocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    private static Sculptor sculptor;
    private static Sculpture sculpture;

    public static void init() {
        sculptor = new Sculptor();
        GameRegistry.registerBlock(sculptor, "sculptor");
        sculpture = new Sculpture();
        GameRegistry.registerBlock(sculpture, "sculpture");
    }
}
