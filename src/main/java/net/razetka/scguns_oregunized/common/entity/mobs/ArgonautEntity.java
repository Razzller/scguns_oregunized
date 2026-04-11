package net.razetka.scguns_oregunized.common.entity.mobs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.ribs.scguns.config.EntityEquipmentConfig;
import top.ribs.scguns.entity.ai.AIType;
import top.ribs.scguns.entity.ai.GunAttackGoal;
import top.ribs.scguns.entity.monster.PraetorEntity;
import top.ribs.scguns.item.GunItem;

import java.util.Collections;

public class ArgonautEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(ArgonautEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_TIMEOUT =
            SynchedEntityData.defineId(ArgonautEntity.class, EntityDataSerializers.INT);
    public ArgonautEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    protected void registerGoals() {
        ItemStack mainHandItem = this.getMainHandItem();
        boolean hasGun = mainHandItem.getItem() instanceof GunItem;

        if (hasGun) {
            this.goalSelector.addGoal(3, new GunAttackGoal<>(this, this.getMainHandItem(), 1.0F, AIType.DEFAULT, 3));
        }
        else {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false) {
            });
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, (double)1.0F, 35.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
            this.targetSelector.addGoal(1, new HurtByTargetGoal(this) {
                @Override
                public boolean canUse() {
                    if (this.mob.getLastHurtByMob() instanceof ArgonautEntity) {
                        return false;
                    }
                    return super.canUse();
                }
            });
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true,
                    player -> !((Player) player).isCreative() && !player.isSpectator()));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR, 6F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2F)
                .add(Attributes.ATTACK_DAMAGE, 4F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5F)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }


    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return Collections.emptyList();
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        return super.getItemBySlot(pSlot);
    }

    @Override
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {
    }

    @Override
    public void handleEntityEvent(byte pId) {
        super.handleEntityEvent(pId);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        EntityEquipmentConfig.equipEntity(this, "scguns:argonaut");
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
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
    public boolean canPickUpLoot() {
        return true;
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

//    @Override
//    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
//        this.doHurtTarget(pTarget);
//    }
}
