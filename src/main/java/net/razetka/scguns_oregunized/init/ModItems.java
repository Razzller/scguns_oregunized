package net.razetka.scguns_oregunized.init;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.BlueprintItem;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScGunsOregunized.MODID);

    public static final RegistryObject<AnimatedGunItem> WHIRLWIND = ITEMS.register("whirlwind",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "whirlwind", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> HERMES = ITEMS.register("hermes",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "hermes", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> AVANTRIMA = ITEMS.register("avantrima",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "avantrima", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> MACTRICIA = ITEMS.register("mactricia",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "mactricia", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> JUPITER7 = ITEMS.register("jupiter-7",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "jupiter-7", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> VOLTERSP = ITEMS.register("volter_sp",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "volter_sp", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> HARETROT = ITEMS.register("haretrot",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "haretrot", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> AMPERBREAKER = ITEMS.register("amperbreaker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1200),
                    "amperbreaker", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));

    public static final RegistryObject<Item> STELLAR_ORDER_BLUEPRINT = ITEMS.register("stellar_order_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ELECTRUM_GUN_FRAME = ITEMS.register("electrum_gun_frame", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
