// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports
package cn.mtpstudio.propsofdoraemon.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class BambooCopterModel extends BipedModel<LivingEntity> {

    public BambooCopterModel() {
        super(1.02F);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bipedHead = new ModelRenderer(this);
        this.bipedHeadwear = new ModelRenderer(this);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        ModelRenderer bambooCopterRenderer = new ModelRenderer(this);
        bambooCopterRenderer.setRotationPoint(0.0F, 24.0F, 0.0F);
        bambooCopterRenderer.setTextureOffset(0, 0).addBox(-1.0F, -33.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        bambooCopterRenderer.setTextureOffset(11, 11).addBox(-0.5F, -42.0F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
        bambooCopterRenderer.setTextureOffset(0, 0).addBox(-5.5F, -42.0F, -5.5F, 11.0F, 0.0F, 11.0F, 0.0F, false);
        bambooCopterRenderer.setTextureOffset(0, 8).addBox(-1.5F, -43.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        this.bipedHeadwear.addChild(bambooCopterRenderer);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
