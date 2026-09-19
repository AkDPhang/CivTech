package net.blackforge.civtech.datagen.lang;

import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.material.Material;
import net.blackforge.civtech.material.MaterialForm;
import net.blackforge.civtech.material.definiton.MaterialList;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class CivTechLangProvider extends LanguageProvider {

    public CivTechLangProvider(PackOutput packOutput) {
        super(packOutput, CivTech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("creativetab.civtech.civtech_ores", "CivTech: Ores");
        add("creativetab.civtech.civtech_geology", "CivTech: Geology");
        add("creativetab.civtech.civtech_materials", "CivTech: Materials");
        add("creativetab.civtech.civtech_components", "CivTech: Components");


        for(Material material : MaterialList.getMaterials()) {
            for(MaterialForm form : material.getMaterialForms()) {
                String idName = material.getMaterialName().toLowerCase() + "_" + form.getName().toLowerCase();

                String text =      material.getMaterialName().substring(0,1).toUpperCase() + material.getMaterialName().substring(1) + " " + form.getName().substring(0,1).toUpperCase() + form.getName().substring(1);
                add("item.civtech." + idName, text);
            }
        }
    }
}
