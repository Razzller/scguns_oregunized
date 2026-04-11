package net.razetka.scguns_oregunized.common.entity.mobs;

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
public class ArgonautRenderer extends MobRenderer<ArgonautEntity, ArgonautModel<ArgonautEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/argonaut.png");

    public ArgonautRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArgonautModel<>(pContext.bakeLayer(ModModelLayers.ARGONAUT_LAYER)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ArgonautEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(ArgonautEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(1.0f, 1.0f, 1.0f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
