package cn.mtpstudio.propsofdoraemon.event;

import cn.mtpstudio.propsofdoraemon.client.Hud;
import cn.mtpstudio.propsofdoraemon.entity.Doraemon;
import cn.mtpstudio.propsofdoraemon.entity.Render;
import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public void onOverlayRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null) {
            return;
        }
        System.out.println("Rendeed");
        Hud hud=new Hud();
        hud.render();
    }
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        System.out.println("SetupModeled");
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.doraa, Render::new);
    }
}