package net.razetka.scguns_oregunized.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final Tier SLEDGEHAMMER = new Tier() {
        @Override
        public int getUses() {
            return 1600;
        }

        @Override
        public float getSpeed() {
            return 64.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 0;
        }

        @Override
        public int getLevel() {
            return -1;
        }

        @Override
        public int getEnchantmentValue() {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.MAUVITE_INGOT.get());
        }
    };
}
