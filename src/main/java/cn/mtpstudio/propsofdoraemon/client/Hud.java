package cn.mtpstudio.propsofdoraemon.client;

import cn.mtpstudio.propsofdoraemon.client.Power.transPower;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;

public class Hud extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;

    public Hud() {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
    }

    public void render() {
        //RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawString(new MatrixStack(),Minecraft.getInstance().fontRenderer, "想象力:"+ transPower.transPower, width/4, height/4+10, 0x33a1c9);
        //blit(width / 2 - 16, height / 2 - 64, 0, 0, 32, 32, 32, 32);
    }
}
