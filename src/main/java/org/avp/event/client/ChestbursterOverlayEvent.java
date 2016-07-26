package org.avp.event.client;

import org.avp.AliensVsPredator;
import org.avp.entities.extended.ExtendedEntityLivingBase;

import com.arisux.airi.lib.RenderUtil;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public class ChestbursterOverlayEvent
{
    private Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void renderTickOverlay(Pre event)
    {
        if (mc.thePlayer != null)
        {
            if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
            {
                ExtendedEntityLivingBase livingBaseProperties = (ExtendedEntityLivingBase) mc.thePlayer.getExtendedProperties(ExtendedEntityLivingBase.IDENTIFIER);

                if (livingBaseProperties.doesEntityContainEmbryo())
                {
                    if (livingBaseProperties.doesEntityContainEmbryo() && Minecraft.getMinecraft().thePlayer.isDead && livingBaseProperties.getEmbryo().getTicksExisted() >= livingBaseProperties.getEmbryo().getGestationPeriod() - 80)
                    {
                        RenderUtil.renderOverlay(AliensVsPredator.resources().BLUR_CHESTBURSTER_EMERGE, 1F, 0F, 0F, 1F);
                    }
                }
            }
        }
    }
}
