package net.razetka.scguns_oregunized.events.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.common.entity.mobs.archon.ArchonRenderer;
import net.razetka.scguns_oregunized.common.entity.mobs.centurion.CenturionRenderer;
import net.razetka.scguns_oregunized.common.entity.mobs.tirone.TironeRenderer;
import net.razetka.scguns_oregunized.common.entity.mobs.arphilem.ArphilemRenderer;
import net.razetka.scguns_oregunized.init.ModEntities;
import top.ribs.scguns.client.render.entity.ProjectileRenderer;
import top.ribs.scguns.client.render.entity.ThrowableGrenadeRenderer;

@Mod.EventBusSubscriber(modid = ScGunsOregunized.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OregunizedEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.LEAD_ROUND_PROJECTILE.get(), ProjectileRenderer::new);
        event.registerEntityRenderer(ModEntities.INCENDIARY_ROUND_PROJECTILE.get(), ProjectileRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWABLE_LEAD_BOMB.get(), ThrowableGrenadeRenderer::new);
        EntityRenderers.register(ModEntities.THROWING_CLUB.get(), ThrownItemRenderer::new);

        EntityRenderers.register(ModEntities.TIRONE.get(), TironeRenderer::new);
        EntityRenderers.register(ModEntities.CENTURION.get(), CenturionRenderer::new);
        EntityRenderers.register(ModEntities.ARPHILEM.get(), ArphilemRenderer::new);
        EntityRenderers.register(ModEntities.ARCHON.get(), ArchonRenderer::new);

    }
}
