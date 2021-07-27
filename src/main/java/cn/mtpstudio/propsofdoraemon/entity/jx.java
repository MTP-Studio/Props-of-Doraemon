// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityJx;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class jx<T extends EntityJx> extends EntityModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer body_r4;
	private final ModelRenderer body_r5;
	private final ModelRenderer body_r6;
	private final ModelRenderer body_r7;
	private final ModelRenderer body_r8;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public jx() {
		texWidth = 64;
		texHeight = 64;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setPos(-3.0F, -0.5F, 3.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.8727F, -0.6981F, 0.0F);
		head_r1.texOffs(40, 30).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setPos(3.0F, -0.5F, 3.0F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 0.8727F, 0.6981F, 0.0F);
		head_r2.texOffs(6, 48).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setPos(0.0F, 11.5F, 2.5F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.4363F, 0.0F, 0.0F);
		body_r1.texOffs(24, 16).addBox(-4.0F, -3.5F, -0.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);

		body_r2 = new ModelRenderer(this);
		body_r2.setPos(1.0F, 11.5F, 3.0F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, 0.4363F, 0.48F, 0.0F);
		body_r2.texOffs(0, 0).addBox(2.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		body_r3 = new ModelRenderer(this);
		body_r3.setPos(-1.0F, 11.5F, 3.0F);
		body.addChild(body_r3);
		setRotationAngle(body_r3, 0.4363F, -0.48F, 0.0F);
		body_r3.texOffs(24, 0).addBox(-4.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		body_r4 = new ModelRenderer(this);
		body_r4.setPos(1.0F, 11.5F, -3.0F);
		body.addChild(body_r4);
		setRotationAngle(body_r4, -0.4363F, -0.48F, 0.0F);
		body_r4.texOffs(16, 32).addBox(2.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		body_r5 = new ModelRenderer(this);
		body_r5.setPos(-1.0F, 11.5F, -3.0F);
		body.addChild(body_r5);
		setRotationAngle(body_r5, -0.4363F, 0.48F, 0.0F);
		body_r5.texOffs(0, 48).addBox(-4.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		body_r6 = new ModelRenderer(this);
		body_r6.setPos(0.0F, 11.5F, -2.5F);
		body.addChild(body_r6);
		setRotationAngle(body_r6, -0.4363F, 0.0F, 0.0F);
		body_r6.texOffs(16, 40).addBox(-4.0F, -3.5F, -0.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);

		body_r7 = new ModelRenderer(this);
		body_r7.setPos(-4.5F, 12.5F, 0.0F);
		body.addChild(body_r7);
		setRotationAngle(body_r7, 0.0F, 0.0F, 0.3927F);
		body_r7.texOffs(40, 20).addBox(-0.5F, -3.5F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		body_r8 = new ModelRenderer(this);
		body_r8.setPos(4.5F, 12.5F, 0.0F);
		body.addChild(body_r8);
		setRotationAngle(body_r8, 0.0F, 0.0F, -0.3927F);
		body_r8.texOffs(46, 12).addBox(-0.5F, -3.5F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setPos(-5.0F, 2.0F, 0.0F);
		left_arm.texOffs(36, 36).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(5.0F, 2.0F, 0.0F);
		right_arm.texOffs(32, 0).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(-1.9F, 12.0F, 0.0F);
		left_leg.texOffs(0, 32).addBox(1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(1.9F, 12.0F, 0.0F);
		right_leg.texOffs(24, 24).addBox(-5.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.left_leg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.right_leg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.left_arm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.right_arm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.head.yRot = netHeadYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}