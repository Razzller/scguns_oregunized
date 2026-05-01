package net.razetka.scguns_oregunized.common.entity;

import galena.oreganized.index.OEffects;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.razetka.scguns_oregunized.Config;
import net.razetka.scguns_oregunized.init.ModEntities;
import net.razetka.scguns_oregunized.init.ModItems;
import net.razetka.scguns_oregunized.Config;

public class ThrowingClubEntity extends ThrowableItemProjectile {
    public ThrowingClubEntity(EntityType<? extends ThrowingClubEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrowingClubEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.THROWING_CLUB.get(), pShooter, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWING_CLUB.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), Config.COMMON.mauviteClubDamage.get());
        entity.addEffect(new MobEffectInstance(OEffects.STUNNING.get(), Config.COMMON.mauviteClubEffectDuration.get(), 0, true, true));
        entity.knockback(Config.COMMON.mauviteClubKnocbackMultiplier.get(), -Mth.sin(getYRot() *  Mth.DEG_TO_RAD), -Mth.cos(getYRot() * Mth.DEG_TO_RAD));
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        ItemEntity itemEntity = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(ModItems.THROWING_CLUB.get()));
        itemEntity.setPickUpDelay(10);
        level().addFreshEntity(itemEntity);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }
}
