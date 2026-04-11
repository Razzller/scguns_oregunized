package net.razetka.scguns_oregunized;

import com.mojang.logging.LogUtils;
import galena.oreganized.index.OItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.razetka.scguns_oregunized.attributes.ModAttributes;
import net.razetka.scguns_oregunized.client.ClientHandler;
import net.razetka.scguns_oregunized.common.entity.DummyProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.IncendiaryRoundProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.LeadRoundProjectileEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.ArgonautRenderer;
import net.razetka.scguns_oregunized.events.ElectrumWeaponEventHandler;
import net.razetka.scguns_oregunized.init.*;
import org.slf4j.Logger;
import top.ribs.scguns.common.ProjectileManager;
import top.ribs.scguns.entity.player.GunTierRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScGunsOregunized.MOD_ID)
public class ScGunsOregunized
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "scguns_oregunized";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ScGunsOregunized(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModParticleTypes.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModAttributes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ElectrumWeaponEventHandler.class);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            ClientHandler.registerClientHandlers(modEventBus);
        });

        modEventBus.addListener(this::commonSetup);


        Config.registerConfig();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        GunTierRegistry.register("stellar_order", 6, "stellar_order_gun_tier", 4);

        ProjectileManager.getInstance().registerFactory(OItems.LEAD_BOLT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new DummyProjectileEntity(ModEntities.DUMMY_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ModItems.LEAD_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new LeadRoundProjectileEntity(ModEntities.LEAD_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ModItems.LEAD_SLUG.get(), (worldIn, entity, weapon, item, modifiedGun) -> new LeadRoundProjectileEntity(ModEntities.LEAD_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(OItems.LEAD_NUGGET.get(), (worldIn, entity, weapon, item, modifiedGun) -> new LeadRoundProjectileEntity(ModEntities.LEAD_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ModItems.INCENDIARY_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new IncendiaryRoundProjectileEntity(ModEntities.INCENDIARY_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.THROWING_CLUB.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.ARGONAUT.get(), ArgonautRenderer::new);
        }
    }
}
