package cn.mtpstudio.propsofdoraemon.item;

import cn.mtpstudio.propsofdoraemon.PropsOfDoraemon;
import cn.mtpstudio.propsofdoraemon.model.BambooCopterModel;
import cn.mtpstudio.propsofdoraemon.register.RegistryHandler;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

/**
 * 竹蜻蜓
 * @author Frank__Wang ShootKing
 */

public class ItemBambooCopter extends ArmorItem {

    /** 添加竹蜻蜓材质 */
    public ResourceLocation textures = new ResourceLocation(PropsOfDoraemon.MODID, "textures/models/armor/bamboo_copter.png");
    /** 添加飞行的竹蜻蜓材质 */
    public ResourceLocation flying_textures = new ResourceLocation(PropsOfDoraemon.MODID, "textures/models/armor/bamboo_copter_flying.png");

    /**
     * 注册竹蜻蜓物品
     * 可以戴在头上
     */

    public ItemBambooCopter() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().group(RegistryHandler.itemBar));
        this.setRegistryName(PropsOfDoraemon.MODID, "bamboo_copter");
    }

    /**
     * 竹蜻蜓模型
     * @param entityLiving 实体
     * @param itemStack 物品栏
     * @param armorSlot 装备栏
     * @return 竹蜻蜓模型
     */

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <T extends BipedModel<?>> T getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, T _default) {
        return (T) new BambooCopterModel();
    }

    /**
     * 飞行竹蜻蜓模型
     * @param stack 物品栏
     * @param slot 装备栏槽位
     * @return 竹蜻蜓贴图
     */

    @Override
    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if (!(entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.isFlying)) {
            return textures.toString();
        }
        return flying_textures.toString();
    }
}
