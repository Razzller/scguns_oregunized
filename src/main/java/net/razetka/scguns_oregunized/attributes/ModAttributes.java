package net.razetka.scguns_oregunized.attributes;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, MOD_ID);

    public static final RegistryObject<Attribute> FALL_DAMAGE_REDUCTION = ATTRIBUTES.register("fall_damage_reduction",
            () -> new RangedAttribute("attribute.%s.%s".formatted(MOD_ID, "fall_damage_reduction"), 0,0,1.0f));
    public static final RegistryObject<Attribute> BULLET_DAMAGE_REDUCTION = ATTRIBUTES.register("bullet_damage_reduction",
            () -> new RangedAttribute("attribute.%s.%s".formatted(MOD_ID, "bullet_damage_reduction"), 0,0,1.0f));

    public static void register(IEventBus eventBus) {ATTRIBUTES.register(eventBus);}
}
