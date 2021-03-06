package org.avp.client.render.entities.living;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelOctohugger;
import org.avp.client.render.RenderLivingHook;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.entities.EntityMedpod;
import org.avp.entities.living.EntityOctohugger;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class RenderOctohugger extends RenderLivingWrapper<EntityOctohugger, ModelOctohugger>
{
    public static ArrayList<EntityRenderTransforms> transforms = new ArrayList<EntityRenderTransforms>();

    public RenderOctohugger(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().OCTOHUGGER);
    }

    @Override
    public void doRender(EntityOctohugger octohugger, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(octohugger, posX, posY, posZ, yaw, renderPartialTicks);

        if (!octohugger.isHangingLocationStale())
        {
            GL11.glLineWidth(4.0F);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex3d(posX, posY + 0.83 + ((ModelOctohugger) this.mainModel).getYOffset(), posZ);
            GL11.glVertex3d(posX + octohugger.getHangingLocation().getX() - octohugger.posX, posY + octohugger.getHangingLocation().getY() - octohugger.posY, posZ + octohugger.getHangingLocation().getZ() - octohugger.posZ);
            GL11.glEnd();
            GL11.glLineWidth(1.0F);
        }
    }

    @Override
    protected void preRenderCallback(EntityOctohugger entityliving, float partialTicks)
    {
        EntityOctohugger octohugger = (EntityOctohugger) entityliving;

        if (octohugger.getRidingEntity() == null && !octohugger.isFertile())
        {
            OpenGL.rotate(90F, 1F, 0F, 0F);
        }

        OpenGL.translate(0F, 1.2F, 0F);
        this.scale(octohugger, 1.1F);

        if (octohugger != null && octohugger.getRidingEntity() != null && octohugger.getRidingEntity().getRidingEntity() != null && octohugger.getRidingEntity().getRidingEntity() instanceof EntityMedpod)
        {
            Entity entity = octohugger.getRidingEntity();
            EntityMedpod medpod = (EntityMedpod) entity.getRidingEntity();

            OpenGL.rotate(medpod.getTileEntity());
            RenderLivingHook.instance.getRenderer().transformEntity(medpod, entity, partialTicks);
        }

        if (octohugger.getRidingEntity() != null && octohugger.getRidingEntity() instanceof EntityLivingBase)
        {
            OpenGL.translate(0F, -1.5F, 0F);
            OpenGL.translate(0F, 0F, 1.25F);

            for (EntityRenderTransforms transform : RenderFacehuggers.transforms)
            {
                if (transform.isApplicable(octohugger.getRidingEntity()))
                {
                    transform.post(octohugger, partialTicks);

                    if (octohugger.getRidingEntity() instanceof EntityPlayer)
                    {

                    }
                    break;
                }
            }
        }
    }

    protected void scale(EntityOctohugger octohugger, float glScale)
    {
        OpenGL.scale(glScale, glScale, glScale);
    }
}
