package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityJx;
import com.joy187.re8joymod.common.entity.model.jx;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderJx extends MobRenderer<EntityJx, jx<EntityJx>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/jx.png");

    public RenderJx(EntityRendererManager manager) {
        super(manager, new jx <EntityJx>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityJx  p_110775_1_) {
        return TEXTURE;
    }

}