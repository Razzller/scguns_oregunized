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
import net.razetka.scguns_oregunized.init.ModParticleTypes;
import net.razetka.scguns_oregunized.init.ModTiers;

import javax.annotation.Nullable;
import java.util.List;

import static net.razetka.scguns_oregunized.common.entity.LeadRoundProjectileEntity.spawnParticles;

public class SledgehammerItem extends DiggerItem {
    private final String tooltipKey;

    public SledgehammerItem(Item.Properties pProperties, String tooltipKey) {
        super(10, -3.3F, ModTiers.SLEDGEHAMMER, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
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

        if (attacker instanceof Player player) {
            player.getCooldowns().addCooldown(this, 200);
        }

        ServerLevel level = (ServerLevel) attacker.level();
        playSoundSpawnParticles(level, target);
    }

    private void playSoundSpawnParticles(ServerLevel world, LivingEntity target) {
        float pitch = (0.8F + world.random.nextFloat() * 0.4F);
        if (!target.level().isClientSide()) {
            world.playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.2F, pitch);

            spawnParticles(target, world);
        }
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
}
