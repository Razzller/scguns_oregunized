package net.razetka.scguns_oregunized.common.entity.throwable;

import galena.oreganized.OreganizedConfig;
import galena.oreganized.api.LeadProtections;
import galena.oreganized.index.OEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.razetka.scguns_oregunized.init.ModEffects;
import net.razetka.scguns_oregunized.init.ModEntities;
import net.razetka.scguns_oregunized.init.ModItems;
import top.ribs.scguns.entity.throwable.ThrowableGrenadeEntity;
import top.ribs.scguns.entity.throwable.ThrowableItemEntity;

public class ThrowableESDGrenadeEntity extends ThrowableGrenadeEntity {

    public ThrowableESDGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public ThrowableESDGrenadeEntity(Level world, LivingEntity player, int maxCookTime) {
        super(ModEntities.THROWABLE_ESD_GRENADE.get(), world, player);
        this.setItem(new ItemStack(ModItems.ESD_GRENADE.get()));
        this.setMaxLife(maxCookTime);
        this.setShouldBounce(true);
    }

    @Override
    public void onDeath() {
        if (!this.level().isClientSide()) {
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.ELECTRIC_SPARK,
                    this.getX(), this.getY(0.0625), this.getZ(), 100, 0.0D, 0.0D, 0.0D, 6);
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.END_ROD,
                    this.getX(), this.getY(0.0625), this.getZ(), 50, 0.0D, 0.0D, 0.0D, 3);
        }
        level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.BLOCKS, 3, 1.2F);
        for (Entity entity : this.level().getEntities(this, new AABB(this.getX() - 6, this.getY() - 4, this.getZ() - 6,
                this.getX() + 6, this.getY() + 4, this.getZ() + 6))) {
            float maxDamage = 30;
            if (entity instanceof LivingEntity living) {
                living.hurt(living.damageSources().lightningBolt(), Math.min(maxDamage,
                        maxDamage * 3 / entity.distanceTo(this))); //Damage falloff relative to the entity distance
                living.addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED.get(),
                        (int) Math.min(600, 600 * 3 / entity.distanceTo(this)))); //Duration falloff
            }
        }
    }
}