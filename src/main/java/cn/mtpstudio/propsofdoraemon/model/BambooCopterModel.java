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
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bipedHead = new ModelRenderer(this);
        this.bipedHeadwear = new ModelRenderer(this);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        ModelRenderer modelRender = new ModelRenderer(this);
        modelRender.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.setRotationAngle(modelRender, 0.0F, 24.0F, 0.0F);
        modelRender.setTextureOffset(0, 0).addBox(-1.0F, -40.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
        modelRender.setTextureOffset(0, 0).addBox(-6.0F, -40.0F, 0.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        modelRender.setTextureOffset(0, 0).addBox(-1.0F, -40.0F, -5.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
        this.bipedHeadwear.addChild(modelRender);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
