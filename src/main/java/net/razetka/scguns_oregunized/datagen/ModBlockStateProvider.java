package net.razetka.scguns_oregunized.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.init.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ScGunsOregunized.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAUVITE_BLOCK);
        blockWithItem(ModBlocks.MAUVITE_BRICKS);
        stairsBlock((StairBlock) ModBlocks.MAUVITE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MAUVITE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MAUVITE_BRICK_SLAB.get()), blockTexture(ModBlocks.MAUVITE_BRICKS.get()), blockTexture(ModBlocks.MAUVITE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.MAUVITE_BRICK_WALL.get()), blockTexture(ModBlocks.MAUVITE_BRICKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.MAUVITE_BUTTON.get(), blockTexture(ModBlocks.MAUVITE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MAUVITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAUVITE_BLOCK.get()));

        blockWithItem(ModBlocks.SILVER_LAMP);
        logBlock((RotatedPillarBlock) ModBlocks.SILVER_PILLAR.get());
        blockWithItem(ModBlocks.CHISELED_SILVER);

        blockWithItem(ModBlocks.SILVER_MOSAIC);
        stairsBlock((StairBlock) ModBlocks.SILVER_MOSAIC_STAIRS.get(), blockTexture(ModBlocks.SILVER_MOSAIC.get()));
        slabBlock(((SlabBlock) ModBlocks.SILVER_MOSAIC_SLAB.get()), blockTexture(ModBlocks.SILVER_MOSAIC.get()), blockTexture(ModBlocks.SILVER_MOSAIC.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
