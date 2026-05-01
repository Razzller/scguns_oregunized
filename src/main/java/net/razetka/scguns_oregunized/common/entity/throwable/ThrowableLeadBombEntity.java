package net.razetka.scguns_oregunized.common.entity.throwable;

import galena.oreganized.OreganizedConfig;
import galena.oreganized.api.LeadProtections;
import galena.oreganized.index.OEffects;
import galena.oreganized.index.OParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.razetka.scguns_oregunized.init.ModEntities;
import net.razetka.scguns_oregunized.init.ModItems;
import top.ribs.scguns.entity.throwable.ThrowableGrenadeEntity;
import top.ribs.scguns.entity.throwable.ThrowableItemEntity;

public class ThrowableLeadBombEntity extends ThrowableGrenadeEntity {
    public ThrowableLeadBombEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public ThrowableLeadBombEntity(Level world, LivingEntity player, int maxCookTime) {
        super(ModEntities.THROWABLE_LEAD_BOMB.get(), world, player);
        this.setItem(new ItemStack(ModItems.LEAD_BOMB.get()));
        this.setMaxLife(maxCookTime);
        this.setShouldBounce(true);
    }

    @Override
    public void onDeath() {

        this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 3.0F, Level.ExplosionInteraction.NONE);
        if (!this.level().isClientSide()) ((ServerLevel)this.level()).sendParticles(OParticleTypes.LEAD_SHRAPNEL.get(),
                this.getX(), this.getY(0.0625D) , this.getZ(), 100, 0.0D, 0.0D, 0.0D, 5);
        for (Entity entity : this.level().getEntities(this, new AABB(this.getX() - 30, this.getY() - 4, this.getZ() - 30,
                this.getX() + 30, this.getY() + 4, this.getZ() + 30))) {
            int random = (int) (Math.random() * 100);
            boolean shouldPoison = false;
            if (entity.distanceToSqr(this) <= 16) {
                shouldPoison = true;
            } else if (entity.distanceToSqr(this) <= 64) {
                if(random < 60) shouldPoison = true;
            } else if (entity.distanceToSqr(this) <= 225) {
                if (random < 30) shouldPoison = true;
            } else if (entity.distanceToSqr(this) <= 900) {
                if (random < 5) shouldPoison = true;
            }
            if (shouldPoison && entity instanceof LivingEntity living) {
                if (LeadProtections.isNotProtected(living)) {
                    living.addEffect(new MobEffectInstance(MobEffects.POISON, 260));
                    if (!OreganizedConfig.COMMON.poisonInsteadOfStunning.get()) {
                        living.addEffect(new MobEffectInstance(OEffects.STUNNING.get(), 800));
                    }
                }
            }
        }
    }
}
