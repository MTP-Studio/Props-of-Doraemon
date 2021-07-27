package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.item.Item;

public class Idea extends Item {
    public Idea() {
        super(new Properties().group(RegistryHandler.itemBar).maxStackSize(1));
    }
}
