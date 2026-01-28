package net.razetka.scguns_oregunized.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.razetka.scguns_oregunized.client.render.gun.model.*;
import net.razetka.scguns_oregunized.init.ModItems;
import top.ribs.scguns.client.render.gun.ModelOverrides;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class ClientHandler {
    public static void registerClientHandlers(IEventBus bus) {
        bus.addListener(ClientHandler::onClientSetup);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::setup);
    }

    public static void setup() {
        registerModelOverrides();
    }
    private static void registerModelOverrides() {
        ModelOverrides.register(ModItems.WHIRLWIND.get(), new WhirlwindModel());
        ModelOverrides.register(ModItems.HERMES.get(), new HermesModel());
        ModelOverrides.register(ModItems.AVANTRIMA.get(), new AvantrimaModel());
        ModelOverrides.register(ModItems.HARETROT.get(), new HaretrotModel());
        ModelOverrides.register(ModItems.VOLTERSP.get(), new VolterSPModel());
        ModelOverrides.register(ModItems.MACTRICIA.get(), new MactriciaModel());
        ModelOverrides.register(ModItems.AMPERBREAKER.get(), new AmperbreakerModel());
        ModelOverrides.register(ModItems.JUPITER7.get(), new Jupiter7Model());
    }
}
