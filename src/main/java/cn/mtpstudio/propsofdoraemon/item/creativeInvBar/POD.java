package cn.mtpstudio.propsofdoraemon.item.creativeInvBar;

import cn.mtpstudio.propsofdoraemon.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class POD extends ItemGroup {
    public POD() {
        super("Props-of-Doraemon");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.Item_TD,1);
    }
}
