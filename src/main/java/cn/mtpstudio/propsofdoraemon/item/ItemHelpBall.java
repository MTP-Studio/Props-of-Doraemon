package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
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
import net.minecraft.util.math.MathHelper;
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
            for (int i = 0; i < 16; ++i) {
                double x = entityLiving.getPosX() + (entityLiving.getRNG().nextDouble() - 0.5D) * 50.0D;
                double y = MathHelper.clamp(entityLiving.getPosY() + (double) (entityLiving.getRNG().nextInt(16) - 8), 0.0D, worldIn.func_234938_ad_() - 1);
                double z = entityLiving.getPosZ() + (entityLiving.getRNG().nextDouble() - 0.5D) * 50.0D;
                if (entityLiving.isPassenger()) {
                    entityLiving.stopRiding();
                }
                if (entityLiving.attemptTeleport(x, y, z, true)) {
                    entityLiving.teleportKeepLoaded(x, y, z);
                    break;
                }
            }
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
