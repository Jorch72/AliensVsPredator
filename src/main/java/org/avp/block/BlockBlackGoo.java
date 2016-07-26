package org.avp.block;

import org.avp.AliensVsPredator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockBlackGoo extends BlockFluidClassic
{
    public BlockBlackGoo()
    {
        super(AliensVsPredator.fluids().fluidBlackGoo, AliensVsPredator.materials().blackgoo);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return AliensVsPredator.resources().ICONSET_BLACK_GOO.getIconForSide(side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        AliensVsPredator.resources().ICONSET_BLACK_GOO.registerIcons(register);
        AliensVsPredator.fluids().fluidBlackGoo.setIcons(AliensVsPredator.resources().ICONSET_BLACK_GOO.getIconForSide(1), AliensVsPredator.resources().ICONSET_BLACK_GOO.getIconForSide(2));
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }

        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }

        return super.displaceIfPossible(world, x, y, z);
    }
}
