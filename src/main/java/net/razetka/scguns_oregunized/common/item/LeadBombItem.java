package net.razetka.scguns_oregunized.common.item;

import galena.oreganized.content.entity.LeadBoltEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.razetka.scguns_oregunized.common.entity.throwable.ThrowableLeadBombEntity;
import top.ribs.scguns.entity.throwable.ThrowableGrenadeEntity;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.GrenadeItem;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;
import java.util.List;
import java.awt.*;

public class LeadBombItem extends GrenadeItem {
    private final String tooltipKey;

    public LeadBombItem(Properties properties, int maxCookTime, String tooltipKey) {
        super(properties, maxCookTime);
        this.tooltipKey = tooltipKey;
    }

    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return new ThrowableLeadBombEntity(world, entity, (int)(Math.random() * 60 + 20)); //Random fuse between 20 and 80 ticks
        //Math.random() generates a random number between 0 and 1, multiply it to 60 to get between 0 and 60, add 20 to get between 20 and 80
        }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (tooltip != null && !tooltipKey.isEmpty()) {
            tooltip.add(Component.translatable(tooltipKey)
                    .withStyle(ChatFormatting.GRAY)
                    .withStyle(ChatFormatting.ITALIC));
        }
    super.appendHoverText(stack, level, tooltip, flag);
    }

    @Override
    public boolean canCook() { return false; }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {

        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
}
