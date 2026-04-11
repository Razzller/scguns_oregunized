package net.razetka.scguns_oregunized.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.scguns.init.ModCreativeModeTabs;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;
import static top.ribs.scguns.init.ModCreativeModeTabs.CREATIVE_MODE_TABS;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCGUNS_OREGUNIZED_TAB = CREATIVE_MODE_TABS.register("scguns_oregunized_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MACTRICIA.get())).title(Component.translatable("creativetab.scguns_oregunized_tab")).displayItems((pParameters, pOutput) -> {
        addItemWithFullAmmo(pOutput, ModItems.WHIRLWIND.get());
        addItemWithFullAmmo(pOutput, ModItems.HERMES.get());
        addItemWithFullAmmo(pOutput, ModItems.AVANTRIMA.get());
        addItemWithFullAmmo(pOutput, ModItems.HARETROT.get());
        addItemWithFullAmmo(pOutput, ModItems.VOLTERSP.get());
        addItemWithFullAmmo(pOutput, ModItems.MACTRICIA.get());
        addItemWithFullAmmo(pOutput, ModItems.AMPERBREAKER.get());
        addItemWithFullAmmo(pOutput, ModItems.JUPITER7.get());
        pOutput.accept(ModItems.ESD_GRENADE.get());
        pOutput.accept(ModItems.ELECTRUM_GUN_FRAME.get());
        pOutput.accept(ModItems.STELLAR_ORDER_FLARE.get());
        pOutput.accept(ModItems.ASSASSIN_DAGGER.get());
        pOutput.accept(ModItems.STELLAR_ORDER_BLUEPRINT.get());
        pOutput.accept(ModBlocks.SILVER_PILLAR.get());
        pOutput.accept(ModBlocks.CHISELED_SILVER.get());
        pOutput.accept(ModBlocks.SILVER_MOSAIC.get());
        pOutput.accept(ModBlocks.SILVER_MOSAIC_STAIRS.get());
        pOutput.accept(ModBlocks.SILVER_MOSAIC_SLAB.get());
        pOutput.accept(ModBlocks.SILVER_LAMP.get());
        pOutput.accept(ModBlocks.SILVER_LANTERN.get());
        pOutput.accept(ModBlocks.SILVER_BARS.get());
        addItemWithFullAmmo(pOutput, ModItems.WOLFHOUND.get());
        addItemWithFullAmmo(pOutput, ModItems.WARTHOG.get());
        addItemWithFullAmmo(pOutput, ModItems.CENTURION_SMG.get());
        addItemWithFullAmmo(pOutput, ModItems.PROSPECTOR.get());
        addItemWithFullAmmo(pOutput, ModItems.CHIMERA_LMG.get());
        addItemWithFullAmmo(pOutput, ModItems.APOTHEOSIS_LRR.get());
        addItemWithFullAmmo(pOutput, ModItems.SABRETUSK.get());
        addItemWithFullAmmo(pOutput, ModItems.NEMESIS.get());
        addItemWithFullAmmo(pOutput, ModItems.MEGATHERIUM.get());
        addItemWithFullAmmo(pOutput, ModItems.DUSTER.get());
        pOutput.accept(ModItems.MAUVITE_BLUDGEON.get());
        pOutput.accept(ModItems.MAUVITE_SLEDGEHAMMER.get());
        pOutput.accept(ModItems.LEAD_BOMB.get());
        pOutput.accept(ModItems.THROWING_CLUB.get());
        pOutput.accept(ModItems.MAUVITE_HELMET.get());
        pOutput.accept(ModItems.MAUVITE_CHESTPLATE.get());
        pOutput.accept(ModItems.MAUVITE_LEGGINGS.get());
        pOutput.accept(ModItems.MAUVITE_BOOTS.get());
        pOutput.accept(ModItems.LEAD_ROUND.get());
        pOutput.accept(ModItems.LEAD_SLUG.get());
        pOutput.accept(ModItems.INCENDIARY_ROUND.get());
        pOutput.accept(ModItems.SMALL_MAUVITE_CASING.get());
        pOutput.accept(ModItems.MEDIUM_MAUVITE_CASING.get());
        pOutput.accept(ModItems.LARGE_MAUVITE_CASING.get());
        pOutput.accept(ModItems.MAUVITE_GUN_FRAME.get());
        pOutput.accept(ModItems.MAUVITE_BLEND.get());
        pOutput.accept(ModItems.MAUVITE_INGOT.get());
        pOutput.accept(ModItems.MAUVITE_NUGGET.get());
        pOutput.accept(ModBlocks.MAUVITE_BLOCK.get());
        pOutput.accept(ModBlocks.MAUVITE_BRICKS.get());
        pOutput.accept(ModBlocks.MAUVITE_BRICK_STAIRS.get());
        pOutput.accept(ModBlocks.MAUVITE_BRICK_SLAB.get());
        pOutput.accept(ModBlocks.MAUVITE_BRICK_WALL.get());
        pOutput.accept(ModBlocks.MAUVITE_BUTTON.get());
        pOutput.accept(ModBlocks.MAUVITE_PRESSURE_PLATE.get());
        pOutput.accept(ModItems.SUPER_POISONOUS_POTATO.get());
        //pOutput.accept(ModItems.ARGONAUT_SPAWN_EGG.get());
    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


    private static void addItemWithFullAmmo(CreativeModeTab.Output output, Item item) {
        ModCreativeModeTabs.CreativeTabHelper.addItemWithFullAmmo(output, item);
    }
}