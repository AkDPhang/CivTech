package net.blackforge.civtech.registry;

import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.material.Material;
import net.blackforge.civtech.material.MaterialForm;
import net.blackforge.civtech.material.definiton.MaterialList;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CivTech.MODID);


    public static final List<DeferredItem<Item>> MATERIAL_ITEMS = new ArrayList<>();

    public static void registerMaterials() {

        for(Material material : MaterialList.getMaterials()) {
            for(MaterialForm form : material.getMaterialForms()) {
                String idName = material.getMaterialName().toLowerCase() + "_" + form.getName().toLowerCase();


                DeferredItem<Item> item = ITEMS.register(idName, () -> new Item(new Item.Properties()));

                MATERIAL_ITEMS.add(item);
            }
        }

    }




    public static void register(IEventBus eventBus) {
        registerMaterials();

        ITEMS.register(eventBus);
    }
}
