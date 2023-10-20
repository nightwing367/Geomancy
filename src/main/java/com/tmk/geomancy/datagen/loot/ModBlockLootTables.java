package com.tmk.geomancy.datagen.loot;

import com.tmk.geomancy.block.ModBlocks;
import com.tmk.geomancy.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DUST_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_DUST_BLOCK.get());

        this.dropSelf(ModBlocks.SOUND_BLOCK.get());


        this.add(ModBlocks.DUST_ORE.get(),
                block -> createDustDrops(ModBlocks.DUST_ORE.get(), 1, 2));
        this.add(ModBlocks.DEEPSLATE_DUST_ORE.get(),
                block -> createDustDrops(ModBlocks.DEEPSLATE_DUST_ORE.get(), 2, 3));
        this.add(ModBlocks.NETHER_DUST_ORE.get(),
                block -> createDustDrops(ModBlocks.NETHER_DUST_ORE.get(), 2, 4));
        this.add(ModBlocks.END_STONE_DUST_ORE.get(),
                block -> createDustDrops(ModBlocks.END_STONE_DUST_ORE.get(), 3, 5));
    }

    //You can copy one from the lot and remake it to your taste
    protected LootTable.Builder createDustDrops(Block pBlock, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(ModItems.RAW_DUST.get()).
                                apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).
                                apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
