package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityPh;
import com.joy187.re8joymod.common.entity.model.ph;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderPh extends MobRenderer<EntityPh, ph<EntityPh>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/ph.png");

    public RenderPh(EntityRendererManager manager) {
        super(manager, new ph <EntityPh>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPh  p_110775_1_) {
        return TEXTURE;
    }

}