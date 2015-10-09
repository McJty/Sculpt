package mcjty.sculpt;

import cpw.mods.fml.client.registry.RenderingRegistry;
import mcjty.sculpt.blocks.Sculpture;
import mcjty.sculpt.blocks.SculptureISBRH;

public final class ModRenderers {

    public static void init() {
        Sculpture.RENDERID_SCULPTURE = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(Sculpture.RENDERID_SCULPTURE, new SculptureISBRH());
    }
}
