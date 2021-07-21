package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.effect.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemFilledTeapot extends Item {

    public ItemFilledTeapot() {
        super(new Properties().maxStackSize(1));
        this.setRegistryName(PropsOfDoraemon.MODID, "filled_teapot");
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 32;
    }

    @Override
    @Nonnull
    public UseAction getUseAction(@Nonnull ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    @Nonnull
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull LivingEntity entityLiving) {
        entityLiving.addPotionEffect(new EffectInstance(Effects.EFFECT_ADVENTURE));
        // TODO 完成喝完茶后的逻辑 (参考net.minecraft.item.PotionItem#onItemUseFinish)
        return new ItemStack(Items.EMPTY_TEAPOT);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {
        return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
    }
}
