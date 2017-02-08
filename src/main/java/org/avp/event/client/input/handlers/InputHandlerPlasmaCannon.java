package org.avp.event.client.input.handlers;

import org.avp.AliensVsPredator;
import org.avp.Sounds;
import org.avp.event.client.input.IInputHandler;
import org.avp.items.ItemWristbracer;
import org.avp.packets.server.PacketPlasmaDischarge;

import com.arisux.mdxlib.lib.game.Game;

public class InputHandlerPlasmaCannon implements IInputHandler
{
    public static final InputHandlerPlasmaCannon instance = new InputHandlerPlasmaCannon();

    private float                                chargeSize;
    private float                                chargeSizePrev;
    private float                                energy;
    private boolean                              recharging;

    @Override
    public void handleInput()
    {
        if (ItemWristbracer.hasPlasmaCannon(ItemWristbracer.wristbracer(Game.minecraft().thePlayer)))
        {
            float potentialChargeSize = this.chargeSize >= this.getMaxChargeSize() ? this.getMaxChargeSize() : this.chargeSize;
            float potentialEnergyUsed = this.getMaxStoredEnergy() * potentialChargeSize / this.getMaxChargeSize();
            
            if (this.energy <= this.getMaxStoredEnergy() / 20)
            {
                this.recharging = true;
            }

            if (this.energy < this.getMaxStoredEnergy())
            {
                this.energy++;
            }
            else if (this.energy >= this.getMaxStoredEnergy())
            {
                this.recharging = false;
            }

            if (AliensVsPredator.keybinds().specialSecondary.getIsKeyPressed())
            {
                if (this.energy >= potentialEnergyUsed && !this.recharging)
                {
                    if (this.chargeSize == 0)
                    {
                        this.onChargeStart();
                    }

                    this.chargeSize += this.getRechargeRate();
                }
                else
                {
                    this.onNoEnergy();
                }
            }

            if (this.chargeSize == this.chargeSizePrev)
            {
                this.chargeSize = 0F;
            }

            if (this.chargeSize == 0F && this.chargeSizePrev != 0F)
            {
                if (this.energy >= potentialEnergyUsed)
                {
                    this.onChargeRelease(potentialChargeSize, potentialEnergyUsed);
                }
            }

            this.chargeSizePrev = this.chargeSize;
        }
    }

    private void onNoEnergy()
    {
        Sounds.SOUND_WEAPON_PLASMACASTER_NOENERGY.playSound(Game.minecraft().thePlayer, 0.6F, 1.0F);
    }

    private void onChargeStart()
    {
        Sounds.SOUND_WEAPON_PLASMACASTER_CHARGE.playSound(Game.minecraft().thePlayer, 0.6F, 1.0F);
    }

    private void onChargeRelease(float chargeSize, float energyUsed)
    {
        this.energy -= energyUsed;
        AliensVsPredator.network().sendToServer(new PacketPlasmaDischarge(chargeSize));
    }

    public float getChargeSize()
    {
        return this.chargeSize;
    }

    public float getMaxChargeSize()
    {
        return 1.0F;
    }

    public float getRechargeRate()
    {
        return 0.025F;
    }

    public float getMaxStoredEnergy()
    {
        return 20 * 10;
    }

    public float getStoredEnergy()
    {
        return this.energy;
    }
    
    public boolean isRecharging()
    {
        return recharging;
    }
}
