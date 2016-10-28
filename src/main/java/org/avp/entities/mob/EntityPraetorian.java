package org.avp.entities.mob;

import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.Sounds;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPraetorian extends EntityXenomorph
{
    public EntityPraetorian(World world)
    {
        super(world);
        this.experienceValue = 300;
        this.setSize(1.0F, 3.0F);
        this.getNavigator().setCanSwim(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1F);
    }

    @Override
    protected void dropRareDrop(int par1)
    {
        if (new Random().nextInt(4) == 1)
            this.entityDropItem(new ItemStack(AliensVsPredator.items().helmXeno), 1);
        if (new Random().nextInt(4) == 1)
            this.entityDropItem(new ItemStack(AliensVsPredator.items().plateXeno), 1);
        if (new Random().nextInt(4) == 1)
            this.entityDropItem(new ItemStack(AliensVsPredator.items().legsXeno), 1);
        if (new Random().nextInt(4) == 1)
            this.entityDropItem(new ItemStack(AliensVsPredator.items().bootsXeno), 1);

        super.dropRareDrop(par1);
    }

    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected String getHurtSound()
    {
        return Sounds.SOUND_PRAETORIAN_HURT.getKey();
    }

    @Override
    protected String getLivingSound()
    {
        return Sounds.SOUND_PRAETORIAN_LIVING.getKey();
    }

    @Override
    protected String getDeathSound()
    {
        return Sounds.SOUND_PRAETORIAN_DEATH.getKey();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }
}
