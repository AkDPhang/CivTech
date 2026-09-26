package net.blackforge.civtech.datagen.lang;

import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.geology.rock.PebbleBlock;
import net.blackforge.civtech.geology.rock.definition.RockDefinitions;
import net.blackforge.civtech.material.Material;
import net.blackforge.civtech.material.MaterialForm;
import net.blackforge.civtech.material.definiton.MaterialList;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

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


        for(RockDefinitions rock : RockDefinitions.values()) {
            String idName = rock.getName() + "_pebble";
            String text = rock.getName().substring(0,1).toUpperCase() + rock.getName().substring(1) + " Pebble";

            add("block.civtech." + idName, text);
        }


        for(Material material : MaterialList.getMaterials()) {
            for(MaterialForm form : material.getMaterialForms()) {
                String idName = material.getMaterialName().toLowerCase() + "_" + form.getName().toLowerCase();

                String text =      material.getMaterialName().substring(0,1).toUpperCase() + material.getMaterialName().substring(1) + " " + form.getName().substring(0,1).toUpperCase() + form.getName().substring(1);
                add("item.civtech." + idName, text);
            }
        }
    }
}
