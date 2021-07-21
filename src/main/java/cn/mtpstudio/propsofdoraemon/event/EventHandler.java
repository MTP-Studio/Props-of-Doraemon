package cn.mtpstudio.propsofdoraemon.event;

import cn.mtpstudio.propsofdoraemon.effect.EffectAdventure;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.ItemBambooCopter;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent e) {
        if (!(e.getEntityLiving() instanceof PlayerEntity && e.getSlot().equals(EquipmentSlotType.HEAD) && (e.getFrom().getItem() instanceof ItemBambooCopter || e.getTo().getItem() instanceof ItemBambooCopter)))
            return;
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

//    @SubscribeEvent
//    public static void onPlayerChangeGameMode(PlayerEvent.PlayerChangeGameModeEvent e) {
//        if (!(e.getCurrentGameMode().isCreative() && e.getNewGameMode().isSurvivalOrAdventure() && e.getPlayer().inventory.armorInventory.get(3).getItem() instanceof ItemBambooCopter))
//            return;
//        PlayerEntity player = e.getPlayer();
//    }

    @SubscribeEvent
    public static void onPotionAdded(PotionEvent.PotionAddedEvent e) {
        if (!(e.getEntityLiving() instanceof PlayerEntity && e.getPotionEffect().getPotion() instanceof EffectAdventure))
            return;
        PlayerEntity player = (PlayerEntity) e.getEntityLiving();
        Thread thread = new Thread(() -> {
            player.removePotionEffect(Effects.EFFECT_ADVENTURE);
            World world = player.getEntityWorld();
            List<Double> x = new ArrayList<>(), y = new ArrayList<>(), z = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                x.add(player.getPosXRandom(10));
                y.add(player.getPosYRandom());
                z.add(player.getPosZRandom(10));
            }
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
            for (int i = 1; i < 11; i++) {
                ZombieEntity zombieChan = new ZombieEntity(world);
                zombieChan.setPosition(x.get(i), y.get(i), z.get(i));
                world.addEntity(zombieChan);
            }
        });
        thread.start();
    }
}
