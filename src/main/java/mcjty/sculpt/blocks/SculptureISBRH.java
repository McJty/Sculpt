package mcjty.sculpt.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class SculptureISBRH implements ISimpleBlockRenderingHandler {
    public boolean enableAO;

    /**
     * Red color value for the top left corner
     */
    public float colorRedTopLeft;
    /**
     * Red color value for the bottom left corner
     */
    public float colorRedBottomLeft;
    /**
     * Red color value for the bottom right corner
     */
    public float colorRedBottomRight;
    /**
     * Red color value for the top right corner
     */
    public float colorRedTopRight;
    /**
     * Green color value for the top left corner
     */
    public float colorGreenTopLeft;
    /**
     * Green color value for the bottom left corner
     */
    public float colorGreenBottomLeft;
    /**
     * Green color value for the bottom right corner
     */
    public float colorGreenBottomRight;
    /**
     * Green color value for the top right corner
     */
    public float colorGreenTopRight;
    /**
     * Blue color value for the top left corner
     */
    public float colorBlueTopLeft;
    /**
     * Blue color value for the bottom left corner
     */
    public float colorBlueBottomLeft;
    /**
     * Blue color value for the bottom right corner
     */
    public float colorBlueBottomRight;
    /**
     * Blue color value for the top right corner
     */
    public float colorBlueTopRight;
    /**
     * Brightness top left
     */
    public int brightnessTopLeft;
    /**
     * Brightness bottom left
     */
    public int brightnessBottomLeft;
    /**
     * Brightness bottom right
     */
    public int brightnessBottomRight;
    /**
     * Brightness top right
     */
    public int brightnessTopRight;

    @Override
    public int getRenderId() {
        return Sculpture.RENDERID_SCULPTURE;
    }

    protected void drawInventoryBlock(Block block, int meta, RenderBlocks renderer) {
        Tessellator t = Tessellator.instance;

        t.startDrawingQuads();
        t.setNormal(-1, 0, 0);
        renderer.renderFaceXNeg(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.WEST.ordinal(), meta));
        t.draw();

        t.startDrawingQuads();
        t.setNormal(1, 0, 0);
        renderer.renderFaceXPos(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.EAST.ordinal(), meta));
        t.draw();

        t.startDrawingQuads();
        t.setNormal(0, 0, -1);
        renderer.renderFaceZNeg(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.NORTH.ordinal(), meta));
        t.draw();

        t.startDrawingQuads();
        t.setNormal(0, 0, 1);
        renderer.renderFaceZPos(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.SOUTH.ordinal(), meta));
        t.draw();

        t.startDrawingQuads();
        t.setNormal(0, -1, 0);
        renderer.renderFaceYNeg(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.DOWN.ordinal(), meta));
        t.draw();

        t.startDrawingQuads();
        t.setNormal(0, 1, 0);
        renderer.renderFaceYPos(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.UP.ordinal(), meta));
        t.draw();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        drawInventoryBlock(block, metadata, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int meta = 0;
//        if (world != null) {
//            meta = world.getBlockMetadata(x, y, z);
//        }
//        ForgeDirection k = ForgeDirection.getOrientation(meta & 7);

        Tessellator t = Tessellator.instance;

        t.startDrawingQuads();
        t.setNormal(-1, 0, 0);
        renderer.renderFaceXNeg(block, 0, 0, 0, renderer.getBlockIconFromSideAndMetadata(block, ForgeDirection.WEST.ordinal(), meta));
        t.draw();

        boolean rc = renderer.renderStandardBlock(block, x, y, z);
        return rc;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }


    public void renderFaceYNeg(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(0.0 * 16.0D);
        double d6 = icon.getInterpolatedV(1.0 * 16.0D);

        double d11 = x + 0.0;
        double d12 = x + 1.0;
        double d13 = y + 0.0;
        double d14 = z + 0.0;
        double d15 = z + 1.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d12, d13, d14, d4, d5);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
        } else {
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.addVertexWithUV(d12, d13, d14, d4, d5);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
        }
    }

    public void renderFaceYPos(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(0.0 * 16.0D);
        double d6 = icon.getInterpolatedV(1.0 * 16.0D);

        double d11 = x + 0.0;
        double d12 = x + 1.0;
        double d13 = y + 1.0;
        double d14 = z + 0.0;
        double d15 = z + 1.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d12, d13, d14, d4, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
        } else {
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.addVertexWithUV(d12, d13, d14, d4, d5);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
        }
    }

    public void renderFaceZNeg(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(16.0D - 1.0 * 16.0D);
        double d6 = icon.getInterpolatedV(16.0D - 0.0 * 16.0D);

        double d11 = x + 0.0;
        double d12 = x + 1.0;
        double d13 = y + 0.0;
        double d14 = y + 1.0;
        double d15 = z + 0.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d14, d15, d4, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d12, d13, d15, d3, d6);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
        } else {
            tessellator.addVertexWithUV(d11, d14, d15, d4, d5);
            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
            tessellator.addVertexWithUV(d12, d13, d15, d3, d6);
            tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
        }
    }

    public void renderFaceZPos(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(16.0D - 1.0 * 16.0D);
        double d6 = icon.getInterpolatedV(16.0D - 0.0 * 16.0D);

        double d11 = x + 0.0;
        double d12 = x + 1.0;
        double d13 = y + 0.0;
        double d14 = y + 1.0;
        double d15 = z + 1.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d14, d15, d3, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d12, d14, d15, d4, d5);
        } else {
            tessellator.addVertexWithUV(d11, d14, d15, d3, d5);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d6);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.addVertexWithUV(d12, d14, d15, d4, d5);
        }
    }

    public void renderFaceXNeg(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(16.0D - 1.0 * 16.0D);
        double d6 = icon.getInterpolatedV(16.0D - 0.0 * 16.0D);

        double d11 = x + 0.0;
        double d12 = y + 0.0;
        double d13 = y + 1.0;
        double d14 = z + 0.0;
        double d15 = z + 1.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d13, d15, d4, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d12, d14, d3, d6);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d12, d15, d4, d6);
        } else {
            tessellator.addVertexWithUV(d11, d13, d15, d4, d5);
            tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
            tessellator.addVertexWithUV(d11, d12, d14, d3, d6);
            tessellator.addVertexWithUV(d11, d12, d15, d4, d6);
        }
    }

    public void renderFaceXPos(double x, double y, double z, IIcon icon) {
        Tessellator tessellator = Tessellator.instance;

        double d3 = icon.getInterpolatedU(0.0 * 16.0D);
        double d4 = icon.getInterpolatedU(1.0 * 16.0D);
        double d5 = icon.getInterpolatedV(16.0D - 1.0 * 16.0D);
        double d6 = icon.getInterpolatedV(16.0D - 0.0 * 16.0D);

        double d11 = x + 1.0;
        double d12 = y + 0.0;
        double d13 = y + 1.0;
        double d14 = z + 0.0;
        double d15 = z + 1.0;

        if (this.enableAO) {
            tessellator.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            tessellator.setBrightness(this.brightnessTopLeft);
            tessellator.addVertexWithUV(d11, d12, d15, d3, d6);
            tessellator.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            tessellator.setBrightness(this.brightnessBottomLeft);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            tessellator.setBrightness(this.brightnessBottomRight);
            tessellator.addVertexWithUV(d11, d13, d14, d4, d5);
            tessellator.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            tessellator.setBrightness(this.brightnessTopRight);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        } else {
            tessellator.addVertexWithUV(d11, d12, d15, d3, d6);
            tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
            tessellator.addVertexWithUV(d11, d13, d14, d4, d5);
            tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
        }
    }

}
