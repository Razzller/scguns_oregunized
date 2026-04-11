package net.razetka.scguns_oregunized.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.razetka.scguns_oregunized.attributes.ModAttributes;
import net.razetka.scguns_oregunized.init.ModArmorMaterials;

import java.util.UUID;

public class MauviteArmorItem extends ArmorItem {
    private static final UUID[] UUIDs = {UUID.fromString("1674499d-d557-4e24-bf9b-c3ef8caa8675"), UUID.fromString("8e3b1e11-6204-459f-8740-536280b5dd24"), UUID.fromString("afd8740f-06b7-49b7-9cdd-3edb9c729a43"), UUID.fromString("b2abf69d-ae8f-4c27-92d8-f6bf0da96578")};
    private Multimap<Attribute, AttributeModifier> defaultModifiers;

    public MauviteArmorItem(Type pType, Properties pProperties) {
        super(ModArmorMaterials.MAUVITE, pType, pProperties);
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(slot == this.getEquipmentSlot()) {
            UUID uuid = UUIDs[type.getSlot().getIndex()];
            return ImmutableMultimap.of(
                    Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", ModArmorMaterials.MAUVITE.getDefenseForType(this.type), AttributeModifier.Operation.ADDITION),
                    //Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", ModArmorMaterials.MAUVITE.getToughness(), AttributeModifier.Operation.ADDITION),
                    Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", ModArmorMaterials.MAUVITE.getKnockbackResistance(), AttributeModifier.Operation.ADDITION),
                    ModAttributes.FALL_DAMAGE_REDUCTION.get(), new AttributeModifier(uuid, "Fall Damage Reduction", 0.15, AttributeModifier.Operation.ADDITION),
                    Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Movement Speed Penalty", -0.05, AttributeModifier.Operation.MULTIPLY_BASE)
            );
        }
        return super.getDefaultAttributeModifiers(slot);
    }
}