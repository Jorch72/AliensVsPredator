package org.avp.item;

import java.util.List;

import org.avp.entities.EntityGrenade;

import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;
import com.arisux.mdx.lib.world.item.HookedItem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGrenade extends HookedItem
{
    private boolean isFlaming;

    public ItemGrenade(boolean isFlaming)
    {
        super();
        this.maxStackSize = 16;
        this.isFlaming = isFlaming;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (!world.isRemote)
        {
            EntityGrenade grenade = new EntityGrenade(world, player);
            grenade.setFlaming(this.isFlaming);
            world.spawnEntity(grenade);
            Inventories.consumeItem(player, this);
        }
        
        return super.onItemRightClick(world, player, hand);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Right click to throw (explodes)");
    }
}
