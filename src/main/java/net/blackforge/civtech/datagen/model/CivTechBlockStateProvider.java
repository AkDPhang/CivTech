package net.blackforge.civtech.datagen.model;

import net.blackforge.civtech.CivTech;
import net.blackforge.civtech.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CivTechBlockStateProvider extends BlockStateProvider {

    public CivTechBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CivTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(DeferredBlock<Block> block: ModBlocks.pebble_List) {
            simpleBlock(block.get(), new ModelFile.UncheckedModelFile(CivTech.MODID + ":rock/" + block.getId().getPath()));
            itemModels().getBuilder(block.getId().getPath()).parent(new ModelFile.UncheckedModelFile(CivTech.MODID + ":rock/" + block.getId().getPath()));
        }
    }
}
