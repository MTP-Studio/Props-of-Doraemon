package cn.mtpstudio.propsofdoraemon.utils;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Utils工具包
 */

public class Utils {

    /**
     * @param x 当前的x坐标
     * @param y 当前的y坐标
     * @param z 当前的z坐标
     * @param worldIn 当前所在的世界
     * @return 返回当前坐标中可到达（即为空气方块但上方不为空气方块的）最高的y值
     */

    public static double getTopY(double x, double y, double z, World worldIn) {
        BlockPos blockPosOne = new BlockPos(x, y, z);
        BlockPos blockPosTwo = new BlockPos(x, y - 1.0, z);
        if (!worldIn.chunkExists(blockPosOne.getX() >> 4, blockPosOne.getZ() >> 4)) {
            // 异常处理，如果当前区块未加载
            return y;
        }
        if (worldIn.getBlockState(blockPosOne).getBlock() != Blocks.AIR) {
            return getTopY(x, (int) y + 1, z, worldIn);
        } else if (worldIn.getBlockState(blockPosTwo).getBlock() == Blocks.AIR) {
            return getTopY(x, (int) y - 1, z, worldIn);
        }
        return y;
    }
}
