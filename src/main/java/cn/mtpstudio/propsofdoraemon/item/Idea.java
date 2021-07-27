package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Idea extends Item {
    public Idea() {
        super(new Properties().group(RegistryHandler.itemBar).maxStackSize(1));
        setRegistryName("idea");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("咒术："+stack.getOrCreateTag().getString("itemType")));
    }
    @SubscribeEvent
    public static void onChat(ServerChatEvent event){
        if(event.getPlayer().isCreative()&&event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem().equals(Items.IDEA.getItem())){
            event.getPlayer().getHeldItem(Hand.MAIN_HAND).getTag().putString("itemType",event.getMessage());
        }
    }
}
