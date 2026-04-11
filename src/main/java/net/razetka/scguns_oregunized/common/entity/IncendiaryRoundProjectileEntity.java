package net.razetka.scguns_oregunized.common.entity;

import galena.oreganized.index.OEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
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
import top.ribs.scguns.network.message.S2CMessageProjectileHitEntity;
import top.ribs.scguns.util.GunEnchantmentHelper;

public class IncendiaryRoundProjectileEntity extends ProjectileEntity {
    private static final float SHIELD_IGNITE_CHANCE = 0.4f;

    public IncendiaryRoundProjectileEntity(EntityType<? extends Entity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public IncendiaryRoundProjectileEntity(EntityType<? extends Entity> entityType, Level worldIn, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, worldIn, shooter, weapon, item, modifiedGun);
    }

    @Override
    protected void onProjectileTick() {
        if (this.level().isClientSide()) {
            if (this.tickCount % 2 == 0) {
                this.level().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
            if (this.tickCount % 3 == 0) {
                this.level().addParticle(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    @Override
    protected void onHitEntity(Entity entity, Vec3 hitVec, Vec3 startVec, Vec3 endVec, boolean headshot) {
        float damage = this.getDamage();
        float newDamage = this.getCriticalDamage(this.getWeapon(), this.random, damage);
        boolean critical = damage != newDamage;
        damage = newDamage;
        ResourceLocation advantage = this.getProjectile().getAdvantage();
        damage *= advantageMultiplier(entity);

        if (headshot) {
            damage *= Config.COMMON.gameplay.headShotDamageMultiplier.get();
        }

        if (entity instanceof LivingEntity livingTarget) {
            damage = applyProjectileProtection(livingTarget, damage);
        }

        DamageSource source = ModDamageTypes.Sources.projectile(this.level().registryAccess(), this, (LivingEntity) this.getOwner());

        boolean blocked = ProjectileHelper.handleShieldHit(entity, this, damage);

        if (blocked) {
            if (entity instanceof Player player && this.random.nextFloat() < SHIELD_IGNITE_CHANCE) {
                ItemStack shield = player.getUseItem();
                if (shield.getItem() instanceof ShieldItem) {
                    player.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.AIR));
                    player.level().addFreshEntity(new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), shield));
                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRE_AMBIENT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        } else {
            if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(OEffects.STUNNING.get())) {
                damage *= net.razetka.scguns_oregunized.Config.COMMON.incendiaryRoundDamageMultiplier.get();
                spawnParticles(entity, level());
            }
            if (!(entity.getType().is(ModTags.Entities.GHOST) && !advantage.equals(ModTags.Entities.UNDEAD.location()))) {
                entity.hurt(source, damage);
                entity.setSecondsOnFire(5);
            }
        }

        if (entity instanceof LivingEntity) {
            GunEnchantmentHelper.applyElementalPopEffect(this.getWeapon(), (LivingEntity) entity);
        }

        if (this.shooter instanceof Player) {
            int hitType = critical ? S2CMessageProjectileHitEntity.HitType.CRITICAL : headshot ? S2CMessageProjectileHitEntity.HitType.HEADSHOT : S2CMessageProjectileHitEntity.HitType.NORMAL;
            PacketHandler.getPlayChannel().sendToPlayer(() -> (ServerPlayer) this.shooter, new S2CMessageProjectileHitEntity(hitVec.x, hitVec.y, hitVec.z, hitType, entity instanceof Player));
        }
    }

    public static void spawnParticles(Entity entity, Level level) {
        int count = 3;

        if (!entity.level().isClientSide()) {
            for (int i = 0; i < count; ++i) {
                ((ServerLevel)level).sendParticles(ModParticleTypes.LEAD_HIT_PARTICLE.get(),
                        entity.getRandomX(0.75), entity.getRandomY(), entity.getRandomZ(0.75),
                        3, 0, 0, 0,0);
            }
        }
    }
}
