package cn.mtpstudio.propsofdoraemon.block.tileEntity;

import cn.mtpstudio.propsofdoraemon.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.Random;

public class BTDTileEntity extends TileEntity {
    public int prob = 1;
    public static TileEntityType<BTDTileEntity> type=
            (TileEntityType<BTDTileEntity>) TileEntityType.Builder.create(()->{return new BTDTileEntity();},
                    Blocks.ZINKIN_DSK).build(null).setRegistryName(Blocks.ZINKIN_DSK.getRegistryName());
    public BTDTileEntity() {
        super(type);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        prob=nbt.getInt("prob");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("prob",prob);
        return compound;
    }
}
