package net.razetka.scguns_oregunized.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.effect.OverloadEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ScGunsOregunized.MODID);

    public static final RegistryObject<MobEffect> OVERLOAD = MOB_EFFECTS.register("overload",
            () -> new OverloadEffect(MobEffectCategory.BENEFICIAL, 0xf7eeaa));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
