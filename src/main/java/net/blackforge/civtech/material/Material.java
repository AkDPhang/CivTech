package net.blackforge.civtech.material;

import java.util.Set;

public class Material {

    private final String materialName;
    private final Set<MaterialForm> materialForms;

    public Material(String materialName, Set<MaterialForm> materialForms) {
        this.materialName = materialName;
        this.materialForms = materialForms;
    }

    public String getMaterialName() {
        return materialName;
    }

    public Set<MaterialForm> getMaterialForms() {
        return materialForms;
    }
}
