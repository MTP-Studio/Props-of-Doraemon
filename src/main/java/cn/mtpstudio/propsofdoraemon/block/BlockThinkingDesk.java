package cn.mtpstudio.propsofdoraemon.block;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockThinkingDesk extends Block {
    public BlockThinkingDesk() {
        super(Blocks.machine);
        this.setRegistryName(PropsOfDoraemon.MODID,"TransBlock");
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        return ActionResultType.SUCCESS;
    }
}
