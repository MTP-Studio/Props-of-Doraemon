package cn.mtpstudio.propsofdoraemon.event;

import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.Items;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onLivingUpdate(TickEvent.PlayerTickEvent event){
        PlayerEntity player = event.player;
        List<Effect> effectList = new ArrayList<>();
        for (EffectInstance effectInstance:player.getActivePotionEffects()){
            effectList.add(effectInstance.getPotion());
        }
        //玩家盔甲栏的头盔是否为竹蜻蜓
        if (player.inventory.armorInventory.get(3).getItem() == Items.BAMBOO_COPTER){
            player.abilities.allowFlying = true;
        }else {
            player.abilities.allowFlying = false;
            player.abilities.isFlying = false;
        }
        //玩家是否有adventure buff在身
        if (effectList.contains(Effects.EFFECT_ADVENTURE)){
            Thread thread = new Thread(() -> {
                player.removeActivePotionEffect(Effects.EFFECT_ADVENTURE);
                World world = player.getEntityWorld();
                List<Double> x = new ArrayList<>(),y = new ArrayList<>(),z = new ArrayList<>();
                for (int i = 0;i < 10;i++){
                    x.add(player.getPosXRandom(10));
                    y.add(player.getPosYRandom());
                    z.add(player.getPosZRandom(10));
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 1;i < 11;i++){
                    ZombieEntity zombie = new ZombieEntity(world);
                    zombie.setPosition(x.get(i),y.get(i), z.get(i));
                    world.addEntity(zombie);
                }
            });
            thread.start();
        }
    }
}
