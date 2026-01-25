package net.razetka.scguns_oregunized.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.scguns.Reference;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);

    public static final RegistryObject<SoundEvent> AMPERBREAKER_FIRE = register("item.amperbreaker.fire");
    public static final RegistryObject<SoundEvent> MACTRICIA_FIRE = register("item.mactricia.fire");
    public static final RegistryObject<SoundEvent> VOLTERSP_FIRE = register ("item.volter_sp.fire");

    public static void register(IEventBus eventbus) {SOUNDS.register(eventbus);}

    private static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID, key)));
    }
}
