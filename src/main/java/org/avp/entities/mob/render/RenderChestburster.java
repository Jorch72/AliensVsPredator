package org.avp.entities.mob.render;

import org.avp.AliensVsPredator;
import org.avp.entities.tile.TileEntityCryostasisTube;
import org.avp.entities.tile.render.RenderCryostasisTube;
import org.avp.entities.tile.render.RenderCryostasisTube.CryostasisTubeRenderer;
import org.avp.entities.tile.render.RenderCryostasisTube.ICustomCryostasisRenderer;

import com.arisux.amdxlib.lib.client.RenderLivingWrapper;
import com.arisux.amdxlib.lib.client.render.OpenGL;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

public class RenderChestburster extends RenderLivingWrapper implements ICustomCryostasisRenderer
{
    public RenderChestburster()
    {
        super(AliensVsPredator.resources().models().CHESTBUSTER);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public CryostasisTubeRenderer getCustomCryostasisRenderer()
    {
        return new CryostasisTubeRenderer()
        {
            @Override
            public void renderChassis(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                super.renderChassis(renderer, tile, posX, posY, posZ);
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    OpenGL.pushMatrix();
                    {
                        if (tile.getVoltage() > 0)
                        {
                            OpenGL.disableLight();
                        }

                        OpenGL.translate(0F, -0.5F, 0F);
                        OpenGL.rotate(90F, 1F, 0F, 0F);
                        RenderManager.instance.renderEntityWithPosYaw(tile.stasisEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                    }
                    OpenGL.popMatrix();
                }
            }

            @Override
            public void renderTube(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                super.renderTube(renderer, tile, posX, posY, posZ);
            }
        };
    }
}
