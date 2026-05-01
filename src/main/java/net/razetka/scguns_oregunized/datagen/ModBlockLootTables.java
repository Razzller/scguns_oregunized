package net.razetka.scguns_oregunized.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.init.ModBlocks;

import java.util.Set;


public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MAUVITE_BLOCK.get());
        this.dropSelf(ModBlocks.MAUVITE_BUTTON.get());
        this.dropSelf(ModBlocks.MAUVITE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAUVITE_BRICKS.get());
        this.dropSelf(ModBlocks.MAUVITE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.MAUVITE_BRICK_SLAB.get());
        this.dropSelf(ModBlocks.MAUVITE_BRICK_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
