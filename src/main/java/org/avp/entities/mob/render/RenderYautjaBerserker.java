package org.avp.entities.mob.render;

import org.avp.AliensVsPredator;
import org.avp.entities.mob.render.RenderFacehugger.IFaceMountable;

import com.arisux.amdxlib.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderYautjaBerserker extends RenderYautja implements IFaceMountable
{
    public RenderYautjaBerserker()
    {
        super(AliensVsPredator.resources().models().YAUTJA_BERSERKER);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityliving, float renderPartialTicks)
    {
        OpenGL.scale(0.85F, 0.85F, 0.85F);
    }
}
