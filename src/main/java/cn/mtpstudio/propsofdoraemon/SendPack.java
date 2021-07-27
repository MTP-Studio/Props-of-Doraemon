package cn.mtpstudio.propsofdoraemon;

import cn.mtpstudio.propsofdoraemon.client.Power.transPower;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;


public class SendPack {
    private String message;

    public SendPack(PacketBuffer buffer) {
        message = buffer.readString(Short.MAX_VALUE);
    }

    public SendPack(String message) {
        this.message = message;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeString(this.message);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            transPower.transPower=Integer.parseInt(message);
        });
        ctx.get().setPacketHandled(true);
    }
}
