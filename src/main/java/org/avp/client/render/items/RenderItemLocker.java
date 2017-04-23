package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.tile.ModelLocker;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemLocker extends ItemRenderer<ModelLocker>
{
    public RenderItemLocker()
    {
        super(AliensVsPredator.resources().models().LOCKER);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.scale(-1F, 1F, 1F);
            OpenGL.rotate(90F, 0F, 0F, 1F);
            OpenGL.rotate(-45F, 0F, 1F, 0F);
            OpenGL.rotate(90F, 1F, 0F, 0F);
            OpenGL.translate(0F, -0.5F, -0.9F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.35F, 0.275F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

        OpenGL.pushMatrix();
        {
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.translate(0F, -1.5F, 0F);
            OpenGL.rotate((Game.minecraft().theWorld.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }
}
