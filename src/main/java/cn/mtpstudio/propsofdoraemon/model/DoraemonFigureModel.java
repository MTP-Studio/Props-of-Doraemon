package cn.mtpstudio.propsofdoraemon.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DoraemonFigureModel extends EntityModel<Entity> {
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer head;

    public DoraemonFigureModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.0781F, -0.8438F);
        body.setTextureOffset(0, 58).addBox(-5.5F, -9.0781F, -1.6563F, 11.0F, 10.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(45, 0).addBox(-5.0F, -10.0781F, -2.1563F, 10.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(45, 7).addBox(-5.5F, 0.9219F, -1.6563F, 11.0F, 1.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(32, 58).addBox(-5.5F, -9.0781F, -2.6563F, 11.0F, 10.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(56, 58).addBox(-4.5F, -9.0781F, 3.3438F, 9.0F, 10.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 8).addBox(-2.5F, -1.3281F, -3.1563F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(41, 36).addBox(-3.0F, -2.3281F, -3.1563F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(36, 52).addBox(-3.5F, -3.3281F, -3.1563F, 7.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 33).addBox(-1.0F, -1.8281F, 4.3438F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -7.8281F, -3.1563F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1309F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 10).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-3.5F, 0.9219F, 0.8438F);
        body.addChild(rightleg);
        rightleg.setTextureOffset(27, 69).addBox(-2.0F, 3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);
        rightleg.setTextureOffset(47, 69).addBox(-1.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(3.5F, 0.9219F, 0.8438F);
        body.addChild(leftleg);
        leftleg.setTextureOffset(58, 13).addBox(-3.0F, 3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);
        leftleg.setTextureOffset(36, 42).addBox(-2.5F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(7.0F, -7.0781F, 0.8438F);
        body.addChild(leftarm);
        leftarm.setTextureOffset(0, 25).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
        leftarm.setTextureOffset(0, 73).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-7.0F, -7.0781F, 0.8438F);
        body.addChild(rightarm);
        rightarm.setTextureOffset(0, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
        rightarm.setTextureOffset(63, 69).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -11.0781F, -0.1562F);
        body.addChild(head);
        head.setTextureOffset(41, 41).addBox(-7.0F, -3.0F, -6.0F, 14.0F, 4.0F, 13.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-8.0F, -12.0F, -6.0F, 16.0F, 12.0F, 13.0F, 0.0F, false);
        head.setTextureOffset(54, 21).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 12.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 42).addBox(-7.0F, -12.0F, 4.0F, 14.0F, 12.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 25).addBox(-7.0F, -13.0F, -6.0F, 14.0F, 4.0F, 13.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}