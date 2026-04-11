package net.razetka.scguns_oregunized.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.attributes.ModAttributes;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void LivingHurtEvent(LivingHurtEvent event) {
        handleFallDamageReduction(event);
    }

    private static void handleFallDamageReduction(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            LivingEntity player = event.getEntity();
            DamageSource source = event.getSource();
            AttributeInstance attribute = player.getAttribute(ModAttributes.FALL_DAMAGE_REDUCTION.get());
            if (attribute != null && source.is(DamageTypes.FALL)) {
                float newDamage = (float) (event.getAmount() - event.getAmount() * attribute.getValue() );
                event.setAmount(newDamage);
            }
        }
    }
}
