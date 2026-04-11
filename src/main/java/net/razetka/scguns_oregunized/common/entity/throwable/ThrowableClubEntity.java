package net.razetka.scguns_oregunized.common.entity.throwable;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.razetka.scguns_oregunized.init.ModEffects;
import net.razetka.scguns_oregunized.init.ModEntities;
import net.razetka.scguns_oregunized.init.ModItems;
import top.ribs.scguns.entity.throwable.ThrowableGrenadeEntity;
import top.ribs.scguns.entity.throwable.ThrowableItemEntity;
import top.ribs.scguns.item.AmmoItem;

public class ThrowableClubEntity extends AmmoItem {
    public ThrowableClubEntity(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack item) { return UseAnim.BOW; }

//    public void onUseTick(Level level, LivingEntity player, ItemStack stack, int count) {
//        if(!this.canCook())
//            return;
//
//        int duration = this.getUseDuration(stack) - count;
//    }
//
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
//        ItemStack stack = playerIn.getItemInHand(handIn);
//        playerIn.startUsingItem(handIn);
//
//        if (!worldIn.isClientSide()) {
//            if (playerIn instanceof Player) {
//                Player player = (Player) playerIn;
//                if
//            }
//        }
//        return InteractionResultHolder.consume(stack);
//    }
}