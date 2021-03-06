package org.avp.client.model.entities.living;

import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelDracoOvamorph extends Model
{
    public ModelRenderer lFrontLobe2;
    public ModelRenderer center;
    public ModelRenderer lBackLobe2;
    public ModelRenderer rBackLobe2;
    public ModelRenderer base;
    public ModelRenderer rFrontLobe2;
    public ModelRenderer lFrontLobe2Child;
    public ModelRenderer sideSpikes1;
    public ModelRenderer sideSpikes2;
    public ModelRenderer sideSpikes3;
    public ModelRenderer sideSpikes4;
    public ModelRenderer webbing1;
    public ModelRenderer webbing2;
    public ModelRenderer webbing3;
    public ModelRenderer webbing4;
    public ModelRenderer webbing1b;
    public ModelRenderer webbing2b;
    public ModelRenderer webbing3b;
    public ModelRenderer webbing4b;
    public ModelRenderer lBackLobe2Child;
    public ModelRenderer rBackLobe2Child;
    public ModelRenderer rFrontLobe2Child;

    public ModelDracoOvamorph()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rBackLobe2Child = new ModelRenderer(this, 37, 6);
        this.rBackLobe2Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBackLobe2Child.addBox(-0.5F, -3.0F, -1.5F, 2, 2, 2, 0.0F);
        this.setRotation(rBackLobe2Child, -5.093295385449892E-7F, 0.0F, -5.093295385449892E-7F);
        this.webbing3 = new ModelRenderer(this, 47, 0);
        this.webbing3.setRotationPoint(3.5F, -1.2F, 0.0F);
        this.webbing3.addBox(0.0F, -0.1F, -3.5F, 0, 2, 7, 0.0F);
        this.setRotation(webbing3, 0.0F, 0.0F, -0.9560913642424937F);
        this.lBackLobe2Child = new ModelRenderer(this, 28, 6);
        this.lBackLobe2Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBackLobe2Child.addBox(-1.5F, -3.0F, -1.5F, 2, 2, 2, 0.0F);
        this.setRotation(lBackLobe2Child, -5.093295385449892E-7F, 0.0F, 5.093295385449892E-7F);
        this.lFrontLobe2Child = new ModelRenderer(this, 28, 0);
        this.lFrontLobe2Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFrontLobe2Child.addBox(-1.5F, -3.0F, -0.5F, 2, 2, 2, 0.0F);
        this.setRotation(lFrontLobe2Child, 5.093295385449892E-7F, 0.0F, 5.093295385449892E-7F);
        this.sideSpikes1 = new ModelRenderer(this, 0, 0);
        this.sideSpikes1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sideSpikes1.addBox(-5.7F, -6.0F, 0.1F, 1, 6, 0, 0.0F);
        this.setRotation(sideSpikes1, 0.0F, -0.8196066167365371F, 0.0F);
        this.webbing1b = new ModelRenderer(this, 39, 25);
        this.webbing1b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing1b.addBox(-3.5F, 1.0F, -4.6F, 7, 0, 3, 0.0F);
        this.setRotation(webbing1b, 0.9841911651996024F, 0.0F, 0.0F);
        this.webbing2b = new ModelRenderer(this, 39, 29);
        this.webbing2b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing2b.addBox(-3.5F, 1.0F, 1.6F, 7, 0, 3, 0.0F);
        this.setRotation(webbing2b, -0.9841911651996024F, 0.0F, 0.0F);
        this.webbing3b = new ModelRenderer(this, 44, 11);
        this.webbing3b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing3b.addBox(1.4F, 1.0F, -3.5F, 3, 0, 7, 0.0F);
        this.setRotation(webbing3b, 0.0F, 0.0F, 0.9841911651996024F);
        this.sideSpikes2 = new ModelRenderer(this, 0, 0);
        this.sideSpikes2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sideSpikes2.addBox(-5.7F, -6.0F, -0.2F, 1, 6, 0, 0.0F);
        this.setRotation(sideSpikes2, 0.0F, 0.8196066167365371F, 0.0F);
        this.webbing1 = new ModelRenderer(this, 26, 25);
        this.webbing1.setRotationPoint(0.0F, -1.2F, -3.4F);
        this.webbing1.addBox(-3.5F, 0.0F, -0.1F, 7, 2, 0, 0.0F);
        this.setRotation(webbing1, -0.9560913642424937F, 0.0F, 0.0F);
        this.lFrontLobe2 = new ModelRenderer(this, 22, 12);
        this.lFrontLobe2.setRotationPoint(1.5F, 18.0F, -1.5F);
        this.lFrontLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotation(lFrontLobe2, 1.1318434189888649E-6F, 0.0F, 1.1318434189888649E-6F);
        this.sideSpikes3 = new ModelRenderer(this, 0, 0);
        this.sideSpikes3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sideSpikes3.addBox(-5.7F, -6.0F, 0.1F, 1, 6, 0, 0.0F);
        this.setRotation(sideSpikes3, 0.0F, -2.367539130330308F, 0.0F);
        this.webbing4 = new ModelRenderer(this, 47, 0);
        this.webbing4.setRotationPoint(-3.5F, -1.2F, 0.0F);
        this.webbing4.addBox(0.0F, -0.2F, -3.5F, 0, 2, 7, 0.0F);
        this.setRotation(webbing4, 0.0F, 0.0F, 0.9560913642424937F);
        this.sideSpikes4 = new ModelRenderer(this, 0, 0);
        this.sideSpikes4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sideSpikes4.addBox(-5.7F, -6.0F, -0.1F, 1, 6, 0, 0.0F);
        this.setRotation(sideSpikes4, 0.0F, 2.367539130330308F, 0.0F);
        this.webbing4b = new ModelRenderer(this, 51, 18);
        this.webbing4b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing4b.addBox(-4.4F, 1.0F, -3.5F, 3, 0, 7, 0.0F);
        this.setRotation(webbing4b, 0.0F, 0.0F, -0.9841911651996024F);
        this.lBackLobe2 = new ModelRenderer(this, 22, 18);
        this.lBackLobe2.setRotationPoint(1.5F, 18.0F, 1.5F);
        this.lBackLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotation(lBackLobe2, -1.1318434189888649E-6F, 0.0F, 1.1318434189888649E-6F);
        this.rFrontLobe2 = new ModelRenderer(this, 35, 12);
        this.rFrontLobe2.setRotationPoint(-1.5F, 18.0F, -1.5F);
        this.rFrontLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotation(rFrontLobe2, 1.1318434189888649E-6F, 0.0F, -1.1318434189888649E-6F);
        this.rBackLobe2 = new ModelRenderer(this, 35, 18);
        this.rBackLobe2.setRotationPoint(-1.5F, 18.0F, 1.5F);
        this.rBackLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotation(rBackLobe2, -1.1318434189888649E-6F, 0.0F, -1.1318434189888649E-6F);
        this.base = new ModelRenderer(this, 0, 15);
        this.base.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.base.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F);
        this.center = new ModelRenderer(this, 0, 0);
        this.center.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.center.addBox(-3.5F, -6.0F, -3.5F, 7, 5, 7, 0.0F);
        this.webbing2 = new ModelRenderer(this, 26, 25);
        this.webbing2.setRotationPoint(0.0F, -1.2F, 3.4F);
        this.webbing2.addBox(-3.5F, 0.0F, 0.1F, 7, 2, 0, 0.0F);
        this.setRotation(webbing2, 0.9560913642424937F, 0.0F, 0.0F);
        this.rFrontLobe2Child = new ModelRenderer(this, 37, 0);
        this.rFrontLobe2Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFrontLobe2Child.addBox(-0.5F, -3.0F, -0.5F, 2, 2, 2, 0.0F);
        this.setRotation(rFrontLobe2Child, 5.093295385449892E-7F, 0.0F, -5.093295385449892E-7F);
        this.rBackLobe2.addChild(this.rBackLobe2Child);
        this.center.addChild(this.webbing3);
        this.lBackLobe2.addChild(this.lBackLobe2Child);
        this.lFrontLobe2.addChild(this.lFrontLobe2Child);
        this.center.addChild(this.sideSpikes1);
        this.webbing1.addChild(this.webbing1b);
        this.webbing2.addChild(this.webbing2b);
        this.webbing3.addChild(this.webbing3b);
        this.center.addChild(this.sideSpikes2);
        this.center.addChild(this.webbing1);
        this.center.addChild(this.sideSpikes3);
        this.center.addChild(this.webbing4);
        this.center.addChild(this.sideSpikes4);
        this.webbing4.addChild(this.webbing4b);
        this.center.addChild(this.webbing2);
        this.rFrontLobe2.addChild(this.rFrontLobe2Child);
    }

    @Override
    public void render(Object obj)
    {
        draw(lFrontLobe2);
        draw(lBackLobe2);
        draw(rFrontLobe2);
        draw(rBackLobe2);
        draw(base);
        draw(center);
    }
}
