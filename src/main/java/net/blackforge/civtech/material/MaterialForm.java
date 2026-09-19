package net.blackforge.civtech.material;

    public enum MaterialForm {
        INGOT("ingot"),
        NUGGET("nugget"),
        DUST("dust"),
        CRUSHED("crushed"),
        CONCENTRATE("concentrate"),
        MATTE("matte"),
        SPONGE("sponge"),
        DROSS("dross");


        private final String name;


        MaterialForm(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }




