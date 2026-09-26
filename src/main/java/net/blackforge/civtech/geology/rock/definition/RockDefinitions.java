package net.blackforge.civtech.geology.rock.definition;

public enum RockDefinitions {

    //| Sedimentary Rock
        CHERT("chert", 0),
        LIMESTONE("limestone", 0),
        SANDSTONE("sandstone", 0),

    //| Metamorphic Rock
        QUARTZITE("quartzite", 0),

    //| Igneous Rock
        GRANITE("granite", 0),
        BASALT("basalt", 0),
        OBSIDIAN("obsidian", 0);

   private final String name;
   private final int knappAbility;

   RockDefinitions(String name, int knappAbility) {
       this.name = name;
       this.knappAbility = knappAbility;
   }

   public String getName() {
       return name;
   }

   public int getKnappAbility() {
       return knappAbility;
   }
}
