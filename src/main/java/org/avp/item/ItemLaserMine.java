package org.avp.item;

import java.util.List;

import org.avp.entities.EntityLaserMine;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLaserMine extends Item
{
    @Override
    public EnumActionResult onItemUse( EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        byte metaValue = (byte) (facing.ordinal() == 5 ? 3 : facing.ordinal() == 4 ? 1 : facing.ordinal() == 3 ? 2 : 0);

        EntityLaserMine entity = new EntityLaserMine(world, pos, metaValue, player.getUniqueID().toString());

        if (!world.isRemote && entity.canStay())
        {
            player.getActiveItemStack().shrink(1);
            world.spawnEntity(entity);
            return EnumActionResult.SUCCESS;
        }
        
        return EnumActionResult.FAIL;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Right click to place on wall (Explodes when entities pass through laser)");
    }
}
