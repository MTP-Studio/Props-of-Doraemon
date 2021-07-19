package cn.mtpstudio.propsofdoraemon.register;

import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlockRegistry(RegistryEvent.Register<Block> event) {

    }
    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> event){
        event.getRegistry().register(Items.BAMBOO_COPTER);
    }
    @SubscribeEvent
    public static void onEffectRegistry(RegistryEvent.Register<Effect> event){
        event.getRegistry().register(Effects.EFFECT_ADVENTURE);
    }
}
