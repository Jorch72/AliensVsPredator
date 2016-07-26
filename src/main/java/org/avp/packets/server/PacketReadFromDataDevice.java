package org.avp.packets.server;

import org.avp.entities.tile.TileEntityTurret;
import org.avp.util.IDataDevice;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketReadFromDataDevice implements IMessage, IMessageHandler<PacketReadFromDataDevice, PacketReadFromDataDevice>
{
    /** Read data from other device with id from device specified using coords x, y, z **/

    public int x, y, z;
    public int id;

    public PacketReadFromDataDevice()
    {
        ;
    }

    public PacketReadFromDataDevice(int x, int y, int z, int id)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);
    }

    @Override
    public PacketReadFromDataDevice onMessage(PacketReadFromDataDevice packet, MessageContext ctx)
    {
        IDataDevice device = (TileEntityTurret) ctx.getServerHandler().playerEntity.worldObj.getTileEntity(packet.x, packet.y, packet.z);

        if (device != null)
        {
            device.readFromOtherDevice(packet.id);
        }

        return null;
    }
}
