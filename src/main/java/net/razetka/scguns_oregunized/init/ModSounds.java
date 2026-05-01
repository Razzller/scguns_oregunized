package net.razetka.scguns_oregunized.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> AMPERBREAKER_FIRE = register("item.amperbreaker.fire");
    public static final RegistryObject<SoundEvent> MACTRICIA_FIRE = register("item.mactricia.fire");
    public static final RegistryObject<SoundEvent> VOLTERSP_FIRE = register("item.volter_sp.fire");

    public static final RegistryObject<SoundEvent> ARPHILEM_IDLE = register("entity.arphilem.idle");
    public static final RegistryObject<SoundEvent> ARPHILEM_HURT = register("entity.arphilem.hurt");
    public static final RegistryObject<SoundEvent> ARPHILEM_DEATH = register("entity.arphilem.death");

    public static final RegistryObject<SoundEvent> TIRONE_IDLE = register("entity.tirone.idle");
    public static final RegistryObject<SoundEvent> TIRONE_HURT = register("entity.tirone.hurt");
    public static final RegistryObject<SoundEvent> TIRONE_DEATH = register("entity.tirone.death");



    public static void register(IEventBus eventbus) {SOUNDS.register(eventbus);}

    private static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, key)));
    }
}
