package org.avp.entities.mob;

import org.avp.Sounds;
import org.avp.entities.EntityAcidProjectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;

public class EntitySpitter extends EntityXenomorph implements IRangedAttackMob
{
    public EntitySpitter(World par1World)
    {
        super(par1World);
        this.experienceValue = 275;
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5500000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }

    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected String getHurtSound()
    {
        return Sounds.SOUND_SPITTER_HURT.getKey();
    }

    @Override
    protected String getLivingSound()
    {
        return Sounds.SOUND_SPITTER_LIVING.getKey();
    }

    @Override
    protected String getDeathSound()
    {
        return Sounds.SOUND_SPITTER_DEATH.getKey();
    }

    @Override
    public int getTotalArmorValue()
    {
        return 2;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.attackEntityWithRangedAttack((EntityLivingBase) entity, 0.2f);
        return true;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase living, float damage)
    {
        if (!living.isDead)
        {
            this.getLookHelper().setLookPosition(living.posX, living.posY + living.getEyeHeight(), living.posZ, 10.0F, this.getVerticalFaceSpeed());

            if (this.canEntityBeSeen(living))
            {
                int attackDamage = 2;

                EntityAcidProjectile entityacid = new EntityAcidProjectile(this.worldObj, this, living, 1.6F, 14 - attackDamage * 4);
                entityacid.setDamage(damage * 2.0F + this.rand.nextGaussian() * 0.25D + attackDamage * 0.11F);
                
                if (this.worldObj.getWorldTime() % 30 == 0)
                {
                    this.worldObj.spawnEntityInWorld(entityacid);
                }
            }
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }
}
