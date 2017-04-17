package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelQueen;
import org.avp.entities.living.EntityQueen;

import com.arisux.mdxlib.lib.client.RenderLivingWrapper;
import com.arisux.mdxlib.lib.client.render.OpenGL;

public class RenderQueen extends RenderLivingWrapper<EntityQueen, ModelQueen>
{
    public RenderQueen()
    {
        super(AliensVsPredator.resources().models().XENOQUEEN);
    }

    @Override
    public void doRender(EntityQueen entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityQueen entityliving, float partialTicks)
    {
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
