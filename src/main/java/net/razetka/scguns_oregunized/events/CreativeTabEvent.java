package net.razetka.scguns_oregunized.events;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.scguns.init.ModCreativeModeTabs;
import top.ribs.scguns.item.GunItem;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;
import static net.razetka.scguns_oregunized.init.ModItems.*;
import static top.ribs.scguns.init.ModItems.*;

/**
 * Author: Atoba Azul
 */

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabEvent {

    @SubscribeEvent
    public static void populateTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeModeTabs.SCORCHED_GUNS_TAB.getKey()) {
            MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entry = event.getEntries();
            putGunItemsAfterGun(entry, SHARD_CULLER, JUPITER7, AMPERBREAKER, MACTRICIA, VOLTERSP, HARETROT, CANTER, JACKRABBIT, AVANTRIMA, HERMES, WHIRLWIND);
            putGunItemsAfterGun(entry, ULTRA_KNIGHT_HAWK, TRENCHBROOM, DUSTER, MEGATHERIUM, NEMESIS, SABRETUSK, APOTHEOSIS, CHIMERA, PROSPECTOR, TIRONE_CONVERSION, TIRONE_SMG, WARTHOG, WOLFHOUND);
        }
    }

    @SafeVarargs
    public static void putGunItemsAfterGun(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entry, RegistryObject<? extends Item> before, RegistryObject<? extends Item>... stack) {
        for (RegistryObject<? extends Item> registryObject : stack) {
            entry.putAfter(getGunWithFullAmmo(before), getGunWithFullAmmo(registryObject), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static ItemStack getGunWithFullAmmo(RegistryObject<? extends Item> item) {
        ItemStack stack = item.get().getDefaultInstance();
        Item _item = item.get();
        GunItem gunItem = (GunItem) _item;
        stack.getOrCreateTag().putInt("AmmoCount", gunItem.getGun().getReloads().getMaxAmmo());

        return stack;
    }
}

