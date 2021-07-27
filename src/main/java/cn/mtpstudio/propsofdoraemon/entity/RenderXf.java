package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityXf;
import com.joy187.re8joymod.common.entity.model.xf;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderXf extends MobRenderer<EntityXf, xf<EntityXf>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/xf.png");

    public RenderXf(EntityRendererManager manager) {
        super(manager, new xf <EntityXf>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityXf  p_110775_1_) {
        return TEXTURE;
    }

}