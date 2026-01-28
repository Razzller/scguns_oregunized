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
        this.addAttributeModifier(Attributes.ATTACK_SPEED, "d333dcc3-d015-4c6f-bbfc-509925c214a0", 0.2, AttributeModifier.Operation.MULTIPLY_BASE);
        this.addAttributeModifier(SCAttributes.RELOAD_SPEED, "ce0046c1-73d5-4b8f-9465-85b4f7488b8b", 0.5, AttributeModifier.Operation.ADDITION);
    }

    private void addAttributeModifier(RegistryObject<Attribute> reloadSpeed, String uuid, double pAmount, AttributeModifier.Operation operation) {
        //TODO Fix this when you'll figure this out, idk what I need here
    }
}
