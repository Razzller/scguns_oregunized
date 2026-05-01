package net.razetka.scguns_oregunized.events;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.attributes.ModAttributes;
import net.razetka.scguns_oregunized.common.ShockwaveExplosion;
import net.razetka.scguns_oregunized.common.entity.mobs.archon.ArchonEntity;
import net.razetka.scguns_oregunized.common.entity.mobs.arphilem.ArphilemEntity;
import net.razetka.scguns_oregunized.init.ModItems;
import top.ribs.scguns.entity.monster.AdjudicatorEntity;
import top.ribs.scguns.entity.monster.SubjugatorEntity;
import top.ribs.scguns.init.ModDamageTypes;
import top.ribs.scguns.init.ModEntities;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void LivingHurtEvent(LivingHurtEvent event) {
        handleFallDamageReduction(event);
        handleBulletDamageReduction(event);
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AdjudicatorEntity || event.getEntity() instanceof SubjugatorEntity) {
            Monster entity = (Monster) event.getEntity();

            entity.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(entity, ArphilemEntity.class, true));
            entity.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(entity, ArchonEntity.class, true));
        }
    }


    private static void handleFallDamageReduction(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            LivingEntity player = event.getEntity();
            DamageSource source = event.getSource();
            AttributeInstance attribute = player.getAttribute(ModAttributes.FALL_DAMAGE_REDUCTION.get());
            if (attribute != null && source.is(DamageTypes.FALL)) {
                float newDamage = (float) (event.getAmount() - event.getAmount() * attribute.getValue() );
                event.setAmount(newDamage);
            }
        }
    }

    private static void handleBulletDamageReduction(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            LivingEntity player = event.getEntity();
            DamageSource source = event.getSource();
            AttributeInstance attribute = player.getAttribute(ModAttributes.BULLET_DAMAGE_REDUCTION.get());
            if (attribute != null && source.is(DamageTypeTags.IS_PROJECTILE) ||
                    source.is(ModDamageTypes.BULLET)) { // Why the hell the BULLET isn't in IS_PROJECTILE damage type tag
                float newDamage = (float) (event.getAmount() - (event.getAmount() * attribute.getValue() ));
                event.setAmount(newDamage);
            }
        }
    }
}
