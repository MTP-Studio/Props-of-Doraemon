package cn.mtpstudio.propsofdoraemon.mixins;

import cn.mtpstudio.propsofdoraemon.item.ItemBambooCopter;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlayerListItemPacket;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.world.GameType;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInteractionManager.class)
public class PlayerInteractionManagerMixin {
    @Shadow
    public ServerPlayerEntity player;
    @Shadow
    public ServerWorld world;
    @Shadow
    private GameType field_241813_e_;
    @Shadow
    private GameType gameType;

    /**
     * @author ShootKing
     * @reason 修复从创造模式切换到生存时竹蜻蜓失效
     */
    @Overwrite
    public void func_241820_a(GameType newGameType, GameType oldGameType) {
        this.field_241813_e_ = oldGameType;
        this.gameType = newGameType;
        if (!(newGameType.isSurvivalOrAdventure() && oldGameType.isCreative() && this.player.inventory.armorInventory.get(3).getItem() instanceof ItemBambooCopter))
            newGameType.configurePlayerCapabilities(this.player.abilities);
        else {
            this.player.abilities.isCreativeMode = false;
            this.player.abilities.disableDamage = false;
            this.player.abilities.allowEdit = !newGameType.hasLimitedInteractions();
        }
        this.player.sendPlayerAbilities();
        this.player.server.getPlayerList().sendPacketToAllPlayers(new SPlayerListItemPacket(SPlayerListItemPacket.Action.UPDATE_GAME_MODE, this.player));
        this.world.updateAllPlayersSleepingFlag();
    }
}
