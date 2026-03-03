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
import net.razetka.scguns_oregunized.common.entity.LeadRoundProjectileEntity;

import java.util.function.BiFunction;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<DummyProjectileEntity>> DUMMY_PROJECTILE = registerBasic("dummy_projectile", DummyProjectileEntity::new);
    public static final RegistryObject<EntityType<LeadRoundProjectileEntity>> LEAD_ROUND_PROJECTILE = registerBasic("lead_round_projectile", LeadRoundProjectileEntity::new);

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
