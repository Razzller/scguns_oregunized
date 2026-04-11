package net.razetka.scguns_oregunized.common.entity;

import galena.oreganized.index.OEffects;
import galena.oreganized.index.OParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.razetka.scguns_oregunized.init.ModParticleTypes;
import top.ribs.scguns.Config;
import top.ribs.scguns.common.Gun;
import top.ribs.scguns.entity.projectile.ProjectileEntity;
import top.ribs.scguns.init.ModDamageTypes;
import top.ribs.scguns.init.ModTags;
import top.ribs.scguns.item.GunItem;
import top.ribs.scguns.network.PacketHandler;
import top.ribs.scguns.network.message.S2CMessageBlood;
import top.ribs.scguns.network.message.S2CMessageProjectileHitEntity;
import top.ribs.scguns.util.GunEnchantmentHelper;

public class LeadRoundProjectileEntity extends ProjectileEntity {
    public LeadRoundProjectileEntity(EntityType<? extends Entity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public LeadRoundProjectileEntity(EntityType<? extends Entity> entityType, Level worldIn, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, worldIn, shooter, weapon, item, modifiedGun);
    }

    @Override
    protected void onHitEntity(Entity entity, Vec3 hitVec, Vec3 startVec, Vec3 endVec, boolean headshot) {
        float damage = this.getDamage();
        float newDamage = this.getCriticalDamage(this.getWeapon(), this.random, damage);
        boolean critical = damage != newDamage;
        damage = newDamage;
        damage *= advantageMultiplier(entity);
        boolean wasAlive = entity instanceof LivingEntity && entity.isAlive();
        if (this.shooter instanceof Player player) {
            damage = GunEnchantmentHelper.getWaterProofDamage(this.getWeapon(), player, damage);
        }
        if (headshot) {
            damage *= Config.COMMON.gameplay.headShotDamageMultiplier.get();
        }
        if (entity instanceof LivingEntity livingTarget) {
            damage = GunEnchantmentHelper.getPuncturingDamageReduction(this.getWeapon(), livingTarget, damage);
            damage = applyProjectileProtection(livingTarget, damage);
            damage = calculateArmorBypassDamage(livingTarget, damage);
        }

        DamageSource source = ModDamageTypes.Sources.projectile(this.level().registryAccess(), this, this.shooter);
        boolean blocked = ProjectileHelper.handleShieldHit(entity, this, damage);

        if (!blocked) {
            if (!(entity.getType().is(ModTags.Entities.GHOST) &&
                    !this.getProjectile().getAdvantage().equals(ModTags.Entities.UNDEAD.location()))) {
                if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(OEffects.STUNNING.get())) {
                    damage *= net.razetka.scguns_oregunized.Config.COMMON.leadRoundDamageMultiplier.get();
                    spawnParticles(entity, this.level());
                }
                if (damage > 0) {
                    entity.hurt(source, damage);
                }
                if (entity instanceof LivingEntity livingEntity) {
                    entity.invulnerableTime = 0;
                    ResourceLocation effectLocation = this.projectile.getImpactEffect();
                    if (effectLocation != null) {
                        float effectChance = this.projectile.getImpactEffectChance();
                        if (this.random.nextFloat() < effectChance) {
                            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(effectLocation);
                            if (effect != null) {
                                livingEntity.addEffect(new MobEffectInstance(
                                        effect,
                                        this.projectile.getImpactEffectDuration(),
                                        this.projectile.getImpactEffectAmplifier()
                                ));
                            }
                        }
                    }
                }
            }
        }

        if (entity instanceof LivingEntity) {
            GunEnchantmentHelper.applyElementalPopEffect(this.getWeapon(), (LivingEntity) entity);
        }

        if (this.shooter instanceof Player) {
            int hitType = critical ? S2CMessageProjectileHitEntity.HitType.CRITICAL : headshot ? S2CMessageProjectileHitEntity.HitType.HEADSHOT : S2CMessageProjectileHitEntity.HitType.NORMAL;
            PacketHandler.getPlayChannel().sendToPlayer(() -> (ServerPlayer) this.shooter, new S2CMessageProjectileHitEntity(hitVec.x, hitVec.y, hitVec.z, hitType, entity instanceof Player));
        }
        PacketHandler.getPlayChannel().sendToTracking(() -> entity, new S2CMessageBlood(hitVec.x, hitVec.y, hitVec.z, entity.getType()));

    }

    public void spawnParticles(Entity entity, Level level) {
        int count = 3;

//        if (!entity.level().isClientSide()) {
//            for (int i = 0; i < count; i++) {
//                entity.level().addParticle(
//                        ModParticleTypes.LEAD_HIT_PARTICLE.get(),
//                        entity.getRandomX(0.75), entity.getRandomY(), entity.getRandomZ(0.75),
//                        0, 0, 0);
//            }
//        }

        if (!entity.level().isClientSide()) {
            for (int i = 0; i < count; ++i) {
                ((ServerLevel)level).sendParticles(ModParticleTypes.LEAD_HIT_PARTICLE.get(),
                        entity.getRandomX(0.75), entity.getRandomY(), entity.getRandomZ(0.75),
                        3, 0, 0, 0,0);
            }
        }
    }
}
