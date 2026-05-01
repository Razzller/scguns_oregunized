package net.razetka.scguns_oregunized.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.effect.ElectrocutedEffect;
import net.razetka.scguns_oregunized.effect.OverloadEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ScGunsOregunized.MOD_ID);

    public static final RegistryObject<MobEffect> OVERLOAD = MOB_EFFECTS.register("overload",
            () -> new OverloadEffect(MobEffectCategory.BENEFICIAL, 0xf7eeaa));
    public static final RegistryObject<MobEffect> ELECTROCUTED = MOB_EFFECTS.register("electrocuted",
            () -> new ElectrocutedEffect(MobEffectCategory.HARMFUL, 0x7df9ff));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
