package net.razetka.scguns_oregunized.common.item;

import net.minecraft.sounds.SoundEvent;
import top.ribs.scguns.item.animated.AnimatedGunItem;

public class ElectrumGunClass extends AnimatedGunItem {
    public ElectrumGunClass(Properties properties, String path, SoundEvent reloadSoundMagOut, SoundEvent reloadSoundMagIn, SoundEvent reloadSoundEnd, SoundEvent boltPullSound, SoundEvent boltReleaseSound) {
        super(properties, path, reloadSoundMagOut, reloadSoundMagIn, reloadSoundEnd, boltPullSound, boltReleaseSound);
    }
}
