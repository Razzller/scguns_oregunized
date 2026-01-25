package net.razetka.scguns_oregunized.events.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
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

    AVANTRIMA_MAIN("avantrima/main"),
    AVANTRIMA_STANDARD_BARREL("avantrima/standard_barrel"),
    AVANTRIMA_EXTENDED_BARREL("avantrima/extended_barrel"),
    AVANTRIMA_SILENCER("avantrima/silencer"),
    AVANTRIMA_ADVANCED_SILENCER("avantrima/advanced_silencer"),
    AVANTRIMA_MUZZLE_BRAKE("avantrima/muzzle_brake"),

    HARETROT_MAIN("haretrot/main"),
    HARETROT_STANDARD_MAG("haretrot/standard_mag"),
    HARETROT_EXTENDED_MAG("haretrot/extended_mag"),
    HARETROT_SPEED_MAG("haretrot/speed_mag"),


    VOLTER_SP_MAIN("volter_sp/main"),

    MACTRICIA_MAIN("mactricia/main"),

    AMPERBREAKER_MAIN("amperbreaker/main");






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
        this.modelLocation = new ResourceLocation(MODID, "special/" + modelName);
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