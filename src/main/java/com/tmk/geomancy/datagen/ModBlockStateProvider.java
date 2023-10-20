package com.tmk.geomancy.datagen;

import com.tmk.geomancy.Geomancy;
import com.tmk.geomancy.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Geomancy.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DUST_BLOCK);
        blockWithItem(ModBlocks.RAW_DUST_BLOCK);

        blockWithItem(ModBlocks.DUST_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_DUST_ORE);
        blockWithItem(ModBlocks.NETHER_DUST_ORE);
        blockWithItem(ModBlocks.END_STONE_DUST_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
