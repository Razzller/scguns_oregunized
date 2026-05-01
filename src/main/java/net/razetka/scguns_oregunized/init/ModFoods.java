package net.razetka.scguns_oregunized.init;


import galena.oreganized.index.OEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SUPER_POISONOUS_POTATO = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(OEffects.STUNNING.get(), 600, 0), 1.0F).effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 1.0F).build();
    public static final FoodProperties ELECTRUM_BERRIES = new FoodProperties.Builder().alwaysEat().nutrition(6).saturationMod(0.9F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F).build();
}

