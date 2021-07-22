package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.model.BambooCopterModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ItemBambooCopter extends ArmorItem {

    public ResourceLocation textures = new ResourceLocation(PropsOfDoraemon.MODID, "textures/models/armor/bamboo_copter.png");

    public ItemBambooCopter() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties());
        this.setRegistryName(PropsOfDoraemon.MODID, "bamboo_copter");
    }

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <T extends BipedModel<?>> T getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, T _default) {
        return (T) new BambooCopterModel();
    }

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return this.textures.toString();
    }


}
