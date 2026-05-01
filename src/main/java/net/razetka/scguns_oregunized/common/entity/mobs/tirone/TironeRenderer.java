package net.razetka.scguns_oregunized.common.entity.mobs.tirone;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.razetka.scguns_oregunized.client.ModModelLayers;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class TironeRenderer extends MobRenderer<TironeEntity, TironeModel<TironeEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/tirone.png");

    public TironeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TironeModel<>(pContext.bakeLayer(ModModelLayers.TIRONE_LAYER)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(TironeEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(TironeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
