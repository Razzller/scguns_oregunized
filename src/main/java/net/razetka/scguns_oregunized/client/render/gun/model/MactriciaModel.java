package net.razetka.scguns_oregunized.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.razetka.scguns_oregunized.events.client.OregunizedSpecialModels;
import top.ribs.scguns.client.render.gun.IOverrideModel;
import top.ribs.scguns.client.util.RenderUtil;
import top.ribs.scguns.common.Gun;
import top.ribs.scguns.init.ModItems;
import top.ribs.scguns.item.attachment.IAttachment;

public class MactriciaModel implements IOverrideModel {
    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_MAIN.getModel(), stack, matrixStack, buffer, light, overlay);
        renderStockAndAttachments(stack, matrixStack, buffer, light, overlay);
        renderGripAttachments(stack, matrixStack, buffer, light, overlay);
        renderMagazineAttachments(stack, matrixStack, buffer, light, overlay);
    }

    private void renderStockAndAttachments(ItemStack stack, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        if ((Gun.hasAttachmentEquipped(stack, IAttachment.Type.STOCK))) {
            if (Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ModItems.WOODEN_STOCK.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_WOODEN_STOCK.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ModItems.LIGHT_STOCK.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_LIGHT_STOCK.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ModItems.WEIGHTED_STOCK.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_WEIGHTED_STOCK.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ModItems.BUMP_STOCK.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_WEIGHTED_STOCK.getModel(), stack, matrixStack, buffer, light, overlay);

        } else
            RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_STANDARD_STOCK.getModel(), stack, matrixStack, buffer, light, overlay);
    }

    private void renderMagazineAttachments(ItemStack stack, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        if (Gun.hasAttachmentEquipped(stack, IAttachment.Type.MAGAZINE)) {
            if (Gun.getAttachment(IAttachment.Type.MAGAZINE, stack).getItem() == ModItems.EXTENDED_MAG.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_EXTENDED_MAG.getModel(), stack, matrixStack, buffer, light, overlay);
            if (Gun.getAttachment(IAttachment.Type.MAGAZINE, stack).getItem() == ModItems.SPEED_MAG.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_SPEED_MAG.getModel(), stack, matrixStack, buffer, light, overlay);
            if (Gun.getAttachment(IAttachment.Type.MAGAZINE, stack).getItem() == ModItems.PLUS_P_MAG.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_EXTENDED_MAG.getModel(), stack, matrixStack, buffer, light, overlay);
        } else {
            RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_DEFAULT_MAG.getModel(), stack, matrixStack, buffer, light, overlay);
        }
    }

    private void renderGripAttachments(ItemStack stack, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        if (Gun.hasAttachmentEquipped(stack, IAttachment.Type.UNDER_BARREL)) {
            if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.VERTICAL_GRIP.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_VERT_GRIP.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.LIGHT_GRIP.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_LIGHT_GRIP.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.IRON_BAYONET.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_IRON_BAYONET.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.ANTHRALITE_BAYONET.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_ANTHRALITE_BAYONET.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.DIAMOND_BAYONET.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_DIAMOND_BAYONET.getModel(), stack, matrixStack, buffer, light, overlay);
            else if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModItems.NETHERITE_BAYONET.get())
                RenderUtil.renderModel(OregunizedSpecialModels.MACTRICIA_NETHERITE_BAYONET.getModel(), stack, matrixStack, buffer, light, overlay);
        }
    }

}
