package cn.mtpstudio.propsofdoraemon.item;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class Items {
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<>();
    public static final ItemBambooCopter BAMBOO_COPTER = new ItemBambooCopter();
    public static final ItemHelpBall HELP_BALL = new ItemHelpBall();
    public static final ItemFilledTeapot FILLED_TEAPOT = new ItemFilledTeapot();
    public static final ItemEmptyTeapot EMPTY_TEAPOT = new ItemEmptyTeapot();
    static {
        MOD_ITEMS.add(BAMBOO_COPTER);
        MOD_ITEMS.add(FILLED_TEAPOT);
        MOD_ITEMS.add(EMPTY_TEAPOT);
        MOD_ITEMS.add(HELP_BALL);
    }
}
