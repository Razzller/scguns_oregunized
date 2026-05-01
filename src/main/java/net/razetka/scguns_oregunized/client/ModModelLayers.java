package net.razetka.scguns_oregunized.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModModelLayers {
    public static final ModelLayerLocation TIRONE_LAYER = new ModelLayerLocation(
            new ResourceLocation(MOD_ID, "argonaut_layer"), "main");
    public static final ModelLayerLocation CENTURION_LAYER = new ModelLayerLocation(
            new ResourceLocation(MOD_ID, "centurion_layer"), "main");
    public static final ModelLayerLocation ARPHILEM_LAYER = new ModelLayerLocation(
            new ResourceLocation(MOD_ID, "arphilem_layer"), "main");
    public static final ModelLayerLocation ARCHON_LAYER = new ModelLayerLocation(
            new ResourceLocation(MOD_ID, "archon_layer"), "main");
}
