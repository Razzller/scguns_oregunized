package net.razetka.scguns_oregunized.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.scguns.attributes.SCAttributes;

public class OverloadEffect extends MobEffect {
    public OverloadEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "d8d6b257-820d-4268-9994-c70f0e9feb1f", 0.2, AttributeModifier.Operation.MULTIPLY_BASE);
        // There's only jump height attribute for the horses >:(
    }
}
