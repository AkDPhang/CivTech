package net.blackforge.civtech.registry;

import net.blackforge.civtech.CivTech;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CivTech.MODID);


    //CivTech: Ores Creative Tab Register
    public static final Supplier<CreativeModeTab> CIVTECH_ORES = CREATIVE_MODE_TAB.register("civtech_ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OVERWORLD_PYRITE_ORE_BLOCK.get()))
                    .title(Component.translatable("creativetab.civtech.civtech_ores"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OVERWORLD_PYRITE_ORE_BLOCK);
                    })).build());

    //CivTech: Geology Creative Tab Register
    public static final Supplier<CreativeModeTab> CIVTECH_GEOLOGY = CREATIVE_MODE_TAB.register("civtech_geology_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.STONE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CivTech.MODID, "civtech_ores_tab"))
                    .title(Component.translatable("creativetab.civtech.civtech_geology"))
                    .displayItems((itemDisplayParameters, output) ->  {
                        output.accept(ModBlocks.OVERWORLD_PYRITE_ORE_BLOCK);
                    }).build());



    public static final Supplier<CreativeModeTab> CIVTECH_MATERIALS = CREATIVE_MODE_TAB.register("civtech_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.IRON_INGOT))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CivTech.MODID, "civtech_geology_tab"))
                    .title(Component.translatable("creativetab.civtech.civtech_materials"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        for (DeferredItem<Item> item : ModItems.MATERIAL_ITEMS) {
                            output.accept(item.get());
                        }
                    })).build());

    public static final Supplier<CreativeModeTab> CIVTECH_COMPONENTS = CREATIVE_MODE_TAB.register("civtech_components_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.STICK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CivTech.MODID, "civtech_materials_tab"))
                    .title(Component.translatable("creativetab.civtech.civtech_components"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OVERWORLD_PYRITE_ORE_BLOCK);
                    })).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
