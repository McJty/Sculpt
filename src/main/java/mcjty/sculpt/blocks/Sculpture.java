package mcjty.sculpt.blocks;

import mcjty.sculpt.Sculpt;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Sculpture extends Block implements ITileEntityProvider {

    public static int RENDERID_SCULPTURE;

    public Sculpture() {
        super(Material.iron);
        setBlockName("sculpture");
        setBlockTextureName(Sculpt.MODID + ":sculpture");
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
        return new SculptureTE();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return RENDERID_SCULPTURE;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }


}
