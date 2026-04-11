package net.razetka.scguns_oregunized.common.item;

import galena.oreganized.index.OEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.razetka.scguns_oregunized.common.ModTags;
import net.razetka.scguns_oregunized.init.ModTiers;

import javax.annotation.Nullable;
import java.util.List;

public class SledgehammerItem extends DiggerItem {
    private final String tooltipKey;

    public SledgehammerItem(Item.Properties pProperties, String tooltipKey) {
        super(9, -3.3F, ModTiers.SLEDGEHAMMER, ModTags.MINEABLE_SLEDGEHAMMER, pProperties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide) {
            float attackcooldown = attacker instanceof Player player ? player.getAttackStrengthScale(0.5f) : 1.0F;
            boolean isCharged = attackcooldown > 0.9f;

            if (attacker instanceof Player player && isCharged && attacker.fallDistance > 0 && !((Player) attacker).getCooldowns().isOnCooldown(this)) {
                performAttack(attacker, target);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    public void performAttack(LivingEntity attacker, LivingEntity target) {
        target.addEffect(new MobEffectInstance(OEffects.STUNNING.get(), 600, 0, true, true));
        //target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 0, true, true));

        if (attacker instanceof Player player) {
            ((Player) attacker).getCooldowns().addCooldown(this, 200);
        }

        ServerLevel level = (ServerLevel) attacker.level();
        if (!level.isClientSide) {
            playExplosionSound(level, target);
        }
    }

    private void playExplosionSound(Level world, LivingEntity target) {
        float pitch = (0.8F + world.random.nextFloat() * 0.4F);

        world.playSound(null, target.getX(), target.getY(), target.getZ(),
                SoundEvents.ANVIL_FALL, SoundSource.PLAYERS, 1.2F, pitch);
        //TODO fix the sound!
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
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return false;
    }
}
