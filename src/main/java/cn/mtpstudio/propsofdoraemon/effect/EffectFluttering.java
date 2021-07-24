package cn.mtpstudio.propsofdoraemon.effect;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectFluttering extends Effect {

    protected EffectFluttering() {
        super(EffectType.NEUTRAL,0x909090FF);
        this.setRegistryName(PropsOfDoraemon.MODID,"fluttering");
    }
}
