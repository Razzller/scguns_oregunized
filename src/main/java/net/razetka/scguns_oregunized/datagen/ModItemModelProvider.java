package net.razetka.scguns_oregunized.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.init.ModItems;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STELLAR_ORDER_FLARE);
        simpleItem(ModItems.STELLAR_ORDER_BLUEPRINT);
        simpleItem(ModItems.ELECTRUM_GUN_FRAME);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), "item/generated").texture("layer0", modLoc("item/" + item.getId().getPath()));
    }
}
