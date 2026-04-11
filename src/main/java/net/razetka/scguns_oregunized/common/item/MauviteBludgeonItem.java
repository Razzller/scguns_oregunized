package net.razetka.scguns_oregunized.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.razetka.scguns_oregunized.init.ModItems;

import java.util.UUID;

public class MauviteBludgeonItem extends Item {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final UUID uuid = UUID.fromString("F5370F66-DB1F-42DD-9E53-40849D257D9B");

    public MauviteBludgeonItem(int pAttackDamageModifier, float pAttackSpeedModifier, float extraKnockback, Item.Properties pProperties) {
        super(pProperties);
        this.attackDamage = (float)pAttackDamageModifier;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(uuid, "Weapon modifier", (double)extraKnockback, AttributeModifier.Operation.ADDITION));
        defaultModifiers = builder.build();
    }


    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    public float getDamage() {
    return attackDamage;
}



public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (entity) -> {
            entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }


    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pToRepair.is(ModItems.MAUVITE_INGOT.get()) || super.isValidRepairItem(pToRepair, pRepair);
    }
}