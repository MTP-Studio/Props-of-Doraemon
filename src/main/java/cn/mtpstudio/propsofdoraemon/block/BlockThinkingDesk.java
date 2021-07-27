package cn.mtpstudio.propsofdoraemon.block;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.block.tileEntity.BTDTileEntity;
import cn.mtpstudio.propsofdoraemon.worldsavedata.thinkingPower;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

public class BlockThinkingDesk extends Block {
    public BlockThinkingDesk() {
        super(Blocks.machine);
        this.setRegistryName(PropsOfDoraemon.MODID,"transblock");
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BTDTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            BTDTileEntity tile = (BTDTileEntity) worldIn.getTileEntity(pos);
            if (player.getHeldItem(Hand.MAIN_HAND).getItem().equals(Items.PAPER)) {
                thinkingPower power = thinkingPower.get(worldIn);
                power.put(player, power.getPlayerTP(player) - 75);
                String[] cat = {"banboo_copter", "empty_teapot", "adventure_tea", "fluttering_medicine", "help_ball"};
                Random random = new Random();
                ItemStack stack = new ItemStack(cn.mtpstudio.propsofdoraemon.item.Items.IDEA, 1);
                stack.getOrCreateTag().putString("itemType", cat[random.nextInt() % 5]);
                player.setHeldItem(Hand.MAIN_HAND, stack);
            } else if (player.getHeldItem(Hand.MAIN_HAND).getItem().equals(cn.mtpstudio.propsofdoraemon.item.Items.IDEA)) {
                if (tile.prob == 0) {
                    worldIn.setBlockState(pos, net.minecraft.block.Blocks.AIR.getDefaultState());
                } else {
                    tile.prob--;
                    tile.markDirty();
                }
                player.setHeldItem(Hand.MAIN_HAND, new ItemStack(cn.mtpstudio.propsofdoraemon.item.Items.MOD_ITEMS.getOrDefault(
                        player.getHeldItem(Hand.MAIN_HAND).getTag().getString("itemType"), Items.AIR
                )));
                return ActionResultType.SUCCESS;
            } else if (player.getHeldItem(Hand.MAIN_HAND).isEmpty()) {
                player.sendMessage(new StringTextComponent("能量剩" + tile.prob), UUID.randomUUID());
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.PASS;
    }
}
