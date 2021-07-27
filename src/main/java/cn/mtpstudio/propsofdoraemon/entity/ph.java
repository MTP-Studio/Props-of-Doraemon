// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityPh;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ph<T extends EntityPh> extends EntityModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public ph() {
		texWidth = 128;
		texHeight = 128;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(28, 30).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);
		head.texOffs(0, 25).addBox(-4.5F, -6.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(16, 59).addBox(-4.0F, 7.0F, 5.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
		body.texOffs(52, 30).addBox(-4.0F, 7.0F, -6.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
		body.texOffs(44, 18).addBox(-6.0F, 3.0F, 4.0F, 12.0F, 11.0F, 1.0F, 0.0F, false);
		body.texOffs(24, 47).addBox(-6.0F, 3.0F, -5.0F, 12.0F, 11.0F, 1.0F, 0.0F, false);
		body.texOffs(0, 0).addBox(-7.0F, -2.0F, -4.0F, 14.0F, 17.0F, 8.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setPos(-5.0F, 2.0F, 0.0F);
		left_arm.texOffs(0, 56).addBox(12.0F, -3.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(5.0F, 0.0F, 0.0F);
		right_arm.texOffs(50, 50).addBox(-16.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(-1.9F, 12.0F, 0.0F);
		left_leg.texOffs(44, 0).addBox(1.9F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(1.9F, 12.0F, 0.0F);
		right_leg.texOffs(0, 38).addBox(-7.9F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
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