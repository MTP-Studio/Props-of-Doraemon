package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
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

public class ItemHelpBall extends Item {
    public ItemHelpBall() {
        super(new Properties().food(new Food.Builder().fastToEat().setAlwaysEdible().hunger(0).build()).maxStackSize(16));
        this.setRegistryName(PropsOfDoraemon.MODID, "help_ball");
    }

    @Override
    @Nonnull
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, World worldIn, @Nonnull LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            double x = entityLiving.getPosXRandom(50);
            double z = entityLiving.getPosZRandom(50);
            double y = Utils.getTopY(x, entityLiving.getPosY(), z, entityLiving.world);
            if (entityLiving.isPassenger()) {
                entityLiving.stopRiding();
            }
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
