package net.razetka.scguns_oregunized.common.entity.mobs.archon;

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
public class ArchonRenderer extends MobRenderer<ArchonEntity, ArchonModel<ArchonEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/archon.png");

    public ArchonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArchonModel<>(pContext.bakeLayer(ModModelLayers.ARCHON_LAYER)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, pContext.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ArchonEntity pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(ArchonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(1.0625F, 1.0625F, 1.0625F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
