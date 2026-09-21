package net.blackforge.civtech.material.definiton;

import com.mojang.logging.LogUtils;
import net.blackforge.civtech.material.Material;
import net.blackforge.civtech.material.MaterialForm;
import org.slf4j.Logger;

import java.util.LinkedHashSet;
import java.util.Set;

public class MaterialList {

    private static final LinkedHashSet<Material> materials = new LinkedHashSet<>();

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Material COPPER = register(new Material("copper", Set.of(MaterialForm.INGOT, MaterialForm.NUGGET)));

    public static Material register(Material material) {
        for(Material m : materials) {
            if (material.getMaterialName().equals(m.getMaterialName())) {
                LOGGER.warn("Duplicate material: " + material.getMaterialName() + " & " + m.getMaterialName());
                return m;
            }
        }

        materials.add(material);
        return material;
    }

    public static LinkedHashSet<Material> getMaterials() {
        return new LinkedHashSet<>(materials);
    }


}
