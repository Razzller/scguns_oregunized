package net.razetka.scguns_oregunized.init;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.common.item.*;
import top.ribs.scguns.init.ModCreativeModeTabs;
import top.ribs.scguns.init.ModSounds;
import top.ribs.scguns.item.BlueprintItem;
import top.ribs.scguns.item.RaidFlareItem;
import top.ribs.scguns.item.TooltipItem;
import top.ribs.scguns.item.animated.AnimatedAirGunItem;
import top.ribs.scguns.item.animated.AnimatedGunItem;
import top.ribs.scguns.item.animated.AnimatedUnderWaterGunItem;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;
import static net.minecraft.world.item.crafting.Ingredient.of;
import static net.razetka.scguns_oregunized.init.ModBlocks.*;
import static top.ribs.scguns.init.ModBlocks.TREATED_IRON_BLOCK;
import static top.ribs.scguns.init.ModBlocks.TREATED_IRON_GRATE_PANE;
import static top.ribs.scguns.init.ModItems.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

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
    public static final RegistryObject<AnimatedGunItem> JACKRABBIT = ITEMS.register("jackrabbit",
            () -> new AnimatedUnderWaterGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "jackrabbit", // Model path
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
    public static final RegistryObject<AnimatedGunItem> CANTER = ITEMS.register("canter",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).rarity(ModRarities.ORGANIZED).durability(1200),
                    "canter", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));



    public static final RegistryObject<AnimatedGunItem> CHIMERA = ITEMS.register("chimera",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "chimera", // Model path
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
    public static final RegistryObject<AnimatedGunItem> TIRONE_SMG = ITEMS.register("tirone_smg",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "tirone_smg", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> TIRONE_CONVERSION = ITEMS.register("tirone_conversion",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "tirone_conversion", // Model path
                    ModSounds.MAG_OUT.get(),        // Reload sound mag out
                    ModSounds.MAG_IN.get(),         // Reload sound mag in
                    ModSounds.RELOAD_END.get(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.get(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.get()    // Ejector sound release
            ));
    public static final RegistryObject<AnimatedGunItem> APOTHEOSIS = ITEMS.register("apotheosis",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(900),
                    "apotheosis", // Model path
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
    public static final RegistryObject<AnimatedGunItem> TRENCHBROOM = ITEMS.register("trenchbroom",
            () -> new AnimatedAirGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "trenchbroom", // Model path
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
    public static final RegistryObject<Item> TIRONE_SPAWN_EGG = ITEMS.register("tirone_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TIRONE, 0xFFFFFF, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> CENTURION_SPAWN_EGG = ITEMS.register("centurion_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CENTURION, 0xFFFFFF, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> ARPHILEM_SPAWN_EGG = ITEMS.register("arphilem_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.ARPHILEM, 0xFFFFFF, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> ARCHON_SPAWN_EGG = ITEMS.register("archon_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.ARCHON, 0xFFFFFF, 0xFFFFFF, new Item.Properties()));

    public static final RegistryObject<Item> UNION_FLARE = ITEMS.register("union_flare",
            () -> new RaidFlareItem(new Item.Properties().stacksTo(16),"white_wolf"));
    public static final RegistryObject<Item> UNION_BLUEPRINT = ITEMS.register("union_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MEDAL_OF_HONOR = ITEMS.register("medal_of_honor", () -> new TooltipItem(new Item.Properties().stacksTo(1),
            "item.scguns_oregunized.medal_of_honor_tooltip",
            "item.scguns.found_in_raids"));


    public static class ModRarities {
        public static final net.minecraft.world.item.Rarity ORGANIZED = net.minecraft.world.item.Rarity.create("scguns_oregunized.organized", style -> style.withColor(0xF4EBA8));
    }


    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(MOD_ID)
                .tab(ModCreativeModeTabs.SCORCHED_ITEMS_TAB.getKey())
                .addItemsAfter(of(IRON_BLUEPRINT.get()), UNION_BLUEPRINT)
                .addItemsAfter(of(DIAMOND_STEEL_BLUEPRINT.get()), STELLAR_ORDER_BLUEPRINT)
                .addItemsAfter(of(LABOR_TROPHY.get()), MEDAL_OF_HONOR)
                .addItemsAfter(of(CERIMONIAL_COD.get()), ASSASSIN_DAGGER)
                .addItemsAfter(of(IRON_BLUEPRINT.get()), UNION_BLUEPRINT)
                .addItemsAfter(of(IRON_FLARE.get()), UNION_FLARE)
                .addItemsAfter(of(DIAMOND_STEEL_FLARE.get()), STELLAR_ORDER_FLARE)
                .addItemsAfter(of(IRON_BLUEPRINT.get()), UNION_BLUEPRINT)
                .addItemsAfter(of(IRON_GUN_FRAME.get()), MAUVITE_GUN_FRAME)
                .addItemsAfter(of(DIAMOND_STEEL_GUN_FRAME.get()), ELECTRUM_GUN_FRAME)
                .addItemsAfter(of(TREATED_BRASS_BOOTS.get()), MAUVITE_HELMET, MAUVITE_CHESTPLATE, MAUVITE_LEGGINGS, MAUVITE_BOOTS)
                .addItemsAfter(of(STANDARD_COPPER_ROUND.get()), LEAD_ROUND, LEAD_SLUG, INCENDIARY_ROUND)
                .addItemsAfter(of(MEDIUM_COPPER_CASING.get()), SMALL_MAUVITE_CASING, MEDIUM_MAUVITE_CASING, LARGE_MAUVITE_CASING)
                .addItemsAfter(of(TREATED_IRON_NUGGET.get()), MAUVITE_BLEND, MAUVITE_INGOT, MAUVITE_NUGGET)
                .addItemsAfter(of(STUN_GRENADE.get()), LEAD_BOMB, THROWING_CLUB)
                .addItemsAfter(of(WARAXE.get()), MAUVITE_BLUDGEON, MAUVITE_SLEDGEHAMMER)
                .addItemsAfter(of(WEIRD_FLESH.get()), SUPER_POISONOUS_POTATO)
                .addItemsAfter(of(SCAMPLER_SPAWN_EGG.get()), TIRONE_SPAWN_EGG, CENTURION_SPAWN_EGG, ARPHILEM_SPAWN_EGG, ARCHON_SPAWN_EGG)

                .tab(ModCreativeModeTabs.SCORCHED_BLOCKS_TAB.getKey())
                .addItemsAfter(of(TREATED_IRON_BLOCK.get()), MAUVITE_BLOCK)
                .addItemsAfter(of(TREATED_IRON_GRATE_PANE.get()), MAUVITE_BRICKS, MAUVITE_BRICK_STAIRS, MAUVITE_BRICK_SLAB, MAUVITE_BRICK_WALL, MAUVITE_BUTTON, MAUVITE_PRESSURE_PLATE);
    }



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
