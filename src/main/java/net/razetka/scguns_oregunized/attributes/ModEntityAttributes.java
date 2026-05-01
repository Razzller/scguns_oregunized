package net.razetka.scguns_oregunized.attributes;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityAttributes {
    @SubscribeEvent
    public static void onEntityAttributeModification(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, ModAttributes.FALL_DAMAGE_REDUCTION.get());
        event.add(EntityType.PLAYER, ModAttributes.BULLET_DAMAGE_REDUCTION.get());
    }
}
