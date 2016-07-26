package org.avp.items.render.parts;

import org.avp.items.render.ItemRendererGroup;

import com.arisux.airi.lib.GlStateManager;
import com.arisux.airi.lib.client.ModelBaseWrapper;
import com.arisux.airi.lib.client.ModelTexMap;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

public class RenderItem88Mod4Barrel extends ItemRendererGroup
{
    public RenderItem88Mod4Barrel(ModelTexMap<? extends ModelBaseWrapper> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack item, Object... data)
    {
        super.renderInInventory(item, data);

        GlStateManager.pushMatrix();
        {
            float glScale = 24F;
            GlStateManager.translate(8F, 8F, 0F);
            GlStateManager.scale(glScale, glScale, glScale);
            GlStateManager.translate(0.0F, 0.0F, -0.2F);
            this.renderPart();
        }
        GlStateManager.popMatrix();
    }
}
