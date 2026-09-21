package net.blackforge.civtech.material;

    public enum MaterialForm {

        //| Basic
        INGOT("ingot"),
        CHUNK("chunk"),
        NUGGET("nugget"),
        POWDER("powder"),
        GRANULE("granule"),

        // | Semi-Finished
        BILLET("billet"),
        BLOOM("bloom"),
        SLAB("slab"),

        // | Long Stock or Billet Products
        BAR("bar"),
        ROD("rod"),
        WIRE("wire"),

        // | Structural Stock or Bloom Products
        BEAM("beam"),
        CHANNEL("channel"),
        ANGLE("angle"),
        RAIL("rail"),

        // | Hollow Stock or Bloom Products
        PIPE("pipe"),
        TUBE("tube"),

        // | Flat Stock or Slab Products
        PLATE("plate"),
        SHEET("sheet"),
        FOIL("foil"),
        STRIP("strip"),

        // | Simple Stock
        RING("ring"),
        DISC("disc");



        private final String name;


        MaterialForm(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }




