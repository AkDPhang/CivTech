package net.blackforge.civtech.datagen.model;

import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.material.Material;
import net.blackforge.civtech.material.MaterialForm;
import net.blackforge.civtech.material.definiton.MaterialList;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CivTechItemModelProvider extends ItemModelProvider {

    public CivTechItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CivTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(Material material : MaterialList.getMaterials()) {
            for(MaterialForm form : material.getMaterialForms()) {
                getBuilder(material.getMaterialName().toLowerCase() + "_" + form.getName().toLowerCase())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", ResourceLocation.fromNamespaceAndPath(CivTech.MODID, "item/material/" + material.getMaterialName().toLowerCase() + "/" + form.getName().toLowerCase()));


            }
        }
    }

}
