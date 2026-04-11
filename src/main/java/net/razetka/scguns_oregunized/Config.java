package net.razetka.scguns_oregunized;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;


@Mod.EventBusSubscriber(modid = ScGunsOregunized.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final Common COMMON;
    private static final ForgeConfigSpec commonSpec;

    public static class Common {
        public final ForgeConfigSpec.DoubleValue leadRoundDamageMultiplier;
        public final ForgeConfigSpec.DoubleValue incendiaryRoundDamageMultiplier;

        private Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configs");

            leadRoundDamageMultiplier = builder
                    .comment("Damage multiplier for Lead Rounds and Lead Slugs upon hitting a target with the Brain Damage effect")
                    .defineInRange("leadRoundDamageMultiplier", 1.5, 1.0, Integer.MAX_VALUE);
            incendiaryRoundDamageMultiplier = builder
                    .comment("Damage multiplier for Incendiary Round upon hitting a target with the Brain Damage effect")
                    .defineInRange("incendiaryRoundDamageMultiplier", 1.75, 1.0, Integer.MAX_VALUE);
        }
    }

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

    public static void registerConfig() {
        var context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, commonSpec);
    }
}
//{
//public static class Rounds {
//    public static ForgeConfigSpec.DoubleValue leadRoundDamageMultiplier;
//    public static ForgeConfigSpec.DoubleValue incendiaryRoundDamageMultiplier;
//
//    public Rounds(ForgeConfigSpec.Builder builder) {
//        builder.comment("Configuration for rounds' damage multipliers").push("rounds");
//        {
//            leadRoundDamageMultiplier = builder
//                    .comment("Damage multiplier for Lead Rounds and Lead Slugs upon hitting a target with the Brain Damage effect")
//                    .defineInRange("leadRoundDamageMultiplier", 1.5, 1.0, Integer.MAX_VALUE);
//            incendiaryRoundDamageMultiplier = builder
//                    .comment("Damage multiplier for Incendiary Round upon hitting a target with the Brain Damage effect")
//                    .defineInRange("leadRoundDamageMultiplier", 1.75, 1.0, Integer.MAX_VALUE);
//        }
//        builder.pop();
//    }
//}
//static final ForgeConfigSpec commonSpec;
//public static final Config.Common COMMON;
//
//final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
//commonSpec = commonSpecPair.getRight();
//COMMON = commonSpecPair.getLeft();
//    }