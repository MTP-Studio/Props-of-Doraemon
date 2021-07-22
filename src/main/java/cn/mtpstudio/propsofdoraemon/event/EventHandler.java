package cn.mtpstudio.propsofdoraemon.event;

import cn.mtpstudio.propsofdoraemon.effect.EffectAdventure;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.ItemBambooCopter;
import cn.mtpstudio.propsofdoraemon.utils.Utils;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件处理
 * @author Frank__Wang ShootKing
 */

@Mod.EventBusSubscriber
public class EventHandler {

    /**
     * 监听装备栏改变
     * 当头部的装备栏变为竹蜻蜓时
     * 允许玩家飞起来
     * @param e 装备栏改变事件
     */

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent e) {
        if ((e.getEntityLiving() instanceof PlayerEntity && e.getSlot().equals(EquipmentSlotType.HEAD) && (e.getFrom().getItem() instanceof ItemBambooCopter || e.getTo().getItem() instanceof ItemBambooCopter))) {
            PlayerEntity player = (PlayerEntity) e.getEntityLiving();
            if (e.getTo().getItem() instanceof ItemBambooCopter) {
                player.abilities.allowFlying = true;
            } else {
                if (!player.isCreative()) {
                    player.abilities.allowFlying = false;
                    player.abilities.isFlying = false;
                }
            }
            player.sendPlayerAbilities();

        }
    }

    /**
     * 当玩家拥有冒险茶所给的效果时
     * 延迟10秒后
     * 在周围半径为10的范围内
     * 随机生成10只僵尸
     * @param e 添加药水效果事件
     */

    @SubscribeEvent
    public static void onPotionAdded(PotionEvent.PotionAddedEvent e) {
        if ((e.getEntityLiving() instanceof PlayerEntity && e.getPotionEffect().getPotion() instanceof EffectAdventure)) {
            PlayerEntity player = (PlayerEntity) e.getEntityLiving();
            Thread thread = new Thread(() -> {
                player.removePotionEffect(Effects.EFFECT_ADVENTURE);
                // 延迟十秒
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
                World world = player.getEntityWorld();
                List<Double> x = new ArrayList<>(), y = new ArrayList<>(), z = new ArrayList<>();
                double playerY = player.getPosY();
                for (int i = 0; i < 10; i++) {
                    // 在平面上半径为10的范围内取一个点
                    double zombieX = player.getPosXRandom(10);
                    double zombieZ = player.getPosZRandom(10);
                    x.add(zombieX);
                    // 将y设为该点可以到达的最高坐标
                    y.add(Utils.getTopY(zombieX, playerY, zombieZ, world));
                    z.add(zombieZ);
                }
                // 生成十只僵尸
                for (int i = 0; i < 10; i++) {
                    ZombieEntity zombieChan = new ZombieEntity(world);
                    zombieChan.setPosition(x.get(i), y.get(i), z.get(i));
                    world.addEntity(zombieChan);
                }
            });
            thread.start();
        }
    }
}
