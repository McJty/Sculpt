package mcjty.sculpt.blocks;

import mcjty.sculpt.Sculpt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Sculpture extends Block {

    public Sculpture() {
        super(Material.iron);
        setBlockName("sculpture");
        setBlockTextureName(Sculpt.MODID + ":sculpture");
        setHardness(2.0f);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
