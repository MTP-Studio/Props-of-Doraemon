package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class ItemHelpBall extends Item {
    public ItemHelpBall() {
        super(new Properties().food(new Food.Builder().fastToEat().hunger(0).build()).maxStackSize(16));
        this.setRegistryName(PropsOfDoraemon.MODID,"help_ball");
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote){
            double x = entityLiving.getPosXRandom(75),y = entityLiving.getPosYRandom(),z = entityLiving.getPosZRandom(75);
            entityLiving.teleportKeepLoaded(x,y,z);
        }
        if (entityLiving instanceof ServerPlayerEntity){
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) entityLiving,stack);
            ((ServerPlayerEntity)entityLiving).addStat(Stats.ITEM_USED.get(this));
        }
        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }
        return stack.isEmpty() ? new ItemStack(Items.AIR) : stack;
    }
}
