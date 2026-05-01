package net.razetka.scguns_oregunized.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;
import net.razetka.scguns_oregunized.common.entity.ThrowingClubEntity;

public class ThrowingClubItem extends Item {
    public ThrowingClubItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        float pitch = 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, pitch);
        pPlayer.getCooldowns().addCooldown(itemstack.getItem(), 10);
        if (!pLevel.isClientSide()) {
            ThrowingClubEntity throwingClub = new ThrowingClubEntity(pLevel, pPlayer);
            throwingClub.setItem(itemstack);
            throwingClub.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(),  0.0F, 1.2F, 1.0F);
            pLevel.addFreshEntity(throwingClub);
        }
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
