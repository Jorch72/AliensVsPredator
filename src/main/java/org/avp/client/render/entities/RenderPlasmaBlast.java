package org.avp.client.render.entities;

import org.avp.client.model.entities.ModelPlasma;
import org.avp.entities.EntityPlasma;

import com.arisux.mdxlib.lib.client.render.Color;
import com.arisux.mdxlib.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPlasmaBlast extends Render
{
    private static final ModelPlasma model    = new ModelPlasma();
    private static final Color       color    = new Color(0.4F, 0.7F, 1F, 0.7F);

    public RenderPlasmaBlast()
    {
        model.setColor(color);
    }

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        EntityPlasma plasma = (EntityPlasma) entity;
        float rotation = (plasma.ticksExisted + renderPartialTicks) % 360;
        double wave = Math.sin(rotation);
        float additionalScale = 4F;

        OpenGL.pushMatrix();
        {
            OpenGL.enableBlend();
            OpenGL.translate(posX, posY + 0.125F, posZ);
            OpenGL.rotate(entity.rotationYaw - 90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(entity.rotationPitch - 90.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.scale(plasma.getPlasmaSize() * additionalScale, plasma.getPlasmaSize() * additionalScale, plasma.getPlasmaSize() * additionalScale);

            boolean drawInnerPlasma = true;
            float pp = plasma.getPlasmaSize() * 1;
            float aps = 0.25F;
            float ps = aps - (aps / (1F + pp));

            if (plasma.getImpactTimer() != -1)
            {
                float radius = 0.25F;
                float wrap = 30F;
                OpenGL.scale(radius, radius, radius);
                radius = plasma.getMaxImpactTimer() - (plasma.getImpactPrev() + ((plasma.getImpactPrev() - plasma.getImpactTimer()) * renderPartialTicks));
                radius = radius * wrap / plasma.getMaxImpactTimer();
                OpenGL.scale(radius, radius, radius);
                drawInnerPlasma = false;
                model.getColor().a = 1F - (1F * plasma.getImpactTimer() / plasma.getMaxImpactTimer());
            }
            else
            {
                OpenGL.scale(1F / 4, 1F, 1F / 4);
                OpenGL.translate(0F, 0F, 0.1F - ps);
            }

            if (drawInnerPlasma)
            {
                OpenGL.disableCullFace();
                OpenGL.pushMatrix();
                OpenGL.translate(wave * 0.005F, 0F, 0F);
                OpenGL.rotate(rotation * 30, 1, 0, 0);
                model.setScale(ps / 2.75F);
                model.render();
                OpenGL.popMatrix();

                OpenGL.pushMatrix();
                OpenGL.translate(wave * -0.005F, 0F, 0F);
                OpenGL.rotate(rotation * -20, 1, 0, 0);
                model.setScale(ps / 2.25F);
                model.render();
                OpenGL.popMatrix();

                OpenGL.pushMatrix();
                OpenGL.translate(wave * 0.005F, 0F, 0F);
                OpenGL.rotate(rotation * 10, 1, 0, 0);
                OpenGL.rotate(rotation, 1, 0, 0);
                model.setScale(ps / 2);
                model.render();
                OpenGL.popMatrix();

                OpenGL.pushMatrix();
                OpenGL.translate(wave * -0.005F, 0F, 0F);
                OpenGL.rotate(rotation * -5, 1, 0, 0);
                OpenGL.rotate(rotation, 1, 0, 0);
                model.setScale(ps / 1.25F);
                model.render();
                OpenGL.popMatrix();
                OpenGL.enableCullFace();
            }

            OpenGL.pushMatrix();
            OpenGL.translate(wave * 0.005F, 0F, 0F);
            OpenGL.rotate(rotation * 5, 1, 0, 0);
            OpenGL.rotate(rotation, 1, 0, 0);
            model.setScale(ps);
            model.render();
            OpenGL.popMatrix();
            OpenGL.disableBlend();
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
