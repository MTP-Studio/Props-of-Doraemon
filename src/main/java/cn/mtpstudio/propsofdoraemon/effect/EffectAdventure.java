package cn.mtpstudio.propsofdoraemon.effect;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

/**
 * 冒险茶效果
 * @author Frank__Wang
 * @see cn.mtpstudio.propsofdoraemon.event.EventHandler
 */

public class EffectAdventure extends Effect {

    /**
     * 注册冒险茶效果
     */

    public EffectAdventure() {
        super(EffectType.HARMFUL, 0x000000F);
        this.setRegistryName(PropsOfDoraemon.MODID,"adventure");
    }
}
