package org.avp.client.render.items;

import com.arisux.mdxlib.lib.client.Model;
import com.arisux.mdxlib.lib.client.TexturedModel;
import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSummoner extends ItemRenderer<Model>
{
    private float                   scale;
    private float                   x;
    private float                   y;
    private TexturedModel<?>        model;

    @SuppressWarnings("all")
    public RenderItemSummoner(TexturedModel<?> model)
    {
        super(null);
        this.model = model.clone();
    }

    public RenderItemSummoner setX(float x)
    {
        this.x = x;
        return this;
    }

    public RenderItemSummoner setY(float y)
    {
        this.y = y;
        return this;
    }

    public RenderItemSummoner setScale(float scale)
    {
        this.scale = scale;
        return this;
    }
    
    public void renderCachedModel()
    {
        OpenGL.pushMatrix();
        {
            OpenGL.enableBlend();
            OpenGL.blendClear();
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.translate(0F, -1F, 0F);
            OpenGL.rotate(180F, 0F, 0F, 1F);
            OpenGL.rotate(-45F, 0F, 1F, 0F);
            OpenGL.disableCullFace();
            this.model.draw();
            OpenGL.enableCullFace();
            OpenGL.disableBlend();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        scale = 0.5F;
        OpenGL.rotate(195F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(180F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(30F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.5F, 0F, 0F);
        OpenGL.scale(scale, scale, scale);
        this.renderCachedModel();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(195F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(180F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(30F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-25F, 0F + y, 20.85F);
        OpenGL.scale(scale, scale, scale);
        this.renderCachedModel();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(x * Model.DEFAULT_SCALE, y * -Model.DEFAULT_SCALE, 0F);
        OpenGL.translate(0F, 0.9F, 0F);
        OpenGL.scale(scale * Model.DEFAULT_SCALE, scale * Model.DEFAULT_SCALE, scale * Model.DEFAULT_SCALE);
        OpenGL.rotate(45F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(180F, 0.0F, 0.0F, 1.0F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        this.renderCachedModel();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(180F, 0.0F, 0.0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1F, 0F);
        OpenGL.rotate((mc.theWorld.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.scale(0.25F, 0.25F, 0.25F);
        OpenGL.translate(0F, -2.5F, 0F);
        this.renderCachedModel();
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
