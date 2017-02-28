package org.avp.client.render.entities;

import org.avp.AliensVsPredator;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class RenderAcidPool extends Render
{
    public RenderAcidPool()
    {
        super(Game.renderManager());
    }

    @Override
    public void doRender(Entity entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            float offset = 1.4F;
            double renderX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * renderPartialTicks;
            double renderY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * renderPartialTicks + entity.getCollisionBorderSize();
            double renderZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * renderPartialTicks;
            double partialX = posX - renderX;
            double partialY = posY - renderY;
            double partialZ = posZ - renderZ;

            OpenGL.enableBlend();
            OpenGL.blendClear();
            OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_DST_ALPHA);
            AliensVsPredator.resources().LIQUID_POOL.bind();
            Draw.startQuads();
            OpenGL.color(1F, 1F, 1F, 1F);

            for (int blockX = MathHelper.floor_double(renderX - offset); blockX <= MathHelper.floor_double(renderX + offset); ++blockX)
            {
                for (int blockY = MathHelper.floor_double(renderY - offset); blockY <= MathHelper.floor_double(renderY); ++blockY)
                {
                    for (int blockZ = MathHelper.floor_double(renderZ - offset); blockZ <= MathHelper.floor_double(renderZ + offset); ++blockZ)
                    {
                        BlockPos pos = new BlockPos(blockX, blockY - 1, blockZ);
                        IBlockState blockstate = Game.minecraft().thePlayer.worldObj.getBlockState(pos);

                        if (blockstate.getBlock() != Blocks.AIR)
                        {
                            this.drawOnBlock(blockstate, posX, posY + entity.getCollisionBorderSize(), posZ, pos, yaw, offset, partialX, partialY + entity.getCollisionBorderSize(), partialZ, entity.ticksExisted);
                        }
                    }
                }
            }

            Draw.tessellate();
            OpenGL.color(1F, 1F, 1F, 1F);
            OpenGL.blendClear();
        }
        OpenGL.popMatrix();
    }

    private void drawOnBlock(IBlockState state, double posX, double posY, double posZ, BlockPos pos, float yaw, float offset, double partialX, double partialY, double partialZ, float opacity)
    {
        if (state.isNormalCube())
        {
            AxisAlignedBB boundingbox = state.getCollisionBoundingBox(Game.minecraft().theWorld, pos);
            double x1 = pos.getX() + boundingbox.minX + partialX;
            double x2 = pos.getX() + boundingbox.maxX + partialX;
            double y = pos.getY() + boundingbox.minY + partialY + 0.015625D;
            double z1 = pos.getZ() + boundingbox.minZ + partialZ;
            double z2 = pos.getZ() + boundingbox.maxZ + partialZ;
            float u1 = (float) ((posX - x1) / 2.0D / offset + 0.5D);
            float u2 = (float) ((posX - x2) / 2.0D / offset + 0.5D);
            float v1 = (float) ((posZ - z1) / 2.0D / offset + 0.5D);
            float v2 = (float) ((posZ - z2) / 2.0D / offset + 0.5D);

            OpenGL.pushMatrix();
            {
                OpenGL.rotate(yaw, 0F, 1F, 0F);
                Draw.vertex(x1, y, z1, u1, v1).endVertex();
                Draw.vertex(x1, y, z2, u1, v2).endVertex();
                Draw.vertex(x2, y, z2, u2, v2).endVertex();
                Draw.vertex(x2, y, z1, u2, v1).endVertex();
            }
            OpenGL.popMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
