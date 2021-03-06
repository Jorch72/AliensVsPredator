package org.avp.client.render.entities;

import org.avp.client.model.entities.ModelBullet;
import org.avp.entities.EntityBullet;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends Render<EntityBullet>
{
    public RenderBullet(RenderManager m)
    {
        super(m);
    }

    public static ModelBullet model = new ModelBullet();

    @Override
    public void doRender(EntityBullet entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        ;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBullet entity)
    {
        return null;
    }
}
