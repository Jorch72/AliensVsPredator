package org.avp.api.power;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPowerConnection
{
    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectPower(ForgeDirection from);
}
