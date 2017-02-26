package org.avp.tile;

import org.avp.api.power.IVoltageReceiver;

import net.minecraftforge.common.util.ForgeDirection;

public class TileEntitySatelliteModem extends TileEntityElectrical implements IVoltageReceiver
{
    public TileEntitySatelliteModem()
    {
        super(false);
    }

    @Override
    public boolean canConnectPower(ForgeDirection from)
    {
        return false;
    }

    @Override
    public double receiveVoltage(ForgeDirection from, double maxReceive, boolean simulate)
    {
        return maxReceive;
    }

    @Override
    public double getCurrentVoltage(ForgeDirection from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(ForgeDirection from)
    {
        return 10000;
    }
}
