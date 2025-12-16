package net.razetka.scguns_oregunized.item;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScGunsOregunized.MODID);

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
