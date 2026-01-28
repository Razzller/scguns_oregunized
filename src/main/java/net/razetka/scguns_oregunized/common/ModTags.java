package net.razetka.scguns_oregunized.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;

public class ModTags{
    public static final TagKey<Item> STELLAR_ORDER_TIER = createSCGunsItemTag("stellar_order_tier");

    private static TagKey<Item> createSCGunsItemTag(String tagName){
        return TagKey.create(Registries.ITEM, new ResourceLocation("scguns", tagName));
    }
}
