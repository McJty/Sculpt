package mcjty.sculpt.blocks;

import mcjty.sculpt.Sculpt;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Sculptor extends Block implements ITileEntityProvider {

    public Sculptor() {
        super(Material.iron);
        setBlockName("sculptor");
        setBlockTextureName(Sculpt.MODID + ":sculptor");
        setHardness(2.0f);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new SculptorTE();
    }


}
