package org.avp.entities.mob;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityAcidPool;
import org.avp.entities.EntityBullet;
import org.avp.util.MarineTypes;

import com.arisux.amdxlib.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMarine extends EntityCreature implements IMob, IRangedAttackMob
{
    private MarineTypes marineType;
    private ArrayList<Class<? extends Entity>> targetList = new ArrayList<Class<? extends Entity>>();
    private ArrayList<Class<? extends Entity>> safeList = new ArrayList<Class<? extends Entity>>();
    private EntityAIBase aiRangedAttack;
    private boolean isFiring;
    private long lastShotFired;

    public EntityMarine(World world)
    {
        super(world);
        this.marineType = MarineTypes.getTypeForId(new Random(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).nextInt(MarineTypes.values().length));
        this.aiRangedAttack = new EntityAIArrowAttack(this, 0.4D, (int) getMarineType().getFirearmItem().getFireRate(), 24);
        this.experienceValue = 5;
        this.dataWatcher.addObject(18, new Integer(15));
        this.dataWatcher.addObject(17, "false");
        this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
        this.tasks.addTask(1, this.aiRangedAttack);
        this.tasks.addTask(2, new EntityAIWander(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
        this.tasks.addTask(3, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIAttackOnCollide(this, 0.8D, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGolem.class, /** targetChance **/
            0, /** shouldCheckSight **/
            false, /** nearbyOnly **/
            false));
        this.applyTargets();
    }

    public MarineTypes getMarineType()
    {
        return marineType;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6499999761581421D);
    }

    private void applyTargets()
    {
        targetList.add(EntitySpeciesAlien.class);
        targetList.add(EntityMob.class);
        targetList.add(EntityYautja.class);
        safeList.add(EntityAcidPool.class);
        safeList.add(EntityPlayer.class);
        safeList.add(EntityMarine.class);
    }

    public boolean isAcceptableTarget(Entity entity)
    {
        for (Class<? extends Entity> entityClass : safeList)
        {
            if (entityClass.isInstance(entity))
            {
                return false;
            }
        }

        for (Class<? extends Entity> entityClass : targetList)
        {
            if (entityClass.isInstance(entity))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        super.dropFewItems(hitByPlayer, lootingLevel);

        if (hitByPlayer)
        {
            this.entityDropItem(new ItemStack(this.getMarineType().getFirearmItem().getAmmoType()), this.rand.nextInt(3));
        }
    }

    @Override
    public float getBlockPathWeight(int posX, int posY, int posZ)
    {
        return 0.5F - this.worldObj.getLightBrightness(posX, posY, posZ);
    }

    @Override
    public int getTotalArmorValue()
    {
        return 10;
    }

    @Override
    protected String getHurtSound()
    {
        return AliensVsPredator.properties().SOUND_MARINE_HURT;
    }

    @Override
    protected String getDeathSound()
    {
        return AliensVsPredator.properties().SOUND_MARINE_DEATH;
    }

    @Override
    public ItemStack getHeldItem()
    {
        return new ItemStack(AliensVsPredator.items().itemM41A);
    }

    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    @Override
    protected void updateAITick()
    {
        super.updateAITick();

        this.dataWatcher.updateObject(18, Integer.valueOf(15));
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.isFiring = !(System.currentTimeMillis() - getLastShotFired() >= 1000 * 3);

        if (!this.worldObj.isRemote)
        {
            this.getDataWatcher().updateObject(17, String.valueOf(this.isFiring));
        }

        if (this.worldObj.isRemote)
        {
            this.isFiring = Boolean.parseBoolean(getDataWatcher().getWatchableObjectString(17));
        }

        if (this.getAttackTarget() != null && (this.getAttackTarget().isDead || !isAcceptableTarget(this.getAttackTarget()) || this.getNavigator().tryMoveToEntityLiving(this.getAttackTarget(), this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()) || !Entities.canEntityBeSeenBy(this.getAttackTarget(), this)))
        {
            this.setAttackTarget(null);
        }

        if (this.getAttackTarget() == null)
        {
            // TODO: This is bad. Lots of lag is induced by this. This needs to be redone.
            // @SuppressWarnings("all")
            // ArrayList<EntityLivingBase> possibleTargets = (ArrayList<EntityLivingBase>) Entities.getEntitiesInCoordsRange(this.worldObj, EntityLivingBase.class, new CoordData(this), 16);
            // EntityLivingBase target = null;
            //
            // for (EntityLivingBase possibleTarget : possibleTargets)
            // {
            // if (possibleTarget != null && isAcceptableTarget(possibleTarget) && this.getNavigator().tryMoveToEntityLiving(possibleTarget, 0.65D))
            // {
            // if (this.getEntitySenses().canSee(possibleTarget))
            // {
            // target = possibleTarget;
            // }
            // }
            // }
            //
            // if (target != null)
            // {
            // this.setAttackTarget(target);
            // }
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float damage)
    {
        if (this.getAttackTarget() != null)
        {
            this.lastShotFired = System.currentTimeMillis();
            EntityBullet entityBullet = new EntityBullet(this.worldObj, this, targetEntity, 10F, 0.0000001F);
            this.worldObj.spawnEntityInWorld(entityBullet);
            this.playSound(getMarineType().getGunfireSound(), 0.7F, 1F);
            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + this.getEyeHeight(), this.posZ, 1, 1, 1);
        }
    }

    public boolean isFiring()
    {
        return isFiring;
    }

    public long getLastShotFired()
    {
        return lastShotFired;
    }
}
