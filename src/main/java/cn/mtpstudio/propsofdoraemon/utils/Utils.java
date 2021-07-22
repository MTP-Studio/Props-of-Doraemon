package cn.mtpstudio.propsofdoraemon.utils;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Utils {
    public static double getTopY(double x, double y, double z, World worldIn) {
        BlockPos blockPosOne = new BlockPos(x, y, z);
        BlockPos blockPosTwo = new BlockPos(x, y - 1.0, z);
        if (!(worldIn.getBlockState(blockPosOne).getBlock() == Blocks.AIR)) {
            return getTopY(x, (int) y + 1, z, worldIn);
        } else if (worldIn.getBlockState(blockPosTwo).getBlock() == Blocks.AIR) {
            return getTopY(x, (int) y - 1, z, worldIn);
        }
        return y;
    }
}
