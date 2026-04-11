package net.razetka.scguns_oregunized.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.razetka.scguns_oregunized.ScGunsOregunized;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> SHOCKWAVE = create("shockwave");

    public static ResourceKey<DamageType> create(String key) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(MOD_ID + key));
    }
}
