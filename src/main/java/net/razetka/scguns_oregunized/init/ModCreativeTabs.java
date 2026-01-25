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

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;
import static top.ribs.scguns.init.ModCreativeModeTabs.CREATIVE_MODE_TABS;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> SCGUNS_OREGUNIZED_TAB = CREATIVE_MODE_TABS.register("scguns_oregunized_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MACTRICIA.get())).title(Component.translatable("creativetab.scguns_oregunized_tab")).displayItems((pParameters, pOutput) -> {
        addItemWithFullAmmo(pOutput, ModItems.WHIRLWIND.get());
        addItemWithFullAmmo(pOutput, ModItems.HERMES.get());
        addItemWithFullAmmo(pOutput, ModItems.AVANTRIMA.get());
        addItemWithFullAmmo(pOutput, ModItems.HARETROT.get());
        addItemWithFullAmmo(pOutput, ModItems.VOLTERSP.get());
        addItemWithFullAmmo(pOutput, ModItems.MACTRICIA.get());
        addItemWithFullAmmo(pOutput, ModItems.AMPERBREAKER.get());
        addItemWithFullAmmo(pOutput, ModItems.JUPITER7.get());
        addItem(pOutput, ModItems.ELECTRUM_GUN_FRAME.get());
        addItem(pOutput, ModItems.STELLAR_ORDER_FLARE.get());
        addItem(pOutput, ModItems.ASSASSIN_DAGGER.get());
        addItem(pOutput, ModItems.STELLAR_ORDER_BLUEPRINT.get());
    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private static void addItem(CreativeModeTab.Output output, Item item) {
        output.accept(item);
    }

    private static void addItemWithFullAmmo(CreativeModeTab.Output output, Item item) {
        ModCreativeModeTabs.CreativeTabHelper.addItemWithFullAmmo(output, item);
    }
}