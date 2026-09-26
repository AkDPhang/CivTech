package net.blackforge.civtech.datagen;


import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.datagen.lang.CivTechLangProvider;
import net.blackforge.civtech.datagen.model.CivTechBlockStateProvider;
import net.blackforge.civtech.datagen.model.CivTechItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;



@EventBusSubscriber(modid = CivTech.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CivTechDataGen {
    @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput packOutput = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(event.includeClient(), new CivTechLangProvider(packOutput));

            generator.addProvider(event.includeClient(), new CivTechItemModelProvider(packOutput, existingFileHelper));

            generator.addProvider(event.includeClient(), new CivTechBlockStateProvider(packOutput, existingFileHelper));
        }
}
