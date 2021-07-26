package cn.mtpstudio.propsofdoraemon.block;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockDoraemonFigure extends Block {
    public BlockDoraemonFigure() {
        super(Properties.create(Material.IRON, MaterialColor.BLUE));
        this.setRegistryName(PropsOfDoraemon.MODID,"doraemon_figure");
    }
}
