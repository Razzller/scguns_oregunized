package net.razetka.scguns_oregunized.events;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.client.ModModelLayers;
import net.razetka.scguns_oregunized.common.entity.mobs.archon.ArchonEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.archon.ArchonModel;
import net.razetka.scguns_oregunized.common.entity.mobs.arphilem.ArphilemModel;
import net.razetka.scguns_oregunized.common.entity.mobs.centurion.CenturionEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.centurion.CenturionModel;
import net.razetka.scguns_oregunized.common.entity.mobs.tirone.TironeEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.tirone.TironeModel;
import net.razetka.scguns_oregunized.common.entity.mobs.arphilem.ArphilemEntity;
import net.razetka.scguns_oregunized.init.ModEntities;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIRONE.get(), TironeEntity.createAttributes().build());
        event.put(ModEntities.CENTURION.get(), CenturionEntity.createAttributes().build());
        event.put(ModEntities.ARPHILEM.get(), ArphilemEntity.createAttributes().build());
        event.put(ModEntities.ARCHON.get(), ArchonEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TIRONE_LAYER, TironeModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CENTURION_LAYER, CenturionModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ARPHILEM_LAYER, ArphilemModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ARCHON_LAYER, ArchonModel::createBodyLayer);
    }
}
