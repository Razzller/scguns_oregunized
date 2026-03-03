package net.razetka.scguns_oregunized.common.item;

import galena.oreganized.index.OEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;

public class SledgehammerItem extends PickaxeItem {

    public SledgehammerItem(Properties properties) {
        super(Tiers.IRON, 7, -3.3f, properties);
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
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 0, true, true));

        if (attacker instanceof Player player) {
            ((Player) attacker).getCooldowns().addCooldown(this, 200);
        }
        attacker.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                SoundEvents.ANVIL_FALL, attacker.getSoundSource(),
                1.2F, 0.8F + attacker.getRandom().nextFloat() * 0.4F);
    }
}
