package com.tmk.geomancy.datagen;

import com.tmk.geomancy.Geomancy;
import com.tmk.geomancy.block.ModBlocks;
import com.tmk.geomancy.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Geomancy.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DUST_DETECTOR_VALUABLES)
                .add(ModBlocks.DUST_BLOCK.get())
                .add(ModBlocks.DUST_ORE.get())
                .add(ModBlocks.DEEPSLATE_DUST_ORE.get())
                .add(ModBlocks.NETHER_DUST_ORE.get())
                .add(ModBlocks.END_STONE_DUST_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DUST_BLOCK.get(),
                        ModBlocks.RAW_DUST_BLOCK.get(),
                        ModBlocks.DUST_ORE.get(),
                        ModBlocks.DEEPSLATE_DUST_ORE.get(),
                        ModBlocks.NETHER_DUST_ORE.get(),
                        ModBlocks.END_STONE_DUST_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DUST_BLOCK.get(),
                        ModBlocks.RAW_DUST_BLOCK.get(),
                        ModBlocks.DUST_ORE.get(),
                        ModBlocks.DEEPSLATE_DUST_ORE.get(),
                        ModBlocks.NETHER_DUST_ORE.get(),
                        ModBlocks.END_STONE_DUST_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_DUST_ORE.get());

        //The Forge exclusive ones
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_DUST_ORE.get());
    }
}
