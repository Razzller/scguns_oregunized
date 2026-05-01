package net.razetka.scguns_oregunized.common;

import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import net.razetka.scguns_oregunized.world.processor.WaterloggedProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import static net.razetka.scguns_oregunized.ScGunsOregunized.MOD_ID;

/***
 * @author yungnickyoung
 */
@AutoRegister(MOD_ID)
public class StructureProcessorTypeModule {
    @AutoRegister("waterlogged_processor")
    public static StructureProcessorType<WaterloggedProcessor> WATERLOGGED_PROCESSOR = () -> WaterloggedProcessor.CODEC;

}