package cn.mtpstudio.propsofdoraemon.item;

import net.minecraft.item.Item;

import java.util.ArrayList;

public class Items {
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<>();
    public static final ItemBambooCopter BAMBOO_COPTER = new ItemBambooCopter();
    public static final ItemTeapot TEAPOT = new ItemTeapot();
    public static final ItemHelpBall HELP_BALL = new ItemHelpBall();
    static {
        MOD_ITEMS.add(BAMBOO_COPTER);
        MOD_ITEMS.add(TEAPOT);
        MOD_ITEMS.add(HELP_BALL);
    }
}
