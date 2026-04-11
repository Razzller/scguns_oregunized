package net.razetka.scguns_oregunized.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MOD_ID);

    public static final RegistryObject<PaintingVariant> GOLDEN_CUBE = PAINTINGS.register("golden_cube",
            () -> new PaintingVariant(32,32));

    public static void register(IEventBus eventBus) {
        PAINTINGS.register(eventBus);
    }
}
