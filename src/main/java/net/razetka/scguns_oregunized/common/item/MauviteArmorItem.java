package net.razetka.scguns_oregunized.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.razetka.scguns_oregunized.attributes.ModAttributes;
import net.razetka.scguns_oregunized.init.ModArmorMaterials;

import java.util.UUID;

public class MauviteArmorItem extends ArmorItem {
    private static final UUID[] UUIDs = {UUID.fromString("1674499d-d557-4e24-bf9b-c3ef8caa8675"), UUID.fromString("8e3b1e11-6204-459f-8740-536280b5dd24"), UUID.fromString("afd8740f-06b7-49b7-9cdd-3edb9c729a43"), UUID.fromString("b2abf69d-ae8f-4c27-92d8-f6bf0da96578")};

    public MauviteArmorItem(Type pType, Properties pProperties) {
        super(ModArmorMaterials.MAUVITE, pType, pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == this.getEquipmentSlot()) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getAttributeModifiers(slot, stack));
            UUID uuid = UUIDs[type.getSlot().getIndex()];
            builder.put(ModAttributes.BULLET_DAMAGE_REDUCTION.get(), new AttributeModifier(uuid, "Fall Damage Reduction", 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Movement Speed Penalty", -0.05, AttributeModifier.Operation.MULTIPLY_BASE));
            return builder.build();
        }
        return super.getAttributeModifiers(slot, stack);
    }
}