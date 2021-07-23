package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.item.Item;

/**
 * 空茶杯
 * @author ShootKing
 */

public class ItemEmptyTeapot extends Item {

    /**
     * 注册冒险茶物品
     */

    public ItemEmptyTeapot() {
        super(new Properties());
        this.setRegistryName(PropsOfDoraemon.MODID, "empty_teapot");
    }
}
