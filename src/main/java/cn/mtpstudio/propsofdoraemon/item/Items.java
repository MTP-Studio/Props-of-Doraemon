package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.block.Blocks;
import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//copr. (c) 2021 Mtp studio
/**
 * 注册物品
 * @author Frank__Wang ShootKing
 */

public class Items {
    public static final Map<String,Item> MOD_ITEMS = new HashMap<>();
    public static final ItemBambooCopter BAMBOO_COPTER = new ItemBambooCopter();
    public static final ItemEmptyTeapot EMPTY_TEAPOT = new ItemEmptyTeapot();
    public static final ItemAdventureTea ADVENTURE_TEA = new ItemAdventureTea();
    public static final ItemHelpBall HELP_BALL = new ItemHelpBall();
    public static final ItemFlutteringMedicine FLUTTERING_MEDICINE = new ItemFlutteringMedicine();
    public static final Item Item_BlockDF=new BlockItem(Blocks.DORAEMON_FIGURE,new Item.Properties().group(RegistryHandler.itemBar).maxStackSize(1)).setRegistryName("itmbdf");
    public static final Item Item_TD=new BlockItem(Blocks.ZINKIN_DSK,new Item.Properties().group(RegistryHandler.itemBar).maxStackSize(1)).setRegistryName("itmtd");
    public static final Idea IDEA=new Idea();
    static {
        // 添加mod物品竹蜻蜓
        MOD_ITEMS.put("banboo_copter",BAMBOO_COPTER);
        // 添加mod物品空茶杯
        MOD_ITEMS.put("empty_teapot",EMPTY_TEAPOT);
        // 添加mod物品冒险茶
        MOD_ITEMS.put("adventure_tea",ADVENTURE_TEA);
        // 添加mod物品救命丸子
        MOD_ITEMS.put("help_ball",HELP_BALL);
        MOD_ITEMS.put("ibdf",Item_BlockDF);
        MOD_ITEMS.put("fluttering_medicine",FLUTTERING_MEDICINE);
        MOD_ITEMS.put("itd",Item_TD);
        MOD_ITEMS.put("ida",IDEA);
    }
}
