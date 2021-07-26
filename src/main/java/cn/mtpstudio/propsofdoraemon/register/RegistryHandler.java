package cn.mtpstudio.propsofdoraemon.register;

import cn.mtpstudio.propsofdoraemon.block.Blocks;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
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
        event.getRegistry().register(withRegistryName(new BlockItem(Blocks.DORAEMON_FIGURE,new Item.Properties().maxStackSize(1))));
    }

    @SubscribeEvent
    public static void onEffectRegistry(RegistryEvent.Register<Effect> event) {
        // 注册冒险茶的药水效果
        event.getRegistry().register(Effects.EFFECT_ADVENTURE);
        event.getRegistry().register(Effects.EFFECT_FLUTTERING);
    }

    @SubscribeEvent
    public static void onBlockRegistry(RegistryEvent.Register<Block> event){
        event.getRegistry().register(Blocks.DORAEMON_FIGURE);
    }

    public static BlockItem withRegistryName(BlockItem block){
        return  (BlockItem) block.setRegistryName(block.getBlock().getRegistryName());
    }
}
