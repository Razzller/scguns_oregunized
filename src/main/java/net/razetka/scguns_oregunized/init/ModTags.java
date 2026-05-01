package net.razetka.scguns_oregunized.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModTags{
    public static final TagKey<Item> STELLAR_ORDER_TIER = createSCGunsItemTag("stellar_order_gun_tier");

    public static final TagKey<Block> MINEABLE_SLEDGEHAMMER = BlockTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "mineable_sledgehammer"));

    public static class Entities {
        public static final TagKey<EntityType<?>> WHITE_WOLF_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MOD_ID, "white_wolf_mobs"));
        public static final TagKey<EntityType<?>> STELLAR_ORDER_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MOD_ID, "stellar_order_mobs"));
    }
    private static TagKey<Item> createSCGunsItemTag(String tagName){
        return TagKey.create(Registries.ITEM, new ResourceLocation("scguns", tagName));
    }
}
