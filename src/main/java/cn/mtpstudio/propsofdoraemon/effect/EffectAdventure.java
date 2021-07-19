package cn.mtpstudio.propsofdoraemon.effect;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectAdventure extends Effect {
    public EffectAdventure() {
        super(EffectType.HARMFUL, 0x000000F);
        this.setRegistryName(PropsOfDoraemon.MODID,"adventure");
    }
}
