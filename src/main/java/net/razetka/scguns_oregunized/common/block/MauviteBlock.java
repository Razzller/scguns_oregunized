package net.razetka.scguns_oregunized.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MauviteBlock extends FallingBlock {
    private static final int fallDamagePerDistance = 3;
    private static final int fallDamageMax = 60;
    public int currentLandCount = 5;

    public MauviteBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void falling(FallingBlockEntity pEntity) { pEntity.setHurtsEntities(fallDamagePerDistance,fallDamageMax); }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState state, BlockState replaceableState, FallingBlockEntity fallingBlock) {

        float hardness = state.getDestroySpeed(level, pos.below());
        if (hardness <= 30 && hardness > 0 && currentLandCount > 0) {
            level.destroyBlock(pos.below(), true);
            currentLandCount -= 1;
            if (currentLandCount == 0) {
                level.destroyBlock(pos, true);
            }
        }
    }
}
