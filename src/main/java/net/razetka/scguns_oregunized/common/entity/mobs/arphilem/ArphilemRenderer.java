package net.razetka.scguns_oregunized.common.entity.mobs.arphilem;

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
public class ArphilemRenderer extends MobRenderer<ArphilemEntity, ArphilemModel<ArphilemEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/arphilem.png");

    public ArphilemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArphilemModel<>(pContext.bakeLayer(ModModelLayers.ARPHILEM_LAYER)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ArphilemEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(ArphilemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(0.95f, 0.95f, 0.95f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
