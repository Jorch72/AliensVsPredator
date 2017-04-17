package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelSniper;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSniper extends ItemRenderer<ModelSniper>
{
    private float defaultFOV = mc.gameSettings.getOptionFloatValue(GameSettings.Options.FOV);

    public RenderItemSniper()
    {
        super(AliensVsPredator.resources().models().SNIPER);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.5F, 0F);
        OpenGL.rotate((Game.minecraft().theWorld.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    public void renderZoom()
    {
        if (mc.gameSettings.thirdPersonView == 0 && mc.thePlayer.getHeldItemMainhand() != null)
        {
            if (mc.thePlayer.getHeldItemMainhand().getItem() == AliensVsPredator.items().itemSniper)
            {
                if (!mc.inGameHasFocus)
                {
                    this.defaultFOV = mc.gameSettings.getOptionFloatValue(GameSettings.Options.FOV);
                }

                if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
                {
                    mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, 9F);
                }
                else if (mc.inGameHasFocus)
                {
                    mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, defaultFOV);
                }
            }
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.2F, 0.3F, -0.17F);
        OpenGL.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(40.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.translate(0.1F, -0.0F, 0.8F);
        float glScale = 1.2F;
        OpenGL.scale(glScale, glScale, glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                this.getModel().getModel().setFirstPerson(true);
                OpenGL.translate(1.26F, 1.985F, -0.375F);
                OpenGL.rotate(102.4F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(115F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(78.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(-0.495F, 0.60F, -1.835F);
            }
            else
            {
                this.getModel().getModel().setFirstPerson(false);
                OpenGL.translate(1.5F, 0.95F, 0.35F);
                OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.scale(2.2F, 2.2F, 2.2F);
            }
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
        }
        this.renderZoom();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(12F, 0F, 0F);
        float glScale = 20F;
        OpenGL.scale(glScale, glScale, glScale);
        this.getModel().draw();
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
