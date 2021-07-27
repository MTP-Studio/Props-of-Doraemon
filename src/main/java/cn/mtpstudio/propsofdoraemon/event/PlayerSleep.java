package cn.mtpstudio.propsofdoraemon.event;

import cn.mtpstudio.propsofdoraemon.worldsavedata.thinkingPower;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerSleep {
    @SubscribeEvent
    public static void onSleep(PlayerSleepInBedEvent event){
        if(event.getPlayer() instanceof ServerPlayerEntity){
            thinkingPower tp=thinkingPower.get(event.getPlayer().getEntityWorld());
            tp.put(event.getPlayer(),500);
        }
    }
}
