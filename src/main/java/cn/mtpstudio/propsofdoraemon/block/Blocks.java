package cn.mtpstudio.propsofdoraemon.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;

public class Blocks {
    public static final AbstractBlock.Properties machine= AbstractBlock.Properties.create(Material.CLAY).hardnessAndResistance(0f,0.5f);
    public static final BlockDoraemonFigure DORAEMON_FIGURE = new BlockDoraemonFigure();
    public static final BlockThinkingDesk ZINKIN_DSK=new BlockThinkingDesk();
}
