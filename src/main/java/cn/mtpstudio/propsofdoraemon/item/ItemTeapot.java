package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraftforge.fluids.capability.ItemFluidContainer;

public class ItemTeapot extends ItemFluidContainer {

    public ItemTeapot() {
        super(new Properties(),0);
        this.setRegistryName(PropsOfDoraemon.MODID,"teapot");
    }
}
