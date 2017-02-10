package org.avp.event.client.render.transforms;

import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

import org.avp.AliensVsPredator;
import org.avp.entities.mob.EntityChestburster;
import org.avp.entities.mob.EntityDrone;
import org.avp.entities.mob.EntityFacehugger;
import org.avp.entities.mob.EntityOvamorph;
import org.avp.entities.mob.EntityPraetorian;
import org.avp.entities.mob.EntityQueen;
import org.avp.entities.mob.EntityXenomorph;
import org.avp.entities.tile.TileEntityCryostasisTube;
import org.avp.entities.tile.render.RenderCryostasisTube;
import org.avp.entities.tile.render.RenderCryostasisTube.CryostasisEntityRenderer;
import org.lwjgl.opengl.GL12;

import com.arisux.mdxlib.lib.client.TexturedModel;
import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;

public class CryostasisTubeRenderers
{
    public static void register()
    {
        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityChestburster.class)
        {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityChestburster;
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    OpenGL.pushMatrix();
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, -0.5F, 0F);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    RenderManager.instance.renderEntityWithPosYaw(tile.stasisEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                    OpenGL.popMatrix();
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityFacehugger.class)
        {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityFacehugger;
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    OpenGL.pushMatrix();
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, -0.5F, 0F);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    RenderManager.instance.renderEntityWithPosYaw(tile.stasisEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                    OpenGL.popMatrix();
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityOvamorph.class)
        {
            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null)
                {
                    OpenGL.pushMatrix();
                    OpenGL.scale(0.875F, 0.875F, 0.875F);
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, 0.75F, 0F);
                    OpenGL.rotate(180F, 1F, 0F, 0F);
                    OpenGL.rotate(23.5F, 0F, 1F, 0F);
                    RenderManager.instance.renderEntityWithPosYaw(tile.stasisEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                    OpenGL.popMatrix();
                }
            }
        });

        RenderCryostasisTube.renderers.add(new CryostasisEntityRenderer(EntityXenomorph.class)
        {
            @Override
            public boolean isApplicable(Entity entity)
            {
                return entity instanceof EntityXenomorph;
            }

            @Override
            public void renderChassis(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                OpenGL.disableCullFace();
                OpenGL.enableBlend();
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                OpenGL.translate(posX + 0.5F, posY + 1.7F, posZ + 0.5F);
                OpenGL.rotate(tile);
                OpenGL.enable(GL12.GL_RESCALE_NORMAL);
                OpenGL.scale(0.75F, -0.75F, 0.75F);
                OpenGL.enable(GL_ALPHA_TEST);
                OpenGL.pushMatrix();
                OpenGL.scale(4, 3, 4);
                OpenGL.translate(0F, -0.75F, 0F);
                AliensVsPredator.resources().models().CRYOSTASIS_TUBE.draw();
                OpenGL.popMatrix();
                OpenGL.enableCullFace();
            }

            @Override
            public void renderEntity(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                if (tile.stasisEntity != null && !(tile.stasisEntity instanceof EntityQueen))
                {
                    double depth = tile.stasisEntity instanceof EntityPraetorian ? -1.95 : tile.stasisEntity instanceof EntityDrone ? -1.0 : -1.5F;

                    OpenGL.pushMatrix();
                    if (tile.getVoltage() > 0)
                        OpenGL.disableLight();
                    OpenGL.translate(0F, -2.75F, depth);
                    OpenGL.rotate(90F, 1F, 0F, 0F);
                    RenderManager.instance.renderEntityWithPosYaw(tile.stasisEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                    OpenGL.popMatrix();
                }
                else if (tile.stasisEntity instanceof EntityQueen)
                {
                    OpenGL.pushMatrix();
                    OpenGL.disableLight();
                    OpenGL.scale(0.25, 0.25, 0.25);
                    OpenGL.translate(-3.25, -16, 0);
                    Draw.drawString("\u26A0", 0, 0, 0xFFFF0000, false);
                    OpenGL.enableLight();
                    OpenGL.popMatrix();
                }
            }

            @Override
            public void renderTube(RenderCryostasisTube renderer, TileEntityCryostasisTube tile, double posX, double posY, double posZ)
            {
                TexturedModel<?> mask = null;

                if (tile.isShattered())
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK_SHATTERED;
                }
                else if (tile.isCracked())
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK_CRACKED;
                }
                else
                {
                    mask = AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK;
                }

                if (tile.getVoltage() > 0)
                {
                    OpenGL.disableLightMapping();
                    OpenGL.disableLight();
                }

                OpenGL.disableCullFace();
                OpenGL.scale(4, 3, 4);
                OpenGL.translate(0F, -0.75F, 0F);
                mask.draw();
                OpenGL.scale(0.5, 0.5, 0.5);
                OpenGL.enableLightMapping();
                OpenGL.enableLight();
                OpenGL.enableCullFace();
            }
        });
    }
}
