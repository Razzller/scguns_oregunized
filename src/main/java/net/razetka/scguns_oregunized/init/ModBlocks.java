package net.razetka.scguns_oregunized.init;

import galena.oreganized.index.OBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razetka.scguns_oregunized.ScGunsOregunized;
import net.razetka.scguns_oregunized.common.block.LuxuriousVaseBlock;
import net.razetka.scguns_oregunized.common.block.MauvitePressurePlateBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ScGunsOregunized.MOD_ID);

    public static final RegistryObject<Block> MAUVITE_BLOCK = registerBlock("mauvite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> MAUVITE_BRICKS = registerBlock("mauvite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> MAUVITE_BRICK_STAIRS = registerBlock("mauvite_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MAUVITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MAUVITE_BRICKS.get())));

    public static final RegistryObject<Block> MAUVITE_BRICK_SLAB = registerBlock("mauvite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(MAUVITE_BRICKS.get())));

    public static final RegistryObject<Block> MAUVITE_BRICK_WALL = registerBlock("mauvite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(MAUVITE_BRICKS.get())));

    public static final RegistryObject<Block> MAUVITE_BUTTON = registerBlock("mauvite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.METAL).noOcclusion().noCollission(), BlockSetType.IRON, 60, false));

    public static final RegistryObject<Block> MAUVITE_PRESSURE_PLATE = registerBlock("mauvite_pressure_plate",
            () -> new MauvitePressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).noOcclusion().noCollission(), BlockSetType.IRON));



    public static final RegistryObject<Block> SILVER_LAMP = registerBlock("silver_lamp",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN)
                    .sound(SoundType.GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> SILVER_LANTERN = registerBlock("silver_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.GLASS)));


    public static final RegistryObject<Block> SILVER_MOSAIC = registerBlock("silver_mosaic",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SILVER_MOSAIC_STAIRS = registerBlock("silver_mosaic_stairs",
            () -> new StairBlock(() -> ModBlocks.MAUVITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SILVER_MOSAIC.get())));
    public static final RegistryObject<Block> SILVER_MOSAIC_SLAB = registerBlock("silver_mosaic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(SILVER_MOSAIC.get())));

    public static final RegistryObject<Block> SILVER_PILLAR = registerBlock("silver_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CHISELED_SILVER = registerBlock("chiseled_silver",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SILVER_BARS = registerBlock("silver_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> LUXURIOUS_VASE = registerBlock("luxurious_vase",
            () -> new LuxuriousVaseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instabreak()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
