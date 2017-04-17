package org.avp.client.render.items.parts;

import org.avp.client.model.items.ModelSniper;
import org.avp.client.render.items.ItemRendererGroup;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.TexturedModel;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSniperBarrel extends ItemRendererGroup<ModelSniper>
{
    public RenderItemSniperBarrel(TexturedModel<ModelSniper> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        

        OpenGL.pushMatrix();
        {
            float glScale = 32F;
            OpenGL.translate(8F, 8F, 0F);

            OpenGL.rotate(45, 1F, 0F, 0F);
            OpenGL.scale(glScale, glScale, glScale);
            OpenGL.translate(0F, -0.075F, -0.3F);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.rotate((this.mc.theWorld.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
}
