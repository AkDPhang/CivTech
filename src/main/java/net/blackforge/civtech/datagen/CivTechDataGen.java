package net.blackforge.civtech.datagen;


import net.blackforge.civtech.datagen.lang.CivTechLangProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;



public class CivTechDataGen {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        CivTechLangProvider langProvider = new CivTechLangProvider(packOutput);

        generator.addProvider(event.includeClient(), langProvider);
    }
}
