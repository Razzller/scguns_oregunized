package net.razetka.scguns_oregunized.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.common.entity.DummyProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.IncendiaryRoundProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.LeadRoundProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.ThrowingClubEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.ArgonautEntity;
import net.razetka.scguns_oregunized.common.entity.throwable.ThrowableESDGrenadeEntity;
import net.razetka.scguns_oregunized .common.entity.throwable.ThrowableLeadBombEntity;

import java.util.function.BiFunction;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<DummyProjectileEntity>> DUMMY_PROJECTILE = registerBasic("dummy_projectile", DummyProjectileEntity::new);
    public static final RegistryObject<EntityType<LeadRoundProjectileEntity>> LEAD_ROUND_PROJECTILE = registerBasic("lead_round_projectile", LeadRoundProjectileEntity::new);
    public static final RegistryObject<EntityType<IncendiaryRoundProjectileEntity>> INCENDIARY_ROUND_PROJECTILE = registerBasic("incendiary_round_projectile", IncendiaryRoundProjectileEntity::new);

    public static final RegistryObject<EntityType<ThrowableLeadBombEntity>> THROWABLE_LEAD_BOMB = registerBasic("throwable_lead_bomb", ThrowableLeadBombEntity::new);
    public static final RegistryObject<EntityType<ThrowableESDGrenadeEntity>> THROWABLE_ESD_GRENADE = registerBasic("throwable_esd_grenade", ThrowableESDGrenadeEntity::new);
    public static final RegistryObject<EntityType<ThrowingClubEntity>> THROWING_CLUB = registerBasic("throwing_club", ThrowingClubEntity::new);

    public static final RegistryObject<EntityType<ArgonautEntity>> ARGONAUT =
            ENTITIES.register("argonaut", () -> EntityType.Builder.of(ArgonautEntity::new, MobCategory.MONSTER)
                    .sized(0.5F, 1.8F).build("argonaut"));


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
