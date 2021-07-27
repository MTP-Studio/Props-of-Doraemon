package cn.mtpstudio.propsofdoraemon.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;

public class Render extends MobRenderer<Doraemon, PlayerModel<Doraemon>> {
    public Render(EntityRendererManager renderManagerIn, PlayerModel<Doraemon> entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }
    public Render(EntityRendererManager rmi){
        super(rmi,new PlayerModel<Doraemon>(1,false),1f);
    }

    @Override
    public ResourceLocation getEntityTexture(Doraemon entity) {
        return new ResourceLocation("minecraft","textures/entity/steve.png");
    }
}
