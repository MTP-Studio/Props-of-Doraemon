package cn.mtpstudio.propsofdoraemon.item;
import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ItemBambooCopter extends ArmorItem {

    public ResourceLocation textures = new ResourceLocation(PropsOfDoraemon.MODID,"textures/models/armor/bamboo_copter.png");

    public ItemBambooCopter() {
		super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD,new Properties());
		this.setRegistryName(PropsOfDoraemon.MODID,"bamboo_copter");
    }

    //模型出了点问题，这个先注释掉，等屑寒霜问大佬
    /*@Nullable
    @Override
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A)new BambooCopterModel();
    }*/

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return this.textures.toString();
    }



}
