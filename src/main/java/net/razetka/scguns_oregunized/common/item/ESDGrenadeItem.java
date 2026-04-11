package net.razetka.scguns_oregunized.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.razetka.scguns_oregunized.common.entity.throwable.ThrowableESDGrenadeEntity;
import net.razetka.scguns_oregunized.common.entity.throwable.ThrowableLeadBombEntity;
import top.ribs.scguns.entity.throwable.ThrowableGrenadeEntity;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.GrenadeItem;

import javax.annotation.Nullable;
import java.util.List;

public class ESDGrenadeItem extends GrenadeItem {
    public ESDGrenadeItem(Properties properties, int maxCookTime) {
        super(properties, maxCookTime);
    }

    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return new ThrowableESDGrenadeEntity(world, entity, 60);
        }



    @Override
    public boolean canCook() { return false; }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
}
