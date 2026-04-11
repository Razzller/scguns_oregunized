package net.razetka.scguns_oregunized.init;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.common.item.*;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.BlueprintItem;
import top.ribs.scguns.item.RaidFlareItem;
import top.ribs.scguns.item.TooltipItem;
import top.ribs.scguns.item.animated.AnimatedAirGunItem;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScGunsOregunized.MOD_ID);

    public static final RegistryObject<AnimatedGunItem> WHIRLWIND = ITEMS.register("whirlwind",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "whirlwind", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> HERMES = ITEMS.register("hermes",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "hermes", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> AVANTRIMA = ITEMS.register("avantrima",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "avantrima", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> MACTRICIA = ITEMS.register("mactricia",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "mactricia", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> JUPITER7 = ITEMS.register("jupiter-7",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "jupiter-7", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> VOLTERSP = ITEMS.register("volter_sp",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "volter_sp", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> HARETROT = ITEMS.register("haretrot",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "haretrot", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> AMPERBREAKER = ITEMS.register("amperbreaker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "amperbreaker", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));



    public static final RegistryObject<AnimatedGunItem> CHIMERA_LMG = ITEMS.register("chimera_lmg",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "chimera_lmg", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> WARTHOG = ITEMS.register("warthog",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "warthog", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> WOLFHOUND = ITEMS.register("wolfhound",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "wolfhound", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> SABRETUSK = ITEMS.register("sabretusk",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "sabretusk", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> CENTURION_SMG = ITEMS.register("centurion_smg",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "centurion_smg", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> APOTHEOSIS_LRR = ITEMS.register("apotheosis_lrr",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "apotheosis_lrr", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> PROSPECTOR = ITEMS.register("prospector",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "prospector", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> NEMESIS = ITEMS.register("nemesis",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "nemesis", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> MEGATHERIUM = ITEMS.register("megatherium",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "megatherium", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> DUSTER = ITEMS.register("duster",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "duster", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));





    public static final RegistryObject<Item> STELLAR_ORDER_BLUEPRINT = ITEMS.register("stellar_order_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ELECTRUM_GUN_FRAME = ITEMS.register("electrum_gun_frame", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASSASSIN_DAGGER = ITEMS.register("assassin_dagger", () -> new TooltipItem(new Item.Properties().stacksTo(1),
            "item.scguns_oregunized.assassin_dagger_tooltip",
            "item.scguns.found_in_raids"));
    public static final RegistryObject<Item> STELLAR_ORDER_FLARE = ITEMS.register("stellar_order_flare",
            () -> new RaidFlareItem(new Item.Properties().stacksTo(16),"stellar_order"));

    public static final RegistryObject<SledgehammerItem> MAUVITE_SLEDGEHAMMER = ITEMS.register("mauvite_sledgehammer", () -> new SledgehammerItem(new Item.Properties(), "item.sledgehammer.tooltip"));
    public static final RegistryObject<LeadBombItem> LEAD_BOMB = ITEMS.register("lead_bomb", () -> new LeadBombItem(new Item.Properties(), 80, // This number doesn't do anything
            "item.lead_bomb.tooltip"));
    public static final RegistryObject<MauviteBludgeonItem> MAUVITE_BLUDGEON = ITEMS.register("mauvite_bludgeon", () -> new MauviteBludgeonItem(6, -2.8F, 1.0F, new Item.Properties().durability(720)));
    public static final RegistryObject<Item> ESD_GRENADE = ITEMS.register("esd_grenade", () -> new ESDGrenadeItem(new Item.Properties(), 80));
    public static final RegistryObject<Item> MAUVITE_HELMET = ITEMS.register("mauvite_helmet", () -> new MauviteArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_CHESTPLATE = ITEMS.register("mauvite_chestplate", () -> new MauviteArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_LEGGINGS = ITEMS.register("mauvite_leggings", () -> new MauviteArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_BOOTS = ITEMS.register("mauvite_boots", () -> new MauviteArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> LEAD_ROUND = ITEMS.register("lead_round", () -> new LeadRoundAmmoItem(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_SLUG = ITEMS.register("lead_slug", () -> new LeadRoundAmmoItem(new Item.Properties()));
    public static final RegistryObject<Item> INCENDIARY_ROUND = ITEMS.register("incendiary_round", () -> new IncendiaryRoundAmmoItem(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_MAUVITE_CASING = ITEMS.register("small_mauvite_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_MAUVITE_CASING = ITEMS.register("medium_mauvite_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_MAUVITE_CASING = ITEMS.register("large_mauvite_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFINISHED_LEAD_ROUND = ITEMS.register("unfinished_lead_round", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFINISHED_LEAD_SLUG = ITEMS.register("unfinished_lead_slug", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFINISHED_INCENDIARY_ROUND = ITEMS.register("unfinished_incendiary_round", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAUVITE_INGOT = ITEMS.register("mauvite_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_NUGGET = ITEMS.register("mauvite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_GUN_FRAME = ITEMS.register("mauvite_gun_frame", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAUVITE_BLEND = ITEMS.register("mauvite_blend", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THROWING_CLUB = ITEMS.register("throwing_club", () -> new ThrowingClubItem(new Item.Properties()));
    public static final RegistryObject<Item> SUPER_POISONOUS_POTATO = ITEMS.register("super_poisonous_potato", () -> new Item(new Item.Properties().food(ModFoods.SUPER_POISONOUS_POTATO)));
    //public static final RegistryObject<Item> ARGONAUT_SPAWN_EGG = ITEMS.register("argronaut_spawn_egg", () -> new SpawnEggItem(ModEntities.ARGONAUT.get(), 0x7C4153, 0xC26B4C, new Item.Properties()));


    public static class ModRarities {
        public static final net.minecraft.world.item.Rarity ORGANIZED = net.minecraft.world.item.Rarity.create("scguns_oregunized.organized", style -> style.withColor(0xF4EBA8));
    }



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
