package net.razetka.scguns_oregunized.init;

import net.minecraft.client.particle.CritParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.client.particle.LeadHitParticle;
import top.ribs.scguns.client.particle.CasingParticle;
import top.ribs.scguns.client.particle.PlasmaRingParticle;


import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModParticleTypes {
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MOD_ID);

    public static final RegistryObject<SimpleParticleType> MAUVITE_CASING_PARTICLE = PARTICLE_TYPES.register("mauvite_casing", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LEAD_HIT_PARTICLE = PARTICLE_TYPES.register("lead_hit_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ELECTRICITY_PARTICLE = PARTICLE_TYPES.register("electricity", () -> new SimpleParticleType(true));

    @Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegisterParticles {
        @SubscribeEvent
        public static void registerParticleTypes(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(MAUVITE_CASING_PARTICLE.get(), CasingParticle.Provider::new);
            event.registerSpriteSet(LEAD_HIT_PARTICLE.get(), LeadHitParticle.Provider::new);
            event.registerSpriteSet(ELECTRICITY_PARTICLE.get(), PlasmaRingParticle.Provider::new);
        }
    }

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}