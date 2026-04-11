package net.razetka.scguns_oregunized.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class LeadHitParticle extends TextureSheetParticle {
    LeadHitParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
        this.friction = 0.7F;
        this.gravity = 0.5F;
        this.xd *= (double)0.1F;
        this.yd *= (double)0.1F;
        this.zd *= (double)0.1F;
        this.xd += pXSpeed * 0.4D;
        this.yd += pYSpeed * 0.4D;
        this.zd += pZSpeed * 0.4D;
        float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
        this.rCol = f;
        this.gCol = f;
        this.bCol = f;
        this.quadSize *= 0.75F;
        this.lifetime = (int) (Math.random() * 10 + 15); //Gives a number between 15 and 25
        this.hasPhysics = false;
        this.tick();
    }

    protected LeadHitParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }

    public float getQuadSize(float pScaleFactor) {
        return this.quadSize * Mth.clamp(((float)this.age + pScaleFactor) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }



    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class DamageIndicatorProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public DamageIndicatorProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            LeadHitParticle leadHitParticle = new LeadHitParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed + 1.0D, pZSpeed);
            leadHitParticle.setLifetime(20);
            leadHitParticle.pickSprite(this.sprite);
            return leadHitParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class MagicProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public MagicProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            LeadHitParticle leadHitParticle = new LeadHitParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed + 1.0, pZSpeed);
            leadHitParticle.pickSprite(this.sprite);
            return leadHitParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            LeadHitParticle leadHitParticle = new LeadHitParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed + 1.0, pZSpeed);
            leadHitParticle.pickSprite(this.sprite);
            return leadHitParticle;
        }
    }
}

