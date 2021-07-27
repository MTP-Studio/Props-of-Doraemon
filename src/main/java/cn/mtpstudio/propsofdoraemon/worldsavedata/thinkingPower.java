package cn.mtpstudio.propsofdoraemon.worldsavedata;

import cn.mtpstudio.propsofdoraemon.NetworkPacket;
import cn.mtpstudio.propsofdoraemon.SendPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class thinkingPower extends WorldSavedData {
    Map<String,Integer> thinkingPowers=new HashMap<>();
    public thinkingPower(){
        super("thinkingPower");
    }
    @Override
    public void read(CompoundNBT nbt) {
        ListNBT ln= (ListNBT) nbt.get("list");
        for(INBT net:ln){
            CompoundNBT nbbt = (CompoundNBT) net;
            thinkingPowers.put(nbbt.getString("player"),nbbt.getInt("pno"));
        }
    }
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT nbt=new ListNBT();
        for(Map.Entry<String,Integer> entry:thinkingPowers.entrySet()){
            CompoundNBT nbt1=new CompoundNBT();
            nbt1.putInt("pno",entry.getValue());
            nbt1.putString("player",entry.getKey());
            nbt.add(nbt1);
        }
        compound.put("list",nbt);
        return compound;
    }
    public int getPlayerTP(String uuid){
        return thinkingPowers.getOrDefault(uuid,500);
    }
    public int getPlayerTP(UUID uuid){
        return getPlayerTP(uuid.toString());
    }
    public int getPlayerTP(PlayerEntity player){
        return getPlayerTP(player.getUniqueID());
    }
    public void put(PlayerEntity p,int pno){
        thinkingPowers.put(p.getUniqueID().toString(),pno);
        NetworkPacket.INSTANCE.send(
                PacketDistributor.PLAYER.with(
                        () -> {
                            return (ServerPlayerEntity) p;
                        }
                ),new SendPack(pno+"")
        );
        markDirty();
    }

    public static thinkingPower get(World worldIn) {
        if (worldIn instanceof ServerWorld) {

        ServerWorld world = worldIn.getServer().getWorld(World.OVERWORLD);
        DimensionSavedDataManager storage = world.getSavedData();
        return storage.getOrCreate(() -> {
            return new thinkingPower();
        }, "thinkingPower");
        }else{
            return null;
        }
    }


}
