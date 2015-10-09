package mcjty.sculpt.blocks;

import mcjty.sculpt.Sculpt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Sculptor extends Block {

    public Sculptor() {
        super(Material.iron);
        setBlockName("sculptor");
        setBlockTextureName(Sculpt.MODID + ":sculptor");
        setHardness(2.0f);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
