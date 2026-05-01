package net.razetka.scguns_oregunized.common.entity.mobs.archon;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.razetka.scguns_oregunized.init.ModSounds;
import net.razetka.scguns_oregunized.init.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.ribs.scguns.config.EntityEquipmentConfig;
import top.ribs.scguns.entity.ai.AIType;
import top.ribs.scguns.entity.ai.GunAttackGoal;
import top.ribs.scguns.entity.monster.AdjudicatorEntity;
import top.ribs.scguns.entity.monster.SubjugatorEntity;
import top.ribs.scguns.item.GunItem;

public class ArchonEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(ArchonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_TIMEOUT =
            SynchedEntityData.defineId(ArchonEntity.class, EntityDataSerializers.INT);

    public ArchonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private static final UniformInt ALERT_INTERVAL = TimeUtil.rangeOfSeconds(4, 6);
    private int ticksUntilNextAlert;


    protected void registerGoals() {
        ItemStack mainHandItem = this.getMainHandItem();
        boolean hasGun = mainHandItem.getItem() instanceof GunItem;

        if (hasGun) {
            this.goalSelector.addGoal(2, new GunAttackGoal<>(this, this.getMainHandItem(), 1.0F, AIType.DEFAULT, 3));
        }
        else {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false) {
            });
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                if (this.mob.getLastHurtByMob() != null &&
                        this.mob.getLastHurtByMob() instanceof ArchonEntity) {
                    return false;
                }
                return super.canUse();
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true,
                player -> !((Player) player).isCreative() && !player.isSpectator()));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SubjugatorEntity.class , true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AdjudicatorEntity.class, true));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 40.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.ARMOR, 12F)
                .add(Attributes.ARMOR_TOUGHNESS, 6f)
                .add(Attributes.ATTACK_DAMAGE, 4F)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0F)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }



    @Override
    public void handleEntityEvent(byte pId) {
        super.handleEntityEvent(pId);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        EntityEquipmentConfig.equipEntity(this, "scguns_oregunized:archon");
        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(ATTACK_TIMEOUT, 0);
    }

    @Override
    public boolean canHoldItem(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.getEntity() != null && pSource.getEntity().getType().is(ModTags.Entities.STELLAR_ORDER_MOBS)) { //Whacky solution to prevent SO mobs from damaging each other with Shock guns
            return false;
        }
        return super.hurt(pSource, pAmount);
    }

    @Override
    public void tick() {
        if (this.getTarget() != null) {
            this.maybeAlertOthers();
        }
        super.tick();
    }

    private void maybeAlertOthers() {
        if (this.ticksUntilNextAlert > 0) {
            --this.ticksUntilNextAlert;
        } else {
            assert this.getTarget() != null;
            if (this.getSensing().hasLineOfSight(this.getTarget())) {
                this.alertOthers();
            }

            this.ticksUntilNextAlert = ALERT_INTERVAL.sample(this.random);
        }
    }

    private void alertOthers() {
        double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB alertArea = AABB.unitCubeFromLowerCorner(this.position()).inflate(d0, 10.0D, d0);
        this.level().getEntitiesOfClass(Monster.class, alertArea, EntitySelector.NO_SPECTATORS)
                .stream()
                .filter(entity -> entity != this)
                .filter(entity -> entity.getType().is(ModTags.Entities.STELLAR_ORDER_MOBS))
                .filter(entity -> entity.getTarget() == null)
                .filter(entity -> {
                    assert this.getTarget() != null;
                    return !entity.isAlliedTo(this.getTarget());
                })
                .forEach(entity -> entity.setTarget(this.getTarget()));
    }

    @Override
    public boolean canAttack(LivingEntity pTarget) {
        if (pTarget.getType().is(ModTags.Entities.STELLAR_ORDER_MOBS)) {
            return false;
        }
        return super.canAttack(pTarget);
    }

//    @Override
//    public boolean hurt(DamageSource pSource, float pAmount) {
//        if (!this.level().isClientSide()) {
//            assert pSource.getEntity() != null;
//            if (pSource.getEntity().getType().is(ModTags.Entities.STELLAR_ORDER_MOBS)) { // Shitty solution to prevent Stellar Order mobs from damaging each other with Shock guns
//                return false;
//            }
//        }
//        return super.hurt(pSource, pAmount);
//    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if (target != null && target.getType().is(ModTags.Entities.STELLAR_ORDER_MOBS)) {
            return;
        }

        if (this.getTarget() == null && target != null) {
            this.ticksUntilNextAlert = this.random.nextInt(20);
        }
        super.setTarget(target);
    }


    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public int getAttackTimeout() {
        return this.entityData.get(ATTACK_TIMEOUT);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.ARPHILEM_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.ARPHILEM_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ARPHILEM_DEATH.get();
    }
}
