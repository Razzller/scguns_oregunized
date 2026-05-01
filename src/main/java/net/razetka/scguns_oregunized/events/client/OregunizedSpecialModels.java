package net.razetka.scguns_oregunized.events.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum OregunizedSpecialModels {
    WHIRLWIND_MAIN("whirlwind/main"),
    WHIRLWIND_STANDARD_MAG("whirlwind/standard_mag"),
    WHIRLWIND_SPEED_MAG("whirlwind/speed_mag"),
    WHIRLWIND_EXTENDED_MAG("whirlwind/extended_mag"),
    WHIRLWIND_EXTENDED_BARREL("whirlwind/extended_barrel"),
    WHIRLWIND_STANDARD_BARREL("whirlwind/standard_barrel"),
    WHIRLWIND_SILENCER("whirlwind/silencer"),
    WHIRLWIND_ADVANCED_SILENCER("whirlwind/advanced_silencer"),
    WHIRLWIND_MUZZLE_BRAKE("whirlwind/muzzle_brake"),

    HERMES_MAIN("hermes/main"),
    HERMES_EXTENDED_BARREL("hermes/extended_barrel"),
    HERMES_STANDARD_BARREL("hermes/standard_barrel"),
    HERMES_SILENCER("hermes/silencer"),
    HERMES_ADVANCED_SILENCER("hermes/advanced_silencer"),
    HERMES_MUZZLE_BRAKE("hermes/muzzle_brake"),

    AVANTRIMA_MAIN("avantrima/main"),
    AVANTRIMA_STANDARD_BARREL("avantrima/standard_barrel"),
    AVANTRIMA_EXTENDED_BARREL("avantrima/extended_barrel"),
    AVANTRIMA_SILENCER("avantrima/silencer"),
    AVANTRIMA_ADVANCED_SILENCER("avantrima/advanced_silencer"),
    AVANTRIMA_MUZZLE_BRAKE("avantrima/muzzle_brake"),

    JACKRABBIT_MAIN("jackrabbit/main"),
    JACKRABBIT_IRON_BAYONET("jackrabbit/iron_bayonet"),
    JACKRABBIT_ANTHRALITE_BAYONET("jackrabbit/anthralite_bayonet"),
    JACKRABBIT_DIAMOND_BAYONET("jackrabbit/diamond_bayonet"),
    JACKRABBIT_NETHERITE_BAYONET("jackrabbit/netherite_bayonet"),
    JACKRABBIT_LIGHT_GRIP("jackrabbit/light_grip"),
    JACKRABBIT_VERT_GRIP("jackrabbit/vertical_grip"),
    JACKRABBIT_DEFAULT_MAG("jackrabbit/default_mag"),
    JACKRABBIT_EXTENDED_MAG("jackrabbit/extended_mag"),
    JACKRABBIT_SPEED_MAG("jackrabbit/speed_mag"),
    JACKRABBIT_LIGHT_STOCK("jackrabbit/light_stock"),
    JACKRABBIT_WOODEN_STOCK("jackrabbit/wooden_stock"),
    JACKRABBIT_WEIGHTED_STOCK("jackrabbit/weighted_stock"),

    CANTER_MAIN("canter/main"),
    CANTER_STANDARD_MAG("canter/default_mag"),
    CANTER_SPEED_MAG("canter/speed_mag"),
    CANTER_EXTENDED_MAG("canter/extended_mag"),
    CANTER_EXTENDED_BARREL("canter/extended_barrel"),
    CANTER_STANDARD_BARREL("canter/standard_barrel"),
    CANTER_SILENCER("canter/silencer"),
    CANTER_ADVANCED_SILENCER("canter/advanced_silencer"),
    CANTER_MUZZLE_BRAKE("canter/muzzle_brake"),

    HARETROT_MAIN("haretrot/main"),
    HARETROT_STANDARD_MAG("haretrot/standard_mag"),
    HARETROT_EXTENDED_MAG("haretrot/extended_mag"),
    HARETROT_SPEED_MAG("haretrot/speed_mag"),


    VOLTER_SP_MAIN("volter_sp/main"),

    MACTRICIA_MAIN("mactricia/main"),
    MACTRICIA_SIGHTS("mactricia/sights"),
    MACTRICIA_IRON_BAYONET("mactricia/iron_bayonet"),
    MACTRICIA_ANTHRALITE_BAYONET("mactricia/anthralite_bayonet"),
    MACTRICIA_DIAMOND_BAYONET("mactricia/diamond_bayonet"),
    MACTRICIA_NETHERITE_BAYONET("mactricia/netherite_bayonet"),
    MACTRICIA_LIGHT_GRIP("mactricia/light_grip"),
    MACTRICIA_VERT_GRIP("mactricia/vertical_grip"),
    MACTRICIA_DEFAULT_MAG("mactricia/default_mag"),
    MACTRICIA_EXTENDED_MAG("mactricia/extended_mag"),
    MACTRICIA_SPEED_MAG("mactricia/speed_mag"),
    MACTRICIA_LIGHT_STOCK("mactricia/light_stock"),
    MACTRICIA_WOODEN_STOCK("mactricia/wooden_stock"),
    MACTRICIA_WEIGHTED_STOCK("mactricia/weighted_stock"),
    MACTRICIA_STANDARD_STOCK("mactricia/standard_grip"),

    AMPERBREAKER_MAIN("amperbreaker/main"),
    AMPERBREAKER_IRON_BAYONET("amperbreaker/iron_bayonet"),
    AMPERBREAKER_ANTHRALITE_BAYONET("amperbreaker/anthralite_bayonet"),
    AMPERBREAKER_DIAMOND_BAYONET("amperbreaker/diamond_bayonet"),
    AMPERBREAKER_NETHERITE_BAYONET("amperbreaker/netherite_bayonet"),
    AMPERBREAKER_LIGHT_GRIP("amperbreaker/light_grip"),
    AMPERBREAKER_VERTICAL_GRIP("amperbreaker/vertical_grip"),
    AMPERBREAKER_LIGHT_STOCK("amperbreaker/light_stock"),
    AMPERBREAKER_WOODEN_STOCK("amperbreaker/wooden_stock"),
    AMPERBREAKER_WEIGHTED_STOCK("amperbreaker/weighted_stock"),
    AMPERBREAKER_STANDARD_STOCK("amperbreaker/standard_grip"),

    JUPITER7_MAIN("jupiter7/main"),
    JUPITER7_NO_SIGHTS("jupiter7/no_sights"),
    JUPITER7_SIGHTS("jupiter7/sights"),



    WOLFHOUND_MAIN("wolfhound/main"),
    WOLFHOUND_STANDARD_BARREL("wolfhound/standard_barrel"),
    WOLFHOUND_EXTENDED_BARREL("wolfhound/extended_barrel"),
    WOLFHOUND_SILENCER("wolfhound/silencer"),
    WOLFHOUND_ADVANCED_SILENCER("wolfhound/advanced_silencer"),
    WOLFHOUND_MUZZLE_BRAKE("wolfhound/muzzle_brake"),

    TIRONE_SMG_MAIN("tirone_smg/main"),
    TIRONE_SMG_STANDARD_BARREL("tirone_smg/standard_barrel"),
    TIRONE_SMG_EXTENDED_BARREL("tirone_smg/extended_barrel"),
    TIRONE_SMG_SILENCER("tirone_smg/silencer"),
    TIRONE_SMG_ADVANCED_SILENCER("tirone_smg/advanced_silencer"),
    TIRONE_SMG_MUZZLE_BRAKE("tirone_smg/muzzle_brake"),
    TIRONE_SMG_IRON_BAYONET("tirone_smg/iron_bayonet"),
    TIRONE_SMG_ANTHRALITE_BAYONET("tirone_smg/anthralite_bayonet"),
    TIRONE_SMG_DIAMOND_BAYONET("tirone_smg/diamond_bayonet"),
    TIRONE_SMG_NETHERITE_BAYONET("tirone_smg/netherite_bayonet"),
    TIRONE_SMG_LIGHT_GRIP("tirone_smg/light_grip"),
    TIRONE_SMG_VERT_GRIP("tirone_smg/vertical_grip"),
    TIRONE_SMG_DEFAULT_MAG("tirone_smg/default_mag"),
    TIRONE_SMG_EXTENDED_MAG("tirone_smg/extended_mag"),
    TIRONE_SMG_SPEED_MAG("tirone_smg/speed_mag"),

    TIRONE_CONVERSION_MAIN("tirone_conversion/main"),
    TIRONE_CONVERSION_STANDARD_BARREL("tirone_conversion/standard_barrel"),
    TIRONE_CONVERSION_EXTENDED_BARREL("tirone_conversion/extended_barrel"),
    TIRONE_CONVERSION_SILENCER("tirone_conversion/silencer"),
    TIRONE_CONVERSION_ADVANCED_SILENCER("tirone_conversion/advanced_silencer"),
    TIRONE_CONVERSION_MUZZLE_BRAKE("tirone_conversion/muzzle_brake"),
    TIRONE_CONVERSION_DEFAULT_MAG("tirone_conversion/default_mag"),
    TIRONE_CONVERSION_EXTENDED_MAG("tirone_conversion/extended_mag"),
    TIRONE_CONVERSION_SPEED_MAG("tirone_conversion/speed_mag"),

    WARTHOG_MAIN("warthog/main"),
    WARTHOG_STANDARD_BARREL("warthog/stan_barrel"),
    WARTHOG_EXTENDED_BARREL("warthog/extended_barrel"),
    WARTHOG_SILENCER("warthog/silencer"),
    WARTHOG_ADVANCED_SILENCER("warthog/advanced_silencer"),
    WARTHOG_MUZZLE_BRAKE("warthog/muzzle_brake"),
    WARTHOG_LIGHT_STOCK("warthog/light_stock"),
    WARTHOG_WOODEN_STOCK("warthog/wooden_stock"),
    WARTHOG_WEIGHTED_STOCK("warthog/weighted_stock"),


    PROSPECTOR_MAIN("prospector/main"),
    PROSPECTOR_STANDARD_BARREL("prospector/standard_barrel"),
    PROSPECTOR_EXTENDED_BARREL("prospector/extended_barrel"),
    PROSPECTOR_SILENCER("prospector/silencer"),
    PROSPECTOR_ADVANCED_SILENCER("prospector/advanced_silencer"),
    PROSPECTOR_MUZZLE_BRAKE("prospector/muzzle_brake"),
    PROSPECTOR_IRON_BAYONET("prospector/iron_bayonet"),
    PROSPECTOR_ANTHRALITE_BAYONET("prospector/anthralite_bayonet"),
    PROSPECTOR_DIAMOND_BAYONET("prospector/diamond_bayonet"),
    PROSPECTOR_NETHERITE_BAYONET("prospector/netherite_bayonet"),
    PROSPECTOR_LIGHT_GRIP("prospector/light_grip"),
    PROSPECTOR_VERT_GRIP("prospector/vertical_grip"),
    PROSPECTOR_DEFAULT_MAG("prospector/default_mag"),
    PROSPECTOR_EXTENDED_MAG("prospector/extended_mag"),
    PROSPECTOR_SPEED_MAG("prospector/speed_mag"),
    PROSPECTOR_LIGHT_STOCK("prospector/light_stock"),
    PROSPECTOR_WOODEN_STOCK("prospector/wooden_stock"),
    PROSPECTOR_WEIGHTED_STOCK("prospector/weighted_stock"),

    CHIMERA_MAIN("chimera/main"),
    CHIMERA_STANDARD_BARREL("chimera/standard_barrel"),
    CHIMERA_EXTENDED_BARREL("chimera/extended_barrel"),
    CHIMERA_SILENCER("chimera/silencer"),
    CHIMERA_ADVANCED_SILENCER("chimera/advanced_silencer"),
    CHIMERA_MUZZLE_BRAKE("chimera/muzzle_brake"),
    CHIMERA_IRON_BAYONET("chimera/iron_bayonet"),
    CHIMERA_ANTHRALITE_BAYONET("chimera/anthralite_bayonet"),
    CHIMERA_DIAMOND_BAYONET("chimera/diamond_bayonet"),
    CHIMERA_NETHERITE_BAYONET("chimera/netherite_bayonet"),
    CHIMERA_LIGHT_GRIP("chimera/light_grip"),
    CHIMERA_VERT_GRIP("chimera/vertical_grip"),
    CHIMERA_DEFAULT_MAG("chimera/default_mag"),
    CHIMERA_EXTENDED_MAG("chimera/extended_mag"),
    CHIMERA_SPEED_MAG("chimera/speed_mag"),
    CHIMERA_LIGHT_STOCK("chimera/light_stock"),
    CHIMERA_WOODEN_STOCK("chimera/wooden_stock"),
    CHIMERA_WEIGHTED_STOCK("chimera/weighted_stock"),
    CHIMERA_SIGHTS("chimera/sights"),
    CHIMERA_NO_SIGHTS("chimera/no_sights"),

    APOTHEOSIS_MAIN("apotheosis/main"),
    APOTHEOSIS_STANDARD_BARREL("apotheosis/standard_barrel"),
    APOTHEOSIS_EXTENDED_BARREL("apotheosis/extended_barrel"),
    APOTHEOSIS_SILENCER("apotheosis/silencer"),
    APOTHEOSIS_ADVANCED_SILENCER("apotheosis/advanced_silencer"),
    APOTHEOSIS_MUZZLE_BRAKE("apotheosis/muzzle_brake"),
    APOTHEOSIS_IRON_BAYONET("apotheosis/iron_bayonet"),
    APOTHEOSIS_ANTHRALITE_BAYONET("apotheosis/anthralite_bayonet"),
    APOTHEOSIS_DIAMOND_BAYONET("apotheosis/diamond_bayonet"),
    APOTHEOSIS_NETHERITE_BAYONET("apotheosis/netherite_bayonet"),
    APOTHEOSIS_LIGHT_GRIP("apotheosis/light_grip"),
    APOTHEOSIS_VERT_GRIP("apotheosis/vertical_grip"),
    APOTHEOSIS_DEFAULT_MAG("apotheosis/default_mag"),
    APOTHEOSIS_EXTENDED_MAG("apotheosis/extended_mag"),
    APOTHEOSIS_SPEED_MAG("apotheosis/speed_mag"),
    APOTHEOSIS_LIGHT_STOCK("apotheosis/light_stock"),
    APOTHEOSIS_WOODEN_STOCK("apotheosis/wooden_stock"),
    APOTHEOSIS_WEIGHTED_STOCK("apotheosis/weighted_stock"),

    SABRETUSK_MAIN("sabretusk/main"),

    NEMESIS_MAIN("nemesis/main"),
    NEMESIS_STANDARD_BARREL("nemesis/standard_barrel"),
    NEMESIS_EXTENDED_BARREL("nemesis/extended_barrel"),
    NEMESIS_SILENCER("nemesis/silencer"),
    NEMESIS_ADVANCED_SILENCER("nemesis/advanced_silencer"),
    NEMESIS_MUZZLE_BRAKE("nemesis/muzzle_brake"),
    NEMESIS_IRON_BAYONET("nemesis/iron_bayonet"),
    NEMESIS_ANTHRALITE_BAYONET("nemesis/anthralite_bayonet"),
    NEMESIS_DIAMOND_BAYONET("nemesis/diamond_bayonet"),
    NEMESIS_NETHERITE_BAYONET("nemesis/netherite_bayonet"),
    NEMESIS_LIGHT_GRIP("nemesis/light_grip"),
    NEMESIS_VERT_GRIP("nemesis/vertical_grip"),
    NEMESIS_LIGHT_STOCK("nemesis/light_stock"),
    NEMESIS_WOODEN_STOCK("nemesis/wooden_stock"),
    NEMESIS_WEIGHTED_STOCK("nemesis/weighted_stock"),

    MEGATHERIUM_MAIN("megatherium/main"),
    MEGATHERIUM_STANDARD_BARREL("megatherium/standard_barrel"),
    MEGATHERIUM_EXTENDED_BARREL("megatherium/extended_barrel"),
    MEGATHERIUM_SILENCER("megatherium/silencer"),
    MEGATHERIUM_ADVANCED_SILENCER("megatherium/advanced_silencer"),
    MEGATHERIUM_MUZZLE_BRAKE("megatherium/muzzle_brake"),
    MEGATHERIUM_DEFAULT_MAG("megatherium/default_mag"),
    MEGATHERIUM_EXTENDED_MAG("megatherium/extended_mag"),
    MEGATHERIUM_SPEED_MAG("megatherium/speed_mag"),
    MEGATHERIUM_LIGHT_STOCK("megatherium/light_stock"),
    MEGATHERIUM_WOODEN_STOCK("megatherium/wooden_stock"),
    MEGATHERIUM_WEIGHTED_STOCK("megatherium/weighted_stock"),

    DUSTER_MAIN("duster/main"),
    DUSTER_IRON_BAYONET("duster/iron_bayonet"),
    DUSTER_ANTHRALITE_BAYONET("duster/anthralite_bayonet"),
    DUSTER_DIAMOND_BAYONET("duster/diamond_bayonet"),
    DUSTER_NETHERITE_BAYONET("duster/netherite_bayonet"),
    DUSTER_LIGHT_GRIP("duster/light_grip"),
    DUSTER_VERT_GRIP("duster/vertical_grip"),

    TRENCHBROOM_MAIN("trenchbroom/main"),
    TRENCHBROOM_LIGHT_STOCK("trenchbroom/light_stock"),
    TRENCHBROOM_WOODEN_STOCK("trenchbroom/wooden_stock"),
    TRENCHBROOM_WEIGHTED_STOCK("trenchbroom/weighted_stock");






    /**
     * The location of an item model in the [MOD_ID]/models/special/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Cached model
     */
    private BakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    OregunizedSpecialModels(String modelName) {
        this.modelLocation = new ResourceLocation(MOD_ID, "special/" + modelName);
    }

    /**
     * Registers the special models into the Forge Model Bakery. This is only called once on the
     * load of the game.
     */
    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event) {
        for (OregunizedSpecialModels model : values()) {
            event.register(model.modelLocation);
        }
    }

    /**
     * Clears the cached BakedModel since it's been rebuilt. This is needed since the models may
     * have changed when a resource pack was applied, or if resources are reloaded.
     */
    @SubscribeEvent
    public static void onBake(ModelEvent.BakingCompleted event) {
        for (OregunizedSpecialModels model : values()) {
            model.cachedModel = null;
        }
    }

    /**
     * Gets the model
     *
     * @return isolated model
     */
    public BakedModel getModel() {
        if (this.cachedModel == null) {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }
    }