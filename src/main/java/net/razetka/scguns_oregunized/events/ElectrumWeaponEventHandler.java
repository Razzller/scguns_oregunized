package net.razetka.scguns_oregunized.events;

import galena.oreganized.index.OArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.razetka.scguns_oregunized.common.ModTags;
import net.razetka.scguns_oregunized.init.ModEffects;

import static net.razetka.scguns_oregunized.init.ModEffects.OVERLOAD;

@Mod.EventBusSubscriber(modid = "scguns_oregunized")
public class ElectrumWeaponEventHandler {



    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            attemptAddEffect(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player player) {
            attemptAddEffect(player);
        }
    }

    private static void attemptAddEffect(Player player) {
        ItemStack mainHandItem = player.getMainHandItem();
        ItemStack offHandItem = player.getOffhandItem();
        MobEffectInstance effect = player.getEffect(MobEffects.MOVEMENT_SPEED);

        boolean isHoldingSpecialItem = isElectrumWeapon(mainHandItem) || isElectrumWeapon(offHandItem);

        if (isHoldingSpecialItem) {
            if (isWearingFullSet(player) && isCorrectArmor(player)) {
                player.addEffect(new MobEffectInstance(OVERLOAD.get(), 20, 1, false, false));
            }
            else {
                player.addEffect(new MobEffectInstance(OVERLOAD.get(), 20, 0, false, false));
            } //
              // Is there a better way to do this? There is. Am I going to fix this? Nah
        }
    }

    private static boolean isElectrumWeapon(ItemStack itemStack) {
        return !itemStack.isEmpty() && itemStack.is(ModTags.STELLAR_ORDER_TIER);
    }

    private static boolean isWearingFullSet(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() &&
                !leggings.isEmpty() &&
                !chestplate.isEmpty() &&
                !helmet.isEmpty();
    }

    private static boolean isCorrectArmor(Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {return false;}
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        OArmorMaterials electrumMaterial = OArmorMaterials.ELECTRUM;

        return helmet.getMaterial() == electrumMaterial &&
                chestplate.getMaterial() == electrumMaterial &&
                leggings.getMaterial() == electrumMaterial &&
                boots.getMaterial() == electrumMaterial;
    }
}
