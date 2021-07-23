package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * 冒险茶
 * @author ShootKing
 */

public class ItemAdventureTea extends Item {

    /**
     * 注册冒险茶物品
     * 不可堆叠
     */

    public ItemAdventureTea() {
        super(new Properties().maxStackSize(1));
        this.setRegistryName(PropsOfDoraemon.MODID, "adventure_tea");
    }

    /**
     * 获取持续时间
     * @param stack 物品栏
     * @return 32
     */

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 32;
    }

    /**
     * 获取使用时的动作
     * @param stack 物品栏
     * @return 饮用
     */

    @Override
    @Nonnull
    public UseAction getUseAction(@Nonnull ItemStack stack) {
        return UseAction.DRINK;
    }

    /**
     * 当喝完之后
     * @param stack 物品栏
     * @param worldIn 当前所在世界
     * @return 物品栏为空则返回空茶杯，否则不变
     */

    @Override
    @Nonnull
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(Effects.EFFECT_ADVENTURE));
        }
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.addStat(Stats.ITEM_USED.get(this));
        }
        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }
        return stack.isEmpty() ? new ItemStack(Items.EMPTY_TEAPOT) : stack;
    }

    /**
     * 动作的结果
     * @param worldIn 当前所在世界
     * @param playerIn 玩家实体
     * @param handIn 手上所持物品
     * @return 开始饮用
     */

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
    }
}
