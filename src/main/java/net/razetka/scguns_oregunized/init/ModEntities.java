package net.razetka.scguns_oregunized.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.common.entity.*;
import net.razetka.scguns_oregunized.common.entity.mobs.archon.ArchonEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.centurion.CenturionEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.tirone.TironeEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.arphilem.ArphilemEntity;
import net.razetka.scguns_oregunized .common.entity.throwable.ThrowableLeadBombEntity;

import java.util.function.BiFunction;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<DummyProjectileEntity>> DUMMY_PROJECTILE = registerBasic("dummy_projectile", DummyProjectileEntity::new);
    public static final RegistryObject<EntityType<LeadRoundProjectileEntity>> LEAD_ROUND_PROJECTILE = registerBasic("lead_round_projectile", LeadRoundProjectileEntity::new);
    public static final RegistryObject<EntityType<IncendiaryRoundProjectileEntity>> INCENDIARY_ROUND_PROJECTILE = registerBasic("incendiary_round_projectile", IncendiaryRoundProjectileEntity::new);

    public static final RegistryObject<EntityType<ThrowableLeadBombEntity>> THROWABLE_LEAD_BOMB = registerBasic("throwable_lead_bomb", ThrowableLeadBombEntity::new);
    public static final RegistryObject<EntityType<ThrowingClubEntity>> THROWING_CLUB = registerBasic("throwing_club", ThrowingClubEntity::new);

    public static final RegistryObject<EntityType<TironeEntity>> TIRONE =
            ENTITIES.register("tirone", () -> EntityType.Builder.of(TironeEntity::new, MobCategory.MONSTER)
                    .sized(0.5F, 1.8F).build("tirone"));
    public static final RegistryObject<EntityType<CenturionEntity>> CENTURION =
            ENTITIES.register("centurion", () -> EntityType.Builder.of(CenturionEntity::new, MobCategory.MONSTER)
                    .sized(0.5F, 2.0F).build("centurion"));
    public static final RegistryObject<EntityType<ArphilemEntity>> ARPHILEM =
            ENTITIES.register("arphilem", () -> EntityType.Builder.of(ArphilemEntity::new, MobCategory.MONSTER)
                    .sized(0.5F, 1.8F).build("arphilem"));
    public static final RegistryObject<EntityType<ArchonEntity>> ARCHON =
            ENTITIES.register("archon", () -> EntityType.Builder.of(ArchonEntity::new, MobCategory.MONSTER)
                    .sized(0.5F, 1.8F).build("archon"));


    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function) {
        return ENTITIES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .noSave()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }

    public static void register(IEventBus eventBus) {ENTITIES.register(eventBus);}
}
