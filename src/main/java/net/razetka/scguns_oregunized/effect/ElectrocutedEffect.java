package net.razetka.scguns_oregunized.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.razetka.scguns_oregunized.init.ModParticleTypes;

public class ElectrocutedEffect extends MobEffect {
    public ElectrocutedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "d8d6b257-820d-4268-9994-c70f0e9feb1f", -0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ARMOR, "d8d6b257-820d-4268-9994-c70f0e9feb1f", -4, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        int particleCount = 3;
        if (!livingEntity.level().isClientSide()) {
            if (livingEntity.tickCount % 40 == 0) {
                livingEntity.hurt(livingEntity.damageSources().lightningBolt(), 2.0F);
            }
        }
        else {
            for (int i = 0; i < particleCount; i++) {
                livingEntity.level().addParticle(ModParticleTypes.ELECTRICITY_PARTICLE.get(),
                        livingEntity.getRandomX(0.75), livingEntity.getRandomY(), livingEntity.getRandomZ(0.75),
                        0.2, 0.2,0.2);
            }
        }
    }
}
