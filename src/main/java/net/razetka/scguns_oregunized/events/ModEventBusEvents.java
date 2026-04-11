package net.razetka.scguns_oregunized.events;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.client.ModModelLayers;
import net.razetka.scguns_oregunized.common.entity.mobs.ArgonautEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.ArgonautModel;
import net.razetka.scguns_oregunized.init.ModEntities;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ARGONAUT.get(), ArgonautEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ARGONAUT_LAYER, ArgonautModel::createBodyLayer);
    }
}
