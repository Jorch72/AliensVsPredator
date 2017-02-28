package org.avp.packets.server;

import org.avp.tile.TileEntityTurret;

import com.arisux.mdxlib.lib.client.render.Rotation;
import com.arisux.mdxlib.lib.game.Game;
import com.arisux.mdxlib.lib.world.Pos;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;

public class PacketTurretTargetUpdate implements IMessage, IMessageHandler<PacketTurretTargetUpdate, PacketTurretTargetUpdate>
{
    public int      x, y, z;
    public int      id;
    public Rotation focrot;
    public Pos      foc;

    public PacketTurretTargetUpdate()
    {
        ;
    }

    public PacketTurretTargetUpdate(TileEntityTurret turret)
    {
        this.x = turret.xCoord;
        this.y = turret.yCoord;
        this.z = turret.zCoord;
        this.id = turret.getTargetEntity().getEntityId();
        this.focrot = turret.getFocusRotation();
        this.foc = turret.getFocusPosition();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.id = buf.readInt();
        this.foc = new Pos(0, 0, 0).readFromBuffer(buf);
        this.focrot = new Rotation(0F, 0F).readFromBuffer(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);
        foc.writeToBuffer(buf);
        focrot.writeToBuffer(buf);
    }

    @Override
    public PacketTurretTargetUpdate onMessage(PacketTurretTargetUpdate packet, MessageContext ctx)
    {
        TileEntityTurret tile = (TileEntityTurret) Game.minecraft().theWorld.getTileEntity(packet.x, packet.y, packet.z);

        if (tile != null)
        {
            tile.onReceiveTargetUpdatePacket(packet, ctx);
        }

        return null;
    }
}
