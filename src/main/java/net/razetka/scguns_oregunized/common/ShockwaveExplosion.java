package net.razetka.scguns_oregunized.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;


public class ShockwaveExplosion {

    ShockwaveExplosion(Level pLevel, BlockPos pPos, float fallDistance) {}

    public static void shockwaveExplode(Level pLevel, BlockPos pPos, float fallDistance) {
        float explosionPower = Math.min ((fallDistance / 6.0f), 10.0f);
        pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), explosionPower, Level.ExplosionInteraction.NONE);
    }
}

