package org.avp.block;

import java.util.Random;

import org.avp.tile.TileEntityAmpule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockAmpule extends Block
{
    public BlockAmpule()
    {
        super(Material.iron);
        this.setLightOpacity(2);
        float size = 0.3F;
        this.setBlockBounds(size, 0.0F, size, 1.0F - size, 1F, 1.0F - size);
    }
    
    @Override
    public void registerIcons(IIconRegister reg)
    {
    	return;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public void updateTick(World world, int posX, int posY, int posZ, Random random)
    {
        super.updateTick(world, posX, posY, posZ, random);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityAmpule();
    }

    @Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase placer, ItemStack itemstack)
    {
        TileEntity tile = world.getTileEntity(posX, posY, posZ);

        if (tile != null && tile instanceof TileEntityAmpule && placer != null)
        {
            TileEntityAmpule ampule = (TileEntityAmpule) tile;
            ampule.setDirection(getFacing(placer));
        }
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockaccess, int posX, int posY, int posZ, int side)
    {
        return false;
    }

    public static EnumFacing getFacing(Entity entity)
    {
        int dir = MathHelper.floor_double((entity.rotationYaw / 90) + 0.5) & 3;
        return EnumFacing.VALID_DIRECTIONS[Direction.directionToFacing[dir]];
    }
}
