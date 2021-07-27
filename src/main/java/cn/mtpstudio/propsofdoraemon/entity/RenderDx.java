package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDx;
import com.joy187.re8joymod.common.entity.model.dx;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDx extends MobRenderer<EntityDx, dx<EntityDx>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dx.png");

    public RenderDx(EntityRendererManager manager) {
        super(manager, new dx <EntityDx>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDx  p_110775_1_) {
        return TEXTURE;
    }

}