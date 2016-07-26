package org.avp.items;

import com.arisux.airi.lib.ItemTypes.HookedItem;
import com.arisux.airi.lib.WorldUtil;
import com.arisux.airi.lib.WorldUtil.Blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIngotLithium extends HookedItem
{
	public boolean isDepleting = true;
	public int depletionTicks = 20 * 60;

	public ItemIngotLithium()
	{
		this.setMaxDurability(20 * 60);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World worldObj, Entity entity, int slot, boolean selected)
	{
		super.onUpdate(itemstack, worldObj, entity, slot, selected);

		this.setDamage(itemstack, itemstack.getCurrentDurability() + 1);

		if (itemstack.getCurrentDurability() >= itemstack.getMaxDurability())
		{
			WorldUtil.createExplosion(entity, worldObj, new Blocks.CoordData(entity), 1F, true, true, true);
			WorldUtil.Entities.Players.Inventories.consumeItem((EntityPlayer) entity, this, true);
		}
	}
}
