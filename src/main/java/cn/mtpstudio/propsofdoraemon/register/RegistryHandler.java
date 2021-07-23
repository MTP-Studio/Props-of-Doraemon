package cn.mtpstudio.propsofdoraemon.register;

import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> event) {
        // 注册物品
        for (Item item : Items.MOD_ITEMS){
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void onEffectRegistry(RegistryEvent.Register<Effect> event) {
        // 注册冒险茶的药水效果
        event.getRegistry().register(Effects.EFFECT_ADVENTURE);
    }
}
