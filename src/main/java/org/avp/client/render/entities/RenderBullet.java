package org.avp.client.render.entities;

import org.avp.client.model.entities.ModelBullet;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends Render
{
    public static ModelBullet model = new ModelBullet();

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        ;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
