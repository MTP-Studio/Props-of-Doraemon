package cn.mtpstudio.propsofdoraemon.register;

import cn.mtpstudio.propsofdoraemon.NetworkPacket;
import cn.mtpstudio.propsofdoraemon.block.Blocks;
import cn.mtpstudio.propsofdoraemon.block.tileEntity.BTDTileEntity;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import cn.mtpstudio.propsofdoraemon.entity.Doraemon;
import cn.mtpstudio.propsofdoraemon.item.Items;
import cn.mtpstudio.propsofdoraemon.item.creativeInvBar.POD;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    public static final POD itemBar=new POD();
    public static EntityType<Doraemon> doraa;
    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> event) {
        // 注册物品
        for (Map.Entry<String,Item> item : Items.MOD_ITEMS.entrySet()){
            event.getRegistry().register(item.getValue());
        }
        event.getRegistry().register(withRegistryName(new BlockItem(Blocks.DORAEMON_FIGURE,new Item.Properties().maxStackSize(1))));
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        NetworkPacket.registerMessage();
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
        event.getRegistry().register(Blocks.ZINKIN_DSK);
    }

    public static BlockItem withRegistryName(BlockItem block){
        return  (BlockItem) block.setRegistryName(block.getBlock().getRegistryName());
    }
    @SubscribeEvent
    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> ter) {
        ter.getRegistry().register(BTDTileEntity.type);
    }
    @SubscribeEvent
    public static void onEntityRegistation(RegistryEvent.Register<EntityType<?>> event) {
        doraa=EntityType.Builder.create((EntityType<Doraemon> entityType, World world) -> {
            return new Doraemon(entityType, world);
        }, EntityClassification.MISC).size(1f,1.8f).build("doraemon");
        doraa.setRegistryName("doraemon");
        event.getRegistry().register(doraa);
    }
}
