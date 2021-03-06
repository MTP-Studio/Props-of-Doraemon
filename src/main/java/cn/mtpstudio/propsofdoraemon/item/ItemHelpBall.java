package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import cn.mtpstudio.propsofdoraemon.utils.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * 救命丸子
 * @author Frank__Wang ShootKing
 */

public class ItemHelpBall extends Item {

    /**
     * 注册救命丸子物品
     * 可食用，食用后不增加饱食度
     * 最大堆叠为16
     */

    public ItemHelpBall() {
        super(new Properties().group(RegistryHandler.itemBar).food(new Food.Builder().fastToEat().setAlwaysEdible().hunger(0).build()).maxStackSize(16));
        this.setRegistryName(PropsOfDoraemon.MODID, "help_ball");
    }

    /**
     * 救命丸子效果
     * 在平面上半径为50的圆中随机取一个点
     * 传送到该点可到达最高的y值
     * @param stack 物品栏
     * @param worldIn 当前所在世界
     * @param entityLiving 当前实体
     * @return Null
     */

    @Override
    @Nonnull
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, World worldIn, @Nonnull LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            // 在平面上半径为50的圆中随机取一个点
            double x = entityLiving.getPosXRandom(50);
            double z = entityLiving.getPosZRandom(50);
            // 获取该点可到达（即为空气方块但上方不为空气方块的）最高的y值
            double y = Utils.getTopY(x, entityLiving.getPosY(), z, entityLiving.world);
            if (entityLiving.isPassenger()) {
                // 如果当前骑在载具或生物上，则使其脱离
                entityLiving.stopRiding();
            }
            // 传送到前面所取的点
            entityLiving.teleportKeepLoaded(x, y, z);
            entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 3));
        }
        if (entityLiving instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) entityLiving, stack);
            ((ServerPlayerEntity) entityLiving).addStat(Stats.ITEM_USED.get(this));
        }
        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
            ((PlayerEntity) entityLiving).getCooldownTracker().setCooldown(this, 1200);
        }
        return stack.isEmpty() ? ItemStack.EMPTY : stack;
    }
}
