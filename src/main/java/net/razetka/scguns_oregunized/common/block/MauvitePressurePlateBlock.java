package net.razetka.scguns_oregunized.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.TntBlock.explode;


public class MauvitePressurePlateBlock extends PressurePlateBlock {
    private BlockSetType type;

    public MauvitePressurePlateBlock(Sensitivity pSensitivity, Properties pProperties, BlockSetType pType) {
        super(pSensitivity, pProperties, pType);
        type = pType;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);

        if (!pState.getValue(POWERED)) {
            pLevel.setBlock(pPos, pState.setValue(POWERED, true),3);
            pLevel.playSound(null, pPos, this.type.pressurePlateClickOn(), SoundSource.BLOCKS);
            this.updateNeighbours(pLevel, pPos);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pState.getValue(POWERED)) {
            pLevel.setBlock(pPos, pState.setValue(POWERED, false), 3);
            this.updateNeighbours(pLevel, pPos);
            pLevel.playSound(null, pPos, this.type.pressurePlateClickOff(), SoundSource.BLOCKS);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
