package net.razetka.scguns_oregunized.common.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.razetka.scguns_oregunized.common.ShockwaveExplosion;
import net.razetka.scguns_oregunized.init.ModBlocks;

import javax.annotation.Nullable;
import java.util.List;

public class AnchorBlock extends FallingBlock {
    private static final int fallDamagePerDistance = 3;
    private static final int fallDamageMax = 60;
    public float storedFallDistance = 0;

    public AnchorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("WIP: Currently broken and I have no idea how to fix it")
                .withStyle(ChatFormatting.GRAY)
                .withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }




    @Override
    public void onLand(Level level, BlockPos pos, BlockState state, BlockState replaceableState, FallingBlockEntity fallingBlock) {
        if (!level.isClientSide()) {
            ShockwaveExplosion.shockwaveExplode(level, pos, storedFallDistance);
            storedFallDistance = 0;
            if (state.getBlock() == ModBlocks.MAUVITE_ANCHOR.get()) {
                level.removeBlock(pos, false);
            }
        }
    }

    @Override
    public void falling(FallingBlockEntity pEntity) {
        pEntity.setHurtsEntities(fallDamagePerDistance, fallDamageMax);
        if (!pEntity.level().isClientSide()) {
            storedFallDistance = pEntity.fallDistance;
            System.out.println(storedFallDistance);
        }
    }
}
