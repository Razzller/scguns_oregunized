package net.razetka.scguns_oregunized.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.init.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STELLAR_ORDER_FLARE);
        simpleItem(ModItems.STELLAR_ORDER_BLUEPRINT);
        simpleItem(ModItems.ELECTRUM_GUN_FRAME);
        simpleItem(ModItems.LEAD_ROUND);
        simpleItem(ModItems.LEAD_SLUG);
        simpleItem(ModItems.INCENDIARY_ROUND);
        simpleItem(ModItems.MAUVITE_INGOT);
        simpleItem(ModItems.MAUVITE_NUGGET);
        simpleItem(ModItems.MAUVITE_GUN_FRAME);
        simpleItem(ModItems.MAUVITE_BLEND);
        simpleItem(ModItems.SMALL_MAUVITE_CASING);
        simpleItem(ModItems.MEDIUM_MAUVITE_CASING);
        simpleItem(ModItems.LARGE_MAUVITE_CASING);
        simpleItem(ModItems.UNFINISHED_LEAD_ROUND);
        simpleItem(ModItems.UNFINISHED_LEAD_SLUG);
        simpleItem(ModItems.UNFINISHED_INCENDIARY_ROUND);
        simpleItem(ModItems.MAUVITE_HELMET);
        simpleItem(ModItems.MAUVITE_CHESTPLATE);
        simpleItem(ModItems.MAUVITE_LEGGINGS);
        simpleItem(ModItems.MAUVITE_BOOTS);
        simpleItem(ModItems.SUPER_POISONOUS_POTATO);




//        evenSimplerBlockItem(ModBlocks.MAUVITE_BRICK_STAIRS);
//        evenSimplerBlockItem(ModBlocks.MAUVITE_BRICK_SLAB);
//        evenSimplerBlockItem(ModBlocks.MAUVITE_BRICK_WALL);
//        evenSimplerBlockItem(ModBlocks.MAUVITE_BUTTON);
//        evenSimplerBlockItem(ModBlocks.MAUVITE_PRESSURE_PLATE);
//        evenSimplerBlockItem(ModBlocks.SILVER_MOSAIC_STAIRS);
//        evenSimplerBlockItem(ModBlocks.SILVER_MOSAIC_SLAB);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID, "item/" + item.getId().getPath()));
    }


    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
