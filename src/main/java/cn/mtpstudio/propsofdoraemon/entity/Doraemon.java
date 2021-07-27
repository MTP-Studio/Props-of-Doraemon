package cn.mtpstudio.propsofdoraemon.entity;

import cn.mtpstudio.propsofdoraemon.item.Items;
import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;

public class Doraemon extends AnimalEntity {
    public Doraemon(EntityType<Doraemon> type, World worldIn) {
        super(type, worldIn);
        this.setCustomName(new StringTextComponent("哆啦a梦"));
        this.goalSelector.addGoal(0,new AvoidEntityGoal<PlayerEntity>(this,PlayerEntity.class,5,1,2));
    }

    @Override
    protected void dropLoot(DamageSource damageSourceIn, boolean attackedRecently) {
        ItemStack stack=new ItemStack(Items.Item_TD,1);
        entityDropItem(stack,1);
        super.dropLoot(damageSourceIn,attackedRecently);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return null;
    }
}
