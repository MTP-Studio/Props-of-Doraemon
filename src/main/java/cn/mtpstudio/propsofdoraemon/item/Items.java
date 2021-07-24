package cn.mtpstudio.propsofdoraemon.item;

import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * 注册物品
 * @author Frank__Wang ShootKing
 */

public class Items {
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<>();
    public static final ItemBambooCopter BAMBOO_COPTER = new ItemBambooCopter();
    public static final ItemEmptyTeapot EMPTY_TEAPOT = new ItemEmptyTeapot();
    public static final ItemAdventureTea ADVENTURE_TEA = new ItemAdventureTea();
    public static final ItemHelpBall HELP_BALL = new ItemHelpBall();
    public static final ItemFlutteringMedicine FLUTTERING_MEDICINE = new ItemFlutteringMedicine();
    static {
        // 添加mod物品竹蜻蜓
        MOD_ITEMS.add(BAMBOO_COPTER);
        // 添加mod物品空茶杯
        MOD_ITEMS.add(EMPTY_TEAPOT);
        // 添加mod物品冒险茶
        MOD_ITEMS.add(ADVENTURE_TEA);
        // 添加mod物品救命丸子
        MOD_ITEMS.add(HELP_BALL);
        MOD_ITEMS.add(FLUTTERING_MEDICINE);
    }
}
