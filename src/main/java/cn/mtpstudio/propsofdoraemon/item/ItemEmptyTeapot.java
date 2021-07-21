package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.item.Item;

public class ItemEmptyTeapot extends Item {
    public ItemEmptyTeapot() {
        super(new Properties());
        this.setRegistryName(PropsOfDoraemon.MODID, "empty_teapot");
    }
}
